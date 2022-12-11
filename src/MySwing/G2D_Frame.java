package MySwing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class G2D_Frame extends JFrame{
	
	G2D_Panel panel;
	
	public G2D_Frame() {
		setLayout(new BorderLayout());
		setTitle("G2D");
		panel = new G2D_Panel();
		panel.setSize(new Dimension(400,400));
		
		add(panel,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		G2D_Frame  panel = new G2D_Frame();
		panel.setSize(900,550);
		panel.setLocation (500,200);
		panel.setVisible(true);
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
