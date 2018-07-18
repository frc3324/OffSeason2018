package frc.team3324.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3324.robot.Constants;

/**
 *
 */
public class TestArm extends Subsystem {
	
	private WPI_TalonSRX testArm = new WPI_TalonSRX(Constants.testArm);
	PowerDistributionPanel mPDP = new PowerDistributionPanel();
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private double Kp;
	private double Ki;
	private double Kd;
	private static Encoder armEncoder = new Encoder(Constants.armEncoderA, Constants.armEncoderB, false, Encoder.EncodingType.k4X);
    
	public void moveTestArm(double speed) {
		testArm.set(speed);
	}
	public void breakArm() {
		testArm.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);	
	}
	public void coastArm() {
		testArm.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);	

	}
	public double getEncoder() {
		return armEncoder.getRaw();
	}
	public double getCurrent(int port) { //int currentPort

    	return mPDP.getCurrent(port);

    }
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

