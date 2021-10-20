// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.BottomIntakeDown;
import frc.robot.commands.BottomIntakeStop;
import frc.robot.commands.BottomIntakeUp;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.LiftDown;
import frc.robot.commands.LiftStop;
import frc.robot.commands.LiftUp;
import frc.robot.commands.SpinBackward;
import frc.robot.commands.SpinForward;
import frc.robot.commands.SpinStop;
import frc.robot.commands.StartShooter;
import frc.robot.commands.StopShooter;
import frc.robot.commands.TopInstakeStop;
import frc.robot.commands.TopIntakeDown;
import frc.robot.commands.TopIntakeUp;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Power;
import frc.robot.subsystems.Sensors;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Spinner;
import frc.robot.subsystems.Vision;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...

  //Drivetrain declare
  private final Drivetrain driveTrain;
  private final DriveWithJoysticks driveWithJoysticks;

  //Shooter declare
  private final Shooter shooter;
  private final StartShooter startShooter;
  private final StopShooter stopShooter;
 

  //Spinner declare
  private final Spinner spinner;
  private final SpinBackward spinBackward;
  private final SpinForward spinForward;
  private final SpinStop spinStop;
  private final LiftUp liftUp;
  private final LiftDown liftDown;
  private final LiftStop liftStop;
  

  //Intake declare
  private final Intake intake;
  private final BottomIntakeDown bottomIntakeDown;
  private final BottomIntakeStop bottomIntakeStop;
  private final BottomIntakeUp bottomIntakeUp;
  private final TopInstakeStop topIntakeStop;
  private final TopIntakeDown topIntakeDown;
  private final TopIntakeUp topIntakeUp;

  //PDP declare
  private final Power power;

  //Sensors declare
  private final Sensors sensors;

  //Controller declare
  public static XboxController driverJoystick;
  public static XboxController operatorJoystick;

  //Vision declare
  private final Vision vision;

  //Sendable chooser declare
  SendableChooser<Command> chooser = new SendableChooser<>();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // initialize drive values
    driveTrain = new Drivetrain();
    driveWithJoysticks = new DriveWithJoysticks(driveTrain);
    driveWithJoysticks.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoysticks);  //set default command

    // initialize shoot values
    shooter = new Shooter();
    startShooter = new StartShooter(shooter);
    startShooter.addRequirements(shooter);
    stopShooter = new StopShooter(shooter);
    stopShooter.addRequirements(shooter);

    // initialize spinner values
    spinner = new Spinner();
    spinForward = new SpinForward(spinner);
    spinForward.addRequirements(spinner);
    spinBackward = new SpinBackward(spinner);
    spinBackward.addRequirements(spinner);
    spinStop = new SpinStop(spinner);
    spinStop.addRequirements(spinner);

    liftUp = new LiftUp(spinner);
    liftUp.addRequirements(spinner);
    liftDown = new LiftDown(spinner);
    liftDown.addRequirements(spinner);
    liftStop = new LiftStop(spinner);
    liftStop.addRequirements(spinner);
    
    // initialize intake values
    intake = new Intake();
    bottomIntakeDown = new BottomIntakeDown(intake);
    bottomIntakeDown.addRequirements(intake);
    bottomIntakeStop = new BottomIntakeStop(intake);
    bottomIntakeStop.addRequirements(intake);
    bottomIntakeUp = new BottomIntakeUp(intake);
    bottomIntakeUp.addRequirements(intake);
    topIntakeDown = new TopIntakeDown(intake);
    topIntakeDown.addRequirements(intake);
    topIntakeStop = new TopInstakeStop(intake);
    topIntakeStop.addRequirements(intake);
    topIntakeUp = new TopIntakeUp(intake);
    topIntakeUp.addRequirements(intake);

    // initialize PDP values
    power = new Power();

    // initialize Sensor values
    sensors = new Sensors();

    // initialize vision
    vision = new Vision();

    // initialize joystick values
    driverJoystick = new XboxController(Constants.DRIVER_JOYSTICK);
    operatorJoystick = new XboxController(Constants.OPERATOR_JOYSTICK);

    //initalize camera (move to its own subsystem later)
    CameraServer.getInstance().startAutomaticCapture();
    //camera.setResolution(Constants.CAMERA_RES_X, Constants.CAMERA_RES_Y);
  
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
    final JoystickButton d_l1 = new JoystickButton(driverJoystick, Constants.D_L1);
    final JoystickButton d_r1 = new JoystickButton(driverJoystick, Constants.D_R1);
    final JoystickButton d_joy1 = new JoystickButton(driverJoystick, Constants.D_JOY1);
    final JoystickButton d_joy2 = new JoystickButton(driverJoystick, Constants.D_JOY2);
    final JoystickButton d_midLeft = new JoystickButton(driverJoystick, Constants.D_MIDLEFT);
    final JoystickButton d_midRight = new JoystickButton(driverJoystick, Constants.D_MIDRIGHT);
    
    final JoystickButton o_dpadUp = new JoystickButton(operatorJoystick, Constants.O_DPAD_UP);
    final JoystickButton o_dpadRight = new JoystickButton(operatorJoystick, Constants.O_DPAD_RIGHT);
    final JoystickButton o_dpadDown = new JoystickButton(operatorJoystick, Constants.O_DPAD_DOWN);
    final JoystickButton o_dpadLeft = new JoystickButton(operatorJoystick, Constants.O_DPAD_LEFT);
    final JoystickButton o_l2 = new JoystickButton(operatorJoystick, Constants.O_L2);
    final JoystickButton o_r2 = new JoystickButton(operatorJoystick, Constants.O_R2);
    final JoystickButton o_l1 = new JoystickButton(operatorJoystick, Constants.O_L1);
    final JoystickButton o_r1 = new JoystickButton(operatorJoystick, Constants.O_R1);
    final JoystickButton o_joy1 = new JoystickButton(operatorJoystick, Constants.O_JOY1);
    final JoystickButton o_joy2 = new JoystickButton(operatorJoystick, Constants.O_JOY2);
    final JoystickButton o_midLeft = new JoystickButton(driverJoystick, Constants.O_MIDLEFT);
    final JoystickButton o_midRight = new JoystickButton(driverJoystick, Constants.O_MIDRIGHT);

    //assign drivers buttons
    d_dpadLeft.whenPressed(startShooter);
    d_dpadLeft.whenReleased(stopShooter);
    o_midLeft.whenPressed(startShooter);
    o_midLeft.whenReleased(stopShooter);
    d_midLeft.whenPressed(startShooter);
    d_midLeft.whenReleased(stopShooter); 

    SmartDashboard.putString("Shooter","---");

    //assign operators buttons
    o_dpadLeft.whenPressed(spinForward);
    o_dpadLeft.whenReleased(spinStop);
    o_dpadRight.whenPressed(spinBackward);
    o_dpadRight.whenReleased(spinStop);
    d_dpadLeft.whenPressed(spinForward);
    d_dpadLeft.whenReleased(spinStop);
    d_dpadRight.whenPressed(spinBackward);
    d_dpadRight.whenReleased(spinStop);
    SmartDashboard.putString("Spinner", "---");

    o_dpadUp.whenPressed(liftUp);
    o_dpadUp.whenReleased(liftStop);
    o_dpadDown.whenPressed(liftDown);
    o_dpadDown.whenReleased(liftStop);
    d_dpadUp.whenPressed(liftUp);
    d_dpadUp.whenReleased(liftStop);
    d_dpadDown.whenPressed(liftDown);
    d_dpadDown.whenReleased(liftStop);
    SmartDashboard.putString("Lift","---");

    o_l1.whenPressed(topIntakeUp);
    o_l1.whenReleased(topIntakeStop);
    o_l2.whenPressed(topIntakeDown);
    o_l2.whenReleased(topIntakeStop);
    d_l1.whenPressed(topIntakeUp);
    d_l1.whenReleased(topIntakeStop);
    d_l2.whenPressed(topIntakeDown);
    d_l2.whenReleased(topIntakeStop);
    SmartDashboard.putString("Intake Top", "---");

    o_r1.whenPressed(bottomIntakeUp);
    o_r1.whenReleased(bottomIntakeStop);
    o_r2.whenPressed(bottomIntakeDown);
    o_r2.whenReleased(bottomIntakeStop);
    d_r1.whenPressed(bottomIntakeUp);
    d_r1.whenReleased(bottomIntakeStop);
    d_r2.whenPressed(bottomIntakeDown);
    d_r2.whenReleased(bottomIntakeStop);
    SmartDashboard.putString("Intake Bottom", "---");


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

