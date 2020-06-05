package tests;


import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

public class CreateTest extends CommandTest 
{	
	@Test
	public void test() 
	{
		String pathToTemplates = reader.getPathToAssets() + "/templates/";		
		File folder = new File(pathToTemplates);
		File[] listOfFiles = folder.listFiles();
		
		for(File f:listOfFiles)
		{
			mainWindow.setTemplate(f.getName().split("-")[0]);
			controller.enact("create");
			String templateContents = reader.readFileAsString(pathToTemplates + f.getName());
			String createdContents = controller.getCurrentDocument().getContents();
			assertEquals(templateContents, createdContents);
		}
	}
}