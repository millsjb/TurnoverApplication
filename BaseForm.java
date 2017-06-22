package forms;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import base.FormRow;
import util.Constants;

public abstract class BaseForm extends JPanel
	implements Constants, ActionListener
{
	HashMap<String, FormRow> rowMap;
	ArrayList<String> fieldNameList;
	GridBagConstraints constraints;
	JLabel label;
	int currentRow;
	boolean rowsHidden;
	protected boolean toggle;
	
	abstract boolean validateField(String name, String value);
	abstract void generateValueButtonClicked(String name);
	abstract void createButtonClicked();
	abstract void comboBoxClicked(JComboBox<String> comboBox);

	JButton createButton, cancelButton;
	
	public BaseForm()
	{
		super(new GridBagLayout());
		toggle = false;
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		rowsHidden = false;
		currentRow = 0;
		constraints = new GridBagConstraints();
		rowMap = new HashMap<String, FormRow>();
		fieldNameList = new ArrayList<String>();
	}
	
	public void addCreateButton()
	{
		final JLabel label = new JLabel("Toggle all fields");
		
		label.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent event)
			{
				toggleHideableRows();
			}
			
			public void mouseEntered(MouseEvent event)
			{
				label.setForeground(new Color(30, 144, 255));
				label.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseExited(MouseEvent event)
			{
				label.setForeground(Color.BLACK);
				label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		createButton = new JButton("Create");
		createButton.setActionCommand("create");
		createButton.addActionListener(this);
		
		// set the color scheme for the button
		createButton.setBackground(BLUE);
		createButton.setForeground(WHITE);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("cancel");
		cancelButton.addActionListener(this);
		
		// set the color scheme for the button
		cancelButton.setBackground(BLUE);
		cancelButton.setForeground(WHITE);
		cancelButton.setVisible(false);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
		panel.add(label);
		panel.add(cancelButton);
		panel.add(createButton);
		
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.gridwidth = 3;
		constraints.weightx = 0;
		constraints.gridx = 0;
		constraints.gridy = currentRow;
		constraints.insets = new Insets(30, 3, 3, 3);
		
		add(panel, constraints);
	}
	
	public void toggleCreateButton()
	{
		toggle = !toggle;
		if (toggle)
		{
			createButton.setText("Save");
		}
		else
		{
			createButton.setText("Create");
		}
		//cancelButton.setEnabled(toggle);
		cancelButton.setVisible(toggle);
	}

	public void addRow(String name, String[] options, boolean hasButton, boolean hideable)
	{
		FormRow formRow = new FormRow(name, options, hasButton, hideable, currentRow++, this);
								
		rowMap.put(name, formRow);
		fieldNameList.add(name);
		
		constraints.weightx = .18;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridy = formRow.getRowIndex();
		constraints.gridx = 0;
		constraints.insets = new Insets(3, 3, 3, 3);		
		
		add(formRow.getLabel(), constraints);
		
		constraints.gridx = 1;
		constraints.weightx = 1;
		
		add(formRow.getField(), constraints);
				
		if(!formRow.hasButton())
		{
			return;
		}
		
		constraints.gridx = 2;
		constraints.weightx = 0;
		
		add(formRow.getButton(), constraints);
	}
	
	public void addTitle(String name)
	{		
		constraints.weightx = 0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridy = currentRow++;
		constraints.gridx = 0;
		constraints.insets = new Insets(3, 3, 3, 3);
		
		Font font = new Font("Helvetica", Font.BOLD,14);
		
		label = new JLabel(name);
		
		label.setFont(font);
		
		add(label, constraints);
		
		constraints.weightx = .25;
		constraints.gridy = currentRow++;
		constraints.gridx = 0;
		constraints.gridwidth = 2;
		
		add(new JSeparator(SwingConstants.HORIZONTAL), constraints);
	}
	
	public void addRow()
	{
		constraints.weightx = 0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridy = currentRow++;
		constraints.gridx = 0;
		constraints.insets = new Insets(3, 3, 3, 3);
		constraints.gridwidth = 2;
		
		add(Box.createVerticalStrut(20), constraints);
	}
	
	public void toggleHideableRows()
	{
		rowsHidden = !rowsHidden;
		
		for(String fieldName : fieldNameList)
		{
			FormRow formRow = rowMap.get(fieldName);
		
			if(formRow.isHideable())
			{
				formRow.toggleRowVisibility(!rowsHidden);
			}
		}

		revalidate();
		repaint();
	}
	
	public String[] toStringArray()
	{
		String[] stringArray = new String[fieldNameList.size()];
		
		for(int i = 0; i < fieldNameList.size(); i++)
		{
			stringArray[i] = getFieldValue(fieldNameList.get(i));
		}
		
		return stringArray;
	}
	
	public void updateComboBox(String name, String[] options)
	{
		if(!rowMap.containsKey(name))
		{
			return;
		}
		
		rowMap.get(name).updateComboBox(options);
	}
	
	public void setFieldValue(String name, String value)
	{
		if(!rowMap.containsKey(name))
		{
			return;
		}
		
		rowMap.get(name).setFieldValue(value);
	}
	
	public void setLockedValue(String name, boolean lock)
	{
		if(!rowMap.containsKey(name))
		{
			return;
		}
		
		JComponent comp = rowMap.get(name).getField();
		
		if (comp instanceof JTextField)
		{
			((JTextField) comp).setEditable(!lock);
		}
		else if (comp instanceof JComboBox)
		{
			((JComboBox) comp).setEditable(!lock);
		}
				
	}
	
	public String getFieldValue(String name)
	{
		if(!rowMap.containsKey(name))
		{
			return "";
		}
		
		return rowMap.get(name).getFieldValue();
	}
	
	public boolean validateAllFields()
	{
		String output = "";
		
		for(String fieldName : fieldNameList)
		{
			if(!validateField(fieldName, getFieldValue(fieldName)))
			{
				output += "<li>" + fieldName + "</li>";
			}
		}
		
		if(!output.isEmpty())
		{
			output = "<html><b>Invalid values specified for the following fields.<br><ul>" + output + "</ul>Do you want to continue?<br><br>";
			
			int results = JOptionPane.showConfirmDialog(null, output, "WARNING - Validation Errors", JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
		    
			if (results == JOptionPane.NO_OPTION)
			{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand().equals("create"))
		{
			createButtonClicked();
			return;
		}
		else if (event.getActionCommand().equals("cancel"))
		{
			toggleCreateButton();
		}
		else if(event.getActionCommand().equals("comboBox"))
		{
			comboBoxClicked((JComboBox<String>) event.getSource());
		}

		
		generateValueButtonClicked(event.getActionCommand());
	}
	
	public String generateRandomUUID()
	{	
        return UUID.nameUUIDFromBytes(String.valueOf(System.currentTimeMillis()).getBytes()).toString();
	}
	
	public String generateRandomNumber(int min, int max)
	{
		return String.valueOf((int) Math.floor(Math.random() * (max - min + 1)) + min);
	}
	
	public String generateRandomName()
	{
		return RANDOM_NAMES[Integer.valueOf(generateRandomNumber(0, RANDOM_NAMES.length - 1))];
	}
	
	public String generateRandomSource()
	{
		return RANDOM_SOURCES[Integer.valueOf(generateRandomNumber(0, RANDOM_SOURCES.length - 1))];
	}
	
	public String generateRandomHostName()
	{
		return RANDOM_HOST_NAMES[Integer.valueOf(generateRandomNumber(0, RANDOM_HOST_NAMES.length - 1))];
	}
	
	public String generateRandomChannelType()
	{
		return RANDOM_CHANNEL_TYPES[Integer.valueOf(generateRandomNumber(0, RANDOM_CHANNEL_TYPES.length - 1))];
	}
	
	public String generateRandomOrganization()
	{
		return RANDOM_ORGANIZATIONS[Integer.valueOf(generateRandomNumber(0, RANDOM_ORGANIZATIONS.length - 1))];
	}
	
	public String generateRandomToken()
	{
		return RANDOM_TOKENS[Integer.valueOf(generateRandomNumber(0, RANDOM_TOKENS.length - 1))];
	}
	
	public String generateRandomFirstName()
	{
		return RANDOM_FIRST_NAMES[Integer.valueOf(generateRandomNumber(0, RANDOM_FIRST_NAMES.length - 1))];
	}
	
	public String generateRandomLastName()
	{
		return RANDOM_LAST_NAMES[Integer.valueOf(generateRandomNumber(0, RANDOM_LAST_NAMES.length - 1))];
	}
	
	public String generateRandomFraudCheckReason()
	{
		return RANDOM_FRAUD_CHECK_REASONS[Integer.valueOf(generateRandomNumber(0, RANDOM_FRAUD_CHECK_REASONS.length - 1))];
	}
	
	public String generateRandomFraudCheckVersion()
	{
		return RANDOM_FRAUD_CHECK_VERSIONS[Integer.valueOf(generateRandomNumber(0, RANDOM_FRAUD_CHECK_VERSIONS.length - 1))];
	}
	
	public String generateFraudData()
	{
		return RANDOM_FRAUD_DATA_EXAMPLES[Integer.valueOf(generateRandomNumber(0, RANDOM_FRAUD_DATA_EXAMPLES.length - 1))];
	}
	
	public String generateRandomAmount()
	{
		return RANDOM_AMOUNTS[Integer.valueOf(generateRandomNumber(0, RANDOM_AMOUNTS.length - 1))];
	}
	
	public String generateRandomDeclineMemo()
	{
		return RANDOM_DECLINE_MEMOS[Integer.valueOf(generateRandomNumber(0, RANDOM_DECLINE_MEMOS.length - 1))];
	}
	
	public String generateRandomDeactivationMemo()
	{
		return RANDOM_DEACTIVATION_MEMOS[Integer.valueOf(generateRandomNumber(0, RANDOM_DEACTIVATION_MEMOS.length - 1))];
	}
	
	public String generateRandomFailureReasonDescription()
	{
		return RANDOM_FAILURE_REASON_DESCRIPTIONS[Integer.valueOf(generateRandomNumber(0, RANDOM_FAILURE_REASON_DESCRIPTIONS.length - 1))];
	}
	
	public String generateRandomMemo()
	{
		return RANDOM_MEMOS[Integer.valueOf(generateRandomNumber(0, RANDOM_MEMOS.length - 1))];
	}
	
	public String generateRandomAddressCity()
	{
		return RANDOM_ADDRESS_CITIES[Integer.valueOf(generateRandomNumber(0, RANDOM_ADDRESS_CITIES.length - 1))];
	}
	
	public String generateRandomAddressLine1()
	{
		return RANDOM_ADDRESS_LINE_1[Integer.valueOf(generateRandomNumber(0, RANDOM_ADDRESS_LINE_1.length - 1))];
	}

	public String generateRandomAddressLine2()
	{
		return RANDOM_ADDRESS_LINE_2[Integer.valueOf(generateRandomNumber(0, RANDOM_ADDRESS_LINE_2.length - 1))];
	}
	
	public String generateRandomAddressState()
	{
		return RANDOM_ADDRESS_STATE[Integer.valueOf(generateRandomNumber(0, RANDOM_ADDRESS_STATE.length - 1))];
	}
	
	public String generateRandomAddressZip()
	{
		return RANDOM_ADDRESS_ZIP[Integer.valueOf(generateRandomNumber(0, RANDOM_ADDRESS_ZIP.length - 1))];
	}
	
	public String generateRandomBusinessName()
	{
		return RANDOM_BUSINESS_NAMES[Integer.valueOf(generateRandomNumber(0, RANDOM_BUSINESS_NAMES.length - 1))];
	}
	
	public String generateRandomPaymentTerms()
	{
		return RANDOM_PAYMENT_TERMS[Integer.valueOf(generateRandomNumber(0, RANDOM_PAYMENT_TERMS.length - 1))];
	}
}
