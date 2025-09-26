package org.firstinspires.ftc.teamcode.TeleOpModes;

import org.firstinspires.ftc.teamcode.Subsystems.Test.LimelightSubsystem;

import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.core.components.SubsystemComponent;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.ftc.components.BulkReadComponent;

public class LimelightTeleOp extends NextFTCOpMode {
    public LimelightTeleOp() {
        addComponents(
            new SubsystemComponent(LimelightSubsystem.INSTANCE),
                BulkReadComponent.INSTANCE,
                BindingsComponent.INSTANCE
        );
    }

    @Override
    public void onUpdate() {
        LimelightSubsystem.INSTANCE.getResult();
    }
}