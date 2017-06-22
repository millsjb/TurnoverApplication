package forms;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import base.AutomatedTestingData;

public class PaymentRequestForm extends BaseForm
{	
	private int counter = 0;
	private int lastKnownIndex = -1;
	private ArrayList<String> data;
	public PaymentRequestForm()
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
		addRow(PARTNER_ID, null, true, false);
		addRow(PARTNER_TYPE, new String[]{"1"}, false, false);
		addRow(RESPONDER_TOKEN, null, true, true);
		
		// shoudl be hidden
		addRow(AUDIT_SOURCE, null, true, true);
		addRow(CHANNEL_TYPE, null, true, true);
		addRow(DEACTIVATION_MEMO, null, true, true);
		addRow(DEACTIVATION_REASON, DEACTIVATION_REASONS, false, true);
		addRow(HOST_NAME, null, true, true);
		addRow(INITIATION_DATE, INITIATION_TIMES, false, true); // might need to change to INITIATION_DATES		
		addRow(PAYMENT_REQUEST_ID, null, true, true);
		addRow(REQUEST_ID, null, true, true);
		addRow(REQUESTOR_DETAILS_ID, null, true, true);
		addRow(RESPONDER_NAME, null, true, true);
		addRow(RESPONDER_ORGANIZATION_ID, null, true, true);
		addRow(RESPONDER_PARTICAPANT_ID, null, true, true);
		addRow(RESPONDER_PAYMENT_PROFILE_ID, null, true, true);
		addRow(STATUS, STATUS_VALUES, false, true);
		
		addRow();
		
		addTitle("Requestor Details");
		
		// Requestor Details
		addRow(RD_DESCRIPTION, null, false, false);
		addRow(RD_FIRST_NAME, null, true, false);
		addRow(RD_LAST_NAME, null, true, false);
		addRow(RD_TOKEN, null, true, false);
		addRow(RD_TOKEN_TYPE, TOKEN_TYPES, false, false);
		
		// should be hidden
		addRow(RD_BUSINESS_NAME, null, true, true);
		addRow(RD_DUE_DATE, DUE_DATES, false, true);
		addRow(RD_FULL_NAME, null, true, true);
		addRow(RD_INVOICE_NUMBER, null, true, true);
		addRow(RD_ORGANIZATION_ID, null, true, true);
		addRow(RD_PAYMENT_PROFILE_ID, null, true, true);
		addRow(RD_PAYMENT_TERMS, null, true, true);
		addRow(RD_PURCHASE_ORDER_NUMBER, null, true, true);
		addRow(RD_REQUESTOR_ID, null, true, true);
				
		addCreateButton();
		
		generateValueButtonClicked(AMOUNT);
		generateValueButtonClicked(PARTNER_ID);
		generateValueButtonClicked(RESPONDER_TOKEN);
		generateValueButtonClicked(AUDIT_SOURCE);
		generateValueButtonClicked(CHANNEL_TYPE);
		generateValueButtonClicked(DEACTIVATION_MEMO);
		generateValueButtonClicked(HOST_NAME);
		generateValueButtonClicked(PAYMENT_REQUEST_ID);
		generateValueButtonClicked(REQUEST_ID);
		generateValueButtonClicked(REQUESTOR_DETAILS);
		generateValueButtonClicked(REQUESTOR_DETAILS_ID);
		generateValueButtonClicked(RESPONDER_NAME);
		generateValueButtonClicked(RESPONDER_ORGANIZATION_ID);
		generateValueButtonClicked(RESPONDER_PARTICAPANT_ID);
		generateValueButtonClicked(RESPONDER_PAYMENT_PROFILE_ID);
		generateValueButtonClicked(RD_FIRST_NAME);
		generateValueButtonClicked(RD_LAST_NAME);
		generateValueButtonClicked(RD_TOKEN);
		generateValueButtonClicked(RD_BUSINESS_NAME);
		generateValueButtonClicked(RD_FULL_NAME);
		generateValueButtonClicked(RD_INVOICE_NUMBER);
		generateValueButtonClicked(RD_ORGANIZATION_ID);
		generateValueButtonClicked(RD_PAYMENT_PROFILE_ID);
		generateValueButtonClicked(RD_PAYMENT_TERMS);
		generateValueButtonClicked(RD_PURCHASE_ORDER_NUMBER);
		generateValueButtonClicked(RD_REQUESTOR_ID);
	
