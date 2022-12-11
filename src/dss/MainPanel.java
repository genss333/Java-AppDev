package dss;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class MainPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MainApp MainApp;

	JButton submit;
	JPanel subpanel;
	BarGraphColor bargraph;
	LineGraph linegraph;

	int width = 200;
	int height = 60;
	int xl = 50;
	int yl = 100;
	int xt = 400;
	int yt = 20;

	class RoundedPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Color backgroundColor;
		private int cornerRadius = 15;

		public RoundedPanel(LayoutManager layout, int radius) {
			super(layout);
			cornerRadius = radius;
		}

		public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
			super(layout);
			cornerRadius = radius;
			backgroundColor = bgColor;
		}

		public RoundedPanel(int radius) {
			super();
			cornerRadius = radius;
		}

		public RoundedPanel(int radius, Color bgColor) {
			super();
			cornerRadius = radius;
			backgroundColor = bgColor;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Dimension arcs = new Dimension(cornerRadius, cornerRadius);
			int width = getWidth();
			int height = getHeight();
			Graphics2D graphics = (Graphics2D) g;
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics.setPaint(Color.white);
			graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint background
			graphics.setColor(getForeground());
		}
	}

	class MainPanelWidget extends JTabbedPane {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MainPanelWidget() {
			setBackground(Color.white);
			setFocusable(false);
			int bound = 127600;
			int[] data = { 127600, 25900, 29990 };
			
			bargraph = new BarGraphColor(bound, data);
			addTab("Product sales", bargraph);
			setMnemonicAt(0, KeyEvent.VK_1);

			linegraph = new LineGraph(bound, data);
			addTab("Product sales Quantity", linegraph);
			setMnemonicAt(1, KeyEvent.VK_2);

		}
	}

	public MainPanel(MainApp Mainframe) {
		
		MainApp = Mainframe;
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

		subpanel = new RoundedPanel(30);
		subpanel.setPreferredSize(new Dimension(850, 650));
		subpanel.setLayout(new BorderLayout());

		MainPanelWidget pane = new MainPanelWidget();
		subpanel.add(pane, BorderLayout.CENTER);
		add(subpanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
