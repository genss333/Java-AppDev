package Lect1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.*;


public class FontTest extends JPanel {

	public FontTest() {
		
		setPreferredSize(new Dimension(500, 400));
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		Font font = g2.getFont();
		String fontName = font.getName();
		String fontSize = String.valueOf(font.getSize());
		String fontStyle = String.valueOf(font.getStyle());
		System.out.println("font.getName:" + font.getName() 
			+ ", font.getSize:"+ font.getSize()
			+ ", font.getStyle:" + font.getStyle());
		
		System.out.println("font.PLAIN:" + font.PLAIN
				+ ", font.BOLD:" + font.BOLD 
				+ ", font.ITALIC:" + font.ITALIC);
		
		
	    AffineTransform at = new AffineTransform();
	    at.setToRotation(Math.PI / 4.0);
	    g2.setTransform(at);
	    g2.drawString("RotatedString", 100, -10);

		
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("FontTest");
		JPanel panel = new FontTest();
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}

}
