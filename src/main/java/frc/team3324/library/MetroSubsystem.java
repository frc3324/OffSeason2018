package frc.team3324.library;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team3324.robot.Constants;

abstract public class MetroSubsystem extends Subsystem {

    public static Encoder[] encoders = new Encoder[4];
    private static final EncodingType ENCODING_TYPE = Encoder.EncodingType.k4X;
    private double distancePerPulse = Constants.CIRCUMFERENCE / Constants.ACTUAL_PULSES;


    public SpeedControllerGroup rightMotorControlGroup, leftMotorControlGroup;
    public WPI_VictorSPX frontRightMotor, backRightMotor, backLeftMotor, frontLeftMotor;
    public DifferentialDrive mDrive;

    public MetroSubsystem() {}
    /*
     *     For use if 2 encoders are needed
     *         */
    public MetroSubsystem(int leftEncoderPortA, int leftEncoderPortB, int rightEncoderPortA, int rightEncoderPortB,
                          int frontLeftMotorPort, int backLeftMotorPort, int frontRightMotorPort,
                          int backRightMotorPort) {

        encoders[0] = new Encoder(leftEncoderPortA, leftEncoderPortB, false, ENCODING_TYPE);
        encoders[1] = new Encoder(rightEncoderPortA, rightEncoderPortB, false, ENCODING_TYPE);

        encoders[0].setDistancePerPulse(distancePerPulse);
        encoders[1].setDistancePerPulse(distancePerPulse);

        frontLeftMotor = new WPI_VictorSPX(frontLeftMotorPort);
        backLeftMotor = new WPI_VictorSPX(backLeftMotorPort);
        leftMotorControlGroup = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);

        frontRightMotor = new WPI_VictorSPX(frontRightMotorPort);
        backRightMotor = new WPI_VictorSPX(backRightMotorPort);
        rightMotorControlGroup = new SpeedControllerGroup(frontRightMotor, backRightMotor);

        mDrive = new DifferentialDrive(leftMotorControlGroup, rightMotorControlGroup);

    }


    public static void clearEncoders() {
        for (int i = 0 ; i < encoders.length; i++) {
            encoders[i].reset();
        }
    }
}