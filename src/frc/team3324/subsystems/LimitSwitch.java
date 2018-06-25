//package frc.team3324.subsystems;
//
//import frc.team3324.Constants;
//
//import edu.wpi.first.wpilibj.Counter;
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
//public class LimitSwitch extends Subsystem {
//
//	DigitalInput backSwitch = new DigitalInput(Constants.LimitSwitchBackPort);
//	DigitalInput frontSwitch = new DigitalInput(Constants.LimitSwitchFrontPort);
//	Counter counter = new Counter(backSwitch);
//
//	public LimitSwitch() {
//	}
//
//	public boolean isBackSwitchPressed() {
//		return backSwitch.get();
//	}
//
//	public boolean isFrontSwitchPressed() {
//		return frontSwitch.get();
//	}
//
////	public boolean isSwitchSet() {
////		return counter.get() > 0;
////
////	}
////
////	public void intializeCounter() {
////		counter.reset();
////	}
//
//	@Override
//	protected void initDefaultCommand() {
//		// TODO Auto-generated method stub
//
//	}
//
//}
