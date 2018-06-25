package frc.team3324;
//
//import frc.team3324.commands.teleop.ArmForward;
//import frc.team3324.commands.teleop.ArmForwardSwitch;
//import frc.team3324.commands.teleop.ArmBackward;
//import frc.team3324.commands.teleop.ArmBackwardSwitch;
import frc.team3324.commands.teleop.ClimberSlideDown;
import frc.team3324.commands.teleop.ClimberSlideUp;
import frc.team3324.commands.teleop.LaunchCube;
//import frc.team3324.commands.teleop.IntakeStop;
import frc.team3324.commands.teleop.PressureSwitch;
import frc.team3324.commands.teleop.Winches;
import frc.team3324.util.MetroController;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private static XboxController gamepad0 = new XboxController(0);
	private static XboxController gamepad1 = new XboxController(1);

	private int val = 0;

	private boolean commandFinished;
	/**
	 * Primary driver buttons assignments
	 */
	Button aButton0 = new JoystickButton(gamepad0, MetroController.BUTTON_A);

	Button leftTrigger0 = new JoystickButton(gamepad0, MetroController.LT);
	Button rightTrigger0 = new JoystickButton(gamepad0, MetroController.RT);

	Button rightBumper0 = new JoystickButton(gamepad0, MetroController.RB);

	/**
	 * Secondary driver buttons assignments
	 */
	Button aButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_A);
	Button bButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_B);
	Button xButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_X);
	static Button yButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_Y);
	Button leftButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_BACK);
	Button rightButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_START);
	Button leftJoystickButton1 = new JoystickButton(gamepad1, MetroController.JOYSTICK_LEFT_CLICK);
	Button rightJoystickButton1 = new JoystickButton(gamepad1, MetroController.JOYSTICK_RIGHT_CLICK);

	Button leftBumper1 = new JoystickButton(gamepad1, MetroController.LB);
	Button rightBumper1 = new JoystickButton(gamepad1, MetroController.RB);

	/**
	 * Controller buttons.
	 *
	 * aButton -> PressureSwitch
	 * bButton -> MoveArm
	 *
	 */
	public OI() {

		/** Primary driver gamepad (gamepad0)
		 *
		 */
//		aButton0.whenPressed(new PressureSwitch());

		/**
		 * Secondary driver gamepad (gamepad1)
		 */
//		aButton0.whenPressed(new PressureSwitch());

//		xButton1.whileHeld(new ClimberSlideUp());
//		yButton1.whileHeld(new ClimberSlideDown());
//		leftButton1.whileHeld(new ClimberSlideUp());
//		rightButton1.whileHeld(new ClimberSlideDown());
//		rightJoystickButton1.whenPressed(new Winches());

//		rightBumper1.whenPressed(new LaunchCube());
//		leftBumper1.whenPressed(new IntakeTeleop());
//		rightBumper1.whenPressed(new OuttakeTeleop());
//		leftJoystickButton.whenPressed(new IntakeStop());
//
//		leftBumper1.toggleWhenPressed(new IntakeTeleop());
//		rightBumper1.toggleWhenPressed(new OuttakeTeleop());

//		leftJoystickButton.cancelWhenPressed(new OuttakeTeleop());
//		xButton1.whenPressed(new ArmForward());
//		aButton1.whenPressed(new ArmForwardSwitch());
//		bButton1.whenPressed(new ArmBackwardSwitch());
//		yButton1.whenPressed(new ArmBackward());

//		xButton1.whenPressed(new ArmBackward());
//		aButton1.whenPressed(new ArmBackwardSwitch());
//		bButton1.whenPressed(new ArmForwardSwitch());
//		yButton1.whenPressed(new IntakeStop());

//		rightBumper1.whenPressed(new Outtake());

//		aButton1.whenPressed(new MoveForward());
//		bButton1.whenPressed(new MoveForwardSwitch());
//		xButton1.whenPressed(new MoveBackwardSwitch());
//		yButton1.whenPressed(new MoveBackward());
//
//		leftBumper1.whenPressed(new );
//		aButton.whenPressed(new PressureSwitch());
		//		if (inTakeEnable = false) {
//			yButton.whenPressed(new Outtake());;
//			inTakeEnable = true;
//		}
//		else {
//			leftBumper.whenPressed(new StopIntake());
//			inTakeEnable = false;
//		}
//		if (inTakeEnable = false) {
//			rightBumper.whenPressed(new ());
//			inTakeEnable = true;
//		}
//		else {
//			leftBumper.whenPressed(new StopIntake());
//			inTakeEnable = false;
//		}



		SmartDashboard.putNumber("have OI", val);
		val++;

		/**
		 * Secondary driver gamepad (gamepad1)
		 */

//		leftBumper.whileHeld(new Intake());
//		rightBumper.whileHeld(new Outtake());
		//yButton.whileHeld(new Climb()); //Actually, make this a trigger, b/c not enough buttons
	}

