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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc1450.FRCSteamworks.Robot;

/**
 *
 */
public class turnRight extends Command {

    private double m_turnAngle;
    private double m_timeoutSeconds;
    private int loopCount = 0;
    private double currentError = 180.0;
    
    public turnRight(double turnAngle, double timeoutSeconds) {

        m_turnAngle = turnAngle;
        m_timeoutSeconds = timeoutSeconds;

        requires(Robot.drives);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	loopCount = 0;
    	Robot.drives.ClearGyroAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentAngle = Robot.drives.GetGyroAngle(); 
    	// 0 <= currentAngle <= 359
    	// -180 <= m_turnAngle <= 180
    	currentError = currentAngle - m_turnAngle;
    	// -180 <= currentError <= 539
    	// 539 - 360 = 
    	if (currentError > 180)
    	{
    		currentError -= 360;
    	}
    	//0.58 overshot
    	SmartDashboard.putNumber("angleErr", currentError);
    	if (currentError > 0.0)
    	{
    		Robot.drives.teleopDrive(-0.57, 0.0);
    	}
    	else if (currentError < 0.0)
    	{
    		Robot.drives.teleopDrive(0.57, 0.0);
    	}
    	loopCount++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return ((Math.abs(currentError) < 3.0) || (loopCount > (m_timeoutSeconds / 0.02)));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drives.teleopDrive(0.0,0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
