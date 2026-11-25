package net.naw.scrollwalk;

import com.mojang.blaze3d.platform.InputConstants;

// Checks whether the chosen modifier key (Alt, Control or Shift) is physically held down.
// Minecraft 26.3 replaced GLFW with SDL, so keys are SDL scancodes:
// left/right Control = 224/228, Shift = 225/229, Alt = 226/230.
public final class ModifierKeys {
    private ModifierKeys() {}

    public static boolean isHeld(ModConfig.ModifierKey key) {
        int left;
        int right;
        switch (key) {
            case CONTROL:
                left = 224;
                right = 228;
                break;
            case SHIFT:
                left = 225;
                right = 229;
                break;
            default:
                left = 226;
                right = 230;
                break;
        }
        return InputConstants.isKeyDown(left) || InputConstants.isKeyDown(right);
    }
}
