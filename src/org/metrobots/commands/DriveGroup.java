package org.metrobots.commands;

import org.metrobots.OI;
import org.metrobots.Robot;
import org.metrobots.commands.teleop.ClimberSlideDown;
import org.metrobots.commands.teleop.ClimberSlideUp;
import org.metrobots.commands.teleop.ControlArm;
import org.metrobots.commands.teleop.DriveTank;
import org.metrobots.commands.teleop.LaunchCube;
import org.metrobots.commands.teleop.PressureSwitch;
import org.metrobots.commands.teleop.Winches;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Group of commands that need to be run during teleop<br><br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 *
 */
public class DriveGroup extends CommandGroup {
	
	/**
	 * Adds teleop commands to be run in parallel:<br>
	 * &emsp;DriveTank<br>
	 * &emsp;PressureSwitch<br>
	 * &emsp;ControlArm<br>
	 */
	//Set ControlArm and ClimberSlide to different controls
	public DriveGroup() {
		this.addParallel(new DriveTank()); //gamepad0, joysticks
		this.addParallel(new PressureSwitch()); //gamepad0, a button
		this.addParallel(new ControlArm()); //gamepad1, left joystick
		this.addParallel(new LaunchCube());
//		this.addParallel(new Outtake()); //gamepad1, right bumper
//		this.addParallel(new IntakeTeleop()); //gamepad1, left bumper
//		this.addParallel(new OuttakeTeleop()); //gamepad1, right bumper
//		this.addParallel(new ClimberSlideUp()); //gamepad1, a button and b button //a and x //a
//		this.addParallel(new ClimberSlideDown()); //b
		this.addParallel(new Winches()); //gamepad1, x button // b button
	}
	
}
