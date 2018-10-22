package frc.team3324.robot.commands.auto;

import frc.team3324.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RotateTo extends Command {

    private double specifiedAngle;
    private double runningSpeed = 0.0;
    private double angleToTravel;
    private double kP = (1 / 180);

    private boolean isFinished = false;

    /**
	 * Rotates to the specified angle at the specified speed
	 * @param angle in degrees (0, 360)
	 */
    public RotateTo(double angle) {
        requires(Robot.mDriveTrain);
        specifiedAngle = angle; //Between 0 and 360, clockwise
    }

    @Override
    protected void initialize() {}

    /**
	 *  Rotates to specified angle (from current angle) at specified speed
	 */
    protected void execute() {
        double measuredAngle = Robot.mDriveTrain.getYaw();
        if (measuredAngle < 180.0) {
            measuredAngle -= 360;
        } else if (measuredAngle < -180) {
            measuredAngle += 360;
        }
        angleToTravel = specifiedAngle - measuredAngle;
        runningSpeed = angleToTravel * kP;

        Robot.mDriveTrain.mDrive.arcadeDrive(0, runningSpeed, false);

        if (angleToTravel == 0.0) { isFinished = true; }
    }

    /**
     * When the current angle is equal to the specified angle, returns true.
     */
    @Override
    protected boolean isFinished() {
        return isFinished;
    }

    /**
	 * Does nothing after the current angle is equal to the specified angle
	 */
    @Override
    protected void end() {
        Robot.mDriveTrain.mDrive.tankDrive(0.0, 0.0, false);
    }

    @Override
    protected void interrupted() {}
}