package frc.team3324.robot.commands.auto.groups;

import frc.team3324.robot.commands.auto.JaciPathfinding;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3324.robot.commands.auto.Outtake;

public class RRight extends CommandGroup {
    public RRight() {
        this.addSequential(new JaciPathfinding("RRRight"));
        this.addSequential(new Outtake());
    }
}
