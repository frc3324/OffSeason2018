package frc.team3324.commands.auto;

import frc.team3324.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class CubeControl extends Command {

	double cubeSpeed;
	double controlTime;
	boolean controlDone;

	Timer timer = new Timer();

	/**
	 * Spin intake/outtake wheels.
	 * Set a positive number to intake, a negative number to outtake.
	 * Time in seconds.
	 */
    public CubeControl(double speed, double time) {
    	cubeSpeed = -speed;
    	controlTime = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (timer.get() < controlTime) {
    		Robot.mCubeController.intake(cubeSpeed); //was -0.6
    		controlDone = false;
    	}
    	else {
    		Robot.mCubeController.intake(0.0);
    		controlDone = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return controlDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
