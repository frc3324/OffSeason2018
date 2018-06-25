package org.metrobots.commands.teleop;

import org.metrobots.Constants;
import org.metrobots.OI;
import org.metrobots.Robot;
//import org.metrobots.subsystems.LimitSwitch;

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
//	public PowerDistributionPanel pdp = new PowerDistributionPanel();
	
//	Encoder leftEncoder;
//	Encoder rightEncoder;
	boolean finished = false;
	int number = 0;
//	double currentValue = 0.0;
	
	boolean startPosition = true; //Assumes arm in starting position at match start
	double goalPulse = 0.0;
	double armSpeed = 0.0;
	
	boolean pastSwitch = false;
	
//	LimitSwitch limitA, limitB;
	
	/**
	 * Move the arm to its opposite position when called. <p>
	 */
    public ControlArm() {
    	requires(Robot.mIntakeArm);
//    	limitA = new LimitSwitch(Constants.LimitSwitchFrontPort);
//    	limitB = new LimitSwitch(Constants.LimitSwitchBackPort);
    }

    /*
     * Encoders reset to 0.0.
     * Arm should be set to starting position.
     */	
    protected void initialize() {
//    	Robot.mIntakeArm.resetEncoder();
    	
//    	DriverStation.reportError("HERE!!!!!", false);
//    	
    }

    // Called repeatedly when this Command is scheduled to run
    /*
     * voltage to motor speed
     * 
     */
    protected void execute() {

    	/*******************************/
    	//aka don't forget to count pulses in a full rotation of the intake arm
//    	if (OI.get1AButton()) {
//    		goalPulse = 0.0;
//    		DriverStation.reportError("A pressed", false);
//    	}
//    	else if (OI.get1BButton()){
//    		goalPulse = 11.25;
//    		DriverStation.reportError("B pressed", false);
//
//    	}
//    	else if (OI.get1XButton()) {
//    		goalPulse = 33.25;
//    		DriverStation.reportError("X pressed", false);
//
//    	}
//    	else if (OI.get1YButton()) {
//    		goalPulse = 45.0;
//    		DriverStation.reportError("Y pressed", false);
//
//    	}//useful like me
//    	double speed = 0.0;
    	double currentPulse = Robot.mIntakeArm.getRawArm();
		SmartDashboard.putNumber("CURRENTPULSE", currentPulse);
//		SmartDashboard.putNumber("GOALPULSE", goalPulse);
//    	double diffPulse = goalPulse + currentPulse; //change to minus if the currentPulse is positive
//    	
//    	if (Math.abs(diffPulse) > 0.0) {
//    		speed = diffPulse / 15;
////        	finished = false;
//    	}
//    	else {
//    		speed = 0.0;
////    		mIntakeArm.armMovement(0.0);
//    	}
//    	
//    	Robot.mIntakeArm.armMovement(speed);
    	/************************************/
    	
//    	if (diffPulse > 0.5) {
////        	double velocity = diffPulse / 200;
//    		if (diffPulse < 0.0) {
//    			speed = -speed;
//    		}
//        	mIntakeArm.armMovement(speed);
////    		finished = false;
//    	}
//    	else {
////    		mIntakeArm.armMovement(0.0);
////    		finished = true;
//    		
//    	}
//    	SmartDashboard.putNumber("DIFFPULSE (lineplot): ", diffPulse);
    	
//    	mIntakeArm.armMovement(0.5);
//    	mIntakeArm.printEncoder();
    	//mIntakeArm.printEncoder(); //right
    	
    	/******************************************************************/
    	//MAGIC NUMBER: 45
//    	mIntakeArm.initializeCounter();
//    	boolean isSwitch = mIntakeArm.isSwitchSet();
//    	SmartDashboard.putBoolean("Switch:", isSwitch);
//    	if (!limitA.isSwitchSet() && !limitB.isSwitchSet()) {
//    		
//	    	double leftY = gamepad1.getY(Hand.kLeft);
//	    	double speedArm = leftY * 1;
//	    	mIntakeArm.armMovement(speedArm);
//	    	
//	    } else {
//	    	
//	    	mIntakeArm.armMovement(0.0);
//	    	limitA.reset();
//	    	limitB.reset();
//	    	DriverStation.reportWarning("LIMIT SWITCHES WENT OFF", false);
//	    }
//    	
    	/******************************************************************/
    	double leftY = OI.get1LeftYAxis();
    	DriverStation.reportError("X AXIS" + leftY, false);
    	Robot.mIntakeArm.armMovement(leftY);
    	double joystickCurrentPulse = Robot.mIntakeArm.getRawArm();
    	SmartDashboard.putNumber("CURRENTPULSE: ", joystickCurrentPulse);
//    	double armCurrent = pdp.getCurrent(Constants.MOTOR_PORT_ARM_LEFT);
//    	SmartDashboard.putNumber("Left arm current", armCurrent);
    	/******************************************************************/
    	
    	/***********************LIMITSWITCH*******************************/
//    	if (Robot.mLimitSwitch.isBackSwitchPressed() && pastSwitch == false) { // && Math.abs(leftY) > 0
////    		Robot.mIntakeArm.armMovement(0.2);
//    		SmartDashboard.putBoolean("Limit switch pressed", pastSwitch);
//    		pastSwitch = true;
//    	}
//    	else if (Robot.mLimitSwitch.isBackSwitchPressed() && pastSwitch == true) {
//    		Robot.mIntakeArm.armMovement(leftY);
//    		pastSwitch = false;
//    		SmartDashboard.putBoolean("Out of pressed zone", pastSwitch);
//    	}
    	/***********************LIMITSWITCH*******************************/
    	
    }
    
//    	DriverStation.reportError("GOALPULSE: " + mIntakeArm.getRawArm(), false);
     /**
      * Variables for moving the arm.
      * 
      * goalPulse is the specified pulse value from the encoders. Since there are six positions (full forward, switch forward, scale forward,
      * scale backward, switch backward, full backward), there will be six different goalPulses.
      * Note: The numbers for these ARE ARBITRARY and just happen to look like angles (but they will resemble the numbers eventually).
      * 
      * currentPulse is the pulse value that arm is at.
      * 
      * maxPulse is the maximum value able to be received from the encoders, assuming one end is 0.0 and there are no negative numbers.
      * 
      * armSpeed is the speed to set the arm motor to based on the code below.
      * 
      * differencePulse is the amount of pulses to travel in order to reach goalPulse.
      * 
      * state is whether the arm should be moving forward or backward to reach goalPulse. True if going toward front of robot, false if 
      * going backward.
      */
   

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
