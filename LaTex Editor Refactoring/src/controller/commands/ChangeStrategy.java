package controller.commands;

import controller.*;
import model.strategies.*;

public class ChangeStrategy extends InternalCommand
{
	private Strategy oldStrategy;
	
	public ChangeStrategy(Controller controller)
	{
		super(controller);
		oldStrategy = versionsManager.getStrategy();
	}
	
	public Strategy makeNewStrategy(String strategyType) 
	{
		if(oldStrategy instanceof VolatileStrategy) 
		{
			return new StableStrategy();
		}
		if(oldStrategy instanceof StableStrategy)
		{
			return new VolatileStrategy();
		}
		return oldStrategy;
	}
	
	@Override
	public void execute() 
	{
		versionsManager.enable();
		String strategyType = controller.getWindow().getStrategy();
		Strategy newStrategy = makeNewStrategy(strategyType);

		newStrategy.setEntireHistory(oldStrategy.getEntireHistory());
		oldStrategy = newStrategy;
		versionsManager.setStrategy(newStrategy);
	}
}