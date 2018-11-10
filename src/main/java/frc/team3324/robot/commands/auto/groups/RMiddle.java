package frc.team3324.robot.commands.auto.groups;

import frc.team3324.robot.commands.auto.JaciPathfinding;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3324.robot.commands.auto.Outtake;

public class RMiddle extends CommandGroup {
    public RMiddle() {
        this.addSequential(new JaciPathfinding("RMiddle"));
        this.addSequential(new Outtake());
    }
}