package com.minty.leemonmc.basics.core;

import com.google.gson.Gson;

public class Server {
	
	private String name, RAM;
	private int ID, maxPlayers, port, playingPlayers;
	private ServerType serverType;
	private ServerGroup serverGroup;
	private GameState gameState;
	private static Gson gson = new Gson();
	
	public Server(String name, GameState state, String rAM, int iD, int _playingPlayers,
			int maxPlayers, int port, ServerType serverType,
			ServerGroup serverGroup) {
		this.name = name;
		this.gameState = state;
		RAM = rAM;
		ID = iD;
		this.playingPlayers = _playingPlayers;
		this.maxPlayers = maxPlayers;
		this.port = port;
		this.serverType = serverType;
		this.serverGroup = serverGroup;
	}

	public Server() {
		
	}
	
	public void save()
	{
		BasicsHandler.getJedis().set("SERVER:" + getName(), serialize(this));
	}

	public boolean isFull() {
		if(getPlayingPlayers() >= getMaxPlayers())
		{
			return true;
		} else {
			return false;
		}
	}
	
	public String getRAM() {
		return RAM;
	}

	public void setPlayingPlayers(int playingPlayers) {
		this.playingPlayers = playingPlayers;
		save();
	}
	
	public int getAvailableSpace() {
		return getMaxPlayers() - getPlayingPlayers();
	}
	
	public int getPlayingPlayers() {
		return playingPlayers;
	}
	
	public void setRAM(String rAM) {
		RAM = rAM;
		save();
	}

	public GameState getGameState() {
		return gameState;
	}
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
		save();
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public Server setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
		save();
		return this;
	}

	public int getPort() {
		return port;
	}

	public Server setPort(int port) {
		this.port = port;
		save();
		return this;
	}

	public ServerType getServerType() {
		save();
		return serverType;
	}

	public Server setServerType(ServerType serverType) {
		this.serverType = serverType;
		save();
		return this;
	}

	public ServerGroup getServerGroup() {
		return serverGroup;
	}

	public Server setServerGroup(ServerGroup serverGroup) {
		this.serverGroup = serverGroup;
		save();
		return this;
	}

	public String getName() {
		return name;
	}

	public Server setName(String name) {
		this.name = name;
		save();
		return this;
	}

	public int getID() {
		return ID;
	}

	public Server setID(int iD) {
		ID = iD;
		save();
		return this;
	}
	
	private static String serialize(Server server) { 
		return gson.toJson(server); 
	}

	private static Server deserialize(String serverData) { 
		return (Server)gson.fromJson(serverData, Server.class);
	}
	
}
