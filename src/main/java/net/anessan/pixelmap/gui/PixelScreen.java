package net.anessan.pixelmap.gui;

import net.anessan.pixelmap.core.Component;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;

public class PixelScreen extends Component {

    public PixelScreen prepareToOpen() {
        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));

        return this;
    }

}
