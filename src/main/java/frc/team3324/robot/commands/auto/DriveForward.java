package frc.team3324.robot.commands.auto;

import frc.team3324.robot.subsystems.DriveTrain;
import frc.team3324.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {

	private double currentDistance, distanceToTravel, speed, goalDistance, lSpeed, rSpeed, straightenValue;
	private double kP;
	private double kI;
	private double kD;

	private boolean isFinished = false;

	/**
	 * Method for auto drive forward
	 *
	 * @param distance	Distance to be traveled by robot.
	 */
	public DriveForward(double distance) {
		goalDistance = distance;
	}

	@Override
	protected void initialize() {
		DriveTrain.clearEncoder();
	}

	@Override
	protected void execute() {
	    // TODO Make sure encoders signed correctly
	    currentDistance = (DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2.0;

		distanceToTravel = goalDistance - currentDistance;

        // TODO Find overshoot to tune
		if (distanceToTravel < 0) {
			isFinished = true;
		}

		speed = distanceToTravel / goalDistance;
		straightenValue = DriveTrain.getLeftDistance() / DriveTrain.getRightDistance();
		lSpeed = speed / straightenValue;
		rSpeed = speed * straightenValue;
		// TODO What? "make speed negative to go forward in real life" Fix.
		Robot.mDriveTrain.mDrive.tankDrive(1.0, 1.0, false);
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	protected void end() {
		Robot.mDriveTrain.mDrive.tankDrive(0.0, 0.0, false);
	}

	@Override
	protected void interrupted() { }
}