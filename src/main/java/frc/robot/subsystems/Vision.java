// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Vision extends SubsystemBase {

UsbCamera camera;
CvSink cvSink;
CvSource outputStream;
MjpegServer mjpegServer1, mjpegServer2;

  /** Creates a new Vision. */
  public Vision() {
  


  }



  public void visionProcess(){
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
