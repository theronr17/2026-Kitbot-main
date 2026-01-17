/*package frc.robot.commands.NamedCommands;

import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FuelSubsystem;

public class RegisterCommands {
    public static void register() {
        // Register named commands here

        NamedCommands.registerCommand("Intake",
            Commands.sequence(
                Commands.run(
                    () -> {
                        FuelSubsystem.intakeLauncherRoller.set(0.5);
                        FuelSubsystem.feederRoller.set(0.4);
                    }
                )
            )
        );
    }
} */
