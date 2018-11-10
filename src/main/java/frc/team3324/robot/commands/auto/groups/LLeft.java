package frc.team3324.robot.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3324.robot.commands.auto.JaciPathfinding;
import frc.team3324.robot.commands.auto.Outtake;

/**
 * Set robot in foremost left of the left driverstation.
 */
public class LLeft extends CommandGroup {

    public LLeft() {
        this.addSequential(new JaciPathfinding("LLLeft")); //was 192
        this.addSequential(new Outtake());
    }
}
