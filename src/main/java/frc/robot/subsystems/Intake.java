// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  VictorSPX intakeTopMotor;
  VictorSPX intakeBottomMotor;


  public Intake() {
    intakeTopMotor = new VictorSPX(Constants.INTAKE_TOPID);
    intakeBottomMotor = new VictorSPX(Constants.INTAKE_BOTTOMID);
  }

  public void bottomIntakeUp()
  {
    intakeBottomMotor.set(ControlMode.PercentOutput, 1);
  }

  public void bottomIntakeDown()
  {
    intakeBottomMotor.set(ControlMode.PercentOutput, -1);
  }

  public void bottomIntakeStop()
  {
    intakeBottomMotor.set(ControlMode.PercentOutput, 0);
  }

  public void topIntakeUp()
  {
    intakeTopMotor.set(ControlMode.PercentOutput, 1);
  }

  public void topIntakeDown()
  {
    intakeTopMotor.set(ControlMode.PercentOutput, -1);
  }

  public void topIntakeStop()
  {
    intakeTopMotor.set(ControlMode.PercentOutput, 0);
  }

  public void stop() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
