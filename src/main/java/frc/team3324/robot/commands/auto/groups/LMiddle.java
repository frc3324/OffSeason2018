package frc.team3324.robot.commands.auto.groups;

import frc.team3324.robot.commands.auto.JaciPathfinding;
import frc.team3324.robot.commands.auto.CubeControl;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LMiddle extends CommandGroup {
    public LMiddle() {
        this.addSequential(new JaciPathfinding("LMiddle", false));
        this.addSequential(new CubeControl(0.6, 6));
    }
}