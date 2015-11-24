package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Extend extends Command {

    public Extend() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires the instance from the main robot class
    	requires(Robot.piston);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//extends the piston if it is retracted
    	if (Robot.piston.get().equals(Value.kReverse_val)) {
    		Robot.piston.extend();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//if the piston is extended, return true, else return false to show if the action has finished
    	if (Robot.piston.get().equals(Value.kForward_val)) { 
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Timer.delay(.5);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
