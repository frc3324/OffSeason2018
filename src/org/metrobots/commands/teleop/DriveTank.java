package org.metrobots.commands.teleop;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.metrobots.OI;
import org.metrobots.Robot;

public class DriveTank extends Command {
	
	boolean slowModeActivated = false;
	boolean isTurning;
	double turnRate;
	double driveTrainCurrent;
	public DriveTank() {
		requires(Robot.mDriveTrain);
	}

	protected void execute() {
//		// TODO Auto-generated method stub
//		//Add robot sensitivity
		Robot.mDriveTrain.printEncoder();
		double leftY = OI.get0LeftY(); // Get y value of left joystick
		double leftX = OI.get0LeftX(); // Get x value of right joystick 
		
		SmartDashboard.putNumber("RightX", leftX);
		SmartDashboard.putNumber("LeftY", leftY);
		SmartDashboard.putNumber("LDistanceDT", Robot.mDriveTrain.getLeftDistance());
		
		Robot.mDriveTrain.arcadeDrive(leftY, -leftX, true);
//		Robot.mDriveTrain.getCurrent();
//		driveTrainPower1 = Robot.mDriveTrain.getCurrent();
//		SmartDashboard.putNumber("DriveTrain1:", driveTrainPower1);
		driveTrainCurrent = Robot.mDriveTrain.getCurrent(12) + Robot.mDriveTrain.getCurrent(13) + Robot.mDriveTrain.getCurrent(14) + Robot.mDriveTrain.getCurrent(15);
		SmartDashboard.putNumber("Total Drivetrain Current Draw:", driveTrainCurrent);
		if (OI.get0RightBumperToggled()) {
			slowModeActivated = !slowModeActivated;
		}
		
		if (slowModeActivated) {
			leftY *= 0.5;
		}
		DriverStation.reportError("LEFTY: "  + leftY, true);
		//Robot.mDriveTrain.arcadeDrive(leftY, rightX, true);
	//	DriverStation.reportError(", printTrace);
		//Robot.mDriveTrain.printEncoder();
		//DriverStation.reportError("something", false);
	}
	
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
//		DriveTrain.clearEncoder();
	
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
	}
}
