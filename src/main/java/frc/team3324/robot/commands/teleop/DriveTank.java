package frc.team3324.robot.commands.teleop;

import frc.team3324.robot.OI;
import frc.team3324.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID;

public class DriveTank extends Command {

    public DriveTank() { requires(Robot.mDriveTrain); }

    protected void execute() {
        double leftY =
            OI.primaryController.getY(GenericHID.Hand.kLeft); // Get the Y (Up/Down) value of the LEFT Joystick
        double rightX =
            OI.primaryController.getX(GenericHID.Hand.kRight); // Get the X (Left/Right) value of the LEFT Joystick
        if (OI.PRIMARY_RIGHT_BUMPER.get()) {
            Robot.mDriveTrain.mDrive.curvatureDrive(leftY, -rightX, true);
        } else if (leftY > 0.1) {
            Robot.mDriveTrain.mDrive.curvatureDrive(leftY, -rightX, true);
        } else {
            Robot.mDriveTrain.mDrive.curvatureDrive(leftY, -rightX, false);
        }
    }

    @Override
    protected void initialize() {}

    @Override
    protected void end() {}

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {}
}