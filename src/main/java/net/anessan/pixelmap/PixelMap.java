package net.anessan.pixelmap;

import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PixelMap implements ClientModInitializer {
	public static final String ID = "pixelmap";
	public static final String NAME = "Pixel Map";

	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitializeClient() {
		PixelMapKeybindings.init();
	}
}