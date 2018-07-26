package  frc.team3324.robot.subsystems;

import  frc.team3324.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeController extends Subsystem {

	WPI_VictorSPX leftIntakeMotor = new WPI_VictorSPX(Constants.LEFT_INTAKE_MOTOR_PORT);
	WPI_VictorSPX rightIntakeMotor = new WPI_VictorSPX(Constants.RIGHT_INTAKE_MOTOR_PORT);

	public CubeController() { }

	// TODO Invert left intake motor
	public void intake(double speed) {
		leftIntakeMotor.set(-speed);
		rightIntakeMotor.set(speed);
	}

	public void initDefaultCommand() { }
}