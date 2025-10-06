package org.firstinspires.ftc.teamcode.Systems;

// Static Constants
import static org.firstinspires.ftc.teamcode.Constants.PositionConstants.p;
import static org.firstinspires.ftc.teamcode.Constants.PositionConstants.i;
import static org.firstinspires.ftc.teamcode.Constants.PositionConstants.d;

import static org.firstinspires.ftc.teamcode.Constants.ConfigConstants.motor_turret_config;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.controllable.RunToPosition;
import dev.nextftc.hardware.impl.MotorEx;

public class TurretSubsystem implements Subsystem {
    public static TurretSubsystem INSTANCE = new TurretSubsystem();
    private TurretSubsystem() { }

    private MotorEx turretMotor = new MotorEx("tur");
    public static ControlSystem turretControl = ControlSystem.builder()
            .posPid(p,i,d)
            .build()
    ;

    @Override
    public void periodic() {
        turretMotor.setPower(turretControl.calculate(turretMotor.getState()));
    }
}
