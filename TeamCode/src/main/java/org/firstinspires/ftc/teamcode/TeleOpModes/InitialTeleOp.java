package org.firstinspires.ftc.teamcode.TeleOpModes;

import static org.firstinspires.ftc.teamcode.Constants.ConfigConstants.*;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.bindings.BindingManager;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.core.components.SubsystemComponent;
import dev.nextftc.ftc.Gamepads;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.ftc.components.BulkReadComponent;
import dev.nextftc.hardware.driving.MecanumDriverControlled;
import dev.nextftc.hardware.impl.MotorEx;

@TeleOp(name = "First Version Teleop", group = "")
public class InitialTeleOp extends NextFTCOpMode {
    public InitialTeleOp() {
        addComponents(
                new SubsystemComponent(RobotSystem.INSTANCE),
                BulkReadComponent.INSTANCE,
                BindingsComponent.INSTANCE
        );
    }

    private static final MotorEx motor_fl = new MotorEx(motor_fl_config);
    private static final MotorEx motor_fr = new MotorEx(motor_fr_config);
    private static final MotorEx motor_bl = new MotorEx(motor_bl_config);
    private static final MotorEx motor_br = new MotorEx(motor_br_config);

    private static Command drivetrain;

    @Override
    public void onStartButtonPressed() {
        drivetrain = new MecanumDriverControlled(
                motor_fl,
                motor_fr,
                motor_bl,
                motor_br,
                Gamepads.gamepad1().leftStickY(),
                Gamepads.gamepad1().leftStickX(),
                Gamepads.gamepad1().rightStickX()
        );
        drivetrain.schedule();
    }

    @Override
    public void onInit() {

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