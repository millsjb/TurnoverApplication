package base;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AutomatedTestingFrame implements ActionListener
{
	
	private JFrame mainFrame;
	private JPanel mainPanel;
	private HashMap<String, FormRow> rowMap;
	private final String[] fields = {"Username", "Password", "Hostname", "Port"};
	private JButton createButton;
	private JCheckBox participantCheckBox, tokenCheckBox, recipientCheckBox, paymentCheckBox, paymentRequestCheckBox;
	
	public AutomatedTestingFrame()
	{
		mainFrame = new JFrame("Run Automated Testing Utility");
		GridBagConstraints constraints = new GridBagConstraints();		

		mainPanel = new JPanel(new GridBagLayout());
		
		rowMap = new HashMap<String, FormRow>();
		
		int currentRow = 0;
		//currentRow = addTitle(mainPanel, "Automated Testing Parameters", constraints, currentRow);
		
		for (int i = 0; i < fields.length; i++)
		{
			addRow(mainPanel, fields[i], null, constraints, currentRow++);
		}
		//currentRow = addTitle(mainPanel, "Import CSV Files", constraints, currentRow);

		participantCheckBox = new JCheckBox("", false);
		tokenCheckBox = new JCheckBox("", false);
		recipientCheckBox = new JCheckBox("", false);
		paymentCheckBox = new JCheckBox("", false);
		paymentRequestCheckBox = new JCheckBox("", false);
		
		participantCheckBox.addActionListener(this);
		tokenCheckBox.addActionListener(this);
		recipientCheckBox.addActionListener(this);
		paymentCheckBox.addActionListener(this);
		paymentRequestCheckBox.addActionListener(this);
		
		addRow(mainPanel, "CXCParticipant", participantCheckBox, constraints, currentRow++);
		addRow(mainPanel, "CXCToken", tokenCheckBox, constraints, currentRow++);
		addRow(mainPanel, "CXCRecipient", recipientCheckBox, constraints, currentRow++);
		addRow(mainPanel, "CXCPayment", paymentCheckBox, constraints, currentRow++);
		addRow(mainPanel, "CXCPaymentRequest", paymentRequestCheckBox, constraints, currentRow++);
		
		addCreateButton(mainPanel, constraints, currentRow++);

		
		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
		mainFrame.setSize(800, 800);
		
	}	
	
	private int addRow(JPanel panel, String name, JCheckBox checkBox, GridBagConstraints constraints, int currentRow)
	{		
		if (checkBox == null)
		{
			FormRow formRow = new FormRow(name, null, false, false, currentRow, null);
			constraints.weightx = .18;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridy = formRow.getRowIndex();
			constraints.insets = new Insets(3, 3, 3, 3);
			
			constraints.gridx = 1;
			panel.add(formRow.getLabel(), constraints);
			
			constraints.gridx = 2;
			constraints.weightx = 1;
			
			panel.add(formRow.getField(), constraints);
			
			rowMap.put(name, formRow);
			
			return currentRow;
		}
		else
		{
			FormRow formRow = new FormRow(name, null, false, false, currentRow, null);
			constraints.weightx = .18;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridy = formRow.getRowIndex();
			constraints.insets = new Insets(3, 3, 3, 3);
			
			constraints.gridx = 0;
			panel.add(checkBox, constraints);
			
			constraints.gridx = 1;
			panel.add(formRow.getLabel(), constraints);
			
			constraints.gridx = 2;
			constraints.weightx = 1;
			
			panel.add(formRow.getField(), constraints);
			JTextField field = (JTextField)formRow.getField();
            field.setDisabledTextColor(Color.BLACK);
            field.setEnabled(false);
            field.setBackground(Color.LIGHT_GRAY);
			rowMap.put(name, formRow);
			
			return currentRow;
		}
		
	}
	
	public int addTitle(JPanel panel, String name, GridBagConstraints constraints, int currentRow)
	{		
		constraints.weightx = 0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridy = currentRow++;
		constraints.gridx = 0;
		constraints.insets = new Insets(3, 3, 3, 3);
		
		Font font = new Font("Helvetica", Font.BOLD,14);
		
		JLabel label = new JLabel(name);
		
		label.setFont(font);
		
		panel.add(label, constraints);
		
		constraints.weightx = .25;
		constraints.gridy = currentRow++;
		constraints.gridx = 0;
		constraints.gridwidth = 2;
		
		panel.add(new JSeparator(SwingConstants.HORIZONTAL), constraints);
		
		return currentRow;
	}
	
	private void addCreateButton(JPanel mainPanel, GridBagConstraints constraints, int currentRow)
	{
		createButton = new JButton("Run");
		createButton.setActionCommand("run");
		createButton.addActionListener(this);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
		panel.add(createButton);
		
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.gridwidth = 3;
		constraints.weightx = 0;
		constraints.gridx = 0;
		constraints.gridy = currentRow;
		constraints.insets = new Insets(30, 3, 3, 3);
		
		mainPanel.add(panel, constraints);
	}
	
	private void openFileChooser(FormRow formRow, JCheckBox checkBox)
	{

		FileFilter filter = new FileNameExtensionFilter("CSV File", "CSV");
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(filter);
		File workingDirectory = new File(System.getProperty("user.dir"));
		fc.setCurrentDirectory(workingDirectory);
		int returnVal = fc.showOpenDialog(mainPanel);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file.getPath().substring(file.getPath().length()-4).equalsIgnoreCase(".csv"))
            {
	            formRow.setFieldValue(file.getPath());
	            formRow.getField().setBackground(Color.WHITE);
	            formRow.getField().setForeground(Color.BLACK);
            }
            else
            {
            	JOptionPane optionPane = new JOptionPane("File must have .csv extension!", JOptionPane.ERROR_MESSAGE);    
            	JDialog dialog = optionPane.createDialog("Failure");
            	dialog.setAlwaysOnTop(true);
            	dialog.setVisible(true);
            	disableField(formRow, checkBox);
            }
        }
        else
        {
        	disableField(formRow, checkBox);
        }
	}
	
	private void disableField (FormRow formRow, JCheckBox checkBox)
	{
		formRow.setFieldValue(" ");
		formRow.getField().setBackground(Color.LIGHT_GRAY);
		checkBox.setSelected(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == participantCheckBox)
		{
			if (participantCheckBox.isSelected())
			{
				openFileChooser(rowMap.get("CXCParticipant"), participantCheckBox);
			}
			else 
			{
				disableField(rowMap.get("CXCParticipant"), participantCheckBox);
			}
		}
		if (e.getSource() == tokenCheckBox)
		{
			if (tokenCheckBox.isSelected())
			{
				openFileChooser(rowMap.get("CXCToken"), tokenCheckBox);			
			}
			else 
			{
				disableField(rowMap.get("CXCToken"), tokenCheckBox);
			}
		}
		if (e.getSource() == recipientCheckBox)
		{
			if (recipientCheckBox.isSelected())
			{
				openFileChooser(rowMap.get("CXCRecipient"), recipientCheckBox);			
			}
			else 
			{
				disableField(rowMap.get("CXCRecipient"), recipientCheckBox);
			}
		}
		if (e.getSource() == paymentCheckBox)
		{
			if (paymentCheckBox.isSelected())
			{
				openFileChooser(rowMap.get("CXCPayment"), paymentCheckBox);
			}
			else 
			{
				disableField(rowMap.get("CXCPayment"), paymentCheckBox);
			}
		}
		if (e.getSource() == paymentRequestCheckBox)
		{
			if (paymentRequestCheckBox.isSelected())
			{
				openFileChooser(rowMap.get("CXCPaymentRequest"), paymentRequestCheckBox);			
			}
			else 
			{
				disableField(rowMap.get("CXCPaymentRequest"), paymentRequestCheckBox);
			}
		}
		if (e.getSource() == createButton)
		{
			run();
		}
	}
	
	private void run()
	{
		String username = rowMap.get("Username").getFieldValue();
		String password = rowMap.get("Password").getFieldValue();
		String hostname = rowMap.get("Hostname").getFieldValue();
		String port = rowMap.get("Port").getFieldValue();
		
		if (!validateInput(username, password, hostname, port))
		{
			return;
		}
		
		String participantFilePath = rowMap.get("CXCParticipant").getFieldValue();
		String tokenFilePath = rowMap.get("CXCToken").getFieldValue();
		String recipientFilePath = rowMap.get("CXCRecipient").getFieldValue();
		String paymentFilePath = rowMap.get("CXCPayment").getFieldValue();
		String paymentRequestFilePath = rowMap.get("CXCPaymentRequest").getFieldValue();
		
		ArrayList<String> filesToRun = new ArrayList<>();
		if (!validateFilePath(participantFilePath, tokenFilePath, recipientFilePath, paymentFilePath, paymentRequestFilePath, filesToRun))
		{
			return;
		}
		
		for (String filename : filesToRun)
		{
			// Run a java app in a separate system process
			Process proc;
			InputStream in;
			InputStream err;
			try {
				proc = Runtime.getRuntime().exec("java -jar" + " C:/Users/codyp/git/AutomatedTestingUI/lib/AutomatedTesting.jar " + hostname + " " + port + " \""
						+ filename + "\" " + username + " " + password);
				// Then retreive the process output
				in = proc.getInputStream();
				err = proc.getErrorStream();	
				
				int size = 0;
				byte[] buffer = new byte[1024];
				while ((size = in.read(buffer)) != -1) System.out.write(buffer, 0, size);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private boolean validateInput(String username, String password, String hostname, String port)
	{
		ArrayList<String> errors = new ArrayList<>();
		if (username == null || username.trim().isEmpty())
		{
			errors.add("Username");
		}
		if (password == null || password.trim().isEmpty())
		{
			errors.add("Password");
		}
		if (hostname == null || hostname.trim().isEmpty())
		{
			errors.add("Hostname");
		}
		if (port == null  || port.trim().isEmpty())
		{
			errors.add("Port");
		}		
		if (errors.size() > 0)
		{
			String error = "The following fields must be set:";
			for (String item : errors)
			{
				error += "\n- "+item;
			}
			JOptionPane optionPane = new JOptionPane(error, JOptionPane.ERROR_MESSAGE);    
        	JDialog dialog = optionPane.createDialog("Failure");
        	dialog.setAlwaysOnTop(true);
        	dialog.setVisible(true);
        	return false;
		}
		
		return true;
	}
	
	private boolean validateFilePath(String participantFilePath, String tokenFilePath, String recipientFilePath,
									String paymentFilePath, String paymentRequestFilePath, ArrayList<String> filesToRun)
	{
		if ((participantFilePath == null || participantFilePath.trim().isEmpty()) && (tokenFilePath == null ||
				tokenFilePath.trim().isEmpty()) && (recipientFilePath == null || recipientFilePath.trim().isEmpty())
				&& (paymentFilePath == null || paymentFilePath.trim().isEmpty()) && (paymentRequestFilePath == null
				|| paymentRequestFilePath.trim().isEmpty()))
		{
			JOptionPane optionPane = new JOptionPane("You must select at least one CSV to use", JOptionPane.ERROR_MESSAGE);    
        	JDialog dialog = optionPane.createDialog("Failure");
        	dialog.setAlwaysOnTop(true);
        	dialog.setVisible(true);
        	return false;
		}
		
		if (participantFilePath != null && !participantFilePath.trim().isEmpty())
		{
			filesToRun.add(participantFilePath);
		}
		if (tokenFilePath != null && !tokenFilePath.trim().isEmpty())
		{
			filesToRun.add(tokenFilePath);
		}
		if (recipientFilePath != null && !recipientFilePath.trim().isEmpty())
		{
			filesToRun.add(recipientFilePath);
		}
		if (paymentFilePath != null && !paymentFilePath.trim().isEmpty())
		{
			filesToRun.add(paymentFilePath);
		}
		if (paymentRequestFilePath != null && !paymentRequestFilePath.trim().isEmpty())
		{
			filesToRun.add(paymentRequestFilePath);
		}
		
		return true;
	}
}