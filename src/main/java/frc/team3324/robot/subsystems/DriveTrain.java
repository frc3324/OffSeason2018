package frc.team3324.robot.subsystems;

import frc.team3324.robot.Constants;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SPI;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.kauailabs.navx.frc.AHRS;

// Identify Drivetrain as a subsystem (class)
public class DriveTrain extends Subsystem implements PIDOutput {

    double rotateToAngleRate;

    private DoubleSolenoid gearShifter = new DoubleSolenoid(0, 1);

    private static Encoder lEncoder =
        new Encoder(Constants.LEFT_ENCODER_PORT_A, Constants.LEFT_ENCODER_PORT_B, false, Encoder.EncodingType.k4X);
    private static Encoder rEncoder =
        new Encoder(Constants.RIGHT_ENCODER_PORT_A, Constants.RIGHT_ENCODER_PORT_B, false, Encoder.EncodingType.k4X);
    private double distancePerPulse = Constants.CIRCUMFERENCE / Constants.ACTUAL_PULSES;

    private static AHRS gyro = new AHRS(SPI.Port.kMXP);

    PowerDistributionPanel mPDP = new PowerDistributionPanel();

    WPI_VictorSPX flMotor =
        new WPI_VictorSPX(Constants.FL_MOTOR_PORT); // Instantiate the motors as a new TalonSRX motor controller
    WPI_VictorSPX blMotor = new WPI_VictorSPX(Constants.BL_MOTOR_PORT);
    SpeedControllerGroup lMotors =
        new SpeedControllerGroup(flMotor,
                                 blMotor); // Combine the left motors into one lMotors speed controller group

    WPI_VictorSPX frMotor = new WPI_VictorSPX(Constants.FR_MOTOR_PORT); //repeat for right motors
    WPI_VictorSPX brMotor = new WPI_VictorSPX(Constants.BR_MOTOR_PORT);
    SpeedControllerGroup rMotors = new SpeedControllerGroup(frMotor, brMotor);

    public DifferentialDrive mDrive = new DifferentialDrive(lMotors, rMotors);

    public DriveTrain() {
        mDrive.setSafetyEnabled(true);
        lEncoder.setDistancePerPulse(distancePerPulse);
        rEncoder.setDistancePerPulse(distancePerPulse);
    }

    /**
     * Set safety status of drivetrain motor controllers
     * @param status
     */
    public void setSafetyEnabled(boolean status) { mDrive.setSafetyEnabled(true); }

    /**
     * Get current through specified PDP port
     * @param port
     * @return
     */
    public double getCurrent(int port) { return mPDP.getCurrent(port); }

    /**
     * Get distance of the left encoder in inches
     * @return
     */
    public static double getLeftDistance() { return lEncoder.getDistance(); }

    /**
     * Get distance of the right encoder in inches
     * @return
     */
    public static double getRightDistance() { return rEncoder.getDistance(); }

    public static int getLeftDistanceRaw() {
        final int rawLDistance = lEncoder.getRaw();
        return rawLDistance;
    }

    public static int getRightDistanceRaw() {
        final double rawLDistance = rEncoder.getRaw();
        return (int)rawLDistance;
    }

    /**
     * Reset both of encoders
     */
    public static void clearEncoder() {
        lEncoder.reset();
        rEncoder.reset();
    }

    /**
     * Print the encoder values, left (L Encoder Distance) and right (R Encoder Distance)
     */
    public void printEncoder() {
        SmartDashboard.putNumber("L Encoder Distance", getLeftDistance());
        SmartDashboard.putNumber("R Encoder Distance", getRightDistance());
    }

    public double getPidAngle() { return gyro.pidGet(); }

    /**
     * Reset the gyro to zero
     * Avoid usage at all costs
     */
    public void clearGyro() { gyro.reset(); }

    public double getYaw() { return gyro.getYaw(); }

    @Override
    /* This function is invoked periodically by the PID Controller, */
    /* based upon navX-MXP yaw angle input and PID Coefficients.    */
    public void pidWrite(double output) {
        rotateToAngleRate = output;
    }

    public void BrakeMode() {
        frMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
        brMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
        blMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
        flMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    }

    public void CoastMode() {
        frMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
        brMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
        blMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
        flMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    }

    public void setHighGear() { gearShifter.set(DoubleSolenoid.Value.kForward); }

    public void setLowGear() { gearShifter.set(DoubleSolenoid.Value.kReverse); }

    protected void initDefaultCommand() {}
}