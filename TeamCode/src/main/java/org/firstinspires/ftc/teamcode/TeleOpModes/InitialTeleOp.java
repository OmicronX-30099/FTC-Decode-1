package org.firstinspires.ftc.teamcode.TeleOpModes;

import static org.firstinspires.ftc.teamcode.Constants.ConfigConstants.*;

import org.firstinspires.ftc.teamcode.Constants.ConfigConstants;
import org.firstinspires.ftc.teamcode.Systems.Subsystems.PartSubsystems.FlywheelSubsystem;

import dev.nextftc.bindings.BindingManager;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.conditionals.IfElseCommand;
import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.core.components.SubsystemComponent;
import dev.nextftc.ftc.Gamepads;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.ftc.components.BulkReadComponent;
import dev.nextftc.hardware.driving.MecanumDriverControlled;
import dev.nextftc.hardware.impl.MotorEx;

public class InitialTeleOp extends NextFTCOpMode {
    public InitialTeleOp() {
        addComponents(
                new SubsystemComponent(FlywheelSubsystem.INSTANCE),
                BulkReadComponent.INSTANCE,
                BindingsComponent.INSTANCE
        );
    }
    private final MotorEx front_left_motor = new MotorEx(motor_fl_config).brakeMode().reversed();
    private final MotorEx front_right_motor = new MotorEx(motor_fr_config).brakeMode();
    private final MotorEx back_left_motor = new MotorEx(motor_bl_config).brakeMode().reversed();
    private final MotorEx back_right_motor = new MotorEx(motor_br_config).brakeMode();

    @Override
    public void onStartButtonPressed() {
        Command drivetrain = new MecanumDriverControlled(
                front_left_motor,
                front_right_motor,
                back_left_motor,
                back_right_motor,
                Gamepads.gamepad1().leftStickY(),
                Gamepads.gamepad1().leftStickX(),
                Gamepads.gamepad1().rightStickX()
        );
        drivetrain.schedule();
    }

    @Override
    public void onUpdate() {
        BindingManager.update();
    }

    @Override
    public void onStop() {
        BindingManager.reset();
    }
}