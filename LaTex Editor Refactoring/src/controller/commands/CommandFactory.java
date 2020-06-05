package controller.commands;

import controller.*;
import model.*;
import model.encryptions.*;

public class CommandFactory
{
	private DocumentManager documentManager;
	private Controller controller;
	
	public CommandFactory(Controller controller)
	{
		this.controller = controller;
		documentManager = new DocumentManager();
	}

	public Command createCommand(String type)
	{
		if(type.equals("addLatex")) {
			return new AddLatex(controller);
		}
		if(type.equals("changeStrategy")) {
			return new ChangeStrategy(controller);
		}
		if(type.equals("edit")) {
			return new Edit(controller);
		}
		if(type.equals("create")) {
			return new Create(documentManager, controller);
		}
		if(type.equals("disableVersions")) {
			return new DisableVersions(controller);
		}
		if(type.equals("enableVersions")) {
			return new EnableVersions(controller);
		}
		if(type.equals("load")) {
			return new Load(controller);
		}
		if(type.equals("rollback")) {
			return new Rollback(controller);
		}
		if(type.equals("save")) {
			return new Save(controller);
		}
		if(type.equals("rot13Save")) {
			return new SaveEncrypted(controller,new Rot13());
		}
		if(type.equals("atbashSave")) {
			return new SaveEncrypted(controller,new Atbash());
		}
		if(type.equals("rot13Load")) {
			return new LoadEncrypted(controller,new Rot13());
		}
		if(type.equals("atbashLoad")) {
			return new LoadEncrypted(controller,new Atbash());
		}
		return null;
	}
}