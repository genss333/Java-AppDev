package dss;

import javax.swing.JFrame;


public class MainApp extends JFrame{

	public MainApp() {
		JFrame frame = new JFrame();
		MainPanel panel = new MainPanel(this);
		frame.add(panel);
		frame.setSize(1200, 800);
		frame.setLocation(500, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new MainApp(); 
		
	}
}
