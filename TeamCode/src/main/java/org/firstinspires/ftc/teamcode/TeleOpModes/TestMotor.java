package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name="Motor Test",group = "TestOpModes")
public class TestMotor extends OpMode {
    public DcMotorEx Motor;

    @Override
    public void init() {
        Motor = hardwareMap.get(DcMotorEx.class, "Motor");
        Motor.setPower(1);
    }
    @Override
    public void loop() {

    }
}
