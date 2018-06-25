package org.metrobots.commands.auto;

import org.metrobots.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveArm extends Command {
	
	boolean finished;
	double armDistance;
	
	/**
	 * 
	 * @param encoderDistance <p>
	 * Zero being the back of the robot. <p>
	 * Forty-five being the front of the robot. <p>
	 */
    public MoveArm(double distance) {
        armDistance = distance;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double goalPulse = armDistance;
    	double speed = 0.0;
    	double currentPulse = Robot.mIntakeArm.getRawArm();
		SmartDashboard.putNumber("CURRENTPULSE", currentPulse);
    	double diffPulse = goalPulse - currentPulse;
    	
    	if (Math.abs(diffPulse) > 0.5) {
    		speed = diffPulse / 45;
        	finished = false;
    	}
    	else {
    		speed = 0.0;
    		Robot.mIntakeArm.armMovement(0.0);
    		finished = true;
    	}
    	
    	Robot.mIntakeArm.armMovement(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
