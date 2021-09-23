// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Spinner extends SubsystemBase {
  /** Creates a new Spinner. */
  VictorSPX spinnerMotor;
  VictorSPX liftMotor;



  public Spinner()
  {
    spinnerMotor = new VictorSPX(Constants.SPINNERID);
    liftMotor = new VictorSPX(Constants.LIFTID);
  } 
 
  public void spinForward()
  {
    spinnerMotor.set(ControlMode.PercentOutput, 1);
  }

  public void spinBackward()
  {
    spinnerMotor.set(ControlMode.PercentOutput, -1);
  }

  public void spinStop()
  {
    spinnerMotor.set(ControlMode.PercentOutput, 0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
