package frc.team3324.robot.commands.auto.groups;

import frc.team3324.robot.commands.auto.JaciPathfinding;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Default extends CommandGroup {
    public Default() { this.addSequential(new JaciPathfinding("Default")); }
}