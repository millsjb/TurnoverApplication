package forms;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import base.AutomatedTestingData;

public class PaymentForm extends BaseForm
{		
	
	private int counter = 0;
	private int lastKnownIndex = -1;
	private ArrayList<String> data;
	public PaymentForm()
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
		addRow(AMOUNT, null, true, false);
		addRow(ACCOUNT_BANK_CODE, null, true, false);
		addRow(ACCOUNT_NUMBER, null, true, false);
		addRow(ACCOUNT_TYPE, ACCOUNT_TYPES, false, false);
		addRow(PARTICIPANT_NAME, null, true, false);
		addRow(PARTNER_ID, null, true, false);
		addRow(PARTNER_TYPE, new String[]{"1"}, false, false);
	    		
		// should be hidden
		addRow(ACH_RETURN_CODE, null, true, true);
		addRow(AUDIT_SOURCE, null, true, true);
		addRow(CHANNEL_TYPE, null, true, true);
		addRow(CHECK_FOR_DUPLICATES, YES_NO_VALUES, false, true);
		addRow(DECLINE_MEMO, null, true, true);
		addRow(EXPEDITED, YES_NO_VALUES, false, true);
		addRow(EXPIRATION_TIME, EXPIRATION_TIMES, false, true);
		addRow(FAILURE_REASON_CODE, FAILURE_REASON_CODES, false, true);
		addRow(FAILURE_REASON_DESCRIPTION, null, true, true);
		addRow(FRAUD_DATA, null, true, true); // How is this going to be implemented?	
		addRow(HOST_NAME, null, true, true);
		addRow(INITIATION_TIME, INITIATION_TIMES, false, true);
		addRow(MEMO, null, true, true);
		addRow(PARTICIPANT_ADDRESS_CITY, null, true, true);
		addRow(PARTICIPANT_ADDRESS_LINE_1, null, true, true);
		addRow(PARTICIPANT_ADDRESS_LINE_2, null, true, true);
		addRow(PARTICIPANT_ADDRESS_STATE, null, true, true);
		addRow(PARTICIPANT_ADDRESS_ZIP, null, true, true);
		addRow(PARTICIPANT_ORGANIZATION_ID, null, true, true);
		addRow(PARTICIPANT_PAYMENT_PROFILE_ID, null, true, true);
		addRow(PARTICIPANT_TOKEN, null, true, true);
		addRow(PAYMENT_ID, new String[]{"generated"}, false, true);
		addRow(PAYMENT_REQUEST_ID, null, true, true);
		addRow(PRODUCT_TYPE, PRODUCT_TYPES, false, true);
		addRow(RECIPIENT_FIRST_NAME, null, true, true);
		addRow(RECIPIENT_LAST_NAME, null, true, true);
		addRow(RECIPIENT_ORGANIZATION_ID, null, true, true);
		addRow(RECIPIENT_PAYMENT_PROFILE_ID, null, true, true);
		addRow(RECIPIENT_TOKEN, null, true, true);
		addRow(REQUEST_ID, null, true, true);
		addRow(STATUS, STATUS_VALUES, false, true);
		
		addCreateButton();
		
		generateValueButtonClicked(AMOUNT);
		generateValueButtonClicked(ACCOUNT_BANK_CODE);
		generateValueButtonClicked(ACCOUNT_NUMBER);
		generateValueButtonClicked(PARTICIPANT_NAME);
		generateValueButtonClicked(PARTNER_ID);
		generateValueButtonClicked(ACH_RETURN_CODE);
		generateValueButtonClicked(AUDIT_SOURCE);
		generateValueButtonClicked(CHANNEL_TYPE);
		generateValueButtonClicked(DECLINE_MEMO);
		generateValueButtonClicked(FAILURE_REASON_DESCRIPTION);
		generateValueButtonClicked(FRAUD_DATA);
		generateValueButtonClicked(HOST_NAME);
		generateValueButtonClicked(MEMO);
		generateValueButtonClicked(PARTICIPANT_ADDRESS_CITY);
		generateValueButtonClicked(PARTICIPANT_ADDRESS_LINE_1);
		generateValueButtonClicked(PARTICIPANT_ADDRESS_LINE_2);
		generateValueButtonClicked(PARTICIPANT_ADDRESS_STATE);
		generateValueButtonClicked(PARTICIPANT_ADDRESS_ZIP);
		generateValueButtonClicked(PARTICIPANT_ORGANIZATION_ID);
		generateValueButtonClicked(PARTICIPANT_PAYMENT_PROFILE_ID);
		generateValueButtonClicked(PARTICIPANT_TOKEN);
		generateValueButtonClicked(PAYMENT_REQUEST_ID);
		generateValueButtonClicked(RECIPIENT_FIRST_NAME);
		generateValueButtonClicked(RECIPIENT_LAST_NAME);
		generateValueButtonClicked(RECIPIENT_ORGANIZATION_ID);
		generateValueButtonClicked(RECIPIENT_PAYMENT_PROFILE_ID);
		generateValueButtonClicked(RECIPIENT_TOKEN);
		generateValueButtonClicked(REQUEST_ID);
		
		toggleHideableRows();
	}

	@Override
	protected void generateValueButtonClicked(String name)
	{
		if(name.equals(AMOUNT))
		{
			setFieldValue(name, generateRandomAmount());
		}
		else if(name.equals(ACCOUNT_BANK_CODE))
		{			
			boolean found = false;
			String bankCode = "";
			while(!found)
			{
				bankCode = generateRandomNumber(100000000, 999999999);
				
				final int[] digits = new int[9];
	
				for(int i = 0; i < bankCode.length(); i++)
				{
					digits[i] = Integer.valueOf(bankCode.substring(i, i + 1));
				}
	
				final int[] multipliers = new int[]{3, 7, 1};
				int sum = 0;
	
				for(int i = 0; i < 9; i++)
				{
					sum += digits[i] * multipliers[i % 3];
				}
	
				if(bankCode.length() == 9)
				{
					if(sum % 10 == 0)
					{
						found = true;
					}
				}
			}
			setFieldValue(name, bankCode);

			
		}
		else if(name.equals(ACCOUNT_NUMBER))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(PARTICIPANT_NAME))
		{
			setFieldValue(name, generateRandomFirstName());
		}
		else if(name.equals(PARTNER_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(ACH_RETURN_CODE))
		{
			setFieldValue(name, generateRandomNumber(1, 999));
		}
		else if(name.equals(AUDIT_SOURCE))
		{
			setFieldValue(name, generateRandomSource());
		}
		else if(name.equals(CHANNEL_TYPE))
		{
			setFieldValue(name, generateRandomChannelType());
		}
		else if(name.equals(DECLINE_MEMO))
		{
			setFieldValue(name, generateRandomDeclineMemo());
		}
		else if(name.equals(FAILURE_REASON_DESCRIPTION))
		{
			setFieldValue(name, generateRandomFailureReasonDescription());
		}
		else if(name.equals(FRAUD_DATA))
		{
			setFieldValue(name, generateFraudData()); // need to generate fraud data
		}
		else if(name.equals(HOST_NAME))
		{
			setFieldValue(name, generateRandomHostName());
		}
		else if(name.equals(MEMO))
		{
			setFieldValue(name, generateRandomMemo());
		}
		else if(name.equals(PARTICIPANT_ADDRESS_CITY))
		{
			setFieldValue(name, generateRandomAddressCity());
		}
		else if(name.equals(PARTICIPANT_ADDRESS_LINE_1))
		{
			setFieldValue(name, generateRandomAddressLine1());
		}
		else if(name.equals(PARTICIPANT_ADDRESS_LINE_2))
		{
			setFieldValue(name, generateRandomAddressLine2());
		}
		else if(name.equals(PARTICIPANT_ADDRESS_STATE))
		{
			setFieldValue(name, generateRandomAddressState());
		}
		else if(name.equals(PARTICIPANT_ADDRESS_ZIP))
		{
			setFieldValue(name, generateRandomAddressZip());
		}
		else if(name.equals(PARTICIPANT_ORGANIZATION_ID))
		{
			setFieldValue(name, generateRandomOrganization());
		}
		else if(name.equals(PARTICIPANT_PAYMENT_PROFILE_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(PARTICIPANT_TOKEN))
		{
			setFieldValue(name, generateRandomToken());
		}
		else if(name.equals(PAYMENT_REQUEST_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(RECIPIENT_FIRST_NAME))
		{
			setFieldValue(name, generateRandomFirstName());
		}
		else if(name.equals(RECIPIENT_LAST_NAME))
		{
			setFieldValue(name, generateRandomLastName());
		}
		else if(name.equals(RECIPIENT_ORGANIZATION_ID))
		{
			setFieldValue(name, generateRandomOrganization());
		}
		else if(name.equals(RECIPIENT_PAYMENT_PROFILE_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(RECIPIENT_TOKEN))
		{
			setFieldValue(name, generateRandomToken());
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
			
			tempArrList.add("PAY" + counter++);
			tempArrList.add("status");
			tempArrList.add("pre");
			tempArrList.add("actual");
			
			tempArrList.addAll(tempArrList.size(), Arrays.asList(this.toStringArray()));
			
			String[] tempArr = new String[tempArrList.size()];
			tempArrList.toArray(tempArr);
			
			AutomatedTestingData.getPaymentPanel().addRow(tempArr);
			
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
				AutomatedTestingData.getPaymentPanel().updateRow(lastKnownIndex, tempArr);
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
			setFieldValue(AMOUNT, data.get(7));
			setFieldValue(ACCOUNT_BANK_CODE, data.get(8));
			setFieldValue(ACCOUNT_NUMBER, data.get(9));
			setFieldValue(ACCOUNT_TYPE, data.get(10));
			setFieldValue(PARTICIPANT_NAME, data.get(11));
			setFieldValue(PARTNER_ID, data.get(12));
			setFieldValue(PARTNER_TYPE, data.get(13));
			setFieldValue(ACH_RETURN_CODE, data.get(14));
			setFieldValue(AUDIT_SOURCE, data.get(15));
			setFieldValue(CHANNEL_TYPE, data.get(16));
			setFieldValue(CHECK_FOR_DUPLICATES, data.get(17));
			setFieldValue(DECLINE_MEMO, data.get(18));
			setFieldValue(EXPEDITED, data.get(19));
			setFieldValue(EXPIRATION_TIME, data.get(20));
			setFieldValue(FAILURE_REASON_CODE, data.get(21));
			setFieldValue(FAILURE_REASON_DESCRIPTION, data.get(22));
			setFieldValue(FRAUD_DATA, data.get(23)); // How is this going to be implemented?	
			setFieldValue(HOST_NAME, data.get(24));
			setFieldValue(INITIATION_TIME, data.get(25));
			setFieldValue(MEMO, data.get(26));
			setFieldValue(PARTICIPANT_ADDRESS_CITY, data.get(27));
			setFieldValue(PARTICIPANT_ADDRESS_LINE_1, data.get(28));
			setFieldValue(PARTICIPANT_ADDRESS_LINE_2, data.get(29));
			setFieldValue(PARTICIPANT_ADDRESS_STATE, data.get(30));
			setFieldValue(PARTICIPANT_ADDRESS_ZIP, data.get(31));
			setFieldValue(PARTICIPANT_ORGANIZATION_ID, data.get(32));
			setFieldValue(PARTICIPANT_PAYMENT_PROFILE_ID, data.get(33));
			setFieldValue(PARTICIPANT_TOKEN, data.get(34));
			setFieldValue(PAYMENT_ID, data.get(35));
			setFieldValue(PAYMENT_REQUEST_ID, data.get(36));
			setFieldValue(PRODUCT_TYPE, data.get(37));
			setFieldValue(RECIPIENT_FIRST_NAME, data.get(38));
			setFieldValue(RECIPIENT_LAST_NAME, data.get(39));
			setFieldValue(RECIPIENT_ORGANIZATION_ID, data.get(40));
			setFieldValue(RECIPIENT_PAYMENT_PROFILE_ID, data.get(41));
			setFieldValue(RECIPIENT_TOKEN, data.get(42));
			setFieldValue(REQUEST_ID, data.get(43));
			setFieldValue(STATUS, data.get(44));	
			
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
