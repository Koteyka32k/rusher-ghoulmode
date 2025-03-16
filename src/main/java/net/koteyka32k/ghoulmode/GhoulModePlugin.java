package net.koteyka32k.ghoulmode;

import net.koteyka32k.ghoulmode.module.GhoulMode;
import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;

/**
 * RusherHack ghoul mode plugin
 *
 * @author Koteyka32k
 * @since March 15, 2025
 */
public class GhoulModePlugin extends Plugin {
	
	@Override
	public void onLoad() {
		final GhoulMode ghoulMode = new GhoulMode();
		RusherHackAPI.getModuleManager().registerFeature(ghoulMode);
	}

	@Override
	public void onUnload() {

	}
	
}