package frc.team3324.robot.commands.teleop;

import frc.team3324.robot.OI;
import frc.team3324.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID;

public class DriveTank extends Command {

	public DriveTank() { requires(Robot.mDriveTrain); }

	protected void execute() {
		double leftY = OI.gamepad0.getY(GenericHID.Hand.kLeft);
		double leftX = OI.gamepad0.getX(GenericHID.Hand.kLeft);

		if (OI.gamepad0.getBumper(GenericHID.Hand.kRight)) {
			leftY *= 0.5;
		}
		Robot.mDriveTrain.mDrive.arcadeDrive(leftY, -leftX, true);
	}

	@Override
	protected void initialize() { }

	@Override
	protected void end() { }

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void interrupted() { }
}