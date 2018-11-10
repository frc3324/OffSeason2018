package frc.team3324.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3324.robot.Robot;
import frc.team3324.robot.subsystems.CubeController;

public class Intake extends Command {
    private double speed;
    public Intake() {
        super("Intake");
        requires(Robot.mCubeController);
    }
    public void initialize() {}
    public void execute() { Robot.mCubeController.intake(-1.0); }
    public boolean isFinished() { return false; }
    public void end() {}
    public void interrupted() {}
}