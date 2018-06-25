package org.metrobots.commands.auto;

import org.metrobots.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForwardTime extends Command {

	Timer timer = new Timer();
	double time;
	
    public DriveForwardTime(double driveTime) {
        requires(Robot.mDriveTrain);
        time = driveTime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    	System.out.println("started");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("running");
    	if (timer.get() < time) {
    		//System.out.println("running");
    		Robot.mDriveTrain.arcadeDrive(0.5, 0.0, false);
    	}
    	else {
    		Robot.mDriveTrain.arcadeDrive(0.0, 0.0, false);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
