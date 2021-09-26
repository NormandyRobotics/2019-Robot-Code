// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.LinearFilter;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensors extends SubsystemBase {
Accelerometer accelerometer;
LinearFilter xAccelFilter = LinearFilter.movingAverage(10);
LinearFilter yAccelFilter = LinearFilter.movingAverage(10);
LinearFilter zAccelFilter = LinearFilter.movingAverage(10);


double prevXAccel = 0;
double prevYAccel = 0;
double prevZAccel = 0;

double prevFilteredXAccel = 0;
double prevFilteredYAccel = 0;
double prevFilteredZAccel = 0;

  /** Creates a new Sensors. */
  public Sensors() 
  {


    accelerometer = new BuiltInAccelerometer();
    



  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //Get accelerometer values in X, Y, and Z directions
    double xAccel = accelerometer.getX();
    double yAccel = accelerometer.getY();
    double zAccel = accelerometer.getZ();

    SmartDashboard.putNumber("Accelerometer X", xAccel);
    SmartDashboard.putNumber("Accelerometer Y", yAccel);
    SmartDashboard.putNumber("Accelerometer Z", zAccel);

    // Calculate the jerk (rate of change in acceleration) in each direction
    // Divide by 0.02 because default timing loop is 20 ms

    double xJerk = (xAccel - prevXAccel)/0.02;
    double yJerk = (yAccel - prevYAccel)/0.02;
    double zJerk = (zAccel - prevZAccel)/0.02;

    SmartDashboard.putNumber("Jerk X", xJerk);
    SmartDashboard.putNumber("Jerk Y", yJerk);
    SmartDashboard.putNumber("Jerk Z", zJerk);

    // reassign previous accelerometer values
    prevXAccel = xAccel;
    prevYAccel = yAccel;
    prevZAccel = zAccel;

    // Filtered accelerations
    double filteredXAccel = xAccelFilter.calculate(xAccel);
    double filteredYAccel = yAccelFilter.calculate(yAccel);
    double filteredZAccel = zAccelFilter.calculate(zAccel);

    SmartDashboard.putNumber("Filtered X", filteredXAccel);
    SmartDashboard.putNumber("Filtered Y", filteredYAccel);
    SmartDashboard.putNumber("Filtered Z", filteredZAccel);



    
  }
}
