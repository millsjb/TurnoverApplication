package forms;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import base.AutomatedTestingData;

public class RecipientForm extends BaseForm
{		
	private int counter = 0;
	private int lastKnownIndex = -1;
	private ArrayList<String> data;
	public RecipientForm()
	{
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
		addRow(CURRENT_RECIPIENT_FIRST_NAME, null, true, false);
		addRow(CURRENT_RECIPIENT_LAST_NAME, null, true, false);
		addRow(TOKEN, null, true, false);
		addRow(TOKEN_TYPE, TOKEN_TYPES, false, false);
		addRow(FIRST_NAME, null, true, false);
		addRow(LAST_NAME, null, true, false);
	    		
		// should be hidden
		addRow(ACCEPTANCE_MODE, ACCEPTANCE_MODES, false, true);
		addRow(ACTIVATE_IF_EXISTS, YES_NO_VALUES, false, true);
		addRow(AUDIT_SOURCE, null, true, true);
		addRow(CAN_RECEIVE_EXPEDITED_PAYMENT, YES_NO_VALUES, false, true);
		addRow(CHANNEL_TYPE, null, true, true);
		addRow(FRAUD_CHECK_REASON, new String[]{}, false, true);
		addRow(FRAUD_CHECK_STATUS, FRAUD_CHECK_STATUSES, false, true);
		addRow(FRAUD_CHECK_VERSION, null, true, true);
		addRow(FRAUD_DATA, null, true, true); // How is this going to be implemented?
		addRow(HOST_NAME, null, true, true);
		addRow(IGNORE_NAME_MATCH, YES_NO_VALUES, false, true);
		addRow(IS_MATCH_RECIPIENT_PASS_THROUGH, YES_NO_VALUES, false, true);
		addRow(IS_OUT_OF_NETWORK, YES_NO_VALUES, false, true);
		addRow(NEW_RECIPIENT_FIRST_NAME, null, true, true);
		addRow(NEW_RECIPIENT_LAST_NAME, null, true, true);
		addRow(ORGANIZATION_ID, null, true, true);
		addRow(PAYMENT_PROFILE_ID, null, true, true);
		addRow(RECIPIENT_ID, null, true, true);
		addRow(REQUEST_ID, null, true, true);
		addRow(STATUS, STATUS_VALUES, false, true);
		addRow(TOKEN_GROUP, null, true, true);
		
		addCreateButton();
		
		generateValueButtonClicked(PARTNER_ID);
		generateValueButtonClicked(CURRENT_RECIPIENT_FIRST_NAME);
		generateValueButtonClicked(CURRENT_RECIPIENT_LAST_NAME);
		generateValueButtonClicked(TOKEN);
		generateValueButtonClicked(FIRST_NAME);
		generateValueButtonClicked(LAST_NAME);
		generateValueButtonClicked(AUDIT_SOURCE);
		generateValueButtonClicked(CHANNEL_TYPE);
		generateValueButtonClicked(FRAUD_CHECK_REASON);
		generateValueButtonClicked(FRAUD_CHECK_VERSION);
		generateValueButtonClicked(FRAUD_DATA);
		generateValueButtonClicked(HOST_NAME);
		generateValueButtonClicked(NEW_RECIPIENT_FIRST_NAME);
		generateValueButtonClicked(NEW_RECIPIENT_LAST_NAME);
		generateValueButtonClicked(ORGANIZATION_ID);
		generateValueButtonClicked(PAYMENT_PROFILE_ID);
		generateValueButtonClicked(RECIPIENT_ID);
		generateValueButtonClicked(REQUEST_ID);
		generateValueButtonClicked(TOKEN_GROUP);
		
		toggleHideableRows();
	}

