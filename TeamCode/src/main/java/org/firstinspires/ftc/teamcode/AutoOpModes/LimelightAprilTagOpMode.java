package org.firstinspires.ftc.teamcode.AutoOpModes;


import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;


@Autonomous(name="Limelight AprilTag Test")
public class LimelightAprilTagOpMode extends LinearOpMode {
    private Limelight3A limelight;


    @Override
    public void runOpMode() {
        // Retrieve the Limelight from the hardware map
        limelight = hardwareMap.get(Limelight3A.class, "limelight");


        // This switches to the pipeline you configured (e.g., Pipeline 0)
        limelight.pipelineSwitch(5);
        limelight.start();


        telemetry.addData("Status", "Limelight Initialized");
        telemetry.update();


        waitForStart();


        while (opModeIsActive()) {
            // Get the latest results from the camera
            LLResult result = limelight.getLatestResult();

            if (result != null && result.isValid()) {
                // Get AprilTag data from the result
                int tagId = result.getFiducialResults().get(0).getFiducialId();

                double tx = result.getTx();
                double ty = result.getTy();


                // Display data to the Driver Station
                telemetry.addData("Tag ID", tagId);
                telemetry.addData("Target X (degrees)", tx);
                telemetry.addData("Target Y (degrees)", ty);


            } else {
                telemetry.addData("Status", "No AprilTag visible");
            }


            telemetry.update();
        }


        limelight.stop();
    }
}


