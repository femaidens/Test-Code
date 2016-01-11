package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MecanumDrive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//instantiation of CANTalons, gyro, and joysticks
	public static CANTalon frontLeft = new CANTalon(RobotMap.frontLeftPort);
	public static CANTalon rearLeft = new CANTalon(RobotMap.rearLeftPort);
	public static CANTalon frontRight = new CANTalon(RobotMap.frontRightPort);
	public static CANTalon rearRight = new CANTalon(RobotMap.rearRightPort);
	public static RobotDrive mecanumDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	
	public static AnalogGyro gyroscope = new AnalogGyro(RobotMap.gyroPort);
	public static Joystick leftJoy =  new Joystick(RobotMap.leftJoyPort);
	public static Joystick rightJoy = new Joystick(RobotMap.rightJoyPort);
	
	public double driveX, driveY, driveZ;
	
	//drive method for teleop
	public void driveTeleop () {
		driveX = leftJoy.getX();
		driveY = leftJoy.getY();
		driveZ = rightJoy.getX();
		mecanumDrive.mecanumDrive_Cartesian(driveX, (driveY/2), (driveZ/2), gyroscope.getAngle());
	}
	
	public void driveAuto(double x, double y, double z) {
		mecanumDrive.mecanumDrive_Cartesian(driveX, driveY, driveZ, gyroscope.getAngle());
	}
	
	public double getGyroAngle() {
		return gyroscope.getAngle();
	}
	
	public double[] getEncoderValues() {
		double[] values = new double[4];
		values[0] = frontLeft.getEncPosition();
		values[1] = rearLeft.getEncPosition();
		values[2] = frontRight.getEncPosition();
		values[3] = rearRight.getEncPosition();
		return values;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

