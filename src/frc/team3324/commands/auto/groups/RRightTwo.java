package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.DriveArc;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.Pause;
import org.metrobots.commands.auto.Rotate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RRightTwo extends CommandGroup {

    public RRightTwo() {
    	this.addSequential(new Pause(0.5));
    	this.addSequential(new DriveForward(100, 1.0)); //was 192
//    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(-90, 0));
    	this.addSequential(new GyroReset());
//    	this.addSequential(new MoveArm(11.75));
//    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(30, 1));
    	this.addSequential(new CubeControl(-0.5, 2));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(15.0, -1.0));
    	this.addSequential(new Rotate(90, 0));
//    	this.addSequential(new DriveForward(30.0, 1.0));
    	this.addParallel(new DriveArc(-180.0, 5.0));
    	this.addParallel(new CubeControl(1.0, 3.0));
    	this.addSequential(new DriveArc(-90.0, 5.0));
    	this.addSequential(new CubeControl(-0.3, 2.0));
    }
}
