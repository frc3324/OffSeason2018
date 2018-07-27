package  frc.team3324.robot.commands.teleop;

import  frc.team3324.robot.OI;
import  frc.team3324.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftGears extends Command {

	boolean gearShifterStatus = false;
	
	public ShiftGears() { }
	
    protected void initialize() { }

    protected void execute() {
    	if (OI.gamepad0.getAButton()) {
    		if (gearShifterStatus) {
        		Robot.mDriveTrain.setHighGear();
        		gearShifterStatus = !gearShifterStatus;
    		}
    		else {
        		Robot.mDriveTrain.setLowGear();
        		gearShifterStatus = !gearShifterStatus;
        	}
    	}
    }

    protected boolean isFinished() {
		return false;
    }

    protected void end() { end(); }

    protected void interrupted() { }
}