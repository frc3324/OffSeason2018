package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.Pause;
import org.metrobots.commands.auto.Rotate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LLeftTwo extends CommandGroup {

    public LLeftTwo() {
    	this.addSequential(new Pause(0.5));
    	this.addSequential(new DriveForward(100, 1)); //was 192
    	this.addSequential(new Rotate(90, 0));
//    	this.addSequential(new MoveArm(11.75));
    	this.addSequential(new DriveForward(30, 1));
    	this.addSequential(new CubeControl(-0.5, 2));
    	this.addSequential(new DriveForward(-20, 1));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(-90, 0));
    	this.addSequential(new DriveForward(15, 1));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(90, 0));
    	
    	this.addParallel(new DriveForward(27, 1));
    	this.addParallel(new CubeControl(1.0, 2));
    	this.addSequential(new Rotate(40, 0));
    	this.addSequential(new GyroReset());
    	this.addSequential(new CubeControl(-0.5, 2));
    	
//    	this.addSequential(new DriveForward());
 //   	this.addSequential(new GyroReset());
//    	this.addSequential(new DriveForward());
    }
}
