package controller.commands;

import controller.*;

public class Save extends InternalCommand
{
	public Save(Controller controller) {
		super(controller);
	}
	
	@Override
	public void execute() 
	{
		String filename = controller.getWindow().getFilename();
		controller.getCurrentDocument().save(filename);
	}
}