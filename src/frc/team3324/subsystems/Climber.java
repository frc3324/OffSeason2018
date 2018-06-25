package frc.team3324.subsystems;

import frc.team3324.Constants;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Climber extends Subsystem {

	WPI_VictorSPX linearSlide = new WPI_VictorSPX(Constants.LINEAR_SLIDE_MOTOR_PORT);
	WPI_VictorSPX winch = new WPI_VictorSPX(Constants.WINCH_PORT);

	public Climber() {

	}

	/**
	 * Set speed of linear slide.
	 * @param speed
	 */
	public void grabBar(double speed) {
		linearSlide.set(speed);
	}

	/**
	 * Set speed of winch.
	 * @param speed
	 */
	public void reelWinch(double speed) {
		winch.set(speed);
	}

	/*
	 * Necessary method that contains nothing
	 */
	protected void initDefaultCommand() {

	}

}
