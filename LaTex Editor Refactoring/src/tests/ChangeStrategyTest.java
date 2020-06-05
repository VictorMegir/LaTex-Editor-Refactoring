package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.strategies.StableStrategy;
import model.strategies.VolatileStrategy;

public class ChangeStrategyTest extends CommandTest 
{
	@Test
	public void test() 
	{
		mainWindow.setTemplate("empty");
		controller.enact("create");
		
		controller.enact("changeStrategy");
		assertTrue(versionsManager.getStrategy() instanceof StableStrategy);
		
		controller.enact("changeStrategy");
		assertTrue(versionsManager.getStrategy() instanceof VolatileStrategy);
	}
}