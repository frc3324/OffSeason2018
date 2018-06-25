package org.metrobots;

//import edu.wpi.first.wpilibj.SPI;

/**
 * Class with tons of constants that won't need to change on the fly.<br>
 * Examples: motor controller ports, sensor ports, gamepad ports,
 * etc.<br>
 * <br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 *
 * Feb 8: Added agitator Motor port; needs put on the robot - Xander
 *
 */
public class Constants {

	/*
	 * Motor ports
	 */
	public final static int flMotorPort = 6; 
	public final static int blMotorPort = 4; 
	public final static int frMotorPort = 0; 
	public final static int brMotorPort = 2; 
	public final static int MOTOR_PORT_ARM_LEFT = 9; 
	public final static int MOTOR_PORT_ARM_RIGHT = 8; 
	public final static int leftIntakeMotorPort = 7; 
	public final static int rightIntakeMotorPort = 3; 
	public final static int LINEAR_SLIDE_MOTOR_PORT = 1; 
	public final static int WINCH_PORT = 5;

	/*
	 * Sensor ports
	 */
	//public final static SPI.Port navxPort = SPI.Port.kMXP;
	
	public final static int leftEncoderPortA = 0; //Checked Buckeye
	public final static int leftEncoderPortB = 1; //Checked Buckeye
	public final static int rightEncoderPortA = 2; //Checked Buckeye
	public final static int rightEncoderPortB = 3; //Checked Buckeye
	public final static int ArmEncoderACLK = 6; //Checked Buckeye
	public final static int ArmEncoderSW = 4; //Checked Buckeye
	public final static int ArmEncoderDT = 5; //Checked Buckeye
//	public final static int LimitSwitchFrontPort = 8;
//	public static final int LimitSwitchBackPort = 9;
	
//	public final static int CAMERA_PORT = 0;
	
	
	/*
	 * Driver station ports
	 */
	public final static int primaryGamepadPort = 0; 
	public final static int secondaryGamepadPort = 1; 
	
	/*
	 * 
	 * Intake/Outtake variables
	 */
	/*
	 * DriveTrain variables
	 */
	public static double kDriveHoldAngleP = 0.007;
	public final static double driveTrainAngleDeadband = 3; 
	public final static double AXIS_DEADBAND = 0.05;
	public final static double CIRCUMFERENCE = 18.85; // (Inches) Need to measure in inches
	public final static double PULSES = 2639.43;
	public final static double INCH_PER_PULSE = 0.074; //circumference of wheel in inches / pulses
	public final static double AUTO_ROTATE_ANGLE_THRESHOLD = 0.3;
	public final static double ENCODER_CONVERSION_RATE = 0.68667;
	public final static double DISTANCE_BETWEEN_WHEELS = 22.5;
}
