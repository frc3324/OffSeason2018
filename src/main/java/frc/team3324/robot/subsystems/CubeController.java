package frc.team3324.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.team3324.robot.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class CubeController extends Subsystem {
    ;
    WPI_VictorSPX leftIntakeMotor;
    WPI_VictorSPX rightIntakeMotor;
    SpeedControllerGroup intakeMotors;
    public CubeController() {
        leftIntakeMotor = new WPI_VictorSPX(Constants.LEFT_INTAKE_MOTOR_PORT);
        rightIntakeMotor = new WPI_VictorSPX(Constants.RIGHT_INTAKE_MOTOR_PORT);
        leftIntakeMotor.setInverted(true);
        intakeMotors = new SpeedControllerGroup(leftIntakeMotor, rightIntakeMotor);
    }

    // TODO Invert left intake motor
    public void intake(double speed) { intakeMotors.set(speed); }

    public void initDefaultCommand() {}
}