package MySwing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorLayout extends JFrame{
	
	JButton btn1 = new JButton("North");
	JButton btn2 = new JButton("South");
	JButton btn3 = new JButton("Center");
	JButton btn4 = new JButton("Westsssssssss");
	JButton btn5 = new JButton("East");
	
	JPanel west = new JPanel();
	int west_with = 200;
	
	public BorLayout() {
		setLayout(new BorderLayout());
		add(btn1,BorderLayout.NORTH);
		add(btn2,BorderLayout.SOUTH);
		add(btn3,BorderLayout.CENTER);
		add(btn4,BorderLayout.WEST);
		add(btn5,BorderLayout.EAST);
		
	}
	
	public static void main(String[] args) {
		BorLayout frame = new BorLayout();
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}

}
