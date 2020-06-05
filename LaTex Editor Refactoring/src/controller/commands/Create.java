package controller.commands;

import controller.Controller;
import model.*;

public class Create extends InternalCommand 
{
	private DocumentManager documentManager;
	
	public Create(DocumentManager documentManager, Controller controller)
	{
		super(controller);
		this.documentManager = documentManager;
	}

	@Override
	public void execute() 
	{
		String type = controller.getWindow().getTemplate();
		Document document = documentManager.createDocument(type);
		controller.setCurrentDocument(document);
	}
}