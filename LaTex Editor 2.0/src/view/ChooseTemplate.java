package view;

import controller.Controller;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseTemplate
{
	private JFrame frame;
	private String previous;
	private Controller controller;
	private MainWindow mainWindow;
	
	public ChooseTemplate(Controller controller, String previous)
	{
		this.previous = previous;
		this.controller = controller;
		mainWindow = new MainWindow(controller);
	}

	private void deselectRadioButtons(JRadioButton radioButton1, JRadioButton radioButton2, JRadioButton radioButton3,JRadioButton radioButton4)
	{
		if(radioButton1.isSelected())
		{
			radioButton2.setSelected(false);
			radioButton3.setSelected(false);
			radioButton4.setSelected(false);
		}
	}
	
	public void initialize()
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Choose Template");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton book = new JRadioButton("Book");
		JRadioButton article = new JRadioButton("Article");
		JRadioButton report = new JRadioButton("Report");
		JRadioButton letter = new JRadioButton("Letter");
		
		book.setBounds(90, 50, 127, 25);
		frame.getContentPane().add(book);
		book.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				deselectRadioButtons(book, article, report, letter);
			}
		});
		
		JLabel lblChooseTemplate = new JLabel("Choose template. (Leave empty for blank document)");
		lblChooseTemplate.setBounds(70, 15, 330, 15);
		frame.getContentPane().add(lblChooseTemplate);
		
		article.setBounds(90, 135, 125, 25);
		frame.getContentPane().add(article);
		article.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				deselectRadioButtons(article, book, report, letter);
			}
		});
		
		report.setBounds(240, 50, 125, 25);
		frame.getContentPane().add(report);
		report.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				deselectRadioButtons(report, article, book, letter);
			}
		});
		
		letter.setBounds(240, 140, 125, 25);
		frame.getContentPane().add(letter);
		letter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				deselectRadioButtons( letter, report, article, book);
			}
		});	
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(240, 195, 100, 25);
		frame.getContentPane().add(btnCreate);
		btnCreate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(book.isSelected()) {
					mainWindow.setTemplate("book");
				}
				else if(report.isSelected()) {
					mainWindow.setTemplate("article");
				}
				else if(article.isSelected()) {
					mainWindow.setTemplate("letter");
				}
				else if(letter.isSelected()) {
					mainWindow.setTemplate("report");
				}
				else {
					mainWindow.setTemplate("empty");
				}
				
				controller.enact("create");
				mainWindow.initialize();
				frame.dispose();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(90, 195, 100, 25);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(previous.equals("main")) {
					mainWindow.initialize();
				}
				else {
					OpeningWindow openingWindow = new OpeningWindow();
					openingWindow.initialize();
				}
				frame.dispose();
			}
		});
	}
}