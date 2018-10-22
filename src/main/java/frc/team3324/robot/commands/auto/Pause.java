package frc.team3324.robot.commands.auto;

import frc.team3324.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pause extends Command {

    private Timer timer = new Timer();

    private double time;

    private boolean isFinished = false;

    public Pause(double time) { this.time = time; }

    // Called just before this Command runs the first time
    protected void initialize() { timer.start(); }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (timer.get() < time) {
            Robot.mDriveTrain.mDrive.arcadeDrive(0.0, 0.0, false);
            isFinished = false;
        } else {
            Robot.mDriveTrain.mDrive.arcadeDrive(0.0, 0.0, false);
            isFinished = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() { return isFinished; }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}
