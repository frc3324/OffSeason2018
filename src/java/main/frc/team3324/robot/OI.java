package frc.team3324.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static XboxController gamepad0 = new XboxController(0);
	public static XboxController gamepad1 = new XboxController(1);

	private int val = 0;

	private boolean commandFinished;

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
	}

}