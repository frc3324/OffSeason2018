package frc.team3324.robot.commands.teleop;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3324.robot.OI;
import frc.team3324.robot.Robot;
import frc.team3324.robot.util.BasicPID;

public class ArmPID extends Command {

	BasicPID mPID;

	private double goal, joystickVal, move, testArmEncoder;

	private boolean buttonA, buttonB, buttonX;

    public ArmPID() { mPID = new BasicPID(1024, 1.032, 0.251, 2.41, 21); } // Ticks per rev, mass(kg), length(m), stall torque (Nm), gear reduction.

    protected void initialize() { Robot.mTestArm.breakArm(); }

    protected void execute() {

    	testArmEncoder = Robot.mTestArm.getEncoder();

    	joystickVal = OI.gamepad1.getY(GenericHID.Hand.kRight);

		buttonB = OI.gamepad1.getBButton();
    	buttonA = OI.gamepad1.getAButton();
    	buttonX = OI.gamepad1.getXButton();

    	if (Math.abs(joystickVal) > 0.1) {
    		Robot.mTestArm.moveTestArm(joystickVal);
    	}
    	else if (buttonB == true) {
    		mPID.updatePID(0.00200625, 0.000068, -1.0);
    		goal = 256.0;
    		move = mPID.getPID(goal, testArmEncoder);

    		SmartDashboard.putNumber("Move", move);
    		Robot.mTestArm.moveTestArm(0.5 * (-move));
    	}
    	else if (buttonA == true) {
    		mPID.updatePID(0.001953125, 0.0, 0);
    		goal = 0.0;
    		move = mPID.getPID(goal, testArmEncoder) + mPID.eDynamic(testArmEncoder, Math.toRadians(90)) - mPID.eStat(testArmEncoder);
    		Robot.mTestArm.moveTestArm(move + (mPID.eStat(testArmEncoder)));

            SmartDashboard.putNumber("Move", move);
        }
    	else if (buttonX == true) {
    	}
    	else {
    		Robot.mTestArm.moveTestArm(0);
    	}
    	SmartDashboard.putNumber("Arm Encoder", Robot.mTestArm.getEncoder());
		SmartDashboard.putNumber("Port 2 Current", Robot.mTestArm.getCurrent(2));
    }

    protected boolean isFinished() { return false; }

    protected void end() { }

    protected void interrupted() { }
}