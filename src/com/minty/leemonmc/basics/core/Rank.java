package com.minty.leemonmc.basics.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.minty.leemonmc.basics.core.queue.QueuePriority;

//public class Rank
//{
//	public String name; // "ADMIN"
//	public String displayNameChat; // "§cAdministrateur"
//	public String displayNameList; // "§cAdmin"
//}

public enum Rank
{
	
    ADMIN(200,"§4§lAdmin§4","§4§lAdmin§4","§4§lAdmin§4","§4§lAdmin§4", "§c", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 10000),
    DEVELOPER(100,"§5Développeur","§5Développeuse","§5Dev","§5Dev", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 10000),
    RESPONSABLE(80, "§6Responsable", "§6Responsable", "§6Responsable", "§6Responsable", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 10000),
    COMMUNITY_MANAGER(70, "§9CM", "§9CM", "§9CM", "§9CM", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 10000),
    SUPER_MOD(50,"§c§lSuper-Mod§c","§c§lSuper-Mod§c","§c§lSuper-Mod§c","§c§lSuper-Mod§c", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 10000),
    MOD(40,"§cModérateur","§cModératrice","§cModérateur","§cModérateur", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 10000),
    HELPER(30,"§dAssistant","§dAssistante","§dAssistant","§dAssistante", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 10000), 
    BUILDER(28,"§3Builder","§3Buildeuse","§3Builder","§3Buildeuse", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 10000),
    STAFF(26,"§2Staff","§2Staff","§7","§7", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 4),
    YOUTUBER(25,"§6Youtubeur","§6Youtubeuse","§6Youtubeur","§6Youtubeuse", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 10000),
    MINI_YOUTUBER(22,"§6Mini-YT","§6Mini-YT","§6Mini-YT","§6Mini-YT", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 10000),
    CUSTOM(20,"§dCustom","§dCustom","§dCustom","§dCustom", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 10000),
    LEMON(15,"§eLemon","§eLemon","§eLemon","§eLemon", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ULTRA_HIGH, 15),
    VIP_PLUS(10,"§bVIP+","§bVIP+","§bVIP+","§bVIP+", "§f", RankPermissions.getAdminPermissions(), QueuePriority.HIGH, 9),
    VIP(2,"§aVIP","§aVIP","§aVIP ","§aVIP ", "§f", RankPermissions.getAdminPermissions(), QueuePriority.ELEVEE, 5),
    PLAYER(0,"§7Joueur","§7Joueuse","§7","§7", "§f", RankPermissions.getAdminPermissions(), QueuePriority.NORMAL, 4);

	private int power;
	private String displayChatMen, displayChatWomen;
	private String displayTabMen, displayTabWomen;
	private String chatColor;
	private List<String> perms;
	private QueuePriority priority;
	private int groupMax;
	
	public static Map<Integer, Rank> ranks = new HashMap<>();
	
	Rank(int power, String displayChatMen, String displayChatWomen, String displayTabMen, String displayTabWomen, String chatColor, List<String> perms, QueuePriority priority, Integer groupMax) {
		this.power = power;
		this.displayChatMen = displayChatMen;
		this.displayChatWomen = displayChatWomen;
		this.displayTabMen = displayTabMen;
		this.displayTabWomen = displayTabWomen;
		this.chatColor = chatColor;
		this.perms = perms;
		this.priority = priority;
		this.groupMax = groupMax;
	}
	
	static {
		for(Rank r : Rank.values())
		{
			ranks.put(r.getPower(), r);
		}
	}
	
	public int getPower() {
		return power;
	}
	
	public int getGroupMax() {
		return groupMax;
	}
	
	public String getdisplayChatMen() {
		return displayChatMen;
	}
	
	public String getdisplayChatWomen() {
		return displayChatWomen;
	}
	
	public String getdisplayTabMen() {
		return displayTabMen;
	}
	
	public String getdisplayTabWomen() {
		return displayTabWomen;
	}
	
	public String getchatColor() {
		return chatColor;
	}
	
	public static Rank powerToRank(int power)
	{
		return ranks.get(power);
	}

	public QueuePriority getPriority() {
		return priority;
	}
	
	public List<String> getPerms() {
		return perms;
	}

	
}
