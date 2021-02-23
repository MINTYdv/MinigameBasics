package com.minty.leemonmc.basics.core.queue;

public enum QueuePriority {

	NORMAL("Normale", 7),
	ELEVEE("Élevée", 5),
	HIGH("Haute", 3),
	ULTRA_HIGH("Ultra-Haute", 1);
	
	private String name;
	private Integer waitTime;
	
	QueuePriority(String _name, Integer _waitTime) {
		name = _name;
		waitTime = _waitTime;
	}
	
	public Integer getWaitTime() {
		return waitTime;
	}
	
	public String getName() {
		return name;
	}
	
}
