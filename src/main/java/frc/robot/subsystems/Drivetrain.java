// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Drivetrain extends SubsystemBase {

  //change speed controller types as necessary
  
  PWMVictorSPX leftFrontMotor;
  PWMVictorSPX leftRearMotor;
  PWMVictorSPX rightFrontMotor;
  PWMVictorSPX rightRearMotor;

  SpeedControllerGroup driveMotorsLeft;
  SpeedControllerGroup driveMotorsRight;

  DifferentialDrive drive;
  

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftFrontMotor = new PWMVictorSPX(Constants.LEFT_FRONT_MOTOR);
    leftFrontMotor.setInverted(true);
    leftRearMotor = new PWMVictorSPX(Constants.LEFT_REAR_MOTOR);
    leftRearMotor.setInverted(true);
    rightFrontMotor = new PWMVictorSPX(Constants.RIGHT_FRONT_MOTOR);
    rightFrontMotor.setInverted(false);
    rightRearMotor = new PWMVictorSPX(Constants.RIGHT_REAR_MOTOR);
    rightRearMotor.setInverted(false);

    driveMotorsLeft = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
    driveMotorsRight = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
  
  }

  public void driveWithJoysticks(XboxController controller, double speed)
  {
    driveMotorsLeft.set(controller.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_Y_AXIS)*speed);
    driveMotorsRight.set(controller.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_Y_AXIS)*speed);
    SmartDashboard.putNumber("Speed from subsystem", speed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run

        //update smartdashboard with current button/axis values
        SmartDashboard.putBoolean("D_L1", RobotContainer.driverJoystick.getRawButton(Constants.D_L1));
        SmartDashboard.putBoolean("D_L2", RobotContainer.driverJoystick.getRawButton(Constants.D_L2));
        SmartDashboard.putBoolean("D_R1", RobotContainer.driverJoystick.getRawButton(Constants.D_R1));
        SmartDashboard.putBoolean("D_R2", RobotContainer.driverJoystick.getRawButton(Constants.D_R2));
        SmartDashboard.putBoolean("D_Dpad_Up", RobotContainer.driverJoystick.getRawButton(Constants.D_DPAD_UP));
        SmartDashboard.putBoolean("D_Dpad_Down", RobotContainer.driverJoystick.getRawButton(Constants.D_DPAD_DOWN));
        SmartDashboard.putBoolean("D_Dpad_Left", RobotContainer.driverJoystick.getRawButton(Constants.D_DPAD_LEFT));
        SmartDashboard.putBoolean("D_Dpad_Right", RobotContainer.driverJoystick.getRawButton(Constants.D_DPAD_RIGHT));
        SmartDashboard.putNumber("Driver_X1", RobotContainer.driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_X_AXIS));
        SmartDashboard.putNumber("Driver_Y1", RobotContainer.driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_Y_AXIS));
        SmartDashboard.putNumber("Driver_X2", RobotContainer.driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_X_AXIS));
        SmartDashboard.putNumber("Driver_Y2", RobotContainer.driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_Y_AXIS));
  }

  public void stop() {
    driveMotorsLeft.stopMotor();
    driveMotorsRight.stopMotor();
  }
}
