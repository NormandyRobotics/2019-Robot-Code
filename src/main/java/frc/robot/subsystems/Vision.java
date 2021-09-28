// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

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
    //Creates UsbCamera and MjpegServer [1] and connects them
    camera = new UsbCamera("USB Camera 0", 0);
    mjpegServer1 = new MjpegServer("server_USB Camera 0", 1181);
    mjpegServer1.setSource(camera);
    //camera = CameraServer.getInstance().startAutomaticCapture(); //change?
    //camera.setResolution(Constants.CAMERA_RES_X,Constants.CAMERA_RES_Y); //change?

    //Creates the CvSink and connects it to the UsbCamera
    cvSink = new CvSink("opencv_USB Camera 0");
    cvSink.setSource(camera);  
    //cvSink = CameraServer.getInstance().getVideo(); //change?
    
    //Creates the CvSource and MjpecServer[2] and connects them
    outputStream = new CvSource("Blur", PixelFormat.kMJPEG, Constants.CAMERA_RES_X, Constants.CAMERA_RES_Y,30);
    mjpegServer2 = new MjpegServer("serve_blur",1182);
    mjpegServer2.setSource(outputStream);
    // outputStream = CameraServer.getInstance().putVideo("Blur",Constants.CAMERA_RES_X,Constants.CAMERA_RES_Y);


  }



  public void visionProcess(){
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
