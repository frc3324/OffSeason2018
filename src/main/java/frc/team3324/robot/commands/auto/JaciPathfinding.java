package frc.team3324.robot.commands.auto;

import java.io.File;
import java.nio.file.Path;

import frc.team3324.robot.Constants;
import frc.team3324.robot.Robot;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class JaciPathfinding extends Command {

    private double angleDifference, turn;
    private String path;
    private Trajectory trajectory;

    private boolean leftFinished = false;
    private boolean fileExists;

    EncoderFollower left;
    EncoderFollower right;

    public JaciPathfinding(String path, Boolean fileExists) {
		this.path = path;
    	Waypoint[] Defaultpoints = new Waypoint[] {
    		    new Waypoint(0, 0, 0),      // Waypoint @ x=-0, y=-0, exit angle= 0 degrees
                new Waypoint(3.048,0,0),
		};
    	Waypoint[] LMiddlepoints = new Waypoint[] {
    	        new Waypoint(0,0,0),
                new Waypoint(3.556, 1.2192, 0),
        };
        Waypoint[] RMiddlepoints = new Waypoint[] {
                new Waypoint(0,0,0),
                new Waypoint(3.556,-1.9812,0),
        };
    	Waypoint[] LLLeftpoints = new Waypoint[] {
    		    new Waypoint(0, 0, 0),      // Waypoint @ x=-0, y=-0, exit angle= 0 degrees
                new Waypoint(4.2672,0.4064,Pathfinder.d2r(90)),
		};
    	Waypoint[] RRRightpoints = new Waypoint[] {
    	        new Waypoint(0,0,0),
                new Waypoint(4.2672, -1.8288, 90),
        };

    	Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_LOW,  0.01, Constants.LOW_GEAR_METERS_PER_SECOND*0.7, 4.5, 9);
    	if (path == "LLLeft" && fileExists == false) {
			trajectory = Pathfinder.generate(LLLeftpoints, config);
			File LLLeft = new File("LLLeft.traj");
			Pathfinder.writeToFile(LLLeft, trajectory);
		} else if (path == "LLLeft" && fileExists == true) {
    		File LLLeft = new File("LLLeft.traj");
    		trajectory = Pathfinder.readFromFile(LLLeft);
		} else if (path == "RRRight" && fileExists == false) {
    	   trajectory = Pathfinder.generate(RRRightpoints, config);
    	   File RRRight = new File("RRRight.traj");
    	   Pathfinder.writeToFile(RRRight, trajectory);
        } else if (path == "RRRight" && fileExists == true) {
    	    File RRRight = new File("RRRight.traj");
    	    trajectory = Pathfinder.readFromFile(RRRight);
        } else if (path == "RMiddle" && fileExists == true) {
    		File RMiddle = new File("RMiddle.traj");
    		trajectory = Pathfinder.readFromFile(RMiddle);
		} else if (path == "RMiddle" && fileExists == false) {
    		trajectory = Pathfinder.generate(RMiddlepoints, config);
    		File RMiddle = new File("RMiddle.traj");
    		Pathfinder.writeToFile(RMiddle, trajectory);
		} else if (path == "LMiddle" && fileExists == true) {
    		File LMiddle = new File("LMiddle.traj");
    		trajectory = Pathfinder.readFromFile(LMiddle);
		} else if (path == "LMiddle" && fileExists == false) {
    		trajectory = Pathfinder.generate(LMiddlepoints, config);
    		File LMiddle = new File("LMiddle.traj");
    		Pathfinder.writeToFile(LMiddle, trajectory);
		} else {
    		trajectory = Pathfinder.generate(Defaultpoints, config);
		}
    	TankModifier modifier = new TankModifier(trajectory).modify(Constants.DISTANCE_BETWEEN_WHEELS_METERS);
    	left = new EncoderFollower(modifier.getLeftTrajectory());
    	right = new EncoderFollower(modifier.getRightTrajectory());
    	left.configureEncoder(Robot.mDriveTrain.getLeftDistanceRaw(), Constants.ACTUAL_PULSES, Constants.WHEEL_DIAMETER_METERS);
    	right.configureEncoder(-Robot.mDriveTrain.getRightDistanceRaw(), Constants.ACTUAL_PULSES, Constants.WHEEL_DIAMETER_METERS); // TODO: Right encoder is negative, can fix in subsystem
    	left.configurePIDVA(0.3, 0.0, 0, 1 / Constants.LOW_GEAR_METERS_PER_SECOND, 0);
    	right.configurePIDVA(0.3, 0.0, 0, 1 / Constants.LOW_GEAR_METERS_PER_SECOND, 0); // TODO: Tune these
		Robot.mDriveTrain.clearGyro();
		Robot.mDriveTrain.BrakeMode();

    }

    Notifier notifier = new Notifier (() -> {
    	double Loutput = left.calculate(Robot.mDriveTrain.getLeftDistanceRaw());
    	double Routput = right.calculate(-Robot.mDriveTrain.getRightDistanceRaw());
    	double gyro_heading = -Robot.mDriveTrain.getYaw();    // Assuming the gyro is giving a value in degrees
    	double desired_heading = Pathfinder.r2d(left.getHeading());  // Should also be in degrees
    	angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
    	turn = 1.2 * (-1.0/80.0) * angleDifference;
    	SmartDashboard.putNumber("Loutput", Loutput);
    	SmartDashboard.putNumber("Routput", Routput);
    	SmartDashboard.putBoolean("JaciFinished", false);
    	Robot.mDriveTrain.mDrive.tankDrive(-(Loutput + turn), -(Routput - turn), false);
    });

    // Called just before this Command runs the first time
    protected void initialize() { notifier.startPeriodic(0.01); }

    protected void execute() { }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (left.isFinished() == true && right.isFinished() == true && angleDifference < 3) {
    		notifier.stop();
    		SmartDashboard.putBoolean("JaciFinished", true);
    		Robot.mDriveTrain.CoastMode();
    		return left.isFinished();
    	}
    	else {
    		SmartDashboard.putBoolean("JaciFinished", left.isFinished());
    		return false;
    	}
    }


    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putBoolean("leftFinished", leftFinished);
    	Robot.mDriveTrain.mDrive.tankDrive(0, 0, false);
    	Robot.mDriveTrain.CoastMode();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() { Robot.mDriveTrain.CoastMode(); }
}