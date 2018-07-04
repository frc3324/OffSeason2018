package frc.team3324.robot.commands.teleop;

import frc.team3324.robot.OI;
import frc.team3324.robot.Robot;

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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	Robot.mCubeController.intake(0.0);

    }
}
