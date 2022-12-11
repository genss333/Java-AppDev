package SwingTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Randomnumber extends JPanel implements ActionListener {

	Random random;
	int number;
	int bound;
	JTextField txt_bound;
	JLabel txt_number;
	JButton gen;

	int xt = 120;
	int yt = 130;
	int xl = 20;
	int yl = 130;
	int x = 350;
	int y = 100;

	JRadioButton DoubleRadio;

	static String DoubleChoise = "DoubleChoise";
	static String IntegerChoise = "IntegerChoise";

	int[] getInt(int number, int bound) {
		int[] figures = new int[number];
		for (int i = 0; i < number; i++) {
			int figure = random.nextInt(bound);
			figures[i] = figure;
		}
		return figures;
	}

	double[] genGaussian(int number) {

		double[] figures = new double[number];
		for (int i = 0; i < number; i++) {
			double figure = random.nextGaussian();
			figures[i] = figure;
		}
		return figures;
	}

	class RoundedPanel extends JPanel {
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

	class NumberBound extends JTextField {

		public NumberBound() {
			setBounds(xt, yt, 150, 35);
			setFont(new Font(null, Font.PLAIN, 14));
			setForeground(Color.DARK_GRAY);
			setCaretColor(Color.DARK_GRAY);
		}
	}


	public Randomnumber() {

		setBackground(new Color(0xeceff6));
		JPanel panel = new RoundedPanel(30);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(500, 500));

		JRadioButton DoubleRadio = new JRadioButton(DoubleChoise);
		DoubleRadio.setBounds(x, y, 200, 50);
		DoubleRadio.setBackground(Color.white);
		DoubleRadio.setFocusable(false);
		DoubleRadio.setActionCommand(DoubleChoise);
		DoubleRadio.setSelected(true);
		DoubleRadio.addActionListener(this);
		panel.add(DoubleRadio);

		y += 50;

		JRadioButton IntegerRadio = new JRadioButton(IntegerChoise);
		IntegerRadio.setBounds(x, y, 200, 50);
		IntegerRadio.setBackground(Color.white);
		IntegerRadio.setFocusable(false);
		IntegerRadio.setActionCommand(IntegerChoise);
		IntegerRadio.addActionListener(this);
		panel.add(IntegerRadio);

		ButtonGroup group = new ButtonGroup();
		group.add(DoubleRadio);
		group.add(IntegerRadio);

		txt_bound = new NumberBound();
		panel.add(txt_bound);

		JLabel lbbound = new JLabel("BOUND:");
		lbbound.setBounds(xl, yl, 100, 35);
		panel.add(lbbound);
		yl += 100;
		JLabel lbnumber = new JLabel("RANDOM NUMBER:");
		lbnumber.setBounds(xl, yl, 150, 35);
		panel.add(lbnumber);

		txt_number = new JLabel();
		txt_number.setText("0");
		txt_number.setBounds(xl + 200, yl, 200, 35);
		txt_number.setFont(new Font(null, Font.PLAIN, 20));
		panel.add(txt_number);

		add(panel);
	}

	public static void random() {

		JFrame random = new JFrame("Random Number");

		Randomnumber panel = new Randomnumber();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}

		random.setSize(700, 700);
		random.setVisible(true);
		random.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		random.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		random.setLocation(500, 200);

		random.add(panel);
	}

	public static void main(String[] args) {
		random();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		System.out.println("command:" + command);
		Object source = e.getSource();
		System.out.println("source:" + source.toString());

		if (!txt_bound.getText().equals("")) {

			if (command.equals(DoubleChoise)) {

				random = new Random(System.currentTimeMillis());
				number = 1;
				bound = Integer.valueOf(String.valueOf(txt_bound.getText()));
				double[] doubleFigures = genGaussian(number);
				int counter = 0;
				for (double figure : doubleFigures) {

					String count = String.valueOf(doubleFigures[(counter++)]);
					txt_number.setText(count);
				}

			}
			if (command.equals(IntegerChoise)) {

				random = new Random(System.currentTimeMillis());
				number = 1;
				bound = Integer.valueOf(String.valueOf(txt_bound.getText()));
				int[] intFigures = getInt(number, bound);
				int counter = 0;
				for (int figure : intFigures) {

					String count = String.valueOf(intFigures[(counter++)]);
					txt_number.setText(count);
				}
			}
		}

	}

}
