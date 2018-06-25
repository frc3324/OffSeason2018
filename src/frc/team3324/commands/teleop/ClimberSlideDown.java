package frc.team3324.commands.teleop;

import frc.team3324.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberSlideDown extends Command {

    public ClimberSlideDown() {
    	requires(Robot.mClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.mClimber.grabBar(-1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if (OI.get1LeftButton()) {
//    		Robot.mClimber.grabBar(-1.0);
//    	}
//    	else if (OI.get1RightButton()) {
//    		Robot.mClimber.grabBar(1.0);
//    	}
//    	else {
//    		Robot.mClimber.grabBar(0.0);
//    	}
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
    	Robot.mClimber.grabBar(0.0);
    }
}
