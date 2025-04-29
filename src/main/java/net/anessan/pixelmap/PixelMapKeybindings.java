package net.anessan.pixelmap;

import net.anessan.pixelmap.gui.PixelScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class PixelMapKeybindings {
    public static final KeyBinding PIXEL_KEYMAPPING = new KeyBinding("key.pixelmap.open", InputUtil.Type.KEYSYM, 77, "key.pixelmap.category");

    public static void init() {
        KeyBindingHelper.registerKeyBinding(PIXEL_KEYMAPPING);
        ClientTickEvents.END_CLIENT_TICK.register(PixelMapKeybindings::onClientTick);
    }

    public static void onClientTick(MinecraftClient client) {
        while (PIXEL_KEYMAPPING.wasPressed()) {
            if (client.currentScreen == null) {
                PixelScreen screen = new PixelScreen();
                screen.init();
                screen.prepareToOpen();
                screen.tick();
                client.setScreen(screen);
            }
        }
    }

}
