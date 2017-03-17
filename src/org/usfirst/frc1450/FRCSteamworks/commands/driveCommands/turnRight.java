// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1450.FRCSteamworks.commands.driveCommands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1450.FRCSteamworks.Robot;

/**
 *
 */
public class turnRight extends Command {

    private double m_turnAngle;
    private double m_timeoutSeconds;
    
    public turnRight(double turnAngle, double timeoutSeconds) {

        m_turnAngle = turnAngle;
        m_timeoutSeconds = timeoutSeconds;

        requires(Robot.drives);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drives.teleopDrive(m_turnAngle, 45);
        try {
			Robot.drives.wait((long)m_timeoutSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Robot.drives.teleopDrive(0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
