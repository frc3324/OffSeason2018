package org.metrobots.commands.teleop;

import org.metrobots.OI;
import org.metrobots.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class Winches extends Command {
	
	double upSpeed;
	
    public Winches() {
    	requires(Robot.mClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    protected void execute() {
    	double currentPulseArm = Robot.mIntakeArm.getRawArm();
//    	if (currentPulseArm < 45) {
//    		Robot.mIntakeArm.armMovement(0.2);
//    	} else {
//    		Robot.mIntakeArm.armMovement(0.0);
//    	}
    	
    	if (OI.get1BButton()) {
    		Robot.mClimber.reelWinch(-1.0);
    	}
    	else {
    		Robot.mClimber.reelWinch(0.0);
    	}
    	
    	if (OI.get1LeftButton()) {
    		Robot.mClimber.grabBar(1.0);
    		DriverStation.reportError("Pressed left", false);
    	}
    	else if (OI.get1RightButton()) {
    		Robot.mClimber.grabBar(-1.0);
    		DriverStation.reportError("Pressed right", false);
    	}
    	else {
    		Robot.mClimber.grabBar(0.0);
    	}
//    	upSpeed = OI.get1RightY();
//    	SmartDashboard.putNumber("Slide speed", upSpeed);
//     	Robot.mClimber.grabBar(upSpeed);
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