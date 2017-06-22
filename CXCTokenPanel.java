package panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import forms.TokenDropDownForm;
import forms.TokenForm;
import util.Constants;

public class CXCTokenPanel extends JPanel
{

	private static TokenForm tokenForm;
	private static TokenDropDownForm tokenDropDownForm;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3514249526904331460L;

	public CXCTokenPanel()
	{
		super(new BorderLayout());
		
		tokenForm = new TokenForm();
		tokenDropDownForm = new TokenDropDownForm(tokenForm);
		
		JScrollPane topScrollPane = new JScrollPane(tokenDropDownForm);
		topScrollPane.getVerticalScrollBar().setUnitIncrement(16);
		this.add(topScrollPane, BorderLayout.NORTH);
		this.setBackground(Constants.BLUE);
		
		JScrollPane scrollPane = new JScrollPane(tokenForm);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		this.add(scrollPane, BorderLayout.CENTER);
		this.setBackground(Color.BLUE);
	}
	
	public static TokenForm getTokenForm()
	{
		return tokenForm;
	}

	public TokenDropDownForm getTokenDropDownForm()
	{
		return tokenDropDownForm;
	}
}
