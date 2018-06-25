package org.metrobots.commands.teleop;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;

import org.metrobots.OI;
import org.metrobots.Robot;
import org.metrobots.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 */
public class ClimberSlideUp extends Command {
	
	double upSpeed;
	
    public ClimberSlideUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.mClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentPulseArm1 = Robot.mIntakeArm.getRawArm();
    	upSpeed = OI.get1RightY();
    	SmartDashboard.putNumber("Slide speed", upSpeed);
     	Robot.mClimber.grabBar(upSpeed);
//    	Robot.mClimber.grabBar(1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	Robot.mClimber.grabBar(0.0);
    }
}
