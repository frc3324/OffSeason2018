package frc.team3324.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public static XboxController gamepad0 = new XboxController(0);
    public static XboxController gamepad1 = new XboxController(1);

    public OI() {}
}