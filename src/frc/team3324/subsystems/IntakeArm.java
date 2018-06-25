package frc.team3324.subsystems;

import frc.team3324.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeArm extends Subsystem implements PIDOutput {
	  PIDController turnController;
	private double rotateToAngleRate;
	static final double kP = 0.03;
	static final double kI = 0.00;
	static final double kD = 0.00;
	static final double kF = 0.00;
	static final double kToleranceDegrees = 2.0f;

//	DigitalInput limitSwitch = new DigitalInput(9);
//    Counter counter = new Counter(limitSwitch);
	static Encoder armEncoder = new Encoder(Constants.ArmEncoderACLK, Constants.ArmEncoderDT, Constants.ArmEncoderSW);
//	static Encoder testArmEncoder = new Encoder(Constants.testArmEncoderA, Constants.testArmEncoderB);
//	static Encoder testArmEncoder = new Encoder(Constants.testArmEncoderA, Constants.testArmEncoderB);

	private WPI_VictorSPX armMotorLeft = new WPI_VictorSPX(Constants.MOTOR_PORT_ARM_LEFT);
	private WPI_VictorSPX armMotorRight = new WPI_VictorSPX(Constants.MOTOR_PORT_ARM_RIGHT);
	private SpeedControllerGroup armMotors = new SpeedControllerGroup(armMotorLeft, armMotorRight);

	public IntakeArm() {
		// CAUTION: direction already set, don't change it
		if (armMotorLeft.getInverted()) {
			armMotorLeft.setInverted(true);
		}
		 turnController = new PIDController(kP, kI, kD, kF, armEncoder, this);
//		 turnController = new PIDController(kP, kI, kD, kF, armEncoder.getDistance(), this); Option 2
	      turnController.setInputRange(-45f,  45f);
	      turnController.setOutputRange(-1.0, 1.0);
	      turnController.setAbsoluteTolerance(kToleranceDegrees);
	      turnController.setContinuous(true);
	}

	/**
	 * Reset the arm encoder to zero.
	 */
//    public boolean isSwitchSet() {
//        return counter.get() > 0;
//    }
//    public void initializeCounter() {
//        counter.reset();
//    }
	  public double RotateARM(double angle, double speed) { // Necessary code for rotating using PID with rotate
              turnController.setSetpoint(angle);
          double currentMovementRate;
              turnController.enable();
              currentMovementRate = rotateToAngleRate * speed;
              turnController.disable();
              currentMovementRate = 0;
          try {

          } catch( RuntimeException ex ) {
              DriverStation.reportError("Error communicating with drive system:  " + ex.getMessage(), true);
          }
          SmartDashboard.putNumber("Gyro", currentMovementRate);
//          SmartDashboard.putNumber("Gyro1", ());
          return currentMovementRate;
      }

	public void resetEncoder() {
		armEncoder.reset();
//		testArmEncoder.reset();
	}

	/**
	 * Get encoder distance in units.
	 * @return
	 */
	public double getRawArm() {
//		return armEncoder.getRate();
		return armEncoder.getDistance();
//		return 0.00;
//		return testArmEncoder.get();
	}

	public void printEncoder() {
		//SmartDashboard.putNumber("R Rate: ", armEncoder.get()); // unit: distance per sec
		int val = 0;
		SmartDashboard.putNumber("Program is Running", val);
		val++;
		SmartDashboard.putNumber("R Rate:", armEncoder.get());
//		DriverStation.reportError("R rate: " + armEncoder.get(), false);
//		DriverStation.reportError("TESTRATE: " + testArmEncoder.get(), false);
//		SmartDashboard.putNumber("R Rate: ", testArmEncoder.get()); // unit: distance per sec
//		int val = 0;
//		SmartDashboard.putNumber("Program is Running", val);
//		val++;
	}
	 /**
	  * Move the arm at specified velocity.
	  * @param speed
	  */

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
    public void pidWrite(double output) {
        rotateToAngleRate = output;
    }
}
