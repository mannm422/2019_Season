package org.usfirst.frc.team2374.robot.subsystems;

import org.usfirst.frc.team2374.robot.RobotMap;
import org.usfirst.frc.team2374.robot.commands.BeltTeleop;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Belt extends Subsystem {

	private TalonSRX belt;
	
	public Belt() {
		belt = new TalonSRX(RobotMap.TALON_BELT);
	}
	
	@Override
	protected void initDefaultCommand() { setDefaultCommand(new BeltTeleop()); }
	
	public void move(double speed, int direction) {
		
//		belt.setSpeed(speed * direction);
		belt.set(ControlMode.PercentOutput, speed * direction);
		
	}
	
}