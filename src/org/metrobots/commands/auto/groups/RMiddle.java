package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.MoveArm;
import org.metrobots.commands.auto.Pause;
import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.Rotate;

/**
 * Set robot in middle position closest to the middle of the field. <p>
 * Position of robot = middle <p>
 * First letter from FMS = L 
 */
public class RMiddle extends CommandGroup {

    public RMiddle() {
//    	this.addSequential(new Pause(0.5));
//    	this.addSequential(new DriveForward(25));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new Rotate(90, 0));
////    	this.addSequential(new MoveArm(11.75));
////    	this.addParallel(new MoveArm(0));
//    	this.addSequential(new Pause(0.5));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new DriveForward(36));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new Rotate(-90,0));
//    	this.addSequential(new DriveForward(32));
//    	this.addSequential(new Pause(0.01));
//    	this.addSequential(new CubeControl(-0.4, 2));
    	
    	/**********COPIED FROM LMIDDLE, NEEDS ADJUSTED ANGLES AND DISTANCE(TRIG STUFF), ONE CUBE, NOT TESTED**********/
//    	this.addSequential(new DriveForward(9.758952, 1));
//    	this.addSequential(new Rotate(22.28, 0));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new DriveForward(130, 1));
//    	this.addSequential(new Rotate(22.28, 0.15));
    	/**********Worlds Arc Goes Here********************************/
    	this.addSequential(new DriveForward(60*0.6716417904477, 1));
    	this.addSequential(new Rotate(90,0));
    	this.addSequential(new DriveForward(72*0.6716417904477, 1));
    	this.addSequential(new Rotate(-90,0));
    	this.addSequential(new DriveForward(44*0.6716417904477, 1));
    	this.addSequential(new CubeControl(-0.4, 2));
    	this.addSequential(new DriveForward(-30*0.6716417904477, 1));
    	this.addSequential(new Rotate(90,0));
    	this.addSequential(new DriveForward(36*0.6716417904477, 1));
    	this.addSequential(new Rotate(-90,0));
    	this.addSequential(new DriveForward(108*0.6716417904477, 1));
    	this.addSequential(new Rotate(-90,0));
    	this.addSequential(new DriveForward(161.25*0.6716417904477, 1));
    	this.addSequential(new Rotate(90,0));




    }

}
