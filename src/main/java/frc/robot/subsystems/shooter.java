package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.*;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;

public class shooter extends SubsystemBase {
    static int Upshooterspeed = 0;
    static int Lowshooterspeed = 0;
    static boolean shooting = false;
    public CANSparkMax shooter_upMotor = new CANSparkMax(5, MotorType.kBrushed);
    public CANSparkMax shooter_lowMotor = new CANSparkMax(6, MotorType.kBrushed);
    private final Timer m_timer = new Timer();

    public void init() {
        shooter_upMotor.restoreFactoryDefaults();
        shooter_lowMotor.restoreFactoryDefaults();
    }

    public void setMotor(Boolean button1, Boolean button2, Boolean button12, boolean button22,
            boolean autonomous_shooter) {
        SmartDashboard.putBoolean("Button1", button1);
        SmartDashboard.putBoolean("Button2", button2);
        SmartDashboard.putBoolean("Button12", button12);
        SmartDashboard.putBoolean("Button22", button22);
        SmartDashboard.putNumber("Up Shooter Motor Speed", Upshooterspeed);
        SmartDashboard.putNumber("Low Shooter Motor Speed", Lowshooterspeed);
        shooter_upMotor.set(-Upshooterspeed);
        shooter_lowMotor.set(-Lowshooterspeed);
        if (button2 == true) {
            // shooting = true;
            // m_timer.start();
            Upshooterspeed = -1;
            Lowshooterspeed = -1;

        }
        if (autonomous_shooter == true) {
            shooting = true;
            m_timer.start();
        }
        if (button1 == true) {
            // Upshooterspeed = -1;
            // Lowshooterspeed = -1;
            Lowshooterspeed = 1;
            Upshooterspeed = 1;
        }
        if (button12 == true) {
            Upshooterspeed = 0;
            Lowshooterspeed = 0;
        }
        if (button22 == true) {
            Upshooterspeed = 0;
            Lowshooterspeed = 0;
        }
    }

    
}
