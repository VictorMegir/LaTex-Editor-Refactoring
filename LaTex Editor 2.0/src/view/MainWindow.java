package view;

import controller.Controller;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow
{
	private JFrame frame;
	private JEditorPane editorPane = new JEditorPane();
	private JFileChooser filechooser = new JFileChooser();
	private Controller controller;
	private String filename,latexCommandType,strategy,template;
	
	public MainWindow(Controller controller)
	{
		this.controller = controller;
		controller.setWindow(this);
	}

	public void initialize()
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("LaTex Editor");
		frame.setResizable(false);
		frame.setBounds(100, 100, 825, 565);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);	
		filechooser.setFileFilter(new FileNameExtensionFilter("TEX File","tex"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 805, 26);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewFile = new JMenuItem("New file");
		mnFile.add(mntmNewFile);
		mntmNewFile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ChooseTemplate chooseTemplate = new ChooseTemplate(controller, "main");
				chooseTemplate.initialize();
				frame.dispose();
			}
		});
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		mntmSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				controller.enact("edit");
			}
		});
		
		JMenuItem addChapter = new JMenuItem("Add chapter");
		JMenu mnCommands = new JMenu("Commands");
		JMenuItem mntmLoadFile = new JMenuItem("Load file");
		mnFile.add(mntmLoadFile);
		mntmLoadFile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				int option = filechooser.showOpenDialog(null);
				if(option == JFileChooser.APPROVE_OPTION)
				{
					filename = filechooser.getSelectedFile().toString();
					controller.enact("load");
					mnCommands.setEnabled(true);
					addChapter.setEnabled(true);
					
					if(template.equals("letter")) {
						mnCommands.setEnabled(false);
					}
					if(template.equals("article")) {
						addChapter.setEnabled(false);
					}
					editorPane.setText(controller.getCurrentDocument().getContents());
				}
			}
		});
		
		JMenuItem mntmSaveFile = new JMenuItem("Save file");
		mnFile.add(mntmSaveFile);
		mntmSaveFile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int option = filechooser.showSaveDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) 
				{
					filename = filechooser.getSelectedFile().toString();
					if(filename.endsWith(".tex") == false) {
						filename = filename + ".tex";
					}
					controller.enact("save");
				}
			}
		});
		
		JMenu saveEncrypted = new JMenu("Encrypt");
		mnFile.add(saveEncrypted);
		
		JMenuItem mntmRot13 = new JMenuItem("Rot13");
		saveEncrypted.add(mntmRot13);
		mntmRot13.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int option = filechooser.showSaveDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) 
				{
					filename = filechooser.getSelectedFile().toString();
					if(filename.endsWith(".tex") == false) {
						filename = filename + ".tex";
					}
					controller.enact("rot13Save");
				}
			}
		});
		
		JMenuItem mntmAtbash = new JMenuItem("Atbash");
		saveEncrypted.add(mntmAtbash);
		mntmAtbash.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int option = filechooser.showSaveDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) 
				{
					filename = filechooser.getSelectedFile().toString();
					if(filename.endsWith(".tex") == false) {
						filename = filename + ".tex";
					}
					controller.enact("atbashSave");
				}
			}
		});
		
		JMenu loadEncrypted = new JMenu("Decrypt");
		mnFile.add(loadEncrypted);
		
		JMenuItem mntmRot13load = new JMenuItem("Rot13");
		loadEncrypted.add(mntmRot13load);
		mntmRot13load.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser filechooser = new JFileChooser();
				int option = filechooser.showOpenDialog(null);
				if(option == JFileChooser.APPROVE_OPTION)
				{
					filename = filechooser.getSelectedFile().toString();
					controller.enact("rot13Load");
					mnCommands.setEnabled(true);
					addChapter.setEnabled(true);
					
					if(template.equals("letter")) {
						mnCommands.setEnabled(false);
					}
					if(template.equals("article")) {
						addChapter.setEnabled(false);
					}
					editorPane.setText(controller.getCurrentDocument().getContents());
				}
			}
		});
		
		JMenuItem mntmAtbashload = new JMenuItem("Atbash");
		loadEncrypted.add(mntmAtbashload);
		mntmAtbashload.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int option = filechooser.showOpenDialog(null);
				if(option == JFileChooser.APPROVE_OPTION)
				{
					filename = filechooser.getSelectedFile().toString();					
					controller.enact("atbashLoad");
					mnCommands.setEnabled(true);
					addChapter.setEnabled(true);
					
					if(template.equals("letter")) {
						mnCommands.setEnabled(false);
					}
					if(template.equals("article")) {
						addChapter.setEnabled(false);
					}
					editorPane.setText(controller.getCurrentDocument().getContents());
				}
			}
		});
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		menuBar.add(mnCommands);
		if(template.equals("letter")) {
			mnCommands.setEnabled(false);
		}
		
		mnCommands.add(addChapter);
		if(template.equals("article")) {
			addChapter.setEnabled(false);
		}
		addChapter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				latexCommandType = "chapter";
				controller.enact("addLatex");
			}
		});
		
		JMenu addSection = new JMenu("Add Section");
		mnCommands.add(addSection);
		
		JMenuItem mntmAddSection = new JMenuItem("Add section");
		addSection.add(mntmAddSection);
		mntmAddSection.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				latexCommandType = "section";
				controller.enact("addLatex");
			}
		});
		
		JMenuItem mntmAddSubsection = new JMenuItem("Add subsection");
		addSection.add(mntmAddSubsection);
		mntmAddSubsection.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				latexCommandType = "subsection";
				controller.enact("addLatex");
			}
		});
		
		JMenuItem mntmAddSubsubsection = new JMenuItem("Add subsubsection");
		addSection.add(mntmAddSubsubsection);
		mntmAddSubsubsection.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				latexCommandType = "subsubsection";
				controller.enact("addLatex");
			}
		});
		
		JMenu addEnumerationList = new JMenu("Add enumeration list");
		mnCommands.add(addEnumerationList);
		
		JMenuItem mntmItemize = new JMenuItem("Itemize");
		addEnumerationList.add(mntmItemize);
		mntmItemize.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				latexCommandType = "itemize";
				controller.enact("addLatex");
			}
		});
		
		JMenuItem mntmEnumerate = new JMenuItem("Enumerate");
		addEnumerationList.add(mntmEnumerate);
		mntmEnumerate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				latexCommandType = "enumerate";
				controller.enact("addLatex");
			}
		});
		
		JMenuItem addTable = new JMenuItem("Add table");
		mnCommands.add(addTable);
		addTable.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				latexCommandType = "table";
				controller.enact("addLatex");
			}
		});
		
		JMenuItem addFigure = new JMenuItem("Add figure");
		mnCommands.add(addFigure);
		addFigure.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				latexCommandType = "figure";
				controller.enact("addLatex");
			}
		});
		
		JMenu mnStrategy = new JMenu("Strategy");
		menuBar.add(mnStrategy);
		
		JMenu mnEnable = new JMenu("Enable");
		mnStrategy.add(mnEnable);

		JCheckBoxMenuItem menuVolatile = new JCheckBoxMenuItem("Volatile");
		mnEnable.add(menuVolatile);
		JCheckBoxMenuItem menuStable = new JCheckBoxMenuItem("Stable");
		mnEnable.add(menuStable);
		menuStable.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				strategy = "stable";
				controller.enact("changeStrategy");
				menuVolatile.setSelected(false);
				menuStable.setEnabled(false);
				menuVolatile.setEnabled(true);
			}
		});

		menuVolatile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				strategy = "volatile";
				controller.enact("changeStrategy");
				menuStable.setSelected(false);
				menuVolatile.setEnabled(false);
				menuStable.setEnabled(true);
			}
		});
		
		JMenuItem mntmDisable = new JMenuItem("Disable");
		mnStrategy.add(mntmDisable);
		mntmDisable.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				controller.enact("disableVersions");
				menuStable.setSelected(false);
				menuVolatile.setSelected(false);
				menuStable.setEnabled(true);
				menuVolatile.setEnabled(true);
			}
		});
		
		JMenuItem mntmRollback = new JMenuItem("Rollback");
		mnStrategy.add(mntmRollback);
		mntmRollback.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				controller.enact("rollback");
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 780, 465);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(editorPane);
		
		editorPane.setText(controller.getCurrentDocument().getContents());
	}
	
	public String getLatexCommandType() {
		return latexCommandType;
	}

	public void setLatexCommandType(String latexCommandType) {
		this.latexCommandType = latexCommandType;
	}
	
	public String getTemplate() {
		return template;
	}
	
	public void setTemplate(String template) {
		this.template = template;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getStrategy() {
		return strategy;
	}
	
	public JEditorPane getEditorPane() {
		return editorPane;
	}
	
	public String getText() {
		return editorPane.getText();
	}
	
	public void setText(String text) {
		editorPane.setText(text);
	}
}