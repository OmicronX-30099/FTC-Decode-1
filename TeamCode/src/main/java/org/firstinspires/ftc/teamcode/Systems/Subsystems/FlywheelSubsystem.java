package org.firstinspires.ftc.teamcode.Systems.Subsystems;

import androidx.annotation.NonNull;

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

    private MotorEx flywheel_motor_left = new MotorEx("fw_l");
    private MotorEx flywheel_motor_right = new MotorEx("fw_r").reversed();

    private MotorGroup flywheel_motors = new MotorGroup(flywheel_motor_left,flywheel_motor_right);

    private ControlSystem flywheel_control_system = ControlSystem.builder()
            .velPid(0,0,0)
            //.basicFF()
            // ff might not be necessary
            .build();

    public Command full_speed = new RunToVelocity(flywheel_control_system, 100).requires(this);
    public Command full_reverse = new RunToVelocity(flywheel_control_system, -100).requires(this);

    public Command set_power(double power) {
        return new SetPower(flywheel_motors,power);
    }

    @NonNull
    @Override
    public Command getDefaultCommand() {

    }
}
/*
* I teach u how to do nextftc stuff ok
* I create new file called TestSubsystem in Subsystems directory
* lol, no
* The other one, the fat thingy where the motors plug in is where code is
* The fat android thingy just tells it which code file to run and when to run
how dou upload code
* U conect to the control hub and click play button at top of android studio
ok
* go to other directory, Systems/Subsystems/TestSubsystem
i dont see that
* Teamcode/java/org/firstinspires/ftc/teamcode/Systems/Subsystems/
* acc wtvr, jst follow me
* */