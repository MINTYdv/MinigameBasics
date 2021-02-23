package com.minty.leemonmc.basics.core.cache;

import com.minty.leemonmc.basics.core.Rank;
import com.minty.leemonmc.core.CoreMain;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Account {
	
	private String UUID;
	private int pulpes = 0;
	private int lemons = 0;
	private Map<String, String> settings = new HashMap<>();
	private int rank = 0;
	private boolean modEnabled = false;
	private String lastUsername;
	private String firstLog;
	
	private String nickName;
	private int nickRank;
	
	public Account(String UUID) {
		this.UUID = UUID;
	}
	
	private void save()
	{
		try {
			CoreMain.getInstance().getAccountManager().saveAccount(this);
			CoreMain.getInstance().getSql().saveData(Bukkit.getPlayer(java.util.UUID.fromString(UUID)));
		} catch(Exception e) {
			// Ignore it <3
		}
	}
	
	public void setSetting(String setting, String value)
	{
		if(getSettings().containsKey(setting))
		{
			getSettings().remove(setting);
		}
		getSettings().put(setting, value);
		CoreMain.getInstance().getAccountManager().saveAccount(this);
	}
	
	public String getSetting(String setting)
	{
		if(getSettings().containsKey(setting))
		{
			return getSettings().get(setting);
		} else {
			return "404";
		}
	}
	
	public String getPrefixAccordingToSettings()
	{
		if(isNicked())
		{
			if(getSetting("global_gender").equalsIgnoreCase("MALE") || getSetting("global_gender").equalsIgnoreCase("NEUTRAL"))
			{
				return getNickedRank().getdisplayChatMen();
			} else
			{
				return getNickedRank().getdisplayChatWomen();
			}
		}
		if(getRank().getPower() == Rank.CUSTOM.getPower())
		{
			if(getSetting("vip_prefix").equalsIgnoreCase("NULL"))
			{
				setSetting("vip_prefix", "&dCustom");
			}
			return getSetting("vip_prefix").replace("&", "§");
		}
		if(getSetting("global_gender").equalsIgnoreCase("MALE") || getSetting("global_gender").equalsIgnoreCase("NEUTRAL"))
		{
			return getRank().getdisplayChatMen();
		} else
		{
			return getRank().getdisplayChatWomen();
		}
	}
	
	public boolean isNicked() {
		if(nickName.equalsIgnoreCase(getLastUsername())) {
			return false;
		}
		return true;
	}
	
	public String getNickedName()
	{
		return nickName;
	}
	
	public Rank getNickedRank()
	{
		return Rank.powerToRank(nickRank);
	}
	
	public void setNickName(String nickName, boolean loading) {
		this.nickName = nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
		save();
	}
	
	public void setNickRank(Rank nickRank, boolean loading) {
		this.nickRank = nickRank.getPower();
	}
	
	public void setNickRank(Rank nickRank) {
		this.nickRank = nickRank.getPower();
		save();
	}
	
	public void setRank(int rank) {
		this.rank = rank;
		save();
		if(isNicked())
		{
			if(getRank() != getNickedRank())
			{
				setNickRank(getRank());
			}
		}
	}
	
	public void setRank(int rank, boolean loading) {
		this.rank = rank;
	}
	
	public void setLastUsername(String lastUsername) {
		this.lastUsername = lastUsername;
		save();
	}
	
	public void setLastUsername(String lastUsername, boolean loading) {
		this.lastUsername = lastUsername;
	}

	public String getFirstLog() {
		return firstLog;
	}

	public String getFirstConnection() {
		return firstLog;
	}
	
	public void setFirstConnection(String firstLog) {
		this.firstLog = firstLog;
		save();
	}
	
	public void setFirstConnection(String firstLog, boolean loading) {
		this.firstLog = firstLog;
	}
	
	public String getLastUsername() {
		return lastUsername;
	}
	
	public void setRank(Rank rank) {
		this.rank = rank.getPower();
		save();
	}
	
	public Rank getRank() {
		return Rank.powerToRank(rank);
	}
	
	public int getPulpes() {
		return pulpes;
	}
	
	public void removeLemons(int amount) {
		lemons -= amount;
		if(getLemons() < 0)
		{
			lemons = 0;
		}
		save();
	}
	
	public void addLemons(int amount) {
		lemons += amount;
		save();
	}
	
	public void removePulpe(int amount) {
		pulpes -= amount;
		if(getPulpes() < 0)
		{
			pulpes = 0;
		}
		save();
	}
	
	public void addPulpe(int amount) {
		pulpes += amount;
		save();
	}
	
	public void setPulpes(int pulpes) {
		this.pulpes = pulpes;
		save();
	}

	public void setPulpes(int pulpes, boolean loading) {
		this.pulpes = pulpes;
	}
	
	public int getLemons() {
		return lemons;
	}

	public void setModEnabled(boolean modEnabled, boolean loading) {
		this.modEnabled = modEnabled;
	}
	
	public void setModEnabled(boolean modEnabled) {
		this.modEnabled = modEnabled;
		save();
	}
	
	public boolean isModEnabled() {
		return modEnabled;
	}
	
	public void setLemons(int lemons, boolean loading) {
		this.lemons = lemons;
	}
	
	public void setLemons(int lemons) {
		this.lemons = lemons;
		save();
	}

	public Map<String, String> getSettings() {
		return settings;
	}

	public String getUUID() {
		return UUID;
	}
}
