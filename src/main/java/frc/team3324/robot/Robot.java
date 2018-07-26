package frc.team3324.robot;

import frc.team3324.robot.commands.auto.DriveForward;
import frc.team3324.robot.commands.DriveGroup;
import frc.team3324.robot.subsystems.CubeController;
import frc.team3324.robot.subsystems.DriveTrain;
import frc.team3324.robot.subsystems.IntakeArm;
import frc.team3324.robot.OI;
import frc.team3324.robot.subsystems.TestArm;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Main robot code<br>
 * <br>
 */
public class Robot extends IterativeRobot {

    /*
     * Instantiate subsystems
     */
    public OI mOI;
    public static final DriveTrain mDriveTrain = new DriveTrain();
    public static final CubeController mCubeController = new CubeController();
    public static final IntakeArm mIntakeArm = new IntakeArm();

    public static final TestArm mTestArm = new TestArm();

    Command selectedCommand;
    SendableChooser<Integer> autoSelector = new SendableChooser<Integer>();

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
        DriveTrain.clearEncoder();
    }

    /**
     * Runs constantly when the robot is disabled. Good for displaying stuff to
     * the driver station
     */
    public void disabledPeriodic() {

        gameData = DriverStation.getInstance().getGameSpecificMessage();

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
                selectedCommand = new DriveForward(90);
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

            CameraServer.getInstance().getVideo();
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

        Scheduler.getInstance().run(); // Run scheduler
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
    }

    /**
     * Runs constantly when test mode is enabled
     */
    public void testPeriodic() {
    }
}