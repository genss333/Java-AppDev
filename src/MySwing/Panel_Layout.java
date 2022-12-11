package MySwing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_Layout extends JFrame{
	
	public Panel_Layout() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		int x = 200;
		int y = 150;
		JPanel redpanel = new JPanel();
		redpanel.setBounds(0,0,200,150);
		redpanel.setBackground(Color.red);
		
		
		JPanel bluepanel = new JPanel();
		bluepanel.setBackground(Color.blue);
		bluepanel.setBounds(x,y,200,150);
		
		JPanel greenpanel = new JPanel();
		greenpanel.setBackground(Color.green);
		greenpanel.setBounds(x+x,y+y,200,150);
		
		JButton btn1 = new JButton("BTN1");
		btn1.setBounds(0,20,50,50);
		
		JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.TOP);
		label.setBounds(0,20,50,50);
		redpanel.add(label);
		
		redpanel.setLayout(new BorderLayout());
		
		add(bluepanel);
		add(redpanel);
		add(greenpanel);
	}
	
	
	
	public static void main(String[] args) {
		Panel_Layout panel = new Panel_Layout();
		panel.setSize(900,550);
		panel.setVisible(true);
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
