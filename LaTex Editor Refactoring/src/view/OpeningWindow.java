package view;

import controller.*;
import model.*;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpeningWindow
{
	private JFrame frame;
	private Controller controller;
	
	public static void main(String[] args)
	{	
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					OpeningWindow window = new OpeningWindow();
					window.initialize();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public OpeningWindow()
	{
		VersionsManager versionsManager = new VersionsManager();
		controller = new Controller(versionsManager);
	}

	public void initialize()
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("LaTex Editor");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 290);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCreateNewDocument = new JButton("Create New Document");
		btnCreateNewDocument.setBounds(80, 25, 280, 35);
		frame.getContentPane().add(btnCreateNewDocument);
		btnCreateNewDocument.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				ChooseTemplate chooseTemplate = new ChooseTemplate(controller, "opening");
				chooseTemplate.initialize();
				frame.dispose();
			}
		});
		
		JButton btnOpenExistingDocument = new JButton("Open Existing Document");
		btnOpenExistingDocument.setBounds(80, 90, 280, 35);
		frame.getContentPane().add(btnOpenExistingDocument);
		btnOpenExistingDocument.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Load latex File");
            	chooser.setFileFilter(new FileNameExtensionFilter("TEX File","tex"));
				chooser.showOpenDialog(null);
				String filename;
				MainWindow mainWindow = new MainWindow(controller);	
				try {
					filename = chooser.getSelectedFile().toString();
				}
				catch(NullPointerException n) {
					return;
				}				
				controller.getWindow().setFilename(filename);
				controller.enact("load");
				mainWindow.initialize();
			}
		});	
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(150, 170, 140, 25);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}