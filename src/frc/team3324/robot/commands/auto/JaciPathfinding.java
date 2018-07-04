package frc.team3324.robot.commands.auto.groups;

import frc.team3324.robot.commands.auto.DriveForward;
import frc.team3324.robot.commands.auto.JaciPathfinding;
import frc.team3324.robot.commands.auto.JaciPathfindingReverse;
import frc.team3324.robot.commands.auto.Pause;
import frc.team3324.robot.commands.auto.Rotate;
import frc.team3324.robot.util.JaciFinder;
import frc.team3324.robot.util.TrajContainer;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class JaciTestLeft extends CommandGroup {

    public JaciTestLeft() {
      this.addSequential(new JaciPathfinding(0, 0, 0, 3.556, 1.125324648, 0));
      //outtake
      // Flip arm backwards (parallel)
      this.addSequential(new JaciPathfindingReverse(3.556, 1.125324648, 0, 3.175, 0.312524648, 45)); // Might need to be negative 45? Might need to convince it it's going forward?
      //Intake
      //Flip arm forwards (parallel)
      this.addSequential(new JaciPathfinding(3.175, 0.312524648, 45, 3.556, 1.125324648, 0));
      //outtake
    }
}
