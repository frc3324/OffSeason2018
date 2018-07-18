package frc.team3324.robot.commands.teleop;

import frc.team3324.robot.OI;
import frc.team3324.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

import frc.team3324.robot.subsystems.DriveTrain;

public class Shift extends Command {
	boolean gearShifterStatus = false;
	
	public Shift() {
	}
	
    protected void initialize() {

    }

   
    protected void execute() {
    	if (OI.get0AButtonPressed()) {
    		if (gearShifterStatus) {
        		Robot.mDriveTrain.setHighGear();
        		DriverStation.reportError("True", false);
        		gearShifterStatus = !gearShifterStatus;
        		
        	} else {
        		DriverStation.reportError("False", false);
        		Robot.mDriveTrain.setLowGear();
        		gearShifterStatus = !gearShifterStatus;
        	}
    	}
    }

  
    protected boolean isFinished() {
    	 return false;
    }

  
    protected void end() {
    	end();
    }

  
    protected void interrupted() {
    	
    }
}
