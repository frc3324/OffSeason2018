package frc.team3324.robot.commands.auto.groups;

import frc.team3324.robot.commands.auto.JaciPathfinding;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3324.robot.commands.auto.Outtake;

public class LMiddle extends CommandGroup {
    public LMiddle() {
        this.addSequential(new JaciPathfinding("LMiddle"));
        this.addSequential(new Outtake());
    }
}