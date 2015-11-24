package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.Robot;

/**
 *
 */
public class Drive extends Command {

	public double x;
	public double y;
	public double z;
	public double time;
	public int degrees;
	public Timer timer;
	public double[] encValues;
	
    public Drive(double xDirection, double yDirection, double zDirection, double secs) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	x = xDirection;
    	y = yDirection;
    	z = zDirection;
    	time = secs;
    	degrees = 0;
    	
    	timer = new Timer();
    	encValues = Robot.drive.getEncoderValues();	
    }
    
    public Drive(double xDirection, double yDirection, double zDirection, int angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	x = xDirection;
    	y = yDirection;
    	z = zDirection;
    	degrees = angle;
    	time = 0;
    	
    	timer = new Timer();
    	encValues = Robot.drive.getEncoderValues();	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.driveAuto(x, y, z);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() == time && encValues[0] == degrees && encValues[1] == degrees && encValues[2] == degrees && encValues[4] == degrees;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.driveAuto(0,0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.driveAuto(0,0,0);
    }
}
