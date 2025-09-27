package org.firstinspires.ftc.teamcode.TeleOpModes;

import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.core.components.SubsystemComponent;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.ftc.components.BulkReadComponent;

public class Test extends NextFTCOpMode {
    public Test() {
        addComponents(
                new SubsystemComponent(),
                BulkReadComponent.INSTANCE,
                BindingsComponent.INSTANCE
        );
    }
    @Override
    public void onStartButtonPressed() {
        // this is where we put our code usually.
        // any code here will run as soon as the start button is pressed
    }
}
/*
so basically tats abt it.
wat do u want me to show u
 */