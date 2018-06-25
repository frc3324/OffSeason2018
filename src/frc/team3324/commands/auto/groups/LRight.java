package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;

/**
 *
 */
public class LRight extends CommandGroup {

    public LRight() {
        this.addSequential(new DriveForward(100, 1));
    }

}