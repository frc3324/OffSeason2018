package org.metrobots.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gyro extends Subsystem {
	private AHRS mAhrs;

	public Gyro() {
		try {
			mAhrs = new AHRS(SPI.Port.kMXP);
		} catch (RuntimeException ex ) {
			DriverStation.reportError("Error Connecting:  " + ex.getMessage(), true);
		}
	}
	
	public double getPidAngle() {
		return mAhrs.pidGet();
	}
	
	public void clear() {
		mAhrs.reset();
	}

     public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

