package controller.commands;

import controller.*;
import model.*;

import java.io.File;
import javax.swing.JEditorPane;

public class AddLatex extends InternalCommand
{
	private String contents;
	
	public AddLatex(Controller controller){
		super(controller);
	}

	public void editContents(String type)
	{
		JEditorPane editorPane = controller.getWindow().getEditorPane();
		contents = controller.getWindow().getText();
		
		String before = contents.substring(0, editorPane.getCaretPosition());
		String after = contents.substring(editorPane.getCaretPosition());
		
		String pathToCommands = reader.getPathToAssets() + "/commands/";		
		File folder = new File(pathToCommands);
		File[] listOfFiles = folder.listFiles();
		
		for(File f:listOfFiles)
		{
			if(f.getName().equals(type))
			{
				String commandContents = reader.readFileAsString(pathToCommands + f.getName());
				contents = before + commandContents + after;
			}
		}
		controller.getWindow().setText(contents);
		editorPane.setText(contents);
	}
	
	@Override
	public void execute()
	{
		Document currentDocument = controller.getCurrentDocument();
		String editedText = controller.getWindow().getText();
		editContents(controller.getWindow().getLatexCommandType());
		
		if(versionsManager.isEnabled())
		{
			versionsManager.getStrategy().putVersion(currentDocument);
			currentDocument.changeVersion();
		}
		currentDocument.setContents(editedText);
	}
}