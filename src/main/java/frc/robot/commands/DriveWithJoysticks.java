// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class DriveWithJoysticks extends CommandBase {
  public final Drivetrain driveTrain;

  /** Creates a new DriveWithJoysticks. */
  public DriveWithJoysticks(Drivetrain dt) {
    driveTrain = dt;
    addRequirements(driveTrain);
   
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double speed = Constants.DRIVETRAIN_SPEED;

  	if(RobotContainer.driverJoystick.getRawButton(Constants.D_L1))
     {
       speed = Constants.DRIVETRAIN_BOOST;
        
     }
     else
     {
      speed = Constants.DRIVETRAIN_SPEED;

      }
     
    driveTrain.driveWithJoysticks(RobotContainer.driverJoystick, speed);



      SmartDashboard.putNumber("Left Y", RobotContainer.driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_Y_AXIS));
      SmartDashboard.putNumber("Speed", speed);
      SmartDashboard.putNumber("Output",RobotContainer.driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_Y_AXIS) * speed);

/*
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
*/

 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
