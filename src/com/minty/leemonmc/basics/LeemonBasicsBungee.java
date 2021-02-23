package com.minty.leemonmc.basics;

import com.minty.leemonmc.basics.core.BasicsHandler;

import net.md_5.bungee.api.plugin.Plugin;

public class LeemonBasicsBungee extends Plugin
{

	private static LeemonBasicsBungee instance;
	
	@Override
	public void onEnable()
	{
		instance = this;
		BasicsHandler.setup();

		System.out.println("[LeemonBasics (Bungee)] Plugin actif !");
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("[LeemonBasics (Bungee)] Plugin inactif !");
	}
	
	public static LeemonBasicsBungee getInstance() {
		return instance;
	}
	
}
