
package org.usfirst.frc.team2265.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.Compressor; 

import org.usfirst.frc.team2265.robot.commands.AutonForFun;
import org.usfirst.frc.team2265.robot.subsystems.MecanumDrive;
import org.usfirst.frc.team2265.robot.subsystems.Piston;
import org.usfirst.frc.team2265.robot.OI;
import org.usfirst.frc.team2265.robot.subsystems.TestShooter;
import org.usfirst.frc.team2265.robot.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project,        you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
	public static OI oi;
	public static TestShooter cannon;
	public static Piston piston;
	public static MecanumDrive drive;
	
    SendableChooser autonChooser;
    //Compressor compressy; 
    CommandGroup autonomous; 
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		piston = new Piston();
		drive = new MecanumDrive();
		//compressy = new Compressor();
		cannon =  new TestShooter();
		
		
        // instantiate the command used for the autonomous period
       // auton1 = new AutonForFun();
        oi.bindButtons();
        createAutonChooser();
        //compressy.start(); 
        
       // boolean enabled = compressy.enabled();
        //boolean pressureSwitch = compressy.getPressureSwitchValue();
        //float current = compressy.getCompressorCurrent();
        //SmartDashboard.putNumber("Compressor value = ", current);

    }
	
    public void createAutonChooser() {
    	autonChooser = new SendableChooser();
    	autonChooser.addDefault("AutonForFun", new AutonForFun());
    	autonChooser.addObject("Extend and Retract Piston", new SecondAuton());
    	SmartDashboard.putData("Autonomous choices", autonChooser);
    }
    
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomous = (CommandGroup) autonChooser.getSelected();
    	if (autonomous != null) autonomous.start();
    	
       // if (auton1 != null) auton1.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out. 
        if (autonomous != null) autonomous.cancel();
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Gyro value = ", drive.getGyroAngle());
        double[] values = drive.getEncoderValues();
		/*SmartDashboard.putNumber("Front Left Encoder Values", values[0]);
		SmartDashboard.putNumber("Rear Left Encoder Values", values[1]);
		SmartDashboard.putNumber("Front Right Encoder Values", values[2]);
		SmartDashboard.putNumber("Rear Right Encoder Values", values[4]); */
		drive.driveTeleop();
		
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
