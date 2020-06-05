package tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoadTest extends CommandTest
{
	
	@Test
	public void test() 
	{
		mainWindow.setTemplate("report");
		controller.enact("create");
		
		String filename = reader.getPathToAssets() + "/tests/LoadTest.tex";
		mainWindow.setFilename(filename);
		controller.enact("save");
		
		mainWindow.setFilename(filename);
		controller.enact("load");
		assertEquals(mainWindow.getText(), mainWindow.getText());
	}
}