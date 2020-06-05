package controller.commands;

import controller.*;
import model.*;

public class Edit extends InternalCommand 
{	
	public Edit(Controller controller) {
		super(controller);
	}

	@Override
	public void execute()
	{
		Document currentDocument = controller.getCurrentDocument();
		String editedText = controller.getWindow().getText();
		if(versionsManager.isEnabled())
		{
			versionsManager.getStrategy().putVersion(currentDocument);
			currentDocument.changeVersion();
		}
		currentDocument.setContents(editedText);
	}
}