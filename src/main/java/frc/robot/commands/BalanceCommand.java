package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.romi.RomiGyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Drivetrain;

public class BalanceCommand extends PIDCommand{

    private static PIDController controller = new PIDController(
        0.5, 
        5, 
        .01
    );

    public BalanceCommand(RomiGyro gyro, Drivetrain drivetrain) {
        super(
            controller, 
            gyro::getAngleY, // --> measures the angle
            0, 
            value -> {
                drivetrain.arcadeDrive(
                    -value * 0.1, // drive speed
                    -.01 // drive rotation
                );
            },
            drivetrain
        );

        SmartDashboard.putData(controller);
    }

}
