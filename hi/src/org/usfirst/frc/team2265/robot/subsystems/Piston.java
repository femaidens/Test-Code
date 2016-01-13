package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Piston extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid actuator = new DoubleSolenoid(RobotMap.sol1Port, RobotMap.sol2Port);
	

	//method to extend the piston
	public void extend() {
		actuator.set(DoubleSolenoid.Value.kForward);
	}
	
	//method to retract the piston
	public void retract() {
		actuator.set(DoubleSolenoid.Value.kReverse);
	}
	
	//method to return the value of the piston
	public Value get() {
		return actuator.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

