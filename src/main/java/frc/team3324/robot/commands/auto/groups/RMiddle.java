package frc.team3324.robot.commands.auto.groups;

import frc.team3324.robot.commands.auto.JaciPathfinding;
import frc.team3324.robot.commands.auto.CubeControl;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RMiddle extends CommandGroup {
    public RMiddle() {
        this.addSequential(new JaciPathfinding("RMiddle", false));
        this.addSequential(new CubeControl(0.6, 6));
    }
}