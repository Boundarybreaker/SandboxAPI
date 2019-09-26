package org.sandboxpowered.sandbox.api.input;

import com.google.common.annotations.Beta;

@Beta
public interface Gamepad extends InputDevice {

    float getAxis(Stick stick, Axis axis);

    float getTrigger(Trigger trigger);

    boolean isDown(Button buttons);

    boolean areDown(Button... buttons);

    enum Stick {
        LEFT,
        RIGHT
    }

    enum Axis {
        X,
        Y,
    }

    enum Trigger {
        LEFT,
        RIGHT,
    }

    enum Button {
        A,
        B,
        X,
        Y,
        START,
        MENU,
        LEFT_BUMPER,
        RIGHT_BUMPER,
        DPAD_UP,
        DPAD_DOWN,
        DPAD_LEFT,
        DPAD_RIGHT,
        LEFT_STICK,
        RIGHT_STICK
    }
}