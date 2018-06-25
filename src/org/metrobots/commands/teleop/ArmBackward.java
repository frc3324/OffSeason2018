//package org.metrobots.commands.teleop;
//
//import org.metrobots.Robot;
//import org.metrobots.subsystems.IntakeArm;
//
//import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//
///**
// *
// */
//public class ArmBackward extends Command {
//	boolean finished;
//    public ArmBackward() {
//        // Use requires() here to declare subsystem dependencies
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	double goalPulse = 40;
//		DriverStation.reportError("A pressed", false);
//    	double speed = 0.0;
//    	double currentPulse = Robot.mIntakeArm.getRawArm();
//		SmartDashboard.putNumber("CURRENTPULSE (LINEPLOT): ", currentPulse);
//		SmartDashboard.putNumber("CURRENTPULSE (textbox): ", currentPulse);
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
//    	/************************************/
//    	Robot.mIntakeArm.printEncoder();
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//		return finished;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
