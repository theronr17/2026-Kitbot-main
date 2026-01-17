package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FuelSubsystem extends SubsystemBase {
    public static TalonFX intakeLauncherRoller = new TalonFX(1);
    public static TalonFX feederRoller = new TalonFX(2);


    double launcherIntakeSpeed = 0.5;
    double launcherLaunchSpeed = 0.7;

    double rollerIntakeSpeed = 0.4;
    double rollerLaunchSpeed = 0.6;
    double rollerSpinUpSpeed = 0.5;
    

    public Command intake() {
        return Commands.run(
            () -> {
                intakeLauncherRoller.set(launcherIntakeSpeed);
                feederRoller.set(rollerIntakeSpeed);
            }
        );
    }

    public Command eject() {
        return Commands.run(
            () -> {
                intakeLauncherRoller.set(-launcherIntakeSpeed);
                feederRoller.set(-rollerIntakeSpeed);
            }
        );
    }

    public Command stop() {
        return Commands.run(
            () -> {
                intakeLauncherRoller.set(0);
                feederRoller.set(0);
            }
        );
    }

    public Command launch() {
        return Commands.run(
            () -> {
                intakeLauncherRoller.set(launcherLaunchSpeed);
                feederRoller.set(rollerLaunchSpeed);
            }
        );
    }

    public Command spinUp() {
        return Commands.run(
            () -> {
                intakeLauncherRoller.set(launcherLaunchSpeed);
                feederRoller.set(rollerSpinUpSpeed);
            }
        );
    }
} 