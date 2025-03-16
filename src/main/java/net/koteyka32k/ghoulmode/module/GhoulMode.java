package net.koteyka32k.ghoulmode.module;

import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.network.protocol.game.ServerboundClientCommandPacket;
import org.rusherhack.client.api.events.render.EventRender2D;
import org.rusherhack.client.api.feature.module.ModuleCategory;
import org.rusherhack.client.api.feature.module.ToggleableModule;
import org.rusherhack.core.event.subscribe.Subscribe;

/**
 * RusherHack Ghoul Mode module
 * Allows you to stay in loaded chunks
 *
 * @author Koteyka32k
 * @since March 15, 2025
 */

public class GhoulMode extends ToggleableModule {
	private boolean dead = false;

	public GhoulMode() {
		super("GhoulMode", "Stay in loaded chunks after death! Disable module to respawn and note that you cannot interact with the world or load new chunks while \"dead\".", ModuleCategory.WORLD);
	}

	@Override
	public void onDisable() {
		if (dead) {
			mc.getConnection().getConnection().send(new ServerboundClientCommandPacket(ServerboundClientCommandPacket.Action.PERFORM_RESPAWN));
			dead = false;
		}

		super.onDisable();
	}

	@Subscribe
	private void onDeathScreen(EventRender2D event) {
		if (mc.screen instanceof DeathScreen) {
			mc.screen = null;
			mc.player.setHealth(20f);
			dead = true;
		}
	}
}