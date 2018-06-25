package org.metrobots.commands.auto;

import org.metrobots.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GyroReset extends Command {
	private boolean isReset = false;
	
    public GyroReset() {
    	requires(Robot.mGyro);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mGyro.clear();
    	if (Math.abs(Robot.mGyro.getPidAngle()) < 0.1) {
    		DriverStation.reportError("Gyro auto: " + Robot.mGyro.getPidAngle(), false);
    		DriverStation.reportError("GYRO RESET", false);
    		isReset = true;
    	}
    	else {
    		isReset = false;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isReset;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
