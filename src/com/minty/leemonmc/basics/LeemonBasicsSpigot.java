package com.minty.leemonmc.basics;

import org.bukkit.plugin.java.JavaPlugin;

import com.minty.leemonmc.basics.core.BasicsHandler;

public class LeemonBasicsSpigot extends JavaPlugin {

	private static LeemonBasicsSpigot instance;
	
	@Override
	public void onEnable()
	{
		instance = this;
		BasicsHandler.setup();

		System.out.println("[LeemonBasics (Spigot)] Plugin actif !");
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("[LeemonBasics (Spigot)] Plugin inactif !");
	}
	
	public static LeemonBasicsSpigot getInstance() {
		return instance;
	}
	
}
