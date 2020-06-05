package tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoadEncryptedTest extends CommandTest
{	
	@Test
	public void rot13Test() 
	{
		mainWindow.setTemplate("article");
		controller.enact("create");
		
		String filename = reader.getPathToAssets() + "/tests/LoadRot13Test.tex";
		mainWindow.setFilename(filename);
		controller.enact("rot13Save");
		
		mainWindow.setFilename(filename);
		controller.enact("rot13Load");
		assertEquals(mainWindow.getText(), mainWindow.getText());
	}

	@Test
	public void atbashTest() 
	{
		mainWindow.setTemplate("book");
		controller.enact("create");
		
		String filename = reader.getPathToAssets() + "/tests/LoadAtbashTest.tex";
		mainWindow.setFilename(filename);
		controller.enact("atbashSave");
		
		mainWindow.setFilename(filename);
		controller.enact("atbashLoad");
		assertEquals(mainWindow.getText(),mainWindow.getText());
	}
}