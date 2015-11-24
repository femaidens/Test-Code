package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonForFun extends CommandGroup {
    
    public  AutonForFun() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new Drive(0, -0.25, 0, 10.0)); //forward
    	addSequential(new Drive(0, 0.7, 0, 10.0)); //backward
    	addSequential
    	(new Drive(0.3, 0, 0, 10.0)); //strafe
    	//addSequential(new Extend()); //extend piston
    	//addSequential(new Retract()); //retract piston
    }
}
