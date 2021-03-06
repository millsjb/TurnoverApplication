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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import forms.TableRowListener;
import forms.ParticipantForm;

public class CXCParticipantPanel extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 9170058317164491853L;
	private static ParticipantForm participantForm;
	
	public CXCParticipantPanel(TableRowListener listener)
	{
		super(new BorderLayout());
		
		participantForm = new ParticipantForm(listener);
		
		drawScreen();
		JScrollPane scrollPane = new JScrollPane(participantForm);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		this.add(scrollPane, BorderLayout.CENTER);
		this.setBackground(Color.GREEN);
	}
	
	private void drawScreen()
	{
		//Comment

		
		JLabel     participantNameLabel     = new JLabel("Participant Name");		
		JButton    participantNameButton    = new JButton("Press Me!");
		JTextField participantNameTextField = new JTextField(50);
		
		JPanel participantNamePanel = new JPanel(new FlowLayout());
		
		participantNamePanel.add(participantNameLabel);
		participantNamePanel.add(participantNameTextField);
		participantNamePanel.add(participantNameButton);
		
		Box verticalBox1 = Box.createVerticalBox();
		
		verticalBox1.add(participantNamePanel);
		
		Box horizontalBox = Box.createHorizontalBox();
		
		JButton createButton = new JButton("Create");
		
		horizontalBox.add(createButton);
		
		Box verticalBox2 = Box.createVerticalBox();
		
		JPanel buttonPane = new JPanel();
		
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(createButton);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		
		horizontalBox.setAlignmentX(Box.RIGHT_ALIGNMENT);
		horizontalBox.add(buttonPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static ParticipantForm getForm()
	{
		return participantForm;
	}

}
