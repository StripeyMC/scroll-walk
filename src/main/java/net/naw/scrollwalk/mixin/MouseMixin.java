package net.naw.scrollwalk.mixin;

import net.naw.scrollwalk.ModifierKeys;
import net.naw.scrollwalk.ScrollWalk;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Mixin into the Mouse class to intercept scroll input
@Mixin(MouseHandler.class)
public class MouseMixin {
    // Detects scroll wheel movement
    @Inject(method = "onScroll", at = @At("HEAD"), cancellable = true)
    private void onMouseScroll(long handle, double xoffset, double yoffset, CallbackInfo ci) {

        // 1. Check if the mod is disabled in config
        if (ScrollWalk.config == null || !ScrollWalk.config.modEnabled) {
            // Reset to default speed if disabled
            if (ScrollWalk.currentSpeed != 0.1) {
                ScrollWalk.currentSpeed = 0.1;
            }
            return;
        }

        // 2. Check if the chosen modifier key (Alt by default) is held down
        boolean isModifierDown = ModifierKeys.isHeld(ScrollWalk.config.modifierKey);

        // Only process scroll if the modifier key is being held
        if (isModifierDown) {
            double step = ScrollWalk.config.scrollStep;
            double max = ScrollWalk.config.maxSpeed;
            double min = ScrollWalk.config.minSpeed;

            // Increase speed on scroll up, decrease on scroll down
            if (yoffset > 0) {
                ScrollWalk.currentSpeed += step;
            } else if (yoffset < 0) {
                ScrollWalk.currentSpeed -= step;
            }

            // Keep the math clean by rounding to 2 decimal places to avoid floating point errors
            ScrollWalk.currentSpeed = Math.round(ScrollWalk.currentSpeed * 100.0) / 100.0;

            // Clamp the speed to ensure it stays within the defined config limits
            if (ScrollWalk.currentSpeed > max) ScrollWalk.currentSpeed = max;
            if (ScrollWalk.currentSpeed < min) ScrollWalk.currentSpeed = min;

            // Cancel the scroll event so the inventory doesn't scroll while changing speed
            ci.cancel();
        }
    }
}
