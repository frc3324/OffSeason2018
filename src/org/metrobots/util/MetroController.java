package org.metrobots.util;

import org.metrobots.Constants;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

/**
 * Class which makes the Joystick class easier to use<br>
 * <br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 *
 */
public class MetroController {
	
/*
	 * Analog Inputs (Axes)
	 */
	public static final int LEFT_X = 0;
	public static final int LEFT_Y = 1;
	public static final int LT = 2;
	public static final int RT = 3;
	public static final int RIGHT_X = 4;
	public static final int RIGHT_Y = 5;

	/*
	 * Digital Inputs/Ports (Buttons)
	 */
	public static final int BUTTON_A = 1;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_X = 3;
	public static final int BUTTON_Y = 4;
	public static final int LB = 5;
	public static final int RB = 6;
	public static final int BUTTON_BACK = 7;
	public static final int BUTTON_START = 8;
	public static final int JOYSTICK_LEFT_CLICK = 9;
	public static final int JOYSTICK_RIGHT_CLICK = 10;

	public static final double AXIS_DEADBAND = 0.01;

	private XboxController gamepad;
	private GenericHID.Hand hand;
	

	/**
	 * Creates instance of MetroGamepad
	 * 
	 * @param port
	 *            Port of the gamepad
	 */
	public MetroController(int port) {
		gamepad = new XboxController(port);
	}

	/**
	 * Read the value of an axis
	 * 
	 * @param axis
	 *            The axis you want to get the value from
	 * @return Value of axis, value from -1.0 to 1.0
	 */
	/*public double getAxis(int axis) {
		try {
			double value = gamepad.getRawAxis(axis);
			double output = 0;
			if (Math.abs(value) > AXIS_DEADBAND) {
				if (axis == LEFT_Y || axis == RIGHT_Y || axis == 3) {
					output = -value;
				} else {
					output = value;
				}
			}
			return output;
		} catch (Exception e) {
			return 0;
		}
	} */
	
	public double getLeftX() { //Method for getting the left x value from the left joystick
		try {
			double leftXValue = gamepad.getX(hand.kLeft); // leftXValue is the x value from the hand enum in GenericHID 
			return leftXValue; // Tell us what that value is if we call the getLeftX method
			//Line to combine previous two lines
			//return (double) gamepad.getX(hand.kLeft);
		}
		catch (Exception e) { 
			return 0;
		}
	}
	
	public double getRightX() { // Repeat for the X-axis on the right axis
		try {
			double rightXValue = gamepad.getX(hand.kRight);
			return rightXValue;
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	public double getLeftY() {
		try {
			double leftYValue = gamepad.getY(hand.kLeft);
			return leftYValue;
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	public double getRightY() {
		try {
			double rightYValue = gamepad.getY(hand.kRight);
			return rightYValue;
		}
		catch (Exception e) {
			return 0;
		}
	}
	public double getLeftTrigger() {
		try {
			double leftTriggerValue = gamepad.getTriggerAxis(hand.kLeft);
			return leftTriggerValue;
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	public double getRightTrigger() {
		try {
			double rightTriggerValue = gamepad.getTriggerAxis(hand.kRight);
			return rightTriggerValue;
			
		}
		catch (Exception e) {
			return 0; 
		}
	}
	
	public boolean getLeftBumper() {
		try {
			boolean leftBumperValue = gamepad.getBumper(hand.kLeft);
			return leftBumperValue;
			
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public boolean getRightBumper() {
		try {
			boolean rightBumperValue = gamepad.getBumper(hand.kRight);
			return rightBumperValue;
		}
		catch (Exception e){
			return false;
		}
	}
	
	/**
	 * Read the anle on the DPad
	 * 
	 * @return Angle of DPad (degrees)
	 */
	public int getDPadAngle() {
		int angle = 0;
		try {
			angle = gamepad.getPOV();
		} catch (Exception e) {
			angle = -1;
		}
		if (angle == -1) {
			return -1;
		} else if (angle == 90) {
			return 0;
		} else if (angle == 180) {
			return 270;
		} else if (angle == 270) {
			return 180;
		} else if (angle == 45) {
			return 45;
		} else if (angle == 135) {
			return 315;
		} else if (angle == 225) {
			return 225;
		} else if (angle == 315) {
			return 135;
		} else if (angle == 0) {
			return 90;
		}

		return angle;
	}

	/**
	 * Read the X component of the DPad
	 * 
	 * @return X component of DPad, value from -1.0 to 1.0
	 */
	public double getDPadX() {
		if (getDPadAngle() == -1) {
			return 0;
		}
		return Math.cos(Math.toRadians(getDPadAngle()));
	}

	/**
	 * Read the Y component of the DPad
	 * 
	 * @return Y component of DPad, value from -1.0 to 1.0
	 */
	public double getDPadY() {
		if (getDPadAngle() == -1) {
			return 0;
		}
		return Math.sin(Math.toRadians(getDPadAngle()));
	}

	/**
	 * Read the value of a button
	 * 
	 * @param button
	 *            The button you want to get the value from
	 * @return Value of the button (boolean)
	 */
	public boolean getButton(int button) {
		boolean buttonVal;
		try {
			buttonVal = gamepad.getRawButton(button);
		} catch (Exception e) {
			buttonVal = false;
		}
		return buttonVal;
	}

	public boolean getAPressed() {
		try {
			boolean APressed = gamepad.getAButtonPressed();
			return APressed;
		}
		catch (Exception e){
			return false;
		}
	}
}
