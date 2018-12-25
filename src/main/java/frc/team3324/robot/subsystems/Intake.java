package frc.team3324.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.team3324.robot.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Intake extends Subsystem {

    WPI_VictorSPX leftIntakeMotor;
    WPI_VictorSPX rightIntakeMotor;
    SpeedControllerGroup intakeMotors;

    public Intake() {
        leftIntakeMotor  = new WPI_VictorSPX(Constants.Intake.LEFT_INTAKE_MOTOR_PORT);
        rightIntakeMotor = new WPI_VictorSPX(Constants.Intake.RIGHT_INTAKE_MOTOR_PORT);
        leftIntakeMotor.setInverted(true);
        intakeMotors = new SpeedControllerGroup(leftIntakeMotor, rightIntakeMotor);
    }

    // TODO Invert left set motor
    public void set(double speed) { intakeMotors.set(speed); }

    @Override
    public void initDefaultCommand() {}
}