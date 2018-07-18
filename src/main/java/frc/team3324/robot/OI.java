package frc.team3324.robot;
import frc.team3324.robot.commands.teleop.LaunchCube;
import frc.team3324.robot.util.MetroController;

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

		SmartDashboard.putNumber("have OI", val);
		val++;

		/**
		 * Secondary driver gamepad (gamepad1)
		 */

	}

	public static double get0LeftY () {
		return gamepad0.getY(Hand.kLeft);

	}


	public static double get0RightX () {
		return gamepad0.getX(Hand.kRight);

	}

	public static double get1RightY () {
		return gamepad1.getY(Hand.kRight);
	}

	public static boolean get0RightBumperToggled() {
		return gamepad0.getBumperPressed(Hand.kRight);
	}




	public static boolean is1APressed() {
		return gamepad1.getAButton();
	}

	public static boolean is1RightBumperPressed() {
		return gamepad1.getBumper(Hand.kRight);
	}

	public static boolean is1LeftBumperPressed() {
		return gamepad1.getBumper(Hand.kLeft);
	}
	public static double get1LeftYAxis() {
		return gamepad1.getY(Hand.kLeft);
	}
	public static double get1RightYAxis() {
		return gamepad1.getY(Hand.kRight);
	}
	public static boolean get1BButton() {
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
