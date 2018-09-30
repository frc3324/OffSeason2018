package frc.team3324.robot.commands.auto.groups;

import frc.team3324.robot.commands.auto.JaciPathfinding;
import frc.team3324.robot.commands.auto.CubeControl;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RRight extends CommandGroup {
    public RRight() {
        this.addSequential(new JaciPathfinding("RRRight", false));
        this.addSequential(new CubeControl(0.6, 6));
    }
}
