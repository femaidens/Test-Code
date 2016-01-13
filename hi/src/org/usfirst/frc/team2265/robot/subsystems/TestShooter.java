package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;

/**
 *
 */
public class TestShooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private double speed = 0.4;
	
	public Talon shooterFL;
	public Talon shooterFR;
	
	public TestShooter() {
		shooterFL = new Talon (RobotMap.shooterFLPort);
		shooterFR = new Talon (RobotMap.shooterFRPort);
	}
	
	public void shootBoulder() {
		shooterFL.set(-speed);
		shooterFR.set(speed);
	}
	
	public void acquire() {
		shooterFL.set(speed);
		shooterFR.set(-speed);
	}
	
	public void stop() {
		shooterFL.set(0);
		shooterFR.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

