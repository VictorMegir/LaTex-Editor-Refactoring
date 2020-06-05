package tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class SaveEncryptedTest extends CommandTest
{	
	@Test
	public void rot13Test() 
	{
		mainWindow.setTemplate("book");
		controller.enact("create");
		
		String filename = reader.getPathToAssets() + "/tests/SaveRot13Test.tex";
		mainWindow.setFilename(filename);
		controller.enact("rot13Save");
		
		String documentContents = controller.getCurrentDocument().getContents() + "\n";
		String fileContents = reader.readFileAsString(filename);
		
		assertEquals(documentContents, fileContents);
	}
	
	@Test
	public void atbashTest() 
	{
		mainWindow.setTemplate("book");
		controller.enact("create");
		
		String filename = reader.getPathToAssets() + "/tests/SaveAtbashTest.tex";
		mainWindow.setFilename(filename);
		controller.enact("atbashSave");
		
		String documentContents = controller.getCurrentDocument().getContents();
		String fileContents = reader.readFileAsString(filename);
		
		assertEquals(documentContents, fileContents);
	}
}