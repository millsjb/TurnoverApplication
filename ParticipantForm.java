package forms;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import base.AutomatedTestingData;

public class ParticipantForm extends BaseForm
{
	private int counter = 0;
	private int lastKnownIndex = -1;
	private ArrayList<String> data;
	private TableRowListener listener;
	
	public ParticipantForm(TableRowListener listener)
	{
		this.listener = listener;
		
		addTitle("Special Headers");
				
		//Special headers (e.g. _ID)
		addRow(_ACTION, ACTIONS, false, false);
		addRow(_DESCIPTION, null, false, false);
		addRow(_EXPECTED_RESULTS, EXPECTED_RESULTS, false, false);
		
		// empty row used for separation
		addRow();
		
		addTitle("Main Attributes");
		
		// always visible
		addRow(PARTNER_ID, null, true, false);
		addRow(PARTNER_TYPE, new String[]{"1"}, false, false);				
		addRow(PARTICIPANT_ID, null, true, false);
		addRow(PARTICIPANT_NAME, null, true, false);
		
		// should be hidden
		addRow(ACTIVATE_IF_EXISTS, YES_NO_VALUES, false, true);
		addRow(AUDIT_SOURCE, null, true, true);
		addRow(CHANNEL_TYPE, null, true, true);
		addRow(EFFECTIVE_DATE, EFFECTIVE_DATES, false, true);
		addRow(EXPIRATION_DATE, EXPIRATION_DATES, false, true);
		addRow(FRAUD_DATA, null, true, true); // How is this going to be implemented?
		addRow(HOST_NAME, null, true, true);
		addRow(ORGANIZATION_ID, null, true, true);
		addRow(REQUEST_ID, null, true, true);
		addRow(STATUS, STATUS_VALUES, false, true);
		
		addCreateButton();
		
		generateValueButtonClicked(PARTNER_ID);
		generateValueButtonClicked(PARTICIPANT_ID);
		generateValueButtonClicked(PARTICIPANT_NAME);
		generateValueButtonClicked(AUDIT_SOURCE);
		generateValueButtonClicked(CHANNEL_TYPE);
		generateValueButtonClicked(FRAUD_DATA);
		generateValueButtonClicked(HOST_NAME);
		generateValueButtonClicked(ORGANIZATION_ID);
		generateValueButtonClicked(REQUEST_ID);
		
		toggleHideableRows();
	}

	@Override
	protected void generateValueButtonClicked(String name)
	{
		if(name.equals(PARTNER_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(PARTICIPANT_ID))
		{
			setFieldValue(name, generateRandomUUID());
		}
		else if(name.equals(PARTICIPANT_NAME))
		{
			setFieldValue(name, generateRandomName());
		}
		else if(name.equals(AUDIT_SOURCE))
		{
			setFieldValue(name, generateRandomSource());
		}
		else if(name.equals(CHANNEL_TYPE))
		{
			setFieldValue(name, generateRandomChannelType());
		}
		else if(name.equals(FRAUD_DATA))
		{
			setFieldValue(name, generateRandomName());
		}
		else if(name.equals(HOST_NAME))
		{
			setFieldValue(name, generateRandomHostName());
		}
		else if(name.equals(ORGANIZATION_ID))
		{
			setFieldValue(name, generateRandomOrganization());
		}
		else if(name.equals(REQUEST_ID))
		{
			setFieldValue(name, generateRandomUUID());
		}
	}
	
	@Override
	protected void createButtonClicked()
	{		
		if (!toggle)
		{
			if(!validateAllFields())
			{
				return;
			}
			
			ArrayList<String> tempArrList = new ArrayList<String>();
			
			tempArrList.add("PAR" + counter++);
			tempArrList.add("status");
			tempArrList.add("pre");
			tempArrList.add("actual");
			
			tempArrList.addAll(tempArrList.size(), Arrays.asList(this.toStringArray()));
			
			String[] tempArr = new String[tempArrList.size()];
			tempArrList.toArray(tempArr);
			
			AutomatedTestingData.getParticipantPanel().addRow(tempArr);
			
			listener.tableRowEvent(this);
			
			System.out.println(Arrays.toString(tempArr));
		}
		else
		{
			if (lastKnownIndex > 0 && data.size() > 0)
			{
				ArrayList<String> tempArrList = new ArrayList<String>();
				for (int i = 0; i < 4; i++)
				{
					if (data.get(i) == null)
					{
						break;
					}
					else
					{
						tempArrList.add(data.get(i));
					}			
				}
				tempArrList.addAll(tempArrList.size(), Arrays.asList(this.toStringArray()));
				String[] tempArr = new String[tempArrList.size()];
				tempArrList.toArray(tempArr);
				AutomatedTestingData.getParticipantPanel().updateRow(lastKnownIndex, tempArr);
				toggleCreateButton();
			}
				
		}
		
	}
	
	@Override
	protected boolean validateField(String name, String value)
	{
		if(name.equals(_ACTION))
		{
			if(value.isEmpty())
			{
				return false;
			}
		}
		
		if(name.equals(_EXPECTED_RESULTS))
		{
			if(value.isEmpty())
			{
				return false;
			}
		}
		
		if(name.equals(PARTNER_ID))
		{
			if(value.isEmpty() || value.length() > 20)
			{
				return false;
			}
		}
		
		
		return true;
	}
	
	public void setValue(ArrayList<String> data, int index)
	{
		if (!toggle)
		{
			setFieldValue(_ACTION, data.get(4));
			setFieldValue(_DESCIPTION, data.get(5));
			setFieldValue(_EXPECTED_RESULTS, data.get(6));
			setFieldValue(PARTNER_ID, data.get(7));
			setFieldValue(PARTNER_TYPE, data.get(8));				
			setFieldValue(PARTICIPANT_ID, data.get(9));
			setFieldValue(PARTICIPANT_NAME, data.get(10));
			setFieldValue(ACTIVATE_IF_EXISTS, data.get(11));
			setFieldValue(AUDIT_SOURCE, data.get(12));
			setFieldValue(CHANNEL_TYPE, data.get(13));
			setFieldValue(EFFECTIVE_DATE, data.get(14));
			setFieldValue(EXPIRATION_DATE, data.get(15));
			setFieldValue(FRAUD_DATA, data.get(16)); // How is this going to be implemented?
			setFieldValue(HOST_NAME, data.get(17));
			setFieldValue(ORGANIZATION_ID,data.get(18));
			setFieldValue(REQUEST_ID, data.get(19));
			setFieldValue(STATUS, data.get(20));
			
			lastKnownIndex = index;
			this.data = data;
			toggleCreateButton();
		}
		else
		{
			Object[] options = {"Yes", "No"};
			int choice = JOptionPane.showOptionDialog(this, "Cancel row editing?", 
				"Cancel Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
				null, options, options[0]);
			if (choice == 0)
			{
				lastKnownIndex = -1;
				toggleCreateButton();
			}
		}
		
	}

	@Override
	void comboBoxClicked(JComboBox<String> comboBox) {
		// TODO Auto-generated method stub
		
	}
}
