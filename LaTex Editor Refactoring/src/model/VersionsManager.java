package model;

import model.strategies.*;

public class VersionsManager 
{
	private boolean enabled;
	private Strategy strategy;

	public VersionsManager()
	{
		this.strategy = new VolatileStrategy();
		this.enabled = false;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void enable() {
		enabled = true;
	}

	public void disable() {
		enabled = false;
	}
	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Strategy getStrategy() {
		return strategy;
	}
}