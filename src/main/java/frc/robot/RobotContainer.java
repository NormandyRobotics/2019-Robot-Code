// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.cscore.UsbCamera;
//import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

/* sample RobotContainer
public class RobotContainer {
     // Configure the button bindings
    configureButtonBindings();
  }


  private void configureButtonBindings() {
    // Create some buttons
    final JoystickButton dpadUp = new JoystickButton(m_joystick, 5);
    final JoystickButton dpadRight = new JoystickButton(m_joystick, 6);
    final JoystickButton dpadDown = new JoystickButton(m_joystick, 7);
    final JoystickButton dpadLeft = new JoystickButton(m_joystick, 8);
    final JoystickButton l2 = new JoystickButton(m_joystick, 9);
    final JoystickButton r2 = new JoystickButton(m_joystick, 10);
    final JoystickButton l1 = new JoystickButton(m_joystick, 11);
    final JoystickButton r1 = new JoystickButton(m_joystick, 12);

    // Connect the buttons to commands
    dpadUp.whenPressed(new SetElevatorSetpoint(0.25, m_elevator));
    dpadDown.whenPressed(new SetElevatorSetpoint(0.0, m_elevator));
    dpadRight.whenPressed(new CloseClaw(m_claw));
    dpadLeft.whenPressed(new OpenClaw(m_claw));

    r1.whenPressed(new PrepareToPickup(m_claw, m_wrist, m_elevator));
    r2.whenPressed(new Pickup(m_claw, m_wrist, m_elevator));
    l1.whenPressed(new Place(m_claw, m_wrist, m_elevator));
    l2.whenPressed(new Autonomous(m_drivetrain, m_claw, m_wrist, m_elevator));
  }
  */

  // The robot's subsystems and commands are defined here...
  //Drivetrain declare
  private final Drivetrain driveTrain;
  private final DriveWithJoysticks driveWithJoysticks;

  //Controller declare
  public static XboxController driverJoystick;
  public static XboxController operatorJoystick;

  //Sendable chooser declare
  SendableChooser<Command> chooser = new SendableChooser<>();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // initialize drive values
    driveTrain = new Drivetrain();
    driveWithJoysticks = new DriveWithJoysticks(driveTrain);
    driveWithJoysticks.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoysticks);  //set default command

    // initialize joystick values
    driverJoystick = new XboxController(Constants.DRIVER_JOYSTICK);
    operatorJoystick = new XboxController(Constants.OPERATOR_JOYSTICK);

    //initalize camera (move to its own subsystem later)
  /*  UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(Constants.CAMERA_RES_X, Constants.CAMERA_RES_Y);
  */

  /*
   // Put Some buttons on the SmartDashboard   (button text, command)
   SmartDashboard.putData("Elevator Bottom", new SetElevatorSetpoint(0, m_elevator));
   SmartDashboard.putData("Elevator Top", new SetElevatorSetpoint(0.25, m_elevator));

   SmartDashboard.putData("Wrist Horizontal", new SetWristSetpoint(0, m_wrist));
   SmartDashboard.putData("Raise Wrist", new SetWristSetpoint(-45, m_wrist));
    */


    // Show what command your subsystem is running on the SmartDashboard (subsystem)
        SmartDashboard.putData(driveTrain);





        
    // Configure the button bindings
    configureButtonBindings();

    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //create some buttons
    final JoystickButton d_dpadUp = new JoystickButton(driverJoystick, Constants.D_DPAD_UP);
    final JoystickButton d_dpadRight = new JoystickButton(driverJoystick, Constants.D_DPAD_RIGHT);
    final JoystickButton d_dpadDown = new JoystickButton(driverJoystick, Constants.D_DPAD_DOWN);
    final JoystickButton d_dpadLeft = new JoystickButton(driverJoystick, Constants.D_DPAD_LEFT);
    final JoystickButton d_l2 = new JoystickButton(driverJoystick, Constants.D_L2);
    final JoystickButton d_r2 = new JoystickButton(driverJoystick, Constants.D_R2);
    //final JoystickButton d_l1 = new JoystickButton(driverJoystick, Constants.D_L1);
    final JoystickButton d_r1 = new JoystickButton(driverJoystick, Constants.D_R1);

    final JoystickButton o_dpadUp = new JoystickButton(operatorJoystick, Constants.O_DPAD_UP);
    final JoystickButton o_dpadRight = new JoystickButton(operatorJoystick, Constants.O_DPAD_RIGHT);
    final JoystickButton o_dpadDown = new JoystickButton(operatorJoystick, Constants.O_DPAD_DOWN);
    final JoystickButton o_dpadLeft = new JoystickButton(operatorJoystick, Constants.O_DPAD_LEFT);
    final JoystickButton o_l2 = new JoystickButton(operatorJoystick, Constants.O_L2);
    final JoystickButton o_r2 = new JoystickButton(operatorJoystick, Constants.O_R2);
    final JoystickButton o_l1 = new JoystickButton(operatorJoystick, Constants.O_L1);
    final JoystickButton o_r1 = new JoystickButton(operatorJoystick, Constants.O_R1);

    final boolean d_l1 = driverJoystick.getRawButton(Constants.D_L1);

   
    //Publish button values to SmartDashboard
    SmartDashboard.putBoolean("D_L1", d_l1);
    SmartDashboard.putBoolean("D_L2", d_l2.get());
    SmartDashboard.putBoolean("D_R1", d_r1.get());
    SmartDashboard.putBoolean("D_R2", d_r2.get());
    SmartDashboard.putBoolean("D_Dpad_Up", d_dpadUp.get());
    SmartDashboard.putBoolean("D_Dpad_Down", d_dpadDown.get());
    SmartDashboard.putBoolean("D_Dpad_Left", d_dpadLeft.get());
    SmartDashboard.putBoolean("D_Dpad_Right", d_dpadRight.get());
    SmartDashboard.putNumber("Driver_X1", driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_X_AXIS));
    SmartDashboard.putNumber("Driver_Y1", driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_Y_AXIS));
    SmartDashboard.putNumber("Driver_X2", driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_X_AXIS));
    SmartDashboard.putNumber("Driver_Y2", driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_Y_AXIS));


    
    /*

    //set normal drive speed 50% with L1 button speed boost to 100%
    if(d_l1)
    {
      driveTrain.setMaxOutput(Constants.DRIVETRAIN_BOOST);
    }
    else
    {
      driveTrain.setMaxOutput(Constants.DRIVETRAIN_SPEED);
    }

    */

  }




  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
 
    return chooser.getSelected();
  }

}

