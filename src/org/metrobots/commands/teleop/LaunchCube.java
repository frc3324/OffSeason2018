package org.metrobots.commands.teleop;

import org.metrobots.OI;
import org.metrobots.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class LaunchCube extends Command {
	boolean isOn = false;
	double motorSpeed;
	
	/**
	 * Spin wheels inward. <p>
	 */
    public LaunchCube() {
    	requires(Robot.mCubeController);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//	    Robot.mCubeController.intake(-0.2);
    
	    
    //  
    //protected void execute() {
//    	if (OI.is1LeftBumperPressed()) {
//    		if (isOn = false) {
//    			motorSpeed = -1.0;
//    			isOn = true;
//    		} else {
//        		motorSpeed = 0.0;	
//        		isOn = false;
//    		}    
//    	 Robot.mCubeController.intake(motorSpeed);
//    	}
    	if (OI.is1LeftBumperPressed()) { //outtake (3/10/18)
    		DriverStation.reportError("LEFT BUMPER", false);
    		motorSpeed = -0.8;
    	}
    	else if (OI.is1RightBumperPressed()) { //intake (3/10/18)
    		DriverStation.reportError("RIGHT BUMPER", false);
    		motorSpeed = 1.0;
    	}
    	else if (OI.is1APressed()) {
    		motorSpeed = 0.3;
    	}
    	else {
    		motorSpeed = 0.0;
    	}
    	Robot.mCubeController.intake(motorSpeed);
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Robot.mCubeController.intake(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	Robot.mCubeController.intake(0.0);
    	
    }
}
