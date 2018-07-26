package frc.team3324.robot.commands.teleop;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3324.robot.OI;
import frc.team3324.robot.Robot;
import frc.team3324.robot.util.BasicPID;

public class ArmPID extends Command {

	BasicPID mpid;

	private double joystickVal;
	private double testArmEncoder;
	private double error;
	private double goal;
	private double kP;
    private double lastError = 0.0;

	private boolean buttonB;
	private boolean buttonA;
	private boolean buttonX;

    public ArmPID() {

        mpid = new BasicPID(0.0024, 0.000003, 100);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        Robot.mTestArm.breakArm();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	testArmEncoder = Robot.mTestArm.getEncoder();
    	joystickVal = OI.gamepad1.getY(GenericHID.Hand.kRight);
		buttonB = OI.gamepad1.getBButton();
    	buttonA = OI.gamepad1.getAButton();

    	if (Math.abs(joystickVal) > 0.1) {
    		Robot.mTestArm.moveTestArm(joystickVal);
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
    		kP = -0.0015;
    		double deriv = error - lastError;
    		this.lastError = error;
    		double move = mpid.getPID(goal, testArmEncoder);
    		SmartDashboard.putNumber("Move", move);
    		Robot.mTestArm.moveTestArm(move);
    	} else if (buttonX == true) {
    		Robot.mTestArm.moveTestArm(0.00);
    	}

    	SmartDashboard.putNumber("Arm Encoder", Robot.mTestArm.getEncoder());
		SmartDashboard.putNumber("Port 2 Current", Robot.mTestArm.getCurrent(2));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() { }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() { }
}