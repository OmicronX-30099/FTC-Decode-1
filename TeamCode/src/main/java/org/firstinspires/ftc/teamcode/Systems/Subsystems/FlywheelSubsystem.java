package org.firstinspires.ftc.teamcode.Systems.Subsystems;


import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.controllable.MotorGroup;
import dev.nextftc.hardware.controllable.RunToVelocity;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.hardware.powerable.SetPower;

public class FlywheelSubsystem implements Subsystem {
    public static final FlywheelSubsystem INSTANCE = new FlywheelSubsystem();
    private FlywheelSubsystem() { }

    private final MotorEx flywheel_motor_left = new MotorEx("fw_l");
    private final MotorEx flywheel_motor_right = new MotorEx("fw_r").reversed();

    private final MotorGroup flywheel_motors = new MotorGroup(flywheel_motor_left,flywheel_motor_right);

    private final ControlSystem flywheel_control_system = ControlSystem.builder()
            .velPid(0,0,0)
            //.basicFF()
            // ff might not be necessary
            .build();

    public Command full_speed = new RunToVelocity(flywheel_control_system, 100).requires(this);
    public Command full_reverse = new RunToVelocity(flywheel_control_system, -100).requires(this);

    public Command set_power(double power) {
        return new SetPower(flywheel_motors,power);
    }

    @Override
    public void periodic() {
        flywheel_motors.setPower(flywheel_control_system.calculate(flywheel_motors.getState()));
    }
}