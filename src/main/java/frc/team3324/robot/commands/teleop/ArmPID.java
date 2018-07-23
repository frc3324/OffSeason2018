package main.java.frc.team3324.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3324.robot.OI;
import frc.team3324.robot.Robot;
import frc.team3324.robot.subsystems.TestArm;
import frc.team3324.robot.util.BasicPID;

/**
 *
 */
public class ArmPID extends Command {
	private double joystickval;
	double testArmEncoder;
	double error;
	double goal;
	double Kp;
	boolean buttonB, buttonA, buttonX;
	double last_error = 0;
	BasicPID mpid;
    public ArmPID() {
    	  mpid = new BasicPID(1024, 1.032, 0.251, 2.41, 21); // Ticks per rev, mass(kg), length(m), stall torque (Nm), gear reduction.
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.mTestArm.breakArm();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	testArmEncoder = Robot.mTestArm.getEncoder();
    	
	joystickval = OI.get1RightYAxis();
    	
	buttonB = OI.get1BButton();
    	buttonA = OI.get1AButton();
    	buttonX = OI.get1XButton();
    	
	SmartDashboard.putBoolean("Button", buttonB);
    	SmartDashboard.putNumber("Port 2 Current", Robot.mTestArm.getCurrent(2));
    	
	if (Math.abs(joystickval) > 0.1) {
    		Robot.mTestArm.moveTestArm(joystickval);
    	} else if (buttonB == true) {
    		mpid.updatePID(0.00200625, 0.000068, -1.0);
    		goal = 256;
    		double move = mpid.getPID(goal, testArmEncoder);
    		SmartDashboard.putNumber("Move", move);
    		Robot.mTestArm.moveTestArm(move);
    	} else if (buttonA == true) {
    		mpid.updatePID(0.001953125, 0.0, 0);
    		goal = 0;
    		error = goal - testArmEncoder;
    		Kp = -0.0015;
    		double deriv = error - last_error;
    		this.last_error = error;
    		double move = mpid.getPID(goal, testArmEncoder);
    		SmartDashboard.putNumber("Move", move);
    		Robot.mTestArm.moveTestArm(move);
    	} else if (buttonX == true) {
		Robot.mTestArm.moveTestArm(mpid.eStat(testArmEncoder));

    	}
    	SmartDashboard.putNumber("Arm Encoder", Robot.mTestArm.getEncoder());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
