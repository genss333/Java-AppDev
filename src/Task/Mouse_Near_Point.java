package Task;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Mouse_Near_Point extends JPanel implements MouseListener, MouseMotionListener {
	
	int width = 600;
	int height = 400;
	Point pointNearMouse;
	int nearness = 2;
	
	ArrayList<Point> points; //Point เรียก generic
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();//ใน panel ออปเจที่สนใจ
		int y = e.getY();//ใน panel ออปเจที่สนใจ
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		pointNearMouse = null;
		Point poly = null;
		for(Iterator<Point> it = points.iterator();it.hasNext();) {
			poly = it.next();
			if(isNear(point,poly)) {
				pointNearMouse = poly;
			}
		}
		
		System.out.println(
				//"source:" + source + 
				//", point:" + point +
				", x:" + x + ", y:" + y + ", xOs:" +xOs + ", yOs:" + yOs);
		points.add(point);
		repaint();
		
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void	mousePressed(MouseEvent e) {
	}

	public void	mouseReleased(MouseEvent e) {
	}

	
	public void mouseDragged(MouseEvent e) {
	}
	
	public void	mouseMoved(MouseEvent e) {
	}
	
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent()");
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		int i = 0;
		for(Iterator<Point> it=points.iterator(); it.hasNext();) {
			Point point = it.next();
			int x = point.x-2;
			int y = point.y-2;
			int w = 5;
			int h = 5;
			if(pointNearMouse !=null && isNear(point,pointNearMouse)) {
				
				g2.fillRect(x, y, w*2, h*2);
				g2.setColor(Color.yellow);
			}
			
			g2.fillRect(x, y, w, h);
		}
		
	}
	
	boolean isNear(Point p1,Point p2) {
		
		boolean near = false;
		int delX = p2.x -p1.x;
		int delY = p2.y - p1.y;
		double distance = Math.sqrt(delX*delX + delY*delY );
		if(Math.round(distance)<=nearness) {
			near = true;
		}
		
		return near;
		
	}
	
	public Mouse_Near_Point() {
		
		setPreferredSize(new Dimension(width, height));
		setOpaque(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		points = new ArrayList<Point>();

	}

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("task2");
		Mouse_Near_Point mouseMove = new Mouse_Near_Point();
		frame.add(mouseMove);
		frame.pack();
		frame.setVisible(true);
	}
}

