package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import org.firstinspires.ftc.robotcore.internal.hardware.android.GpioPin;

import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.ftc.ActiveOpMode;

public class LimelightSubsystem implements Subsystem {
    public static final LimelightSubsystem INSTANCE = new LimelightSubsystem();
    private LimelightSubsystem() { }

    public Limelight3A limelight;



    @Override
    public void initialize() {
        limelight = ActiveOpMode.hardwareMap().get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(5);
        limelight.start();


        ActiveOpMode.telemetry().addData("Status", "Limelight Initialized");
        ActiveOpMode.telemetry().update();
    }

    public void getResult() {
        LLResult result = limelight.getLatestResult();

            if (result != null && result.isValid()) {
                // Get AprilTag data from the result
                int tagId = result.getFiducialResults().get(0).getFiducialId();

                double tx = result.getTx();
                double ty = result.getTy();


                // Display data to the Driver Station
                ActiveOpMode.telemetry().addData("Tag ID", tagId);
                ActiveOpMode.telemetry().addData("Target X (degrees)", tx);
                ActiveOpMode.telemetry().addData("Target Y (degrees)", ty);


            } else {
                ActiveOpMode.telemetry().addData("Status", "No AprilTag visible");
            }
        ActiveOpMode.telemetry().update();
    }
}
