package org.usfirst.frc.team2374.robot.commands;

import org.usfirst.frc.team2374.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Default drivetrain command, controls drivetrain allowing for tank 
 * drive (independent control of left and right sides of drivetrain)
 * 
 * @author robotics
 */
public class DrivetrainTeleop extends Command {
	
	public DrivetrainTeleop() { requires(Robot.drive); }
	
	@Override
	protected void initialize() { }
	
	@Override
	protected void execute() {
		
		boolean leftBumper = Robot.oi.getLeftBumper();
		boolean rightBumper = Robot.oi.getRightBumper();
		
		double leftJoy = Robot.oi.getDriverLeftY();
		double rightJoy = Robot.oi.getDriverRightY();
		// This is a functionality Alec likes, the left and right triggers can make the robot drive
		// straight forward or straight back (2014, colorized)
		
		// This is the functionality Milne likes, the left and right bumpers can make the robot drive 
		// straight forward or straight back, full speed
		if (rightBumper) {
			Robot.drive.tankDrive(1.0, 1.0);
		} else if (leftBumper) {
			Robot.drive.tankDrive(-1.0, -1.0);
		} else {
			Robot.drive.tankDrive(leftJoy, rightJoy);
		}
		// This is how normal people drive, the left joystick controls the left side of the
		// drivetrain and the right joystick controls the right side of the drivetrain
	}

	@Override
	protected boolean isFinished() { return false; }
	
	@Override
	protected void end() { Robot.drive.tankDrive(0, 0); }
	
	@Override
	protected void interrupted() { end(); }

}