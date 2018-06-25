package org.metrobots.subsystems;

import org.metrobots.Robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDStabilization extends Subsystem implements PIDOutput {
	AHRS ahrs;
	PIDController turnController;
	double rotateToAngleRate;
	static final double kP = 0.06;
	static final double kI = 0.00;
	static final double kD = 0.00;
	static final double kF = 0.00;
	static final double kToleranceDegrees = 2.0f;
	double currentRotationRate;
    // Initialize your subsystem here
    public PIDStabilization() {
    	  try {
	          /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
	          /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
	          /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
	          ahrs = new AHRS(SPI.Port.kMXP); 
	      } catch (RuntimeException ex ) {
	          DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
	      }
	      turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
	      turnController.setInputRange(-180.0f,  180.0f);
	      turnController.setOutputRange(-1.0, 1.0);
	      turnController.setAbsoluteTolerance(kToleranceDegrees);
	      turnController.setContinuous(true);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
	public void GyroStabilize(double speed) { // Necessary code for rotating using PID with rotate
		if(!turnController.isEnabled()) {
			// Acquire current yaw angle, using this as the target angle.
			turnController.setSetpoint(ahrs.getYaw());
			rotateToAngleRate = 0; // This value will be updated in the pidWrite() method.
			turnController.enable();
		}
		double leftStickValue = speed + rotateToAngleRate;
		double rightStickValue = speed - rotateToAngleRate;
		SmartDashboard.putNumber("GyroGoal", rotateToAngleRate);
		SmartDashboard.putNumber("GyroReading", ahrs.getYaw());
		Robot.mDriveTrain.tankDrive(leftStickValue, rightStickValue, false);	
	}
	
	public void turnControllerDisable() { //Disables the PIDController
		  turnController.disable();
	}
	
	public void pidWrite(double output) {
	    rotateToAngleRate = output;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
