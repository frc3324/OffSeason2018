package frc.team3324.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3324.robot.Robot;

public class Outtake extends Command {
    public Outtake() {
        super("OuttakeAuto");
        requires(Robot.mCubeController);
        setTimeout(2);
    }
    public void initialize() {}
    public void execute() { Robot.mCubeController.set(1.0); }
    public boolean isFinished() { return isTimedOut(); }
    public void end() {}
    public void interrupted() {}
}
