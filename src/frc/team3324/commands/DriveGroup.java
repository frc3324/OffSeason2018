package frc.team3324.commands;

import frc.team3324.OI;
import frc.team3324.Robot;
import frc.team3324.commands.teleop.ClimberSlideDown;
import frc.team3324.commands.teleop.ClimberSlideUp;
import frc.team3324.commands.teleop.ControlArm;
import frc.team3324.commands.teleop.DriveTank;
import frc.team3324.commands.teleop.LaunchCube;
import frc.team3324.commands.teleop.PressureSwitch;
import frc.team3324.commands.teleop.Winches;

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
