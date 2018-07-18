package frc.team3324.robot.commands.auto;

import frc.team3324.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pause extends Command {

	Timer timer = new Timer();
	double time;
	boolean timerFinished = false;

    public Pause(double pauseTime) {
    	time = pauseTime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (timer.get() < time) {
    		Robot.mDriveTrain.arcadeDrive(0.0, 0.0, false);
    		timerFinished = false;
    	}
    	else {
    		Robot.mDriveTrain.arcadeDrive(0.0, 0.0, false);
    		timerFinished = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timerFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
