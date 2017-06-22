package forms;

import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import base.AutomatedTestingData;

public class TokenDropDownForm extends BaseForm
{
	private static final long serialVersionUID = 8303506100832467938L;
	
	private TokenForm tokenForm;
	
	public TokenDropDownForm(TokenForm tokenForm)
	{
		this.tokenForm = tokenForm;
		
//		setBorder(BorderFactory.createTitledBorder("Suck it Dan"));

		addRow(SELECT_TOKEN, new String[]{""}, false, false);
	}
	
	public void updatePullDown()
	{
		DefaultTableModel participantTableModel = AutomatedTestingData.getParticipantPanel().getData();
		String[] valueArr = new String[participantTableModel.getRowCount() - 1];

		for (int i = 1; i < participantTableModel.getRowCount(); i++)
		{
			valueArr[i - 1] = participantTableModel.getValueAt(i, AutomatedTestingData.getColumnIndex("partnerID")).toString();
		}
		
		updateComboBox(SELECT_TOKEN, valueArr);
	}
	
	@Override
	boolean validateField(String name, String value) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void generateValueButtonClicked(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void createButtonClicked() {
		// need to populate the 
		
	}

	@Override
	void comboBoxClicked(JComboBox<String> comboBox) 
	{
		if(comboBox.getSelectedIndex() == -1)
		{
			return;
		}
		
		String partnerID = (String) comboBox.getSelectedItem();
		
		if (partnerID.isEmpty())
		{
			tokenForm.setLockedValue(PARTNER_ID, false);
			tokenForm.setLockedValue(PARTNER_TYPE, false);
			tokenForm.setLockedValue(PARTICIPANT_ID, false);
			
			return;
		}
		
		DefaultTableModel participantTableModel = AutomatedTestingData.getParticipantPanel().getData();
		String[] valueArr = new String[participantTableModel.getColumnCount()];
		
		//Get the rows of data from the CXCParticipant table
		//Loop through data to find the matching partnerID
		//Save row of data with matching partnerID		
		
		for (int i = 1; i < participantTableModel.getRowCount(); i++)
		{
			// getColumnIndex will retrieve the index for the specified column
			if (participantTableModel.getValueAt(i, AutomatedTestingData.getColumnIndex("partnerID")).toString().equalsIgnoreCase(partnerID))
			{			
				// save data in row that matches partnerID
				for (int j = 0; j < participantTableModel.getColumnCount(); j++)
				{
					
					valueArr[j] = participantTableModel.getValueAt(i, j).toString();
				}
			}
		}
		
		System.out.println(Arrays.toString(valueArr));
		
		// Use tokenForm.setFieldValue(name, value) to set the participant info
		// set attribute values specific to participant data
		tokenForm.setFieldValue(PARTNER_ID, valueArr[7]);
		tokenForm.setFieldValue(PARTNER_TYPE, valueArr[8]);
		tokenForm.setFieldValue(PARTICIPANT_ID, valueArr[9]);
		
		tokenForm.setLockedValue(PARTNER_ID, true);
		tokenForm.setLockedValue(PARTNER_TYPE, true);
		tokenForm.setLockedValue(PARTICIPANT_ID, true);
		
		
	}
	
}