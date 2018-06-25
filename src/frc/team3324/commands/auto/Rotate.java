package frc.team3324.commands.auto;

import frc.team3324.Constants;
import frc.team3324.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Rotate extends Command {

	private double specifiedAngle = 0; //angle that robot should go to
	private double runningSpeed = 0.0;
	private double angleToTravel;
	private static final double speed = 1;
	private boolean isDone = false;
	private double coast;

	/**
	 * Rotates to the specified angle at the specified speed.
	 * @param angle
	 */
	public Rotate(double angle, double speed) {
		requires(Robot.mDriveTrain);
		requires(Robot.mGyro);
		specifiedAngle = -angle;
		coast = speed;
	}

	/**
	 * When the command starts, set current angle to zero
	 */
	@Override
	protected void initialize() {
	}

	/**
	 * Rotate to specified angle (from current angle), at specified speed.
	 */
	protected void execute() {
//		isDone = false;
		double measuredAngle = Robot.mGyro.getPidAngle();
        SmartDashboard.putNumber("Gyro", measuredAngle);
        angleToTravel = Math.abs(specifiedAngle) - Math.abs(measuredAngle);
        //25.54 = 90 - 64.46
        //specifiedAngle = -90
        //measuredAngle = 64.46
        SmartDashboard.putNumber("angle to travel:", angleToTravel);
//		speed = angleToTravel / specifiedAngle;
        if (measuredAngle > specifiedAngle && angleToTravel > 30) {
            /*leftSideSpeed = angleDifference / 180;
            rightSideSpeed = angleDifference / 180;*/
            runningSpeed = -speed;
            DriverStation.reportError("Here", false);
        } else if (measuredAngle > specifiedAngle && angleToTravel < 30) {
        	runningSpeed = -speed * 0.7;
        	DriverStation.reportError("Here1", false);
        } else if (specifiedAngle > measuredAngle && angleToTravel > 30) {
            runningSpeed = speed;
            DriverStation.reportError("Here2", false);
        } else if (specifiedAngle > measuredAngle && angleToTravel < 30) {
        	runningSpeed = speed * 0.7;
        	DriverStation.reportError("Here3", false);
        } else {
        	DriverStation.reportError("You have reached the forbidden zone!", false);
        }
        if (Math.abs(angleToTravel) < Constants.AUTO_ROTATE_ANGLE_THRESHOLD) {
        	DriverStation.reportError("Is done:", isDone);
        	runningSpeed = 0;
        	isDone = true;
        }
        if (angleToTravel < Constants.AUTO_ROTATE_ANGLE_THRESHOLD) {
        	runningSpeed = 0;
        	isDone = true;
        }
    	SmartDashboard.putBoolean("Is turn over?", isDone);
        SmartDashboard.putNumber("RunningSpeed:", runningSpeed);
        Robot.mDriveTrain.BrakeMode();
//        Robot.mDriveTrain.tankDrive(runningSpeed, -runningSpeed, false);
        Robot.mDriveTrain.arcadeDrive(coast, runningSpeed, false); //negative in shop
        //drivetrain.tankDrive(leftSpeed, rightSpeed);

    }

    /**
     * When the current angle is equal to the specified angle, returns true.
     */
    @Override
    protected boolean isFinished() {
       return isDone;
    }

	/**
	 * Does nothing after the current angle is equal to the specified angle.
	 */
	@Override
	protected void end() {
		Robot.mDriveTrain.tankDrive(0.0, 0.0, false);
	}

	/**
	 * Do nothing
	 */
	@Override
	protected void interrupted() {}

}
