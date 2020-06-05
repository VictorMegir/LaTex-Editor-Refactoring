package controller.commands;

import controller.*;

public class DisableVersions extends InternalCommand
{
	public DisableVersions(Controller controller){
		super(controller);
	}

	@Override
	public void execute() {
		versionsManager.disable();
	}
}