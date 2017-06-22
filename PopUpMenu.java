package util;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import base.AutomatedTestingData;

public class PopUpMenu extends JPopupMenu implements ActionListener{
	    
	private JMenuItem deleteItem;
	private String panel = "";
	private ArrayList<Integer> rows;
	
	public PopUpMenu(String panel, ArrayList<Integer> rows){
		super();
		
		deleteItem = new JMenuItem("Delete");
		deleteItem.addActionListener(this);
	    add(deleteItem);
	    this.panel = panel;
	    this.rows = rows;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String output = "";
		boolean delete = false;
		String ID = "";		
		
		for(Integer row : rows)
		{
			if (panel.equalsIgnoreCase("participant"))
			{
				ID = (String) AutomatedTestingData.getParticipantPanel().getData().getValueAt(row, 0);
			}
			else if (panel.equalsIgnoreCase("token"))
			{
				ID = (String) AutomatedTestingData.getTokenPanel().getData().getValueAt(row, 0);
			}
			else if (panel.equalsIgnoreCase("recipient"))
			{
				ID = (String) AutomatedTestingData.getRecipientPanel().getData().getValueAt(row, 0);
			}
			else if (panel.equalsIgnoreCase("payment"))
			{
				ID = (String) AutomatedTestingData.getPaymentPanel().getData().getValueAt(row, 0);
			}
			else if (panel.equalsIgnoreCase("paymentrequest"))
			{
				ID = (String) AutomatedTestingData.getPaymentRequestPanel().getData().getValueAt(row, 0);
			}
			
			output += "<li>" + ID + "</li>";
		}
		
		if(!output.isEmpty())
		{
			output = "<html><b>You are about to delete the following rows.<br><ul>" + output + "</ul>Do you want to continue?<br><br>";
			
		}
		else
		{
			output = "<html><b>No rows selected.<br><br>Do you want to continue?<br>";
		}
		
		int results = JOptionPane.showConfirmDialog(null, output, "WARNING", JOptionPane.YES_NO_OPTION, 
				JOptionPane.WARNING_MESSAGE);
		
		
		if (results == JOptionPane.YES_OPTION)
		{
			delete = true;
		}
		
		if (e.getSource() == deleteItem)
		{
			if(delete && panel.equalsIgnoreCase("participant"))
			{
				AutomatedTestingData.getParticipantPanel().removeRows(rows);
			}
			if(delete && panel.equalsIgnoreCase("token"))
			{
				AutomatedTestingData.getTokenPanel().removeRows(rows);
			}
			if(delete && panel.equalsIgnoreCase("recipient"))
			{
				AutomatedTestingData.getRecipientPanel().removeRows(rows);
			}
			if(delete && panel.equalsIgnoreCase("payment"))
			{
				AutomatedTestingData.getPaymentPanel().removeRows(rows);
			}
			if(delete && panel.equalsIgnoreCase("paymentrequest"))
			{
				AutomatedTestingData.getPaymentRequestPanel().removeRows(rows);
			}
		}
	}	
}

