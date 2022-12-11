package MySwing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class G2D_Panel extends JPanel{
	
	Image image;
	
	public G2D_Panel() {
		image = new ImageIcon("./imge/logo.png").getImage();
	}
	
	public void paint (Graphics g) {
		  Graphics2D g2D = (Graphics2D) g;
		  g2D.drawImage (image, 20, 20, null);
	}

}
