// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Power extends SubsystemBase {
  /** Creates a new Power. */
  private final PowerDistributionPanel pdp = new PowerDistributionPanel(Constants.PDP);


  public Power() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
    //Display current draw
    SmartDashboard.putNumber("Current Channel 1", pdp.getCurrent(1));
    SmartDashboard.putNumber("Current Channel 2", pdp.getCurrent(2));
    SmartDashboard.putNumber("Current Channel 3", pdp.getCurrent(3));
    SmartDashboard.putNumber("Current Channel 4", pdp.getCurrent(4));
    SmartDashboard.putNumber("Current Channel 5", pdp.getCurrent(5));
    SmartDashboard.putNumber("Current Channel 6", pdp.getCurrent(6));
    SmartDashboard.putNumber("Current Channel 7", pdp.getCurrent(7));
    SmartDashboard.putNumber("Current Channel 8", pdp.getCurrent(8));
    SmartDashboard.putNumber("Current Channel 9", pdp.getCurrent(9));
    SmartDashboard.putNumber("Current Channel 10", pdp.getCurrent(10));
    SmartDashboard.putNumber("Current Channel 11", pdp.getCurrent(11));
    SmartDashboard.putNumber("Current Channel 12", pdp.getCurrent(12));
    SmartDashboard.putNumber("Current Channel 13", pdp.getCurrent(13));
    SmartDashboard.putNumber("Current Channel 14", pdp.getCurrent(14));
    /*
     * Get the voltage going into the PDP, in Volts.
     * The PDP returns the voltage in increments of 0.05 Volts.
     */
    SmartDashboard.putNumber("Voltage", pdp.getVoltage());

    /*
     * Retrieves the temperature of the PDP, in degrees Celsius.
     * convert to farenheit?
     */
    SmartDashboard.putNumber("Temperature", pdp.getTemperature());
  }
}
