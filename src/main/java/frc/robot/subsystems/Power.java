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
        /*
     * Get the current going through channel 7, in Amperes. The PDP returns the
     * current in increments of 0.125A. At low currents
     * the current readings tend to be less accurate.
     * 
     * Add addtional channels to watch current draw
     */
    SmartDashboard.putNumber("Current Channel 7", pdp.getCurrent(7));

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
