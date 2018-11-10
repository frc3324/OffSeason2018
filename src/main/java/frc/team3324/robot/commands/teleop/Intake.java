package frc.team3324.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3324.robot.Robot;

public class Intake extends Command {
    public Intake() {
        super("Intake");
        requires(Robot.mCubeController);
    }
    public void initialize() {}
    public void execute() { Robot.mCubeController.set(-1.0); }
    public boolean isFinished() { return false; }
    public void end() {}
    public void interrupted() {}
}