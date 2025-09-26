package org.firstinspires.ftc.teamcode.Systems.Subsystems.PartSubsystems;

import static org.firstinspires.ftc.teamcode.Constants.ConfigConstants.*;

import java.util.Set;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.controllable.MotorGroup;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.hardware.powerable.SetPower;

public class FlywheelSubsystem implements Subsystem {
    public static final FlywheelSubsystem INSTANCE = new FlywheelSubsystem();
    private FlywheelSubsystem() { }

    private final MotorEx flywheel_left = new MotorEx(motor_fwl_config);
    private final MotorEx flywheel_right = new MotorEx(motor_fwr_config);
    private final MotorGroup flywheel_motors = new MotorGroup(flywheel_left, flywheel_right);

    // Might not be necessary
/*
    private final ControlSystem flywheel_control_sys = ControlSystem.builder()
            .posPid(0, 0, 0)
            .elevatorFF(0)
            .build();
*/

    public Command fullAhead = new SetPower(flywheel_motors, 1);
    public Command shutOff = new SetPower(flywheel_motors, 0);
    public Command fullReverse = new SetPower(flywheel_motors, -1);

    public Command setPower(double power) {
        return new SetPower(flywheel_motors, power);
    }
}
