package SwingTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseMotionListenerExample implements MouseMotionListener {
	public static void main(String args[]) throws Exception {
	    JFrame f = new JFrame("Draw a Red Line");
	    f.setSize(500, 500);
	    f.setLocation(300, 300);
	    f.setResizable(false);
	    JPanel p = new JPanel() {
	        Point pointStart = null;
	        Point pointEnd   = null;
	        {
	            addMouseListener(new MouseAdapter() {
	                public void mousePressed(MouseEvent e) {
	                    pointStart = e.getPoint();
	                }

	                public void mouseReleased(MouseEvent e) {
	                    pointStart = null;
	                }
	            });
	            addMouseMotionListener(new MouseMotionAdapter() {
	                public void mouseMoved(MouseEvent e) {
	                    pointEnd = e.getPoint();
	                }

	                public void mouseDragged(MouseEvent e) {
	                    pointEnd = e.getPoint();
	                    repaint();
	                }
	            });
	        }
	        public void paint(Graphics g) {
	            super.paint(g);
	            if (pointStart != null) {
	                g.setColor(Color.RED);
	                g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
	            }
	        }
	    };
	    f.add(p);
	    f.setVisible(true); 
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
