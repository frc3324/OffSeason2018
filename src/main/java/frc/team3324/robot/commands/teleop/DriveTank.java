package frc.team3324.robot.commands.teleop;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team3324.robot.OI;
import frc.team3324.robot.Robot;

public class DriveTank extends Command {

	boolean slowModeActivated = false;
	boolean isTurning;
	double turnRate;
	double driveTrainCurrent;
	public DriveTank() {
		requires(Robot.mDriveTrain);
	}

	protected void execute() {
		double leftY = OI.get0LeftY(); // Get y value of left joystick
		double leftX = OI.get0LeftX(); // Get x value of right joystick


		Robot.mDriveTrain.arcadeDrive(leftY, -leftX, true);

		if (OI.get0RightBumperToggled()) {
			slowModeActivated = !slowModeActivated;
		}

		if (slowModeActivated) {
			leftY *= 0.5;
		}


	}


	@Override
	protected void initialize() {

	}

	@Override
	protected void end() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void interrupted() {
	}
}
