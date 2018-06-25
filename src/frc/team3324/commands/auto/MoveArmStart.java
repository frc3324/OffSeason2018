package frc.team3324.commands.auto;

import frc.team3324.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmStart extends Command {

	private boolean finished = false;

    public MoveArmStart() {
    	requires(Robot.mIntakeArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	double goalPulse = 45;
//    	double speed = 0.0;
//    	double currentPulse = Robot.mIntakeArm.getRawArm();
//		SmartDashboard.putNumber("CURRENTPULSE", currentPulse);
//    	double diffPulse = goalPulse - currentPulse;
//		//
//    	if (Math.abs(diffPulse) > 0.5) {
//    		speed = diffPulse / 45;
//        	finished = false;
//    	}
//    	else {
//    		speed = 0.0;
//    		Robot.mIntakeArm.armMovement(0.0);
//    		finished = true;
//    	}
//
//    	Robot.mIntakeArm.armMovement(speed);
    	Robot.mIntakeArm.RotateARM(45, 0.5);
      	if (Robot.mIntakeArm.RotateARM(45, 0.5) < 0.1) {
    		finished = true;
    	}
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
