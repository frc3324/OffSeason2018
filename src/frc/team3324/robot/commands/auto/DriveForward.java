package frc.team3324.robot.commands.auto;

import frc.team3324.robot.Robot;
import frc.team3324.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForward extends Command {

	double finalSpeed, currentSpeed, currentDistance, distanceToTravel, LSpeed, RSpeed; //goalDistance
	double goalDistance = 0.0;

	boolean driveFinished = false;

	/**
	 * Measurement testing from 3/10/18
	 * Speed: 1.0 Set: 100 Received: 174 in
	Speed: 1.0 Set: 100 Received: 167 in
	Speed: 0.5 Set: 100 Received:
	Speed: 1.0 Set: 60 Received: 110 in
	Speed: 1.0 Set: 60 Received: 118 in
	Speed: 1.0 Set: 60 Received: 111 in
	//minus 2ish inches
	Speed: 1.0 Set: 76.78 Received: 135 in Encoder distance: 76.3849
	Speed: 1.0 Set: 100 Received: 172 R: 0.95
	Speed: 1.0 Set: 100 Received: 169 R: 0.95
	Speed: 0.75 Set: 100 Received: 146 R: 0.9
	//minus 2ish inches
	Speed: 0.5 Set: 100 Received: 137
	Speed: 0.5 Set: 100 Received: 137
	Speed: 1.0 Set: 76.78 Received: 133.75
	 */

	/**
	 * Method for auto drive forward.<p>
	 *
	 * Distance to be traveled by robot.
	 * Speed of motor, -1 to 1.
	 * @param distance
	 * @param speed
	 */
	public DriveForward(double distance, double speed) {
		//distance is equal to the circumference of the wheel times the amount of pulses = inches.
		goalDistance = distance;
		currentSpeed = speed;

	}

	@Override
	protected void initialize() {
		DriveTrain.clearEncoder();
	}

	@Override
	protected void execute() {

		currentDistance = (Math.abs(DriveTrain.getLeftDistance()) + Math.abs(DriveTrain.getRightDistance())) / 2.0;

		SmartDashboard.putNumber("AVERAGE DRIVETRAIN PULSE1: ", currentDistance);
		SmartDashboard.putNumber("Right from robot encoder: ", DriveTrain.getRightDistance());
		SmartDashboard.putNumber("Left from robot encoder: ", DriveTrain.getRightDistance());
		distanceToTravel = goalDistance - currentDistance;
		SmartDashboard.putNumber("GOAL DISTANCE", distanceToTravel);

		if (distanceToTravel < 10) {
			finalSpeed = -0.4 * currentSpeed;
		}
		else {
			finalSpeed = -1 * currentSpeed;
		}

		LSpeed = finalSpeed;
		RSpeed = finalSpeed;
		SmartDashboard.putNumber("LSpeed", LSpeed);
		SmartDashboard.putNumber("RSpeed", RSpeed);

		if (Math.abs(distanceToTravel) < 1) { //0.5
			driveFinished = true;
		}

		//make speed negative to go forward in real life
		Robot.mDriveTrain.tankDrive(LSpeed, RSpeed, false);
		SmartDashboard.putNumber("Gyro!!!!", Robot.mGyro.getPidAngle());

	}

	@Override
	protected boolean isFinished() {
		return driveFinished;
	}


	protected void end() {
		Robot.mDriveTrain.tankDrive(0.0, 0.0, false);
	}
	@Override
	protected void interrupted() {}

}