//	public static boolean get1LeftButton() {
//		return gamepad1.getBackButton();
//	}
//
//	public static boolean get1RightButton() {
//		return gamepad1.getStartButton();
//	}

	public static double get0LeftY () {
		return gamepad0.getY(Hand.kLeft);

	}

//	public static double get0LeftX () {
//		return gamepad0.getX(Hand.kLeft);
//
//	}

	public static double get0RightX () {
		return gamepad0.getX(Hand.kRight);

	}

	public static double get1RightY () {
		return gamepad1.getY(Hand.kRight);
	}

//	public static double get0RightY () {
//		return gamepad0.getY(Hand.kRight);
//
//	}

//	public static boolean get0RightBumper() {
//		return gamepad0.getBumper(Hand.kRight);
//	}

	public static boolean get0RightBumperToggled() {
		return gamepad0.getBumperPressed(Hand.kRight);
	}

	/**
	 * Determine if the A button is pressed on the primary driver controller.
	 * @return true or false
	 */

//	public static boolean is0APressed() {
//		return gamepad0.getAButtonPressed();
//	}
//
	/**
	 * Determine if the B button is pressed on the primary driver controller.
	 * @return true or false
	 */
//	public static boolean is0BPressed() {
//		return gamepad0.getBButton();
//	}

	/**
	 * Determine if the X button is pressed on the primary driver controller.
	 * @return true or false
	 */
//	public static boolean is0XPressed() {
//		return gamepad0.getXButton();
//	}

	/**
	 * Determine if the Y button is pressed on the primary driver controller.
	 * @return true or false
	 */
//	public static boolean is0YPressed() {
//		return gamepad0.getYButtonPressed();
//	}

	public static boolean is1APressed() {
		return gamepad1.getAButton();
	}
	public static boolean is1RightBumperPressed() {
		return gamepad1.getBumper(Hand.kRight);
	}
//	public static boolean is1BPressed() {
//		return gamepad1.getBButtonPressed();
//	}

//	public static boolean is1XPressed() {
//		return gamepad1.getXButtonPressed();
//	}

//	public static boolean is1YPressed() {
//		return gamepad1.getYButtonPressed();
//	}
	public static boolean is1LeftBumperPressed() {
		return gamepad1.getBumper(Hand.kLeft);
	}
	public static double get1LeftYAxis() {
		// TODO Auto-generated method stub
		return gamepad1.getY(Hand.kLeft);
	}
//	public static boolean get1YButton() {
//		// TODO Auto-generated method stub
//		return gamepad1.getYButton();
//	}
//	public static boolean get1XButton() {
//		// TODO Auto-generated method stub
//		return gamepad1.getXButton();
//	}
	public static boolean get1BButton() {
		// TODO Auto-generated method stub
		return gamepad1.getBButton();
	}
	public static boolean get1AButton() {
		// TODO Auto-generated method stub
		return gamepad1.getAButton();
	}
	public static boolean get1RightJoystickButton() {
		return gamepad1.getRawButton(MetroController.JOYSTICK_RIGHT_CLICK);
	}
	public static boolean get0AButton() {
		return gamepad0.getAButton();
	}
	public static boolean get0AButtonPressed(){
		return gamepad0.getAButtonPressed();
	}
	public static boolean is0BPressed() {
		return gamepad0.getBButton();
	}

	public static boolean get1LeftButton() {
		return gamepad1.getBackButton();
	}

	public static boolean get1RightButton() {
		return gamepad1.getStartButton();
	}

	public static double get0LeftX() {
		// TODO Auto-generated method stub
		return gamepad0.getX(Hand.kLeft);
	}

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
