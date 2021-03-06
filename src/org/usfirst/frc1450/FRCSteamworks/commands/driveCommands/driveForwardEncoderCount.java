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
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc1450.FRCSteamworks.Robot;
import org.usfirst.frc1450.FRCSteamworks.RobotMap;

/**
 *
 */
public class driveForwardEncoderCount extends Command {

    private double m_encoderCount;
    private double m_timeoutSeconds;
    private int loopCounter;
 
    public driveForwardEncoderCount(double encoderCount, double timeoutSeconds) {
        m_encoderCount = encoderCount;
        m_timeoutSeconds = timeoutSeconds;
        loopCounter = 0;

        requires(Robot.drives);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	//VelocityControlMethod
    	Robot.drives.ClearGyroAngle();
    	Robot.drives.SetVelocityControl();
    	if (m_encoderCount / 217.3084112149533 > 12)
    	{
    		Robot.drives.GoPositionWithSpeed(
    				Robot.drives.driveSpeedCeiling * 0.5,
    				Robot.drives.driveSpeedCeiling * 0.5,
    				m_encoderCount,
    				m_encoderCount);
    	}else
    	{
    		Robot.drives.GoPositionWithSpeed(
    				Robot.drives.driveSpeedCeiling * 0.125,
    				Robot.drives.driveSpeedCeiling * 0.125,
    				m_encoderCount,
    				m_encoderCount);
    	}
    	
    	/*
    	Robot.drives.SetPositionControl();
    	Robot.drives.GoPosition(m_encoderCount, m_encoderCount);
    	*/
    	SmartDashboard.putString("CommandState", "Init");
    	loopCounter = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	loopCounter++;
    	SmartDashboard.putNumber("LoopCount", loopCounter);
    	double leftSpeedAdjust = 1.0;
    	double rightSpeedAdjust = 1.0;
    	
    	double currentAngle = Robot.drives.GetGyroAngle(); 
    	// 0 <= currentAngle <= 359
    	// -180 <= m_turnAngle <= 180
    	// -180 <= currentError <= 539
    	// 539 - 360 = 
    	if (currentAngle > 180)
    	{
    		currentAngle -= 360;
    	}
    	
    	double correctionAmplifier = 2.0;
    	
    	
    	//not enough correction.  need to boost
    	if (currentAngle < 0)
    	{
    		rightSpeedAdjust = 1.0 - Math.abs(currentAngle) * correctionAmplifier / 180.0;
    	}
    	else
    	{
    		leftSpeedAdjust = 1.0 - Math.abs(currentAngle) * correctionAmplifier / 180.0;
    	}
    	
    	//VelocityControlMethod
    	if (Math.abs((-1.0 * m_encoderCount) - Robot.drives.GetLeftPosition()) / 217.3084112149533 < 12)
    	{
    		Robot.drives.GoPositionWithSpeed(
    				leftSpeedAdjust * Robot.drives.driveSpeedCeiling * 0.125,
    				rightSpeedAdjust * Robot.drives.driveSpeedCeiling * 0.125,
    				m_encoderCount,
    				m_encoderCount);
    	}
    	else if (Math.abs(m_encoderCount - Robot.drives.GetLeftPosition()) / 217.3084112149533 < 12)
    	{
    		Robot.drives.GoPositionWithSpeed(
    				leftSpeedAdjust * Robot.drives.driveSpeedCeiling * 0.125,
    				rightSpeedAdjust * Robot.drives.driveSpeedCeiling * 0.125,
    				m_encoderCount,
    				m_encoderCount);
    	}
    	else
    	{
    		Robot.drives.GoPositionWithSpeed(
    				leftSpeedAdjust * Robot.drives.driveSpeedCeiling * 0.5,
    				rightSpeedAdjust * Robot.drives.driveSpeedCeiling * 0.5,
    				m_encoderCount,
    				m_encoderCount);
    	}
    	
    	SmartDashboard.putNumber("leftErr", Robot.drives.GetLeftError());
    	SmartDashboard.putNumber("rightErr", Robot.drives.GetRightError());
    	SmartDashboard.putNumber("leftSet", Robot.drives.GetLeftSetPt());
    	SmartDashboard.putNumber("rightSet", Robot.drives.GetRightSetPt());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.drives.ReachedPosition(217.3084112149533 * 3.0) || (loopCounter >= m_timeoutSeconds / 0.02));
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	//VelocityControlMethod
    	Robot.drives.StopVelocityControl();
    	
    	Robot.drives.VoltageControl();
    	SmartDashboard.putString("CommandState", "Done");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
