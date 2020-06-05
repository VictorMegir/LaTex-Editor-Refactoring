package tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class EnableDisableTest extends CommandTest
{
	@Test
	public void enableTest() 
	{
		controller.enact("enableVersions");
		assertEquals(true,versionsManager.isEnabled());
	}
	
	@Test
	public void disableTest() 
	{
		controller.enact("disableVersions");
		assertEquals(false,versionsManager.isEnabled());
	}
}