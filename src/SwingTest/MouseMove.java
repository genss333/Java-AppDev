package SwingTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MouseMove extends JPanel implements MouseListener, MouseMotionListener {

	ArrayList<Point> points = new ArrayList<>();
	static boolean isClosed = false;

	MouseMove() {
		JFrame frame = new JFrame("Polygon ON CLICK");
		frame.addMouseListener(this);
		frame.setLocation(500, 100);
		frame.setSize(500, 700);
		frame.add(this);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.setColor(Color.RED);
		for (int i = 1; i < points.size(); i++) {
			int w = 5;
			int h = 5;
			graphics.drawRect((int)points.get(i - 1).getX(), (int) points.get(i - 1).getY(), w, h);
			
			graphics.drawLine((int) points.get(i - 1).getX(), (int) points.get(i - 1).getY(),
					(int) points.get(i).getX(), (int) points.get(i).getY());
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (!isClosed) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				points.add(e.getPoint().getLocation());
			}
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			isClosed = true;
		}
		repaint();
		
		System.out.println("mouseMoved()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println(
				//"source:" + source + 
				", point:" + point +
				", x:" + x + ", y:" + y + ", xOs:" +xOs + ", yOs:" + yOs);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if (!isClosed) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				points.add(e.getPoint().getLocation());
			}
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			isClosed = true;
		}
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
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

	public static void main(String[] args) {
		new MouseMove();
	}

}
