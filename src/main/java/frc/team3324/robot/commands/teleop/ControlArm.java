package frc.team3324.robot.commands.teleop;

import frc.team3324.robot.Constants;
import frc.team3324.robot.OI;
import frc.team3324.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Moves the intake arm from forward to backward with the press of a button.
 * The button acts as a toggle.
 *
 */
public class ControlArm extends Command {
	boolean finished = false;
	int number = 0;

	boolean startPosition = true; //Assumes arm in starting position at match start
	double goalPulse = 0.0;
	double armSpeed = 0.0;

	boolean pastSwitch = false;

	/**
	 * Move the arm to its opposite position when called. <p>
	 */
    public ControlArm() {
    	requires(Robot.mIntakeArm);
    }

    /*
     * Arm should be set to starting position.
     */
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    /*
     * voltage to motor speed
     *
     */
    protected void execute() {

    	double leftY = OI.get1LeftYAxis();

    	DriverStation.reportError("X AXIS" + leftY, false);

    	Robot.mIntakeArm.armMovement(leftY);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return finished;
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
