// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1450.FRCSteamworks;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon drivesLeftFrontMotor;
    public static CANTalon drivesLeftRearMotor;
    public static CANTalon drivesRightFrontMotor;
    public static CANTalon drivesRightRearMotor;
    public static RobotDrive drivesRobotDrive;
    public static CANTalon gearShiftGearShiftMotor;
    public static DigitalInput gearShiftLeftLimitSwitch;
    public static DigitalInput gearShiftRightLimitSwitch;
    public static CANTalon climberClimberMotor;
    public static DoubleSolenoid gearReleaseLeftGearReleaseSolenoid;
    public static DoubleSolenoid gearReleaserightGearReleaseSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivesLeftFrontMotor = new CANTalon(10);
        //LiveWindow.addActuator("Drives", "LeftFrontMotor", drivesLeftFrontMotor);
        drivesLeftFrontMotor.changeControlMode(TalonControlMode.Voltage);
    	//drivesLeftFrontMotor.setInverted(false);
    	//drivesLeftFrontMotor.configMaxOutputVoltage(12);
    	drivesLeftFrontMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	//drivesLeftFrontMotor.reverseOutput(false);
    	//drivesLeftFrontMotor.reverseSensor(true);
    	drivesLeftFrontMotor.EnableCurrentLimit(false);
    	drivesLeftFrontMotor.setSafetyEnabled(false);
    	drivesLeftFrontMotor.reverseSensor(true);
    	drivesLeftFrontMotor.enableBrakeMode(false);
    	drivesLeftFrontMotor.setCurrentLimit(40);
    	drivesLeftFrontMotor.EnableCurrentLimit(true);
        
        drivesLeftRearMotor = new CANTalon(11);
        //LiveWindow.addActuator("Drives", "LeftRearMotor", drivesLeftRearMotor);
        drivesLeftRearMotor.changeControlMode(TalonControlMode.Voltage);
        //drivesLeftRearMotor.setInverted(false);
        drivesLeftRearMotor.configMaxOutputVoltage(12);
        //drivesLeftRearMotor.set(drivesLeftFrontMotor.getDeviceID());
        drivesLeftRearMotor.reverseOutput(false);
        drivesLeftRearMotor.setSafetyEnabled(false);
        drivesLeftRearMotor.enableBrakeMode(false);
        drivesLeftRearMotor.setCurrentLimit(40);
        drivesLeftRearMotor.EnableCurrentLimit(true);
        
        drivesRightFrontMotor = new CANTalon(12);
        //LiveWindow.addActuator("Drives", "RightFrontMotor", drivesRightFrontMotor);
        drivesRightFrontMotor.changeControlMode(TalonControlMode.Voltage);
        //drivesRightFrontMot7aaaaaaaaaaaaa+or.setInverted(false);
        //drivesRightFrontMotor.configMaxOutputVoltage(12);
        drivesRightFrontMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        //drivesRightFrontMotor.reverseOutput(false);
        drivesRightFrontMotor.EnableCurrentLimit(false);
        drivesRightFrontMotor.setSafetyEnabled(false);
        drivesRightFrontMotor.reverseSensor(true);
        drivesRightFrontMotor.enableBrakeMode(false);
        drivesRightFrontMotor.setCurrentLimit(40);
        drivesRightFrontMotor.EnableCurrentLimit(true);
        
        drivesRightRearMotor = new CANTalon(13);
        //LiveWindow.addActuator("Drives", "RightRearMotor", drivesRightRearMotor);
        drivesRightRearMotor.changeControlMode(TalonControlMode.Voltage);
        //drivesRightRearMotor.setInverted(false);
        drivesRightRearMotor.configMaxOutputVoltage(12);
        //drivesRightRearMotor.set(drivesRightFrontMotor.getDeviceID());
        drivesRightRearMotor.reverseOutput(false);
        drivesRightRearMotor.setSafetyEnabled(false);
        drivesRightRearMotor.enableBrakeMode(false);
        drivesRightRearMotor.setCurrentLimit(40);
        drivesRightRearMotor.EnableCurrentLimit(true);
        
        drivesRobotDrive = new RobotDrive(drivesLeftFrontMotor, drivesLeftRearMotor,
              drivesRightFrontMotor, drivesRightRearMotor);
        
        drivesRobotDrive.setSafetyEnabled(false);
        drivesRobotDrive.setExpiration(0.1);
        drivesRobotDrive.setSensitivity(0.5);
        drivesRobotDrive.setMaxOutput(12.0);
        drivesRobotDrive.setInvertedMotor(MotorType.kFrontLeft,true);
        drivesRobotDrive.setInvertedMotor(MotorType.kFrontRight,true);
        drivesRobotDrive.setInvertedMotor(MotorType.kRearLeft,true);
        drivesRobotDrive.setInvertedMotor(MotorType.kRearRight,true);

        gearShiftGearShiftMotor = new CANTalon(14);
        //LiveWindow.addActuator("GearShift", "GearShiftMotor", gearShiftGearShiftMotor);
        
        gearShiftLeftLimitSwitch = new DigitalInput(0);
        //LiveWindow.addSensor("GearShift", "LeftLimitSwitch", gearShiftLeftLimitSwitch);
        
        gearShiftRightLimitSwitch = new DigitalInput(1);
        //LiveWindow.addSensor("GearShift", "RightLimitSwitch", gearShiftRightLimitSwitch);
        
        climberClimberMotor = new CANTalon(15);
        //LiveWindow.addActuator("Climber", "ClimberMotor", climberClimberMotor);
        climberClimberMotor.changeControlMode(TalonControlMode.Voltage);
        climberClimberMotor.configMaxOutputVoltage(12.0);
        //climberClimberMotor.enableBrakeMode(true);
        //climberClimberMotor.setCurrentLimit(40);
        //climberClimberMotor.EnableCurrentLimit(true);
        
        gearReleaseLeftGearReleaseSolenoid = new DoubleSolenoid(0, 0, 1);
        //LiveWindow.addActuator("GearRelease", "LeftGearReleaseSolenoid", gearReleaseLeftGearReleaseSolenoid);
        
        gearReleaserightGearReleaseSolenoid = new DoubleSolenoid(0, 2, 3);
        //LiveWindow.addActuator("GearRelease", "rightGearReleaseSolenoid", gearReleaserightGearReleaseSolenoid);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