		toggleHideableRows();
	}

	@Override
	protected void generateValueButtonClicked(String name)
	{
		if(name.equals(AMOUNT))
		{
			setFieldValue(name, generateRandomAmount());
		}
		else if(name.equals(PARTNER_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(RESPONDER_TOKEN))
		{
			setFieldValue(name, generateRandomToken());
		}
		else if(name.equals(AUDIT_SOURCE))
		{
			setFieldValue(name, generateRandomSource());
		}
		else if(name.equals(CHANNEL_TYPE))
		{
			setFieldValue(name, generateRandomChannelType());
		}
		else if(name.equals(DEACTIVATION_MEMO))
		{
			setFieldValue(name, generateRandomDeactivationMemo());
		}
		else if(name.equals(HOST_NAME))
		{
			setFieldValue(name, generateRandomHostName());
		}
		else if(name.equals(PAYMENT_REQUEST_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(REQUEST_ID))
		{
			setFieldValue(name, generateRandomUUID());
		}		
		else if(name.equals(REQUESTOR_DETAILS_ID))
		{
			setFieldValue(name, generateRandomUUID());
		}
		else if(name.equals(RESPONDER_NAME))
		{
			setFieldValue(name, generateRandomName());
		}
		else if(name.equals(RESPONDER_ORGANIZATION_ID))
		{
			setFieldValue(name, generateRandomOrganization());
		}
		else if(name.equals(RESPONDER_PARTICAPANT_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(RESPONDER_PAYMENT_PROFILE_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(RD_FIRST_NAME))
		{
			setFieldValue(name, generateRandomFirstName());
		}
		else if(name.equals(RD_LAST_NAME))
		{
			setFieldValue(name, generateRandomLastName());
		}
		else if(name.equals(RD_TOKEN))
		{
			setFieldValue(name, generateRandomToken());
		}
		else if(name.equals(RD_BUSINESS_NAME))
		{
			setFieldValue(name, generateRandomBusinessName());
		}
		else if(name.equals(RD_FULL_NAME))
		{
			setFieldValue(name, generateRandomName());
		}
		else if(name.equals(RD_INVOICE_NUMBER))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(RD_ORGANIZATION_ID))
		{
			setFieldValue(name, generateRandomOrganization());
		}
		else if(name.equals(RD_PAYMENT_PROFILE_ID))
		{
			setFieldValue(name, generateRandomNumber(1, 999999999));
		}
		else if(name.equals(RD_PAYMENT_TERMS))
		{
			setFieldValue(name, generateRandomPaymentTerms());
		}
		else if(name.equals(RD_PURCHASE_ORDER_NUMBER))
		{
			setFieldValue(name, generateRandomNumber(1, 9999));
		}
		else if(name.equals(RD_REQUESTOR_ID))
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
			
			tempArrList.add("PR" + counter++);
			tempArrList.add("status");
			tempArrList.add("pre");
			tempArrList.add("actual");
			
			tempArrList.addAll(tempArrList.size(), Arrays.asList(this.toStringArray()));
			
			String[] tempArr = new String[tempArrList.size()];
			tempArrList.toArray(tempArr);
			
			AutomatedTestingData.getPaymentRequestPanel().addRow(tempArr);
			
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
				AutomatedTestingData.getPaymentRequestPanel().updateRow(lastKnownIndex, tempArr);
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
			setFieldValue(PARTNER_ID, data.get(8));
			setFieldValue(PARTNER_TYPE, data.get(9));
			setFieldValue(RESPONDER_TOKEN, data.get(10));	
			setFieldValue(AUDIT_SOURCE, data.get(11));
			setFieldValue(CHANNEL_TYPE, data.get(12));
			setFieldValue(DEACTIVATION_MEMO, data.get(13));
			setFieldValue(DEACTIVATION_REASON, data.get(14));
			setFieldValue(HOST_NAME, data.get(15));
			setFieldValue(INITIATION_DATE, data.get(16));		
			setFieldValue(PAYMENT_REQUEST_ID, data.get(17));
			setFieldValue(REQUEST_ID, data.get(18));
			setFieldValue(REQUESTOR_DETAILS_ID, data.get(19));
			setFieldValue(RESPONDER_NAME, data.get(20));
			setFieldValue(RESPONDER_ORGANIZATION_ID, data.get(21));
			setFieldValue(RESPONDER_PARTICAPANT_ID, data.get(22));
			setFieldValue(RESPONDER_PAYMENT_PROFILE_ID, data.get(23));
			setFieldValue(STATUS, data.get(24));
			setFieldValue(RD_DESCRIPTION, data.get(25));
			setFieldValue(RD_FIRST_NAME, data.get(26));
			setFieldValue(RD_LAST_NAME, data.get(27));
			setFieldValue(RD_TOKEN, data.get(28));
			setFieldValue(RD_TOKEN_TYPE, data.get(29));
			setFieldValue(RD_BUSINESS_NAME, data.get(30));
			setFieldValue(RD_DUE_DATE, data.get(31));
			setFieldValue(RD_FULL_NAME, data.get(32));
			setFieldValue(RD_INVOICE_NUMBER, data.get(33));
			setFieldValue(RD_ORGANIZATION_ID, data.get(34));
			setFieldValue(RD_PAYMENT_PROFILE_ID, data.get(35));
			setFieldValue(RD_PAYMENT_TERMS, data.get(36));
			setFieldValue(RD_PURCHASE_ORDER_NUMBER, data.get(37));
			setFieldValue(RD_REQUESTOR_ID, data.get(38));				
			
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
