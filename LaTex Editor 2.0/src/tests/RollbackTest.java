package tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class RollbackTest extends CommandTest
{	
	@Test
	public void test() 
	{
		mainWindow.setTemplate("article");
		controller.enact("create");
		controller.enact("enableVersions");
		
		String original = "DORA THE EXPLORER";
		mainWindow.setText(original);
		controller.enact("edit");
		
		String edited = "SCOOBY DOO";
		mainWindow.setText(edited);
		controller.enact("edit");
		
		controller.enact("rollback");
		assertEquals(original, mainWindow.getText());
	}
}