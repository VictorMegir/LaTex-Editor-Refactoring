package controller.commands;

import controller.Controller;
import model.encryptions.Encryption;

public class SaveEncrypted extends Save
{
	private Encryption cipher;
	
	public SaveEncrypted(Controller controller, Encryption cipher) 
	{
		super(controller);
		this.cipher = cipher;
	}
	
	public void execute()
	{
		String plaintext = controller.getCurrentDocument().getContents();
		String ciphertext = cipher.encrypt(plaintext);
		controller.getCurrentDocument().setContents(ciphertext);
		super.execute();
	}
}