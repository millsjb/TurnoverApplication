package base;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import javax.swing.table.TableModel;

import util.Constants;


public class AutomatedTestingUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1548748901550654765L;
	private JSplitPane splitPane;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem exportMenuItem, importMenuItem, runMenuItem;
	final JFileChooser fc = new JFileChooser();
	private AutomatedTestingData dataPanel;
	
	public AutomatedTestingUI()
	{
		super();
		this.setTitle("Automated Testing UI");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(Constants.WIDTH,Constants.HEIGHT);
        this.setLayout(new BorderLayout());
        
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("A menu for controlling various functions related to files");
        menuBar.add(menu);
        
        runMenuItem = new JMenuItem("Run...");
        runMenuItem.getAccessibleContext().setAccessibleDescription(
                "Run the Automated Testing Utility");
        runMenuItem.addActionListener(this);
        menu.add(runMenuItem);
        
        menu.addSeparator();
        
        exportMenuItem = new JMenuItem("Export");
        exportMenuItem.getAccessibleContext().setAccessibleDescription(
                "Export to file");
        exportMenuItem.addActionListener(this);
        menu.add(exportMenuItem);
        
        importMenuItem = new JMenuItem("Import");
        importMenuItem.getAccessibleContext().setAccessibleDescription(
                "Import from a file");
        importMenuItem.addActionListener(this);
        menu.add(importMenuItem);
        
        this.setJMenuBar(menuBar);
        
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, addTabs(), addDataPane());

		splitPane.setBackground(Constants.BLUE);
		
		splitPane.setResizeWeight(1);
		this.add(splitPane, BorderLayout.CENTER);
        this.setVisible(true);
	}
	
	private AutomatedTestingTabbedPane addTabs()
	{
		return new AutomatedTestingTabbedPane();
	}
	
	private AutomatedTestingData addDataPane()
	{
		dataPanel = new AutomatedTestingData();
		return dataPanel;
	}
	
	public static void main(String args[])
	{
		new AutomatedTestingUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if (e.getSource().equals(exportMenuItem))
		{
			generateCSV();
		}
		else if (e.getSource().equals(importMenuItem))
		{
			openImportWindow();
		}
		else if (e.getSource().equals(runMenuItem))
		{
			runAutomatedTestingUtil();
		}
	}
	
	private void openImportWindow()
	{
		File workingDirectory = new File(System.getProperty("user.dir"));
		fc.setCurrentDirectory(workingDirectory);
		int returnVal = fc.showOpenDialog(AutomatedTestingUI.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            importFromFile(file);
        }
	}
	
	private void generateCSV()
	{
		int counter = 0;
		if (AutomatedTestingData.getParticipantPanel().getData().getRowCount() > 1)
		{
			counter++;
			writeToFile("CXCParticipant", AutomatedTestingData.getParticipantPanel().getData());
		}
		if (AutomatedTestingData.getTokenPanel().getData().getRowCount() > 1)
		{
			counter++;
			writeToFile("CXCToken", AutomatedTestingData.getParticipantPanel().getData());
		}
		if (AutomatedTestingData.getRecipientPanel().getData().getRowCount() > 1)
		{
			counter++;
			writeToFile("CXCRecipient", AutomatedTestingData.getParticipantPanel().getData());
		}
		if (AutomatedTestingData.getPaymentPanel().getData().getRowCount() > 1)
		{
			counter++;
			writeToFile("CXCPayment", AutomatedTestingData.getParticipantPanel().getData());
		}
		if (AutomatedTestingData.getPaymentRequestPanel().getData().getRowCount() > 1)
		{
			counter++;
			writeToFile("CXCPaymentRequest", AutomatedTestingData.getParticipantPanel().getData());
		}
		
		if (counter > 0)
		{
			JOptionPane optionPane = new JOptionPane(counter + " files successfully written!", JOptionPane.INFORMATION_MESSAGE);    
	    	JDialog dialog = optionPane.createDialog("Success");
	    	dialog.setAlwaysOnTop(true);
	    	dialog.setVisible(true);
		}
		else
		{
			JOptionPane optionPane = new JOptionPane("No files written. Please check data and try again", JOptionPane.ERROR_MESSAGE);    
	    	JDialog dialog = optionPane.createDialog("Failure");
	    	dialog.setAlwaysOnTop(true);
	    	dialog.setVisible(true);
		}
	}
	
	private void writeToFile(String fileName, TableModel table)
	{
		String seperator = "|";
		String fileContents = "";
		
		Date currentDate = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(currentDate);
		try {		
			fileName += " - " + date + ".csv";
			
			File varTmpDir = new File(fileName);
			boolean exists = varTmpDir.exists();
			
			int choice = 1;
			if (exists)
			{
				Object[] options = {"No", "Yes"};
				choice = JOptionPane.showOptionDialog(this, "File '" + fileName + "' already exists. Would you like to overwrite the existing file?", 
						"Overwrite Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						null, options, options[0]);
			}
			
			if (choice == 1)
			{
				FileWriter writer = new FileWriter(fileName);
				
				for (int i = 0; i < table.getRowCount(); i++)
				{
					for (int j = 0; j < table.getColumnCount(); j++)
					{
						if (table.getValueAt(i, j) != null)
						{
							fileContents += table.getValueAt(i, j).toString();
							if (j != table.getColumnCount()-1)
							{
								fileContents += seperator;
							}
							else
							{
								fileContents += "\n";
							}
						}
					}
				}
				writer.write(fileContents);
				writer.close();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,
				    "Error writing '" + fileName + "'. Exception is :\n" + e.getMessage());
		}
	}
	
	private void importFromFile(File file)
	{
		String lowerCaseName = file.getName().toLowerCase();
		if (!lowerCaseName.contains("participant") && !lowerCaseName.contains("token") && !lowerCaseName.contains("recipient")
				&& !lowerCaseName.contains("payment") && !lowerCaseName.contains("payment request"))
		{
			JOptionPane.showMessageDialog(this,
				    "Filename must contain one of the following keywords to direct processing:\nParticipant, Token, Recipient,"
				    + " Payment, or Payment Request");
			openImportWindow();
		}
		else if (!lowerCaseName.contains(".csv"))
		{
			JOptionPane.showMessageDialog(this,
				    "File type is not \".csv\". Please try again.");
			openImportWindow();
		}
		else
		{
			Scanner input = null;
			int type = -1;
			 try {

				 	if (lowerCaseName.contains("participant"))
				 	{
				 		type = 1;
				 	}
				 	else if (lowerCaseName.contains("token"))
				 	{
				 		type = 2;
				 	}
				 	else if (lowerCaseName.contains("recipient"))
				 	{
				 		type = 3;
				 	}
				 	else if (lowerCaseName.contains("payment"))
				 	{
				 		type = 4;
				 	}
				 	else if (lowerCaseName.contains("payment request"))
				 	{
				 		type = 5;
				 	}
				 	input = new Scanner(file);

				 	input.nextLine(); //Skip the first line with all of the headers
		            while (input.hasNextLine()) {
		                readLine(type, input.nextLine());
		            }
		            input.close();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			 finally
			 {
				 if (input != null) { input.close(); input = null; }
			 }
		}
	}
	
	private void readLine(int type, String line)
	{
		switch (type)
		{
		case 1: 
			AutomatedTestingData.getParticipantPanel().addRow(line.split("\\|"));
			break;
		case 2: 
			AutomatedTestingData.getTokenPanel().addRow(line.split("\\|"));
			break;
		case 3: 
			AutomatedTestingData.getRecipientPanel().addRow(line.split("\\|"));
			break;
		case 4: 
			AutomatedTestingData.getPaymentPanel().addRow(line.split("\\|"));
			break;
		case 5: 
			AutomatedTestingData.getPaymentRequestPanel().addRow(line.split("\\|"));
			break;

		}
		
	}
	
	private void runAutomatedTestingUtil()
	{
		new AutomatedTestingFrame();
	}
}
