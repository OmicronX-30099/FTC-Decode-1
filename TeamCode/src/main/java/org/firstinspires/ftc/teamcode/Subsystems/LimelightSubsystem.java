package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.hardware.limelightvision.Limelight3A;

import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.ftc.ActiveOpMode;

public class LimelightSubsystem implements Subsystem {
    public static final LimelightSubsystem INSTANCE = new LimelightSubsystem()
    private LimelightSubsystem() { }

    public Limelight3A limelight;

    @Override
    public void initialize() {
        limelight = ActiveOpMode.hardwareMap
    }
}
