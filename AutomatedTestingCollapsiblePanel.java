package base;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Constants;

public class AutomatedTestingCollapsiblePanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1341871945168743798L;
	private boolean selected;
    JPanel contentPanel_;
    HeaderPanel headerPanel_;
    
 
    private class HeaderPanel extends JPanel implements MouseListener {
        /**
		 * 
		 */
		private static final long serialVersionUID = -292822265445763610L;
		String text_;
        Font font;
        final int OFFSET = 30;
        String openImg = "⇩";
        String closedImg = "⇨";
        boolean open = false;
 
        public HeaderPanel(String text) {
            addMouseListener(this);
            text_ = text;
            font = new Font("sans-serif", Font.PLAIN, 14);
            this.setBackground(Constants.DARK_SLATE_GREY);
            this.setForeground(Constants.WHITE);
            // setRequestFocusEnabled(true);
            setPreferredSize(new Dimension(1000, 30));
            getWidth();
            getHeight();
 
        }
        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            int h = getHeight();
            g2.setFont(font);
            FontRenderContext frc = g2.getFontRenderContext();
            LineMetrics lm = font.getLineMetrics(text_, frc);
            float height = lm.getAscent() + lm.getDescent();
            float x = OFFSET;
            float y = (h + height) / 2 - lm.getDescent();
            
            //logic to determine the state of the data panel (open or closed)
            // for the arrow img
            if (open)
            {
            	g2.drawString(openImg, (int) x, (int) y);
            }
            else
            {
            	g2.drawString(closedImg, (int) x, (int) y);
            }
            
            // draw the panel text
            g2.drawString(text_, x + 20, y);
           
        }
 
        public void mouseClicked(MouseEvent e) {
            toggleSelection();
            
            if (open == false)
            {
            	open = true;
            }
            else
            {
            	open = false;
            }
        }
 
        public void mouseEntered(MouseEvent e) 
        {
        	this.setForeground(Constants.DARK_SLATE_GREY);
        	this.setBackground(Constants.WHITE);
        	this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
 
        public void mouseExited(MouseEvent e) 
        {
        	this.setForeground(Constants.WHITE);
        	this.setBackground(Constants.DARK_SLATE_GREY);
        	this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
 
        public void mousePressed(MouseEvent e) {
        }
 
        public void mouseReleased(MouseEvent e) {
        }
 
    }
 
    public AutomatedTestingCollapsiblePanel(String text, JPanel panel) {
        super(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1, 3, 0, 3);
        gbc.weightx = 1.0;
        gbc.fill = gbc.HORIZONTAL;
        gbc.gridwidth = gbc.REMAINDER;
 
        selected = false;
        headerPanel_ = new HeaderPanel(text);
 
        setBackground(new Color(200, 200, 220));
        contentPanel_ = panel;
 
        add(headerPanel_, gbc);
        add(contentPanel_, gbc);
        contentPanel_.setVisible(false);
 
        JLabel padding = new JLabel();
        gbc.weighty = 1.0;
        add(padding, gbc);
 
    }
 
    public void toggleSelection() {
        selected = !selected;
 
        if (contentPanel_.isShowing())
            contentPanel_.setVisible(false);
        else
            contentPanel_.setVisible(true);
 
        validate();
 
        headerPanel_.repaint();
    }
    
    public HeaderPanel getHeader()
    {
    	return headerPanel_;
    }
 
}
