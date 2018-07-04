package frc.team3324.robot.subsystems;

import frc.team3324.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeController extends Subsystem {

	WPI_VictorSPX leftIntakeMotor = new WPI_VictorSPX(Constants.leftIntakeMotorPort);
	WPI_VictorSPX rightIntakeMotor = new WPI_VictorSPX(Constants.rightIntakeMotorPort);

	public CubeController() {
	}

	public void intake(double speed) {
		leftIntakeMotor.set(-speed);
		rightIntakeMotor.set(speed);
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
