package frc.team3324.robot.subsystems;

import frc.team3324.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3324.robot.commands.teleop.ControlArm;

public class Arm extends Subsystem {
    // TODO Invert stuff
    private WPI_VictorSPX armMotorLeft     = new WPI_VictorSPX(Constants.Arm.MOTOR_PORT_ARM_LEFT);
    private WPI_VictorSPX armMotorRight    = new WPI_VictorSPX(Constants.Arm.MOTOR_PORT_ARM_RIGHT);
    private SpeedControllerGroup armMotors = new SpeedControllerGroup(armMotorLeft, armMotorRight);

    public Arm() {
        // CAUTION: direction already set, don't change it
        if (armMotorLeft.getInverted()) { armMotorLeft.setInverted(true); }
    }

    /**
	 * Move the arm at the specified speed.
	 * @param speed
	 */
    public void armMovement(double speed) { armMotors.set(speed); }

    public void initDefaultCommand() { setDefaultCommand(new ControlArm()); }
}