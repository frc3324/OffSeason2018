package frc.team3324.robot.subsystems;

import frc.team3324.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeArm extends Subsystem {



	private WPI_VictorSPX armMotorLeft = new WPI_VictorSPX(Constants.MOTOR_PORT_ARM_LEFT);
	private WPI_VictorSPX armMotorRight = new WPI_VictorSPX(Constants.MOTOR_PORT_ARM_RIGHT);
	private SpeedControllerGroup armMotors = new SpeedControllerGroup(armMotorLeft, armMotorRight);

	public IntakeArm() {
		// CAUTION: direction already set, don't change it
		if (armMotorLeft.getInverted()) {
            armMotorLeft.setInverted(true);
        }
	}
	/**
	 * Move the arm at the specified speed.
	 * @param speed
	 */
	public void armMovement(double speed) {
		armMotors.set(speed);
	}

    public void initDefaultCommand() {
        //Do nothing
    }
}
