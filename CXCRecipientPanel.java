package panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import forms.RecipientForm;

public class CXCRecipientPanel extends JPanel implements ActionListener{

	private static RecipientForm recipientForm;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6624466904936934433L;

	public CXCRecipientPanel()
	{
		super(new BorderLayout());
		
		recipientForm = new RecipientForm();
		
		drawScreen();
		JScrollPane scrollPane = new JScrollPane(recipientForm);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);

		this.add(scrollPane, BorderLayout.CENTER);
		this.setBackground(Color.GREEN);
	}
	
	private void drawScreen()
	{
		//What needs to be drawn here?
       
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// any actions?
		
	}
	
	public static RecipientForm getForm()
	{
		return recipientForm;
	}

}
