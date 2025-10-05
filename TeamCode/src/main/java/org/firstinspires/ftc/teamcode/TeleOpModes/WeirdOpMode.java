package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.CommandManager;
import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.ftc.Gamepads;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.ftc.components.BulkReadComponent;
import dev.nextftc.hardware.controllable.MotorGroup;
import dev.nextftc.hardware.driving.MecanumDriverControlled;
import dev.nextftc.hardware.impl.MotorEx;

@TeleOp(name = "Drivetrain OpMode",group="TestOpModes")
public class DrivetrainOpMode extends NextFTCOpMode {
    public DrivetrainOpMode() {
        addComponents(
                BulkReadComponent.INSTANCE,
                BindingsComponent.INSTANCE
        );
    }

    // change the names and directions to suit your robot
    private final MotorEx frontLeftMotor = new MotorEx("fl").reversed();
    private final MotorEx frontRightMotor = new MotorEx("fr");
    private final MotorEx backLeftMotor = new MotorEx("bl").reversed();
    private final MotorEx backRightMotor = new MotorEx("br");
    private final MotorEx fwl = new MotorEx("fwl").reversed();
    private final MotorEx fwr = new MotorEx("fwr");
    private final MotorGroup fwmotors = new MotorGroup(fwl,fwr);

    @Override
    public void onStartButtonPressed() {
        Command driverControlled = drivetrain(1).named("normalDrivetrain");
        driverControlled.schedule();

        Gamepads.gamepad1().rightTrigger().greaterThan(0.05)
                .whenTrue(() -> fwmotors.setPower(Gamepads.gamepad1().rightTrigger().get()))
                .whenBecomesFalse(() -> fwmotors.setPower(0));
        Gamepads.gamepad1().leftBumper().whenBecomesTrue(
                () -> drivetrain(0.5).named("slowDrivetrain").schedule()
        );
        Gamepads.gamepad1().rightBumper().whenBecomesTrue(
                () -> drivetrain(1).named("normalDrivetrain").schedule()
        );
    }
    public Command drivetrain(double scalar) {
        return new MecanumDriverControlled(
                frontLeftMotor,
                frontRightMotor,
                backLeftMotor,
                backRightMotor,
                () -> -1 * scalar * Gamepads.gamepad1().leftStickY().get(),
                () -> scalar * Gamepads.gamepad1().leftStickX().get(),
                () -> scalar * Gamepads.gamepad1().rightStickX().get()
        );
    }
}
