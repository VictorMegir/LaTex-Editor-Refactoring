package controller.commands;

import controller.Controller;
import model.Document;
import model.encryptions.Encryption;

public class LoadEncrypted extends Load
{
	private Encryption cipher;
	
	public LoadEncrypted(Controller controller, Encryption cipher)
	{
		super(controller);
		this.cipher = cipher;
	}

	public void execute() 
	{
		fetchContentsFromFile();
		Document currentDocument = new Document();
		controller.setCurrentDocument(currentDocument);
		
		String plaintext = cipher.decrypt(fileContents);
		currentDocument.setContents(plaintext);
		configTemplate(plaintext);
	}
}