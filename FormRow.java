package base;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

public class FormRow
{
	private int rowIndex;
	private String name;
	private JButton button;
	private JLabel label;
	private JComponent field;
	private DefaultComboBoxModel<String> comboBoxModel;
	private boolean hasButton;
	private boolean hideable;
	
	public FormRow(String name, String[] options, boolean hasButton, 
			boolean hideable, int rowIndex, ActionListener listener)
	{
		this.name = name;
		this.rowIndex = rowIndex;
		this.hasButton = hasButton;
		this.hideable = hideable;
		
		label = new JLabel(name);

		if(options != null)
		{
			comboBoxModel = new DefaultComboBoxModel<String>(options);
			
			JComboBox<String> comboBox = new JComboBox<String>(comboBoxModel);
			comboBox.setActionCommand("comboBox");
			comboBox.addActionListener(listener);
			
			JComponent comp = (JComponent) comboBox.getRenderer();
			comp.setBorder(BorderFactory.createEmptyBorder(3, 6, 3, 6));
			comboBox.setRenderer((ListCellRenderer) comp);
			
			field = comboBox;
		}
		else
		{
			JTextField textField = new JTextField();
			textField.setBorder(BorderFactory.createCompoundBorder(textField.getBorder(), 
					BorderFactory.createEmptyBorder(3, 6, 3, 6)));
			
			field = textField;
		}
		
		button = new JButton("↻");
		button.setActionCommand(name);
		
		if(hasButton)
		{
			button.addActionListener(listener);
		}
	
	}
	
	public void updateComboBox(String[] options)
	{
		comboBoxModel.removeAllElements();
		comboBoxModel.addElement("");
		
		for(String option : options)
		{
			comboBoxModel.addElement(option);
		}
	}
	
	public void setFieldValue(String value)
	{
		if(field instanceof JTextField)
		{
			((JTextField) field).setText(value);
		}
		else if(field instanceof JComboBox)
		{
			((JComboBox) field).setSelectedItem(value);
		}
	}
	
	public String getFieldValue()
	{
		if(field instanceof JTextField)
		{
			return ((JTextField) field).getText();
		}
		else if(field instanceof JComboBox)
		{
			return (String) ((JComboBox) field).getSelectedItem();
		}
		
		return "";
	}
	
	public void toggleRowVisibility(boolean visible)
	{
		label.setVisible(visible);
		field.setVisible(visible);
		button.setVisible(visible);
	}
	
	public boolean isHideable()
	{
		return hideable;
	}
	
	public boolean hasButton()
	{
		return hasButton;
	}
	
	public JComponent getField()
	{
		return field;
	}
	
	public int getRowIndex()
	{
		return rowIndex;
	}

	public String getName()
	{
		return name;
	}

	public JButton getButton()
	{
		return button;
	}

	public JLabel getLabel()
	{
		return label;
	}
}
