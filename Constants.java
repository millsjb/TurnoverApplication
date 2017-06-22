package util;
import java.awt.Color;

import java.awt.Color;

public interface Constants
{
	// default dimensions
	public static final int HEIGHT = 1000;
	public static final int WIDTH = 1000;
	
	// Color Scheme
	public static final Color BLUE = new Color(0, 15, 78);
	public static final Color WHITE = Color.WHITE;
	public static final Color ORANGE = new Color(255, 143, 30);
	public static final Color GREEN = new Color(143, 255, 30);
	public static final Color PURPLE = new Color(142,  30,  255);
	public static final Color LIGHT_SLATE_GREY = new Color(85, 85, 85);
	public static final Color DARK_SLATE_GREY = new Color(47, 79, 79);
	
	// Special column headers
	public static final String _ID = "ID";
	public static final String _STATUS = "Status";
	public static final String _ACTION = "Action";
	public static final String _DESCIPTION = "Description";
	public static final String _EXPECTED_RESULTS = "Expected Results";
	public static final String _ACTUAL_RESULTS = "Actual Results";
	public static final String _PREREQUESITES = "Prerequesites";
	public static final String SELECT_TOKEN = "Select Token";
	
	// Shared attributes
	static final String PARTNER_ID = "Partner ID";
	static final String PARTNER_TYPE = "Partner Type";
	static final String FRAUD_DATA = "Fruad Data";
	static final String ACTIVATE_IF_EXISTS = "Activate If Exists";
	static final String HOST_NAME = "Host Name";
	static final String ORGANIZATION_ID = "Organziation ID";
	static final String ACCEPTANCE_MODE = "Acceptance Mode";
	static final String AUDIT_SOURCE = "Audit Source";
	static final String CAN_RECEIVE_EXPEDITED_PAYMENT = "Can Receive Expedited Payment";
	static final String CHANNEL_TYPE = "Channel Type";
	static final String FIRST_NAME = "First Name";
	static final String IGNORE_NAME_MATCHING = "Ignore Name Matching";
	static final String LAST_NAME = "Last Name";
	static final String PAYMENT_PROFILE_ID = "Payment Profile ID";
	static final String TOKEN = "Token";
	static final String TOKEN_TYPE = "Token Type";
	static final String ACCOUNT_BANK_CODE = "Account Bank Code";
	static final String ACCOUNT_NUMBER = "Account Number";
	static final String ACCOUNT_TYPE = "Account Type";
	static final String REQUEST_ID ="Request ID";
	static final String AMOUNT = "Amount";
	static final String PAYMENT_REQUEST_ID = "Payment Request ID";
	
	// CXC Participant specific attributes
	static final String PARTICIPANT_ID = "Participant ID";
	static final String PARTICIPANT_NAME = "Participant Name";
	static final String EFFECTIVE_DATE = "Effective Date";
	static final String EXPIRATION_DATE = "Expiration Date";
	static final String STATUS = "Status";
	
	// CXC Token specific attributes
	static final String CHANGE_REASON = "Change Reason";
	static final String IS_CUSTOMER_SERVICE = "Is Customer Service";
	static final String PAYMENT_PROFILE_STATUS = "Payment Profile Status";
	static final String TOKEN_STATUS = "Token Status";
	
	// CXC Recipient specific attributes
	static final String CURRENT_RECIPIENT_FIRST_NAME = "Current Recipient First Name";
	static final String CURRENT_RECIPIENT_LAST_NAME = "Current Recipient Last Name";
	static final String FRAUD_CHECK_REASON = "Fraud Check Reason";
	static final String FRAUD_CHECK_STATUS = "Fraud Check Status";
	static final String FRAUD_CHECK_VERSION = "Fraud Check Version";
	static final String IGNORE_NAME_MATCH = "Ignore Name Match";
	static final String IS_MATCH_RECIPIENT_PASS_THROUGH = "Is Match Recipient Pass Through";
	static final String IS_OUT_OF_NETWORK = "Is Out Of Network";
	static final String NEW_RECIPIENT_FIRST_NAME = "New Recipient First Name";
	static final String NEW_RECIPIENT_LAST_NAME = "New Recipient Last Name";
	static final String RECIPIENT_ID = "Recipient ID";
	static final String TOKEN_GROUP = "Token Group";
	
	// CXC Payment specific attributes
	static final String ACH_RETURN_CODE = "ACH Return Code";
	static final String CHECK_FOR_DUPLICATES = "Check For Duplicates";
	static final String DECLINE_MEMO = "Decline Memo";
	static final String EXPEDITED = "Expedited";
	static final String FAILURE_REASON_CODE = "Failure Reason Code";
	static final String EXPIRATION_TIME = "Expiration Time";
	static final String FAILURE_REASON_DESCRIPTION = "Failure Reason Description";
	static final String INITIATION_TIME = "Initiation Time";
	static final String MEMO = "Memo";
	static final String PARTICIPANT_ADDRESS_CITY = "Participant Address City";
	static final String PARTICIPANT_ADDRESS_LINE_1 = "Participant Address Line 1";
	static final String PARTICIPANT_ADDRESS_LINE_2 = "Participant Address Line 2";
	static final String PARTICIPANT_ADDRESS_STATE = "Participant Address State";
	static final String PARTICIPANT_ADDRESS_ZIP = "Participant Address Zip";
	static final String PARTICIPANT_ORGANIZATION_ID = "Participant Organization ID";
	static final String PARTICIPANT_PAYMENT_PROFILE_ID = "Participant Payment Profile ID";
	static final String PARTICIPANT_TOKEN = "Participant Token";
	static final String PAYMENT_ID = "Payment ID";
	static final String PRODUCT_TYPE = "Product Type";
	static final String RECIPIENT_FIRST_NAME = "Recipient First Name";
	static final String RECIPIENT_LAST_NAME = "Recipient Last Name";
	static final String RECIPIENT_ORGANIZATION_ID = "Recipient Organization ID";
	static final String RECIPIENT_PAYMENT_PROFILE_ID = "Recipient Payment Profile ID";
	static final String RECIPIENT_TOKEN = "Recipient Token";

	// CXC PaymentRequest specific attributes
	static final String DEACTIVATION_MEMO = "Deactivation Memo";
	static final String DEACTIVATION_REASON = "Deactivation Reason";
	static final String INITIATION_DATE = "Initiation Date";
	static final String REQUESTOR_DETAILS = "Requestor Details";
	static final String REQUESTOR_DETAILS_ID = "Requestor Details ID";
	static final String RESPONDER_NAME = "Responder Name";
	static final String RESPONDER_ORGANIZATION_ID = "Responder Organization ID";
	static final String RESPONDER_PARTICAPANT_ID = "Responder Participant ID";
	static final String RESPONDER_PAYMENT_PROFILE_ID = "Responder Payment Profile ID";
	static final String RESPONDER_TOKEN = "Responder Token";
	static final String RD_BUSINESS_NAME = "Business Name";
	static final String RD_DESCRIPTION = "Description";
	static final String RD_DUE_DATE = "Due Date";
	static final String RD_FIRST_NAME = "First Name";
	static final String RD_FULL_NAME = "Full Name";
	static final String RD_INVOICE_NUMBER = "Invoice Number";
	static final String RD_LAST_NAME = "Last Name";
	static final String RD_ORGANIZATION_ID = "Organization ID";
	static final String RD_PAYMENT_PROFILE_ID = "Payment Profile ID";
	static final String RD_PAYMENT_TERMS = "Payment Terms";
	static final String RD_PURCHASE_ORDER_NUMBER = "Purchase Order Number";
	static final String RD_REQUESTOR_ID = "Requestor ID";
	static final String RD_TOKEN = "Token";
	static final String RD_TOKEN_TYPE = "Token Type";
	
	//Headers
	static final String[] participantHeaders = {"_ID", "_Status", "_Prerequisites","_ActualResult", "_Action", "_Description", "_ExpectedResults",
			"partnerID", "partnerType", "participantID", "participantName", "activateIfExists", "auditSource", "channelType", 
			"effectiveDate", "expirationDate", "fraudData", "hostName", "organizationID", "requestID", "status"}; 
	
	static final String[] paymentHeaders = {"_ID", "_Status", "_Prerequisites","_ActualResult", "_Action", "_Description", "_ExpectedResults",
			"amount", "accountBankCode", "accountNumber", "accountType", "participantName", "partnerID", "partnerType", "achReturnCode",
			"auditSource", "channelType", "checkForDuplicates", "declineMemo", "expedited", "expirationTime", "failureReasonCode", 
			"failureReasonDescription", "fraudData", "hostName", "initiationTime", "Memo", "participantAddressCity", "participantAddressLine1",
			"participantAddressLine2", "participantAddressState", "participantAddressZip", "participantOrganizationID", "participantPaymentProfileID",
			"participantToken", "paymentID", "paymentRequestID", "productType", "recipientFirstName", "recipientLastName", 
			"recipientOrganizationID", "recipientPaymentProfileID", "recipientToken", "requestID", "status"}; 
	
	static final String[] paymentRequestHeaders = {"_ID", "_Status", "_Prerequisites", "_ActualResult", "_Action", "_Description", "_ExpectedResults",
			"amount", "partnerID", "partnerType", "responderToken", "/description", "/firstName", "/lastName", "/token", "/tokenType",
			"/businessName", "/dueDate", "/fullName", "/invoiceNumber", "/organizationID", "/paymentProfileID", "/paymentTerms", 
			"/purchaseOrderNumber", "/requestorID", "auditSource", "channelType", "deactivationMemo", "deactivationReason", "hostName", 
			"initiationDate", "paymentRequestID", "requestID", "requestorDetailsID", "responderName", "responderOrganizationID", 
			"responderParticipantID", "responderPaymentProfileID", "status"};
	
	static final String[] recipientHeaders = {"_ID", "_Status", "_Prerequisites", "_ActualResult", "_Action", "_Description", "_ExpectedResults",
			"partnerID", "partnerType", "currentRecipientFirstName", "currentRecipientLastName", "token", "tokenType",
			"firstName", "lastName", "acceptanceMode", "activateIfExists", "auditSource", "canReceiveExpeditedPayment", 
			"channelType", "fraudCheckReason", "fraudCheckStatus", "fraudCheckVersion", "fraudData", "hostName", "ignoreNameMatch", 
			"isMatchRecipientPassThrough", "isOutOfNetwork", "newRecipientFirstName", "newRecipientLastName", "organizationID",
			"paymentProfileID", "recipientID", "requestID", "status", "tokenGroup"};
	
	static final String[] tokenHeaders = {"_ID", "_Status", "_Prerequisites", "_ActualResult", "_Action", "_Description", "_ExpectedResults",
			"partnerID", "partnerType", "paymentProfileID", "paymentProfileStatus", "token", "tokenStatus", "tokenType", "participantID",
			"acceptanceMode", "accountBankCode", "accountNumber", "accountType", "auditSource", "canReceiveExpeditedPayment",
			"changeReason", "channelType", "firstName", "fraudData", "hostName", "ignoreNameMatching", "isCustomerService",
			"lastName", "organizationID", "requestID"};
	
	// Drop down options
	
	static final String[] YES_NO_VALUES = new String []
	{
		"",
		"N", 
		"Y"		
	};
	
	static final String[] ACTIONS = new String []
	{
		"",
		"CREATE", 
		"UPDATE",
		"DELETE"
	};
	
	static final String[] EXPECTED_RESULTS = new String []
	{
		"",
		"SUCCESS",
		"FAILURE"
	};
	
	static final String[] ACTUAL_RESULTS = new String []
	{
		""
	};
	
	static final String[] STATUS_VALUES = new String []
	{
		"A", 
		"I"		
	};
	
	static final String[] FRAUD_CHECK_STATUSES = new String []
	{
		"Y", 
		"N",
		"U"
	};
	
	static final String[] TOKEN_TYPES = new String []
	{
		"E", 
		"M"		
	};
	
	static final String[] ACCEPTANCE_MODES = new String []
	{
		"A", 
		"M"		
	};
	
	static final String[] ACCOUNT_TYPES = new String []
	{
		"C", 
		"S"		
	};
	
	static final String[] CHANGE_REASONS = new String []
	{
		"U", 
		"C"		
	};
	
	static final String[] DUE_DATES = new String []
	{
		"2018-07-16T19:20:30+01:00", 
		"2019-07-16T19:20:30+01:00", 
		"2020-07-16T19:20:30+01:00", 
		"2021-07-16T19:20:30+01:00"	
	};
	
	static final String[] EFFECTIVE_DATES = new String []
	{
		"2017-07-16T19:20:30+01:00", 
		"2016-07-16T19:20:30+01:00", 
		"2015-07-16T19:20:30+01:00", 
		"2014-07-16T19:20:30+01:00"	
	};
	
	static final String[] EXPIRATION_DATES = new String []
	{
		"2018-07-16T19:20:30+01:00", 
		"2019-07-16T19:20:30+01:00", 
		"2020-07-16T19:20:30+01:00", 
		"2021-07-16T19:20:30+01:00"	
	};
	
	static final String[] EXPIRATION_TIMES = new String []
	{
		"2018-07-16T19:20:30+01:00", 
		"2019-07-16T19:20:30+01:00", 
		"2020-07-16T19:20:30+01:00", 
		"2021-07-16T19:20:30+01:00"	
	};
	
	static final String[] INITIATION_TIMES = new String []
	{
		"2017-07-16T19:20:30+01:00", 
		"2016-07-16T19:20:30+01:00", 
		"2015-07-16T19:20:30+01:00", 
		"2014-07-16T19:20:30+01:00"	
	};
	
	static final String[] FAILURE_REASON_CODES = new String[] 
	{
		"A", 
		"R", 
		"C",
		"P",
		"P",
		"D",
		"X",
		"N",
		"O",
		"M",
		"L",
		"I",
		"U"
	};
	
	static final String[] PRODUCT_TYPES = new String[] 
	{
		"P", 
		"C", 
		"B"
	};
	
	static final String[] DEACTIVATION_REASONS = new String[] 
	{
		"Deactivation Reason 1", 
		"Deactivation Reason 2", 
		"Deactivation Reason 3"
	};
	
	
	// Constants for random generation
	
	// List of random names for randomNameGenerator
	static final String[] RANDOM_NAMES = new String[] 
	{
		"Tester One", 
		"Tester Two", 
		"Tester Three", 
		"Tester Four", 
		"Tester Five",
		"Tester Hana",
		"John Doe",
		"Jane Doe",
		"Tester Yul",
		"Jimmy Page",
		"Hannah Page"
	};
	
	static final String[] RANDOM_FIRST_NAMES = new String[] 
	{
		"Tester", 
		"Tester", 
		"Tester", 
		"Tester", 
		"Tester",
		"Tester",
		"John",
		"Jane",
		"Tester",
		"Jimmy",
		"Hannah"
	};
	
	static final String[] RANDOM_LAST_NAMES = new String[] 
	{
		"One", 
		"Two", 
		"Three", 
		"Four", 
		"Five",
		"Hana",
		"Doe",
		"Doe",
		"Yul",
		"Page",
		"Page"
	};
	
	static final String[] RANDOM_BUSINESS_NAMES = new String[]
	{
		"Business 1",
		"Business 2",
		"Business 3"
	};
	
	static final String[] RANDOM_PAYMENT_TERMS = new String[]
	{
		"Payment Terms 1",
		"Payment Terms 2",
		"Payment Terms 3"
	};
	
	static final String[] RANDOM_TOKENS = new String[] 
	{
		"testerone@email.com", 
		"testertwo@email.com", 
		"testerthree@email.com", 
		"testerfour@email.com", 
		"testerfive@email.com",
		"testerhana@email.com",
		"johndoe@email.com",
		"janedoe@email.com",
		"testeryul@email.com",
		"Jimmypage@email.com",
		"hannahpage@email.com",
		"19875861145",
		"95516518651",
		"9846516516",
		"2586546565"
	};
	
	static final String[] RANDOM_SOURCES = new String[] 
	{
		"Audit 1", 
		"Audit 2", 
		"Audit 3"
	};
	
	static final String[] RANDOM_CHANNEL_TYPES = new String[] 
	{
		"SIT", 
		"DEV", 
		"VDI"
	};
	
	static final String[] RANDOM_HOST_NAMES = new String[] 
	{
		"IP 1", 
		"localhost", 
		"5884"
	};
	
	static final String[] RANDOM_ORGANIZATIONS = new String[] 
	{
		"BBD", 
		"BBT", 
		"BBU"
	};
	
	static final String[] RANDOM_FRAUD_CHECK_REASONS = new String[] 
	{
		"Reason 1", 
		"Reason 2", 
		"Reason 3"
	};
	
	static final String[] RANDOM_FRAUD_CHECK_VERSIONS = new String[] 
	{
		"Version 1", 
		"Version 2", 
		"Version 3"
	};
	
	static final String[] RANDOM_FRAUD_DATA_EXAMPLES = new String[] 
	{
		"Example 1", 
		"Example 2", 
		"Example 3"
	};
	
	static final String[] RANDOM_AMOUNTS = new String[] 
	{
		"1.01", 
		"100.00",  
		"95.01", 
		"24.00", 
		"1.01", 
		"1000.21", 
		"1010.0", 
		"1.02", 
		"1.03", 
		"1.04", 
		"1.05" 
	};
	
	static final String[] RANDOM_DECLINE_MEMOS = new String[] 
	{
		"Decline Memo 1", 
		"Decline Memo 2",  
		"Decline Memo 3", 
		"Decline Memo 4", 
		"Decline Memo 5" 
	};
	
	static final String[] RANDOM_DEACTIVATION_MEMOS = new String[] 
	{
		"Deactivation Memo 1", 
		"Deactivation Memo 2",  
		"Deactivation Memo 3", 
		"Deactivation Memo 4", 
		"Deactivation Memo 5" 
	};
	
	static final String[] RANDOM_FAILURE_REASON_DESCRIPTIONS = new String[] 
	{
		"Description 1", 
		"Description 2",  
		"Description 3", 
		"Description 4", 
		"Description 5" 
	};
	
	static final String[] RANDOM_MEMOS = new String[] 
	{
		"Memo 1", 
		"Memo 2",  
		"Memo 3", 
		"Memo 4", 
		"Memo 5" 
	};
	
	static final String[] RANDOM_ADDRESS_CITIES = new String[] 
	{
		"Charlotte", 
		"Boston",  
		"New York City", 
		"Los Angeles", 
		"Toronto", 
		"Montreal", 
		"Beijing", 
		"Chicago", 
		"Atlanta", 
		"Miami" 
	};
	
	static final String[] RANDOM_ADDRESS_LINE_1 = new String[] 
	{
		"427 Crestview Drive", 
		"1246 Evverett Avenue",  
		"7105 Plover Circle", 
		"524 Pecan Street", 
		"1022 Bridges Drive", 
		"712 Admiralty way", 
		"3809 Shawnee Tr.", 
	};
	
	static final String[] RANDOM_ADDRESS_LINE_2 = new String[] 
	{
		"", 
		"", 
		"Apt. 201",  
		"Apt. 983"
	};
	
	static final String[] RANDOM_ADDRESS_STATE = new String[] 
	{
		"NC", 
		"GA",  
		"NY", 
		"CA", 
		"AL", 
		"PA", 
		"FL"
	};
	
	static final String[] RANDOM_ADDRESS_ZIP = new String[] 
	{
		"40204", 
		"76135",  
		"76036", 
		"76012"
	};
	
	static final String[] RANDOM_REQUESTOR_DETAILS = new String[] 
	{
		"Requestor Details 1", 
		"Requestor Details 2",  
		"Requestor Details 3" 
	};
}