	@Override
	protected void generateValueButtonClicked(String name)
	{
		if(name.equals(PARTNER_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(CURRENT_RECIPIENT_FIRST_NAME))
		{
			setFieldValue(name, generateRandomFirstName());
		}
		else if(name.equals(CURRENT_RECIPIENT_LAST_NAME))
		{
			setFieldValue(name, generateRandomLastName());
		}
		else if(name.equals(TOKEN))
		{
			setFieldValue(name, generateRandomToken());
		}
		else if(name.equals(FIRST_NAME))
		{
			setFieldValue(name, generateRandomFirstName());
		}
		else if(name.equals(LAST_NAME))
		{
			setFieldValue(name, generateRandomLastName());
		}
		else if(name.equals(AUDIT_SOURCE))
		{
			setFieldValue(name, generateRandomSource());
		}
		else if(name.equals(CHANNEL_TYPE))
		{
			setFieldValue(name, generateRandomChannelType());
		}
		else if(name.equals(FRAUD_CHECK_REASON))
		{
			setFieldValue(name, generateRandomFraudCheckReason());
		}
		else if(name.equals(FRAUD_CHECK_VERSION))
		{
			setFieldValue(name, generateRandomFraudCheckVersion());
		}
		else if(name.equals(FRAUD_DATA))
		{
			setFieldValue(name, generateFraudData()); // need to generate fraud data
		}
		else if(name.equals(HOST_NAME))
		{
			setFieldValue(name, generateRandomHostName());
		}
		else if(name.equals(NEW_RECIPIENT_FIRST_NAME))
		{
			setFieldValue(name, generateRandomFirstName());
		}
		else if(name.equals(NEW_RECIPIENT_LAST_NAME))
		{
			setFieldValue(name, generateRandomLastName());
		}
		else if(name.equals(ORGANIZATION_ID))
		{
			setFieldValue(name, generateRandomOrganization());
		}	
		else if(name.equals(PAYMENT_PROFILE_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(RECIPIENT_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}		
		else if(name.equals(REQUEST_ID))
		{
			setFieldValue(name, generateRandomUUID());
		}
		else if(name.equals(TOKEN_GROUP))
		{
			setFieldValue(name, generateRandomNumber(1, 999));
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
			
			tempArrList.add("REC" + counter++);
			tempArrList.add("status");
			tempArrList.add("pre");
			tempArrList.add("actual");
			
			tempArrList.addAll(tempArrList.size(), Arrays.asList(this.toStringArray()));
			
			String[] tempArr = new String[tempArrList.size()];
			tempArrList.toArray(tempArr);
			
			AutomatedTestingData.getRecipientPanel().addRow(tempArr);
			
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
				AutomatedTestingData.getRecipientPanel().updateRow(lastKnownIndex, tempArr);
				toggleCreateButton();
			}
				
		}
	}
	
	@Override
	protected boolean validateField(String name, String value)
	{
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
			setFieldValue(CURRENT_RECIPIENT_FIRST_NAME, data.get(9));
			setFieldValue(CURRENT_RECIPIENT_LAST_NAME, data.get(10));
			setFieldValue(TOKEN, data.get(11));
			setFieldValue(TOKEN_TYPE, data.get(12));
			setFieldValue(FIRST_NAME, data.get(13));
			setFieldValue(LAST_NAME, data.get(14));	    		
			setFieldValue(ACCEPTANCE_MODE,data.get(15));
			setFieldValue(ACTIVATE_IF_EXISTS, data.get(16));
			setFieldValue(AUDIT_SOURCE, data.get(17));
			setFieldValue(CAN_RECEIVE_EXPEDITED_PAYMENT, data.get(18));
			setFieldValue(CHANNEL_TYPE, data.get(19));
			setFieldValue(FRAUD_CHECK_REASON, data.get(20));
			setFieldValue(FRAUD_CHECK_STATUS, data.get(21));
			setFieldValue(FRAUD_CHECK_VERSION, data.get(22));
			setFieldValue(FRAUD_DATA, data.get(23)); // How is this going to be implemented?
			setFieldValue(HOST_NAME, data.get(24));
			setFieldValue(IGNORE_NAME_MATCH, data.get(25));
			setFieldValue(IS_MATCH_RECIPIENT_PASS_THROUGH, data.get(26));
			setFieldValue(IS_OUT_OF_NETWORK, data.get(27));
			setFieldValue(NEW_RECIPIENT_FIRST_NAME, data.get(28));
			setFieldValue(NEW_RECIPIENT_LAST_NAME, data.get(29));
			setFieldValue(ORGANIZATION_ID, data.get(30));
			setFieldValue(PAYMENT_PROFILE_ID, data.get(31));
			setFieldValue(RECIPIENT_ID, data.get(32));
			setFieldValue(REQUEST_ID, data.get(33));
			setFieldValue(STATUS, data.get(34));
			setFieldValue(TOKEN_GROUP, data.get(35));	
			
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
