package MySwing;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class FrameTable extends JFrame{
	
	public FrameTable() {
		
		TableRenderDemo table = new TableRenderDemo();
		setVisible(true);
		setSize(600,600);
		setLocation(500,200);
		setLayout(new GridLayout(0,1));
	}
	
	public static void main(String[] args) {
		new FrameTable();
	}

}
