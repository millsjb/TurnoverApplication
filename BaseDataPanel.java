package base;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import panels.CXCParticipantPanel;
import panels.CXCPaymentPanel;
import panels.CXCPaymentRequestPanel;
import panels.CXCRecipientPanel;
import panels.CXCTokenPanel;
import util.PopUpMenu;

public class BaseDataPanel extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 200896519028311437L;
	
	private JTable fields;
	private DefaultTableModel dtm;
	private String panelName;
	
	public BaseDataPanel(DefaultTableModel dtm, String[] headers, String panelName)
	{
		super();
		
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.dtm = dtm;
		this.panelName = panelName;
		
		fields = new JTable(){
		    /**
			 * 
			 */
			private static final long serialVersionUID = 7831367675993322738L;

			@Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		    };
		fields.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		fields.setModel(dtm);
		fields.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		fields.addMouseListener(this);
		
		fields.setFont(new Font("sans-serif", Font.PLAIN, 14));

		//fields.setPreferredSize(new Dimension(AutomatedTestingConstants.WIDTH * 2, 15));
		addRow(headers);
		
		this.add(fields, BorderLayout.CENTER);
	}
	
	public void addRow(String[] rowToAdd)
	{
		dtm.addRow(rowToAdd);
	}
	
	public void updateRow (int rowIndex, String[] data)
	{
		for (int i = 0; i < dtm.getColumnCount(); i++)
		{
			dtm.setValueAt(data[i], rowIndex, i);
		}
	}
	
	public DefaultTableModel getData()
	{
		return dtm;
	}
	
	public void removeRows(ArrayList<Integer> rows) {
		Collections.sort(rows);
		for (int i = rows.size() - 1; i >= 0; i--) {
			if (rows.get(i) > 0 && rows.get(i) < this.dtm.getRowCount())
				this.dtm.removeRow(rows.get(i));
	    }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e, fields.getSelectedRows());
        else if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2 && !e.isConsumed())
        {
        	if (fields.getSelectedRow() > 0)
        	{
	        	ArrayList<String> data = new ArrayList<>();
	        	for (int count = 0; count < dtm.getColumnCount(); count++)
	        	{
	        		data.add(dtm.getValueAt(fields.getSelectedRow(), count).toString());
	        	}
	        	
	        	if (panelName.equalsIgnoreCase("participant"))
	        	{
	        		CXCParticipantPanel.getForm().setValue(data, fields.getSelectedRow());
	        	}
	        	else if (panelName.equalsIgnoreCase("token"))
	        	{
	        		CXCTokenPanel.getTokenForm().setValue(data, fields.getSelectedRow());
	        	}
	        	else if (panelName.equalsIgnoreCase("recipient"))
	        	{
	        		CXCRecipientPanel.getForm().setValue(data, fields.getSelectedRow());
	        	}
	        	else if (panelName.equalsIgnoreCase("payment"))
	        	{
	        		CXCPaymentPanel.getForm().setValue(data, fields.getSelectedRow());
	        	}
	        	else if (panelName.equalsIgnoreCase("paymentrequest"))
	        	{
	        		CXCPaymentRequestPanel.getForm().setValue(data, fields.getSelectedRow());
	        	}
        	}
        }
    }

	@Override
	public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e, fields.getSelectedRows());
    }
	
	private void doPop(MouseEvent e, int[] rows){
    	ArrayList<Integer> items = new ArrayList<>();
    	for (int item : rows)
    	{
    		items.add(item);
    	}
        PopUpMenu menu = new PopUpMenu(panelName, items);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}
