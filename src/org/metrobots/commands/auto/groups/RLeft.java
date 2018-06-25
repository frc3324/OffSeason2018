package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;

/**
 * Switch = right
 * Left = driver station position
 */
public class RLeft extends CommandGroup {

    public RLeft() {
    	
    	this.addSequential(new DriveForward(100, 1));
    	
    }

}
