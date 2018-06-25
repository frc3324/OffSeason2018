 package frc.team3324.commands.auto;

import frc.team3324.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotatePID extends Command {
	double angle2;
	double speed2;
	double turn;
	private boolean finished;
    public RotatePID(double angle1, double speed1) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.mDriveTrain);
    	angle2 = angle1;
    	speed2 = speed1;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	turn = Robot.mDriveTrain.RotatePID(angle2, speed2);
    	Robot.mDriveTrain.arcadeDrive(0, turn, false);
    	if (Robot.mDriveTrain.RotatePID(angle2, speed2) < 0.1) {
    		finished = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
