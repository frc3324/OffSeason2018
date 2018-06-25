package org.metrobots.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

	private DoubleSolenoid gearShifter = new DoubleSolenoid(0, 1);
	
	public Pneumatics() {
		
	}
	
	public void setHighGear() {
		gearShifter.set(DoubleSolenoid.Value.kForward);
//		Robot.mStatusLED.setStateHigh();
	}
	
	public void setLowGear() {
		gearShifter.set(DoubleSolenoid.Value.kReverse);
//		Robot.mStatusLED.setStateLow();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

