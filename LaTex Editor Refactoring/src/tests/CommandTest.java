package tests;

import controller.Controller;
import model.*;
import view.MainWindow;

public class CommandTest 
{
	protected VersionsManager versionsManager = new VersionsManager();
	protected Controller controller = new Controller(versionsManager);
	protected MainWindow mainWindow = new MainWindow(controller);
	protected CustomFileReader reader = new CustomFileReader();
}
