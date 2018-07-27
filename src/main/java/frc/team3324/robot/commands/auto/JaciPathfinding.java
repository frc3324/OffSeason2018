package frc.team3324.robot.commands.auto;

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

    private double angleDifference;
    private double turn;

    private boolean leftFinished = false;

    EncoderFollower left;
    EncoderFollower right;

    public JaciPathfinding(double x1, double y1, double angle1, double x2, double y2, double angle2) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	Waypoint[] points = new Waypoint[] {
    		    new Waypoint(x1, y1, Pathfinder.d2r(angle1)),      // Waypoint @ x=-0, y=-0, exit angle=-45 degrees
    		    new Waypoint(x2, y2, Pathfinder.d2r(angle2)),                           // Waypoint @ x=0, y=0,   exit angle=0 radians
//    		    new Waypoint(4.039, 0.2413, Pathfinder.d2r(-90)),                        // Waypoint @ x=-3.429, y=0, exit angle=0 radians
//    		    new Waypoint(4.353, 4.5, 0),

		};

    	Robot.mDriveTrain.clearEncoder();
    	Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_LOW,  0.02, Constants.LOW_GEAR_METERS_PER_SECOND*0.7, 4.5, 9);
    	Trajectory trajectory = Pathfinder.generate(points, config);
    	TankModifier modifier = new TankModifier(trajectory).modify(Constants.DISTANCE_BETWEEN_WHEELS_METERS);
    	left = new EncoderFollower(modifier.getLeftTrajectory());
    	right = new EncoderFollower(modifier.getRightTrajectory());
    	left.configureEncoder(Robot.mDriveTrain.getLeftDistanceRaw(), Constants.ACTUAL_PULSES, Constants.WHEEL_DIAMETER_METERS);
    	right.configureEncoder(-Robot.mDriveTrain.getRightDistanceRaw(), Constants.ACTUAL_PULSES, Constants.WHEEL_DIAMETER_METERS);
    	left.configurePIDVA(0.3, 0.0, 0, 1 / Constants.LOW_GEAR_METERS_PER_SECOND, 0);
    	right.configurePIDVA(0.3, 0.0, 0, 1 / Constants.LOW_GEAR_METERS_PER_SECOND, 0);
//    	this.left = left;
//    	this.right = right;
		Robot.mDriveTrain.clearGyro();
		Robot.mDriveTrain.clearGyro();
		Robot.mDriveTrain.clearGyro();
		Robot.mDriveTrain.CoastMode();
    }

    Notifier notifier = new Notifier (() -> {
    	double Loutput = left.calculate(Robot.mDriveTrain.getLeftDistanceRaw());
    	double Routput = right.calculate(-Robot.mDriveTrain.getRightDistanceRaw());
    	double gyro_heading = -Robot.mDriveTrain.getYaw();    // Assuming the gyro is giving a value in degrees
    	double desired_heading = Pathfinder.r2d(left.getHeading());  // Should also be in degrees
    	angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
    	turn = 1.2 * (-1.0/80.0) * angleDifference;
    	SmartDashboard.putNumber("Desired Heading", desired_heading);
    	SmartDashboard.putNumber("gyro_heading", gyro_heading);
    	SmartDashboard.putNumber("Turn:", turn);
    	Robot.mDriveTrain.tankDrive(-(Loutput + turn), -(Routput - turn), false);
    	SmartDashboard.putNumber("Loutput", Loutput);
    	SmartDashboard.putNumber("Routput", Routput);
    	SmartDashboard.putBoolean("JaciFinished", false);
    });

    // Called just before this Command runs the first time
    protected void initialize() { notifier.startPeriodic(0.02); }

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
    	Robot.mDriveTrain.tankDrive(0, 0, false);
    	Robot.mDriveTrain.CoastMode();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() { Robot.mDriveTrain.CoastMode(); }
}