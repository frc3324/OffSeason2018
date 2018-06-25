package org.metrobots.util;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StatusLED {

	// Chasing LED strip lights?!! Maybe?!!
	private DigitalOutput redLights;
	private DigitalOutput greenLights;
	private DigitalOutput blueLights;
	boolean isPulsing = false; 
	
	public StatusLED() {
		redLights = new DigitalOutput(4);
		greenLights = new DigitalOutput(5);
		blueLights = new DigitalOutput(6);
	}
	
	/**
	 * Set state to show cube is in the intake (green).
	 */
	public void setStateHigh() {
		greenLights.set(true);
	}
	
	/**
	 * Set state to show cube is not in the intake (red).
	 */
	public void setStateLow() {
		redLights.set(true);
	}
	
	/**
	 * Alternatively turn on and off the lights of the robot (red, green, blue).
	 */
	public void setPartyMode() {
		redLights.pulse(100);
		greenLights.pulse(100);
		blueLights.pulse(100);
		isPulsing = redLights.isPulsing();
		SmartDashboard.putBoolean("Pulsing?", isPulsing);
	}
	
	/**
	 * Stop pulsing of the lights.
	 * @param lightType
	 */
	public void stopPulse(Solenoid lightType) {
		lightType.set(false);
	}
	
	/**
	 * Set state of robot to brownout (rapid blinking red).
	 */
	public void setStateBrownout() {
		redLights.pulse(10);
	}
	
}
