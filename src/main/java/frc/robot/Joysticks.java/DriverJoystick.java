package frc.robot;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.FuelSubsystem;

public class DriverJoystick {
    private final CommandXboxController joystick;
    private final CommandSwerveDrivetrain drivetrain;
    private final FuelSubsystem fuelSubsystem;
    
    public DriverJoystick(CommandXboxController joystick, CommandSwerveDrivetrain drivetrain, FuelSubsystem fuelSubsystem) {

        this.joystick = joystick;
        this.drivetrain = drivetrain;
        this.fuelSubsystem = fuelSubsystem;
    }

    public void configureButtonBindings() {
        joystick.a()
            .whileTrue(fuelSubsystem.intake())
            .onFalse(
                Commands.run(
                    () -> {
                        fuelSubsystem.stop();
                    }
                )
            );

        joystick.b()
            .whileTrue(fuelSubsystem.eject())
            .onFalse(
                Commands.run(
                    () -> {
                        fuelSubsystem.stop();
                    }
                )
            );

        joystick.x()
            .onTrue(fuelSubsystem.launch().withTimeout(0.5))
            .onFalse(
                Commands.run(
                    () -> {
                        fuelSubsystem.stop();
                    }
                )
            );

        joystick.y()
            .whileTrue(fuelSubsystem.spinUp().withTimeout(0.5))
            .onFalse(
                Commands.run(
                    () -> {
                        fuelSubsystem.stop();
                    }
                )
            );

        joystick.rightBumper().onTrue(fuelSubsystem.stop());
    }
} 
