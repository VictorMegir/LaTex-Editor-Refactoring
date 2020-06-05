package controller.commands;

import controller.*;

public class EnableVersions extends InternalCommand
{	
	public EnableVersions(Controller controller) {
		super(controller);
	}

	@Override
	public void execute() {
		versionsManager.enable();
	}
}