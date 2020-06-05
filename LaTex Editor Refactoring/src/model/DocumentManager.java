package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class DocumentManager
{
	private HashMap<String, Document> templates = new HashMap<String, Document>();
	private ArrayList<String> templateNames = new ArrayList<String>();
	private CustomFileReader reader =  new CustomFileReader();
	
	public DocumentManager()
	{
		templateNames = reader.readLineByLine(reader.getPathToAssets() + "/TemplateNames");
		for(String s:templateNames)
		{
			Document prototype = new Document();
			prototype.setContents(getContents(s));
			templates.put(s, prototype);
		}
	}
	
	public String getContents(String template)
	{
		String pathToTemplates = reader.getPathToAssets() + "/templates/";		
		File folder = new File(pathToTemplates);
		File[] listOfFiles = folder.listFiles();
		
		for(File f:listOfFiles)
		{	
			if(f.getName().split("-")[0].equals(template))
				return reader.readFileAsString(pathToTemplates + f.getName());
		}
		return "";
	}
	
	public Document createDocument(String template) {
		return templates.get(template).clone();
	}	
}
