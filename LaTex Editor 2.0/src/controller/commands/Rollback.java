package controller.commands;

import controller.*;
import model.*;
import model.strategies.Strategy;

import javax.swing.JOptionPane;

public class Rollback extends InternalCommand
{	
	public Rollback(Controller controller) {
		super(controller);
	}
	
	@Override
	public void execute() 
	{
		if(versionsManager.isEnabled() == false) 
		{
			JOptionPane.showMessageDialog(null, "Version Tracking is disbled!", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		Strategy strategy = versionsManager.getStrategy();
		Document doc = strategy.getVersion();
		
		if(doc == null) 
		{
			JOptionPane.showMessageDialog(null, "No version available!", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		strategy.removeVersion();
		controller.setCurrentDocument(doc);
		controller.getWindow().setText(doc.getContents());
	}
}