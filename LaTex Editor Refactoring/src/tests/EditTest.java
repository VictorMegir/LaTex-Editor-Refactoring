package tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class EditTest extends CommandTest
{
	@Test
	public void test() 
	{
		mainWindow.setTemplate("empty");
		controller.enact("create");
		
		String testText = "SPONGEBOB";
		mainWindow.setText(testText);
		controller.enact("edit");
		assertEquals(testText,mainWindow.getText());
	}
}