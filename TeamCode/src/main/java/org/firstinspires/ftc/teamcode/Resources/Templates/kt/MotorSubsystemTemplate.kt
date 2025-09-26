/*package org.firstinspires.ftc.teamcode.Resources.Templates.kt

import com.rowanmcalpin.nextftc.core.Subsystem
import com.rowanmcalpin.nextftc.core.command.Command
import com.rowanmcalpin.nextftc.core.control.controllers.PIDFController
import com.rowanmcalpin.nextftc.core.control.controllers.feedforward.StaticFeedforward
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.HoldPosition
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.RunToPosition
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.SetPower

object MotorSubsystemTemplate: Subsystem() {
    lateinit var sample_motor: MotorEx

    val sample_position = 0.0

    val sample_controller = PIDFController(0.0, 0.0,0.0, StaticFeedforward(0.0))

    fun set_power(power: Double): Command {
        return SetPower(sample_motor, power, this)
    }

    val run_to_pos: Command
        get() = RunToPosition(sample_motor, sample_position, sample_controller, this)

    override val defaultCommand: Command
        get() = HoldPosition(sample_motor, sample_controller, this)

    override fun initialize() {
        // replace with config name
        sample_motor = MotorEx("*name*")
    }
}
*/