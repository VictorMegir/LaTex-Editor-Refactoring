package tests;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

public class AddLatexTest extends CommandTest 
{	
	@Test
	public void test()
	{
		mainWindow.setTemplate("empty");
		controller.enact("create");
		
		String pathToCommands = reader.getPathToAssets() + "/commands/";
		File folder = new File(pathToCommands);
		File[] listOfFiles = folder.listFiles();
		
		for(File f:listOfFiles)
		{
			mainWindow.setText("");
			mainWindow.setLatexCommandType(f.getName());
			controller.enact("addLatex");
			String contents = reader.readFileAsString(pathToCommands + f.getName());
			assertEquals(contents, mainWindow.getText());
		}
	}
}