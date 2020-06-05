package controller.commands;

import controller.Controller;
import model.*;

public class InternalCommand implements Command
{

	protected Controller controller;
	protected VersionsManager versionsManager;
	protected CustomFileReader reader = new CustomFileReader();
	
	public InternalCommand(Controller controller) 
	{
		this.controller = controller;		
		this.versionsManager = controller.getVersionsManager();
	}
	
	@Override
	public void execute() {
		
	}
}