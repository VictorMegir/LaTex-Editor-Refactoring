package tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class SaveTest extends CommandTest
{	
	@Test
	public void test() 
	{
		mainWindow.setTemplate("article");
		controller.enact("create");
		
		String savefile = reader.getPathToAssets() + "/tests/SaveTest.tex";
		mainWindow.setFilename(savefile);
		controller.enact("save");
		
		String savedDocumentContents = controller.getCurrentDocument().getContents();
		String savedFileCocuments = reader.readFileAsString(savefile);
		assertEquals(savedDocumentContents, savedFileCocuments);
	}
}