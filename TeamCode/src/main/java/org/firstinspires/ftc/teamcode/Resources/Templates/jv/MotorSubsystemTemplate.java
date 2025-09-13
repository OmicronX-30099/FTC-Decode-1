package org.firstinspires.ftc.teamcode.Resources.Templates.jv;

import androidx.annotation.NonNull;

import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.control.controllers.PIDFController;
import com.rowanmcalpin.nextftc.core.control.controllers.feedforward.StaticFeedforward;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.HoldPosition;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.RunToPosition;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.SetPower;

public class MotorSubsystemTemplate extends Subsystem {

    public static final MotorSubsystemTemplate INSTANCE = new MotorSubsystemTemplate();
    private MotorSubsystemTemplate() {}

    public static MotorEx sample_motor;
    public static PIDFController sample_controller = new PIDFController(0, 0, 0, new StaticFeedforward(0));

    public static final double SAMPLE_POSITION = 0;

    // Default command to hold current position
    @NonNull
    @Override
    public Command getDefaultCommand() {
        return new HoldPosition(sample_motor, sample_controller, this);
    }

    // Command that inputs a power and sets the motor to that power
    public Command set_power(float power) {
        return new SetPower(sample_motor, power, this);
    }

    // Command that sets the motor to a certain position
    public Command run_to_pos() {
        return new RunToPosition(sample_motor, SAMPLE_POSITION, sample_controller, this);
    }

    @Override
    public void initialize() {
        // insert config name for motor
        sample_motor = new MotorEx("*name*");
    }
}