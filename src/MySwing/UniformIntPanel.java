package MySwing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UniformIntPanel extends JPanel {
	
	final static int IDLE = 0;
	final static int BOUND_ROUND = 1;
	final static int BOUND_NUMBER = 2;
	
	static int status;
	
	static int width;
	static int height;
	
	static int controlHeight = 50;
	
	String boundStr = null;
	String roundStr = null;
	String numberStr = null;
	
	DisplayPanel displayPanel;

	public UniformIntPanel(int width, int height) {
		
		this.width = width;
		this.height = height;
		
		setPreferredSize(new Dimension(this.width, this.height));
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		status = IDLE;
		
		JTabbedPane tabbedPane = new JTabbedPane();
	
		// add(new UniformIntBoundRoundPanel());
		tabbedPane.addTab(UniformIntBoundRoundPanel.title, new UniformIntBoundRoundPanel(this));
		// add(new UniformIntBoundNumber());
		tabbedPane.addTab(UniformIntBoundNumber.title, new UniformIntBoundNumber(this));
		
		add(tabbedPane);
		
		displayPanel = new DisplayPanel(this);
		add(displayPanel);
	} 
	
	public void paintBoundRound(String strBound, String strRound) {
		
		status = BOUND_ROUND;
		boundStr = strBound;
		roundStr = strRound;
		
		displayPanel.repaint();
		
	}
	
	static class DisplayPanel extends JPanel {
	
		UniformIntPanel normalIntPanel;
		
		DisplayPanel(UniformIntPanel normalIntPanel) {
			
			System.out.println("DisplayPanel(UniformIntPanel normalIntPanel)");
			this.normalIntPanel = normalIntPanel;
			setPreferredSize(new Dimension(width, height-controlHeight));
			setOpaque(true);
			setBackground(Color.YELLOW);
			JLabel label = new JLabel("|| DisplayPanel ||");
			label.setBackground(Color.CYAN);
			label.setOpaque(true);
			add(label);
			
		}
		
		// useing paint(Graphics g) will completely override painting components in 
		// the constructor
		// Instead, paintComponent(Graphics g) will additionally paint on top of
		// components painted in the constructor
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			System.out.println("DisplayPanel.paintComponent()");
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.PINK);
			String text = "<<  DisplayPanel  >>";
			FontMetrics matrics = g2.getFontMetrics();
			int oh = matrics.getHeight();
			int size = 30;
			Font font = new Font("Sans serif", Font.BOLD, size);
			g2.setFont(font);
			matrics = g2.getFontMetrics();
			int w = matrics.stringWidth(text);
			int h = matrics.getHeight();
			h += (oh+5);
			g2.drawString(text, (width-w)/2, h);
			
			int x = 10;
			int y = h + size;
			if(normalIntPanel.boundStr != null) {
				g2.setColor(Color.BLUE);
				g2.drawString("boundStr:" + normalIntPanel.boundStr, x, y);
			}
			y += size + 5 ;
			if(normalIntPanel.roundStr != null) {
				g2.setColor(Color.MAGENTA);
				g2.drawString("roundStr:" + normalIntPanel.roundStr, x, y);
			}
			
			y += size + 5 ;
			if(normalIntPanel.numberStr != null) {
				g2.setColor(Color.RED);
				g2.drawString("numberStr:" + normalIntPanel.numberStr, x, y);
			}
		}

		
	}
	
	// for generating, within a bound, 
	static class UniformIntBoundRoundPanel extends JPanel implements ActionListener {
		
		static String title = "UniformIntBoundRoundPanel";	
		
		String strBound = "Bound: ";
		String strRound = "Round: ";
		
		String[] boundList = {"10", "100", "1000", "10000"};
		String[] roundList = {"10", "100", "1000", "10000", "100000", "1000000"};
		
		JComboBox bounds;
		JComboBox rounds;
		
		UniformIntPanel normalIntPanel;
		
		UniformIntBoundRoundPanel(UniformIntPanel normalIntPanel) {

			this.normalIntPanel = normalIntPanel; 
			setPreferredSize(new Dimension(width, controlHeight));
			setBackground(Color.CYAN);
			setOpaque(true);
			add(new JLabel(strBound));
			bounds = new JComboBox(boundList);
			add(bounds);
			
			add(new JLabel(strRound));
			rounds = new JComboBox(roundList);
			add(rounds);
			
			JButton btnGo = new JButton(" Go ");
			btnGo.addActionListener(this);
			add(btnGo);
		}
				
		public void actionPerformed(ActionEvent ev) {
			System.out.println("UniformIntBoundRoundPanel.actionPerformed()");
			String boundsStr = (String)bounds.getSelectedItem();
			String roundsStr = (String)rounds.getSelectedItem();
			
			System.out.println("normalIntPanel:" + normalIntPanel);
			normalIntPanel.paintBoundRound(boundsStr, roundsStr);
		}
	}
	
	// for generating, within a bound, a number of int
	static class UniformIntBoundNumber extends JPanel implements ActionListener {
		
		static String title = "UniformIntBoundNumber";

		String strBound = "Bound: ";
		String strNumber = "Number: ";
		
		String[] boundList = {"10", "100", "1000", "10000"};
		String[] numberList = {"1", "2", "3", "4", "5", "10", "100", "1000", "10000", "100000", "1000000"};

		JComboBox bounds;
		JComboBox number;
		
		UniformIntPanel normalIntPanel;
		
		UniformIntBoundNumber(UniformIntPanel normalIntPanel) {

			this.normalIntPanel = normalIntPanel; 
			setPreferredSize(new Dimension(width, controlHeight));
			setBackground(Color.CYAN);
			setOpaque(true);
			add(new JLabel(strBound));
			bounds = new JComboBox(boundList);
			add(bounds);
			
			add(new JLabel(strNumber));
			number = new JComboBox(numberList);
			add(number);

			JButton btnGo = new JButton(" Go ");
			btnGo.addActionListener(this);
			add(btnGo);

		}
		
		public void actionPerformed(ActionEvent ev) {
			System.out.println("UniformIntBoundRoundPanel.actionPerformed()");
			normalIntPanel.boundStr = (String)bounds.getSelectedItem();
			normalIntPanel.numberStr = (String)number.getSelectedItem();
			
			normalIntPanel.displayPanel.repaint();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		int width = 600;
		int height = 400;
		
		JFrame frame = new JFrame();
		frame.add(new UniformIntPanel(width, height));
		frame.pack();
		frame.setVisible(true);
		
	}

}
