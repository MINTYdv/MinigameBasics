package com.minty.leemonmc.basics.core;

import java.util.ArrayList;
import java.util.List;

public class RankPermissions {

	public RankPermissions() {
		
	}
	
	public static List<String> getAdminPermissions() {
		List<String> perms = new ArrayList<String>();
		perms.add("*");
		return perms;
	}
	
	public static List<String> getPlayerPermissions() {
		List<String> perms = new ArrayList<String>();
		perms.add("help.use");
		return perms;
	}

}
