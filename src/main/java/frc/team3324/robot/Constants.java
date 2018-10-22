package frc.team3324.robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

// import edu.wpi.first.wpilibj.SPI;

/**
 * Class with unchanging variables. <br>
 * Examples: motor controller ports, sensor ports, gamepad ports,
 * etc.<br>
 * <br>
 */
public class Constants {
    // TODO Research const
    /*
     * Motor ports (drivetrain, arm, intake)
     */
    public final static int FL_MOTOR_PORT = 6;
    public final static int BL_MOTOR_PORT = 4;
    public final static int FR_MOTOR_PORT = 0;
    public final static int BR_MOTOR_PORT = 2;
    public final static int MOTOR_PORT_ARM_LEFT = 9;
    public final static int MOTOR_PORT_ARM_RIGHT = 8;
    public final static int LEFT_INTAKE_MOTOR_PORT = 7;
    public final static int RIGHT_INTAKE_MOTOR_PORT = 3;
    public final static int TEST_ARM = 5;

    /*
     * Sensor ports (encoder)
     */
    public final static int LEFT_ENCODER_PORT_A = 0;  // Checked Buckeye
    public final static int LEFT_ENCODER_PORT_B = 1;  // Checked Buckeye
    public final static int RIGHT_ENCODER_PORT_A = 2; // Checked Buckeye
    public final static int RIGHT_ENCODER_PORT_B = 3; // Checked Buckeye
    public final static int ARM_ENCODER_A = 4;        // Checked Buckeye
    public final static int ARM_ENCODER_B = 5;        // Checked Buckeye

    /*
     * DriveTrain variables
     */
    public final static double CIRCUMFERENCE = 18.85; // (Inches) Need to measure in inches
    public final static double WHEEL_DIAMETER_METERS = 0.15240359;
    public final static int ACTUAL_PULSES = 7680; // 256 (pulses) * 4 (quadature, 4 ticks/pulse) * 3 * 2.5 (gear ratios)
    public final static double ENCODER_CONVERSION_RATE = 0.68667;
    public final static double DISTANCE_BETWEEN_WHEELS = 22.5;
    public final static double DISTANCE_BETWEEN_WHEELS_METERS = 0.5715;
    public final static double LOW_GEAR_METERS_PER_SECOND = 2.4384; // lowgearSpeedMeters
}