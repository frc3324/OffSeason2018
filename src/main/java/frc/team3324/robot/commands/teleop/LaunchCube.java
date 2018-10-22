package frc.team3324.robot.commands.teleop;

import frc.team3324.robot.OI;
import frc.team3324.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;

public class LaunchCube extends Command {

    private double speed = 0.0;

    /**
	 * Spin wheels inward. <p>
	 */
    public LaunchCube() { requires(Robot.mCubeController); }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (OI.gamepad1.getBumper(GenericHID.Hand.kLeft)) {
            speed = -0.8;
        } else if (OI.gamepad1.getBumper(GenericHID.Hand.kRight)) {
            speed = 1.0;
        } else if (OI.gamepad1.getAButton()) {
            speed = 0.3;
        } else {
            speed = 0.0;
        }
        Robot.mCubeController.intake(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() { return false; }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}