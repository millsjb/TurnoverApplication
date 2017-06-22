package base;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import forms.BaseForm;
import forms.TableRowListener;
import forms.ParticipantForm;
import panels.CXCParticipantPanel;
import panels.CXCPaymentPanel;
import panels.CXCPaymentRequestPanel;
import panels.CXCRecipientPanel;
import panels.CXCTokenPanel;
import util.Constants;

public class AutomatedTestingTabbedPane extends JTabbedPane
	implements TableRowListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2310636151794023194L;
	CXCParticipantPanel participantPanel = new CXCParticipantPanel(this);
	CXCTokenPanel tokenPanel = new CXCTokenPanel();
	CXCRecipientPanel recipientPanel = new CXCRecipientPanel();
	CXCPaymentPanel paymentPanel = new CXCPaymentPanel();
	CXCPaymentRequestPanel paymentRequestPanel = new CXCPaymentRequestPanel();
	//JComponent exportPanel = new ExportPanel();
	
	public AutomatedTestingTabbedPane()
	{
		super();
		
		this.setBackground(Constants.WHITE);
		this.setForeground(Constants.BLUE);
		
		this.setFont(new Font("sans-serif", Font.PLAIN, 16));
		this.addTab("CXCParticipant", participantPanel);
		this.setMnemonicAt(0, KeyEvent.VK_1);
		
		this.addTab("CXCToken", tokenPanel);
		this.setMnemonicAt(1, KeyEvent.VK_2);
		
		this.addTab("CXCRecipient", recipientPanel);
		this.setMnemonicAt(2, KeyEvent.VK_3);
		
		this.addTab("CXCPayment", paymentPanel);
		this.setMnemonicAt(3, KeyEvent.VK_4);
		
		this.addTab("CXCPaymentRequest", paymentRequestPanel);
		this.setMnemonicAt(4, KeyEvent.VK_5);
		
//		this.addTab("Export", exportPanel);
//		this.setMnemonicAt(5, KeyEvent.VK_6);

	}

	@Override
	public void tableRowEvent(BaseForm form) 
	{
		if(form instanceof ParticipantForm)
		{
			tokenPanel.getTokenDropDownForm().updatePullDown();
		}
	}
}
