package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.MoveArm;
import org.metrobots.commands.auto.Pause;
import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.Rotate;
import org.metrobots.commands.auto.RotatePID;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Set robot in middle position closest to the middle of the field. <p>
 * Position of robot = middle <p>
 * First letter from FMS = L 
 */
public class LMiddle extends CommandGroup {
	
    public LMiddle() {
    	
    	/*************FANCYTURN**************/
//    	this.addSequential(new Pause(0.1));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new GyroReset());
////    	this.addSequential(new DriveForward(5));
//    	this.addSequential(new Rotate(-45, 0.45));
////    	this.addSequential(new MoveArm(11.75));
////    	this.addParallel(new MoveArm(0));
//    	this.addSequential(new Pause(0.1));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new Rotate(30, 0));
//    	this.addSequential(new DriveForward(5));
////    	this.addSequential(new GyroReset());
////    	this.addSequential(new Rotate(-30, 0));
////    	this.addSequential(new DriveForward(50));
//    	this.addSequential(new CubeControl(-0.5, 2));
    	/*************FANCYTURN**************/
    	
//    	this.addSequential(new Pause(0.1));
//    	this.addSequential(new DriveForward(25));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new Rotate(-90, 0));
////    	this.addSequential(new MoveArm(11.75));
////    	this.addParallel(new MoveArm(0));
//    	this.addSequential(new Pause(0.5));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new DriveForward(36));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new Rotate(90,0));
//    	this.addSequential(new DriveForward(44));
//    	this.addSequential(new Pause(0.01));
//    	this.addSequential(new CubeControl(-0.4, 2));
    	
    	/******IN SHAPE OF TRIANGLE, ONE CUBE, HAS NOT BEEN TESTED******/
//    	this.addSequential(new DriveForward(9.758952, 1));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new Rotate(-36, 0));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new DriveForward(70, 1));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new Rotate(36, 0.15));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new CubeControl(0.4, 2));
    	/***************************Fourth Generation LMiddle Auto Code*******************/
    	this.addSequential(new DriveForward(60*0.6716417904477, 1));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(-90, 0));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(40*0.6716417904477, 1));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(90, 0));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(44*0.6716417904477, 1));
    	this.addSequential(new CubeControl(-0.4, 2));
    	this.addSequential(new DriveForward(30*0.6716417904477, -1));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(-90, 0));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(20*0.6716417904477, 1));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(90, 0));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(108*0.6716417904477, 1));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(90, 0));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(161.25*0.6716417904477, 1));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(-90, 0));

//    	this.addSequential(new DriveForward(9.758952, 1));
//    	this.addSequential(new Rotate(22.28, 0));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new DriveForward(130, 1));
//    	this.addSequential(new Rotate(22.28, 0.15));
    	//For two cube, VEEEEEERRRRRRRRRRYYYYYYY rough draft
//    	this.addSequential(new DriveForward(-7));
//    	this.addSequential(new Rotate(90, 0));
//    	this.addParallel(new MoveArm(/*a number*/));
//    	this.addParallel(new DriveForward(20));
//    	this.addParallel(new CubeControl(-0.4, 3));
//    	this.addSequential(new DriveForward(-20));
//    	this.addSequential(new Rotate(-90, 0));
//    	this.addSequential(new MoveArm(/*a number*/));
//    	this.addSequential(new CubeControl(0.4, 2));
    }
    	
    }
