package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import controller.*;
import model.*;

public class Load extends InternalCommand
{
	private Scanner scanner;
	protected String fileContents;
	
	public Load(Controller controller){
		super(controller);
	}

	public void configTemplate(String fileContents)
	{
		fileContents = fileContents.trim();
		String template = "empty";
		
		CustomFileReader reader = new CustomFileReader();
		ArrayList<String> startOfTemplates = new ArrayList<String>();
		startOfTemplates = reader.readLineByLine(reader.getPathToAssets() + "/TemplateStart");
		
		for(String s:startOfTemplates)
		{
			if(fileContents.startsWith(s)) {
				template = s.split("}")[0].split(Pattern.quote("{"))[1];
			}
		}
		controller.getWindow().setTemplate(template);
	}
	
	public void fetchContentsFromFile()
	{
		fileContents = "";
		String filename = controller.getWindow().getFilename();
		try 
		{
			scanner = new Scanner(new FileInputStream(filename));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute()
	{
		fetchContentsFromFile();
		Document currentDocument = new Document();
		controller.setCurrentDocument(currentDocument);
		
		currentDocument.setContents(fileContents);
		configTemplate(fileContents);
	}
}