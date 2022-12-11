package MySwing;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestGridLayout extends JFrame{
	
	public TestGridLayout() {
		setSize(500,500);
		setVisible(true);
		setLocation(getMousePosition());
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(getPreferredSize());
		
		
	}
	
	public static void main(String[] args) {
		new TestGridLayout();
	}

}
