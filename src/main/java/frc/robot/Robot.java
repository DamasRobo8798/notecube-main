// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
//import frc.robot.subsystems.drive;
import frc.robot.subsystems.shooter;

// This is a new comment
public class Robot extends TimedRobot {

  private static XboxController m_stick = new XboxController(0);
  private final DifferentialDrive m_drive = new DifferentialDrive(null, null) ();
  private final shooter m_shooter = new shooter();
  private final Timer m_timer = new Timer();
  private final D lead = new PWMSparkMax(5);
  private final PWMSparkMax follow = new PWMSparkMax(6);
  static int m_stage;
  static boolean autonomous_shooter = false;
  static boolean autonomous_stopShooter = false;
  @Override

  public void robotInit() {
    m_drive.init();
    m_shooter.init();
  }
  @Override
  public void teleopPeriodic() {
    final double stickY = -m_stick.getLeftY();
    final double stickX = -m_stick.getRightX();
    
    m_drive.arcadeDrive(stickY,stickX);


    if(m_stick.getRawButton(1)){
      m_shooter.shooter_lowMotor.set(0.6);
    }
    else if(m_stick.getRawButton(4)){
      m_shooter.shooter_lowMotor.set(-0.6);
    }
    else{
      m_shooter.shooter_lowMotor.set(0);
    }
    //m_shooter.setMotor(m_stick.getRawButton(2),m_stick.getRawButton(0),m_stick.getRawButtonReleased(2),m_stick.getRawButtonReleased(0),autonomous_shooter);
  }
  public void autonomousInit() {
    m_timer.start();
    m_stage = 1;
  }
}
