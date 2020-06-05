package controller;

import controller.commands.*;
import model.*;
import view.MainWindow;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller
{
	private HashMap<String, Command> commands = new HashMap<String, Command>();
	private ArrayList<String> commandNames = new ArrayList<String>();
	private CustomFileReader reader = new CustomFileReader();
	
	private Document currentDocument;
	private VersionsManager versionsManager;
	private MainWindow mainWindow;
	
	public Controller(VersionsManager versionsManager)
	{
		this.versionsManager = versionsManager;
		CommandFactory commandFactory = new CommandFactory(this);
		String filePath = reader.getPathToAssets() + "/LatexCommands";
		commandNames = reader.readLineByLine(filePath);
		
		for(String s:commandNames)
			commands.put(s,commandFactory.createCommand(s));
	}	
	
	public void enact(String command) {
		commands.get(command).execute();
	}
	
	public VersionsManager getVersionsManager() {
		return versionsManager;
	}

	public Document getCurrentDocument() {
		return currentDocument;
	}
	
	public void setCurrentDocument(Document currentDocument) {
		this.currentDocument = currentDocument;
	}
	
	public void setWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	public MainWindow getWindow() {
		return mainWindow;
	}
}