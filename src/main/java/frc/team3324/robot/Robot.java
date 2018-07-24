package frc.team3324.robot;

import java.io.IOException;

import frc.team3324.robot.commands.DriveGroup;
import frc.team3324.robot.commands.auto.DriveForward;
import frc.team3324.robot.commands.auto.Rotate;
import frc.team3324.robot.subsystems.CubeController;
import frc.team3324.robot.subsystems.DriveTrain;
import frc.team3324.robot.subsystems.Gyro;
import frc.team3324.robot.subsystems.IntakeArm;
import frc.team3324.robot.util.StatusLED;
import frc.team3324.robot.subsystems.TestArm;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.followers.EncoderFollower;

/**
 * Main robot code<br>
 * <br>
 *
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 *
 * Feb 8: Added agitator Talon and stuff - Xander
 *
 */
public class Robot extends TimedRobot {

	/*
	 * Initialize SubSytems
	 */
	public OI mOI;
	public static final DriveTrain mDriveTrain = new DriveTrain();
	public static final Gyro mGyro = new Gyro();
	public static final CubeController mCubeController = new CubeController();
	public static final IntakeArm mIntakeArm = new IntakeArm();
	
	public static final TestArm mTestArm = new TestArm();
	
//	public static PowerDistributionPanel pdp = new PowerDistributionPanel();

	Command selectedCommand; // Selected command
	SendableChooser<Integer> autoSelector = new SendableChooser<Integer>(); // Put a selection menu on the SmartDashboard

	String gameData;
	char firstLetter;
	String positionString;
	String infoString;
	int defaultSet = 0;
	int left = 1;
	int middle = 2;
	int right = 3;

	/**
	 * When the robot first boots up, initialize all of the gamepads, motor
	 * controllers, sensors, and subsystems
	 *
	 */
	public void robotInit() {
        mOI = new OI();
        /* Initialize AUTO selecter UI */
        autoSelector.addDefault("Default", defaultSet);
    	autoSelector.addObject("Left position", left);
    	autoSelector.addObject("Middle position", middle);
    	autoSelector.addObject("Right position", right);
        SmartDashboard.putData("CHOOSE ONE", autoSelector);
//        pdp = new PowerDistributionPanel();
	}

	/**
	 * Initialize whatever you need to when the robot becomes disables
	 */
	public void disabledInit() {
		CameraServer.getInstance().startAutomaticCapture();
		CameraServer.getInstance().putVideo("Camera output", 1280, 720);
		mDriveTrain.clearEncoder();
	}

	/**
	 * Runs constantly when the robot is disabled. Good for displaying stuff to
	 * the driver station
	 */
	public void disabledPeriodic() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		CameraServer.getInstance().getVideo();

		if (autoSelector.getSelected() == defaultSet) {
			positionString = "Default position";
		}
		else if (autoSelector.getSelected() == left) {
			positionString = "Left position";
		}
		else if (autoSelector.getSelected() == middle) {
			positionString = "Middle position";
		}
		else if (autoSelector.getSelected() == right) {
			positionString = "Right position";
		}
		SmartDashboard.putString("You are in: ", positionString);


		if (gameData != null && gameData.length() > 0) {

			firstLetter = gameData.charAt(0);
			if (positionString.equals("Default position")) {
				selectedCommand = new DriveForward(90, 1);
				infoString = "Drive forward (default)";
			}
			else if (firstLetter == 'L' && positionString.equals("Left position")) {
//				selectedCommand = new LLeft();
				infoString = "LLeft";
			}
			if (firstLetter == 'L' && positionString.equals("Middle position")) {
//				selectedCommand = new LMiddleArc();
				infoString = "LMiddle";
			}
			else if (firstLetter == 'L' && positionString.equals("Right position")) {
//				selectedCommand = new LRight();
				infoString = "LRight";
			}
			if (firstLetter == 'L'  && positionString.equals("Right position")){
//				selectedCommand = new RLeft();
				infoString = "RLeft";
			}
			else if (firstLetter == 'R' && positionString.equals("Middle position")) {
//				selectedCommand = new RMiddleArc();
				infoString = "RMiddle";
			}
			else if (firstLetter == 'R') {
//				selectedCommand = new RRight();
				infoString = "RRight";
			}
			else {
				DriverStation.reportError("No game data received.", false);
//				selectedCommand = new JaciTestLeft();
				infoString = "No game data received.";
			}
		}
		}

	/**
	 * Initialize whatever you need to when the robot starts autonomous
	 */

	public void autonomousInit() {
		Scheduler.getInstance().add(selectedCommand);
		SmartDashboard.putString("COMMENCING: ", infoString);

	}

	/**
	 * Runs constantly when autonomous is enabled
	 */
	public void autonomousPeriodic() {
		/*******************CODETHATWORKS**************************/
		Scheduler.getInstance().run(); // Run scheduler
		/*******************CODETHATWORKS**************************/

	}

	/**
	 * Initialize whatever you need to when the robot starts teleop
	 */
	public void teleopInit() {
		Scheduler.getInstance().add(new DriveGroup());
	}

	/**
	 * Runs constantly when teleop is enabled
	 */
	public void teleopPeriodic() {
		CameraServer.getInstance().getVideo();
		Scheduler.getInstance().run();
		mDriveTrain.printEncoder();
//		Robot.mDriveTrain.getCurrent(12);
		
		//CURRENT AND POWER MONITOR//
//		for(int i = 0; i < 10; i++)
//		{
//			SmartDashboard.putNumber("Channel " + i + " Current", pdp.getCurrent(i));
//		}
//			SmartDashboard.putNumber("Channel" + 2 + " Current", pdp.getCurrent(2));
		/*SmartDashboard.putNumber("Total Current", pdp.getTotalCurrent());
		SmartDashboard.putNumber("Total Power", pdp.getTotalPower());            Useless apparently?*/
		//CURRENT AND POWER MONITOR//
	
	}

	/**
	 * Runs constantly when test mode is enabled
	 */
	public void testPeriodic() {
	}
}
