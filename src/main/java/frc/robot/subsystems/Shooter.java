// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  //TalonSRX shootMotor;
  VictorSPX shootMotor;

  /** Creates a new Shooter. */
  public Shooter() {
    //shootMotor = new TalonSRX(Constants.SHOOTERID);
    shootMotor = new VictorSPX(Constants.SHOOTERID);
    shootMotor.setInverted(true);
  
  }

  //start the shooter motor

  public void startShooter()
  {
    shootMotor.set(ControlMode.PercentOutput, 1);
    
  }

  //stop the shooter motor
  public void stopShooter()
  {
    shootMotor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
