package base;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import util.Constants;

public class AutomatedTestingData extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4961387960258853760L;
	private AutomatedTestingCollapsiblePanel participantPanel;
	private AutomatedTestingCollapsiblePanel tokenPanel;
	private AutomatedTestingCollapsiblePanel recipientPanel;
	private AutomatedTestingCollapsiblePanel paymentPanel;
	private AutomatedTestingCollapsiblePanel paymentRequestPanel;
	
	private static BaseDataPanel participantDataPanel;
	private static BaseDataPanel tokenDataPanel;
	private static BaseDataPanel recipientDataPanel;
	private static BaseDataPanel paymentDataPanel;
	private static BaseDataPanel paymentRequestDataPanel;
	
	private DefaultTableModel participantDataModel;
	private DefaultTableModel tokenDataModel;
	private DefaultTableModel recipientDataModel;
	private DefaultTableModel paymentDataModel;
	private DefaultTableModel paymentRequestDataModel;
	

	public AutomatedTestingData()
	{
		super();
		//this.setPreferredSize(new Dimension(450, 100));
				
		JPanel masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());		
		Box box = Box.createVerticalBox();
		
		createTableModels();
		
		participantDataPanel = new BaseDataPanel(participantDataModel, Constants.participantHeaders, "participant");
		tokenDataPanel = new BaseDataPanel(tokenDataModel, Constants.tokenHeaders, "token");
		recipientDataPanel = new BaseDataPanel(recipientDataModel, Constants.recipientHeaders, "recipient");
		paymentDataPanel = new BaseDataPanel(paymentDataModel, Constants.paymentHeaders, "payment");
		paymentRequestDataPanel = new BaseDataPanel(paymentRequestDataModel, Constants.paymentRequestHeaders, "paymentrequest");
		
		participantPanel = new AutomatedTestingCollapsiblePanel("CXCParticipant", participantDataPanel);
		tokenPanel = new AutomatedTestingCollapsiblePanel("CXCToken", tokenDataPanel);
		recipientPanel = new AutomatedTestingCollapsiblePanel("CXCRecipient", recipientDataPanel);
		paymentPanel = new AutomatedTestingCollapsiblePanel("CXCPayment", paymentDataPanel);
		paymentRequestPanel = new AutomatedTestingCollapsiblePanel("CXCPaymentRequest", paymentRequestDataPanel);
				
		box.add(participantPanel);
		box.add(tokenPanel);
		box.add(recipientPanel);
		box.add(paymentPanel);
		box.add(paymentRequestPanel);
		masterPanel.add(box, BorderLayout.NORTH);

				
		JScrollPane pane = new JScrollPane(masterPanel);
		pane.setBackground(Constants.DARK_SLATE_GREY);
		pane.getVerticalScrollBar().setUnitIncrement(16);
		this.setLayout(new BorderLayout());
		this.add(pane, BorderLayout.CENTER);
		this.setBackground(Constants.LIGHT_SLATE_GREY);
		this.setVisible(true);

	}
	
	private void createTableModels()
	{
		participantDataModel = new DefaultTableModel(0,0)
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 2510943009383907042L;

			@Override
				public boolean isCellEditable(int row, int column) {
				   //all cells false
				   return false;
				}
		};
		participantDataModel.setColumnIdentifiers(Constants.participantHeaders);
		
		tokenDataModel = new DefaultTableModel(0,0)
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 2510943009383907042L;

			@Override
				public boolean isCellEditable(int row, int column) {
				   //all cells false
				   return false;
				}
		};
		tokenDataModel.setColumnIdentifiers(Constants.tokenHeaders);
		
		recipientDataModel = new DefaultTableModel(0,0)
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 2510943009383907042L;

			@Override
				public boolean isCellEditable(int row, int column) {
				   //all cells false
				   return false;
				}
		};
		recipientDataModel.setColumnIdentifiers(Constants.recipientHeaders);
		
		paymentDataModel = new DefaultTableModel(0,0)
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 2510943009383907042L;

			@Override
				public boolean isCellEditable(int row, int column) {
				   //all cells false
				   return false;
				}
		};
		paymentDataModel.setColumnIdentifiers(Constants.paymentHeaders);
		
		paymentRequestDataModel = new DefaultTableModel(0,0)
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 2510943009383907042L;

			@Override
				public boolean isCellEditable(int row, int column) {
				   //all cells false
				   return false;
				}
		};
		paymentRequestDataModel.setColumnIdentifiers(Constants.paymentRequestHeaders);
	}
	
	public static BaseDataPanel getParticipantPanel()
	{
		return participantDataPanel;
	}
	public static BaseDataPanel getTokenPanel()
	{
		return tokenDataPanel;
	}
	public static BaseDataPanel getRecipientPanel()
	{
		return recipientDataPanel;
	}
	public static BaseDataPanel getPaymentPanel()
	{
		return paymentDataPanel;
	}
	public static BaseDataPanel getPaymentRequestPanel()
	{
		return paymentRequestDataPanel;
	}
	
	public static int getColumnIndex(String columnName)
	{		
		int index = 0;
		DefaultTableModel participantTableModel = AutomatedTestingData.getParticipantPanel().getData();
		
		for (int i = 0; i < 1; i++)
		{
			for (int j = 0; j < participantTableModel.getColumnCount(); j++)
			{
				if (participantTableModel.getValueAt(i, j).toString().equalsIgnoreCase(columnName))
				{
					index = j;
				}
			}
		}
		
		return index;
	}
}
