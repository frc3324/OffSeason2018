package frc.team3324.robot.commands;

import frc.team3324.robot.commands.teleop.ArmPID;
import frc.team3324.robot.commands.teleop.ControlArm;
import frc.team3324.robot.commands.teleop.DriveTank;
import frc.team3324.robot.commands.teleop.LaunchCube;
import frc.team3324.robot.commands.teleop.ShiftGears;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Group of commands that need to be run during teleop<br><br>
 */
public class DriveGroup extends CommandGroup {

	/**
	 * Adds teleop commands to be run in parallel:<br>
	 * &emsp;DriveTank<br>
	 * &emsp;PressureSwitch<br>
	 * &emsp;ControlArm<br>
	 */
	public DriveGroup() {
		this.addParallel(new DriveTank()); //gamepad0, joysticks
		this.addParallel(new ControlArm()); //gamepad1, left joystick
		this.addParallel(new LaunchCube());
		this.addParallel(new ShiftGears());
		this.addParallel(new ArmPID());
	}
}