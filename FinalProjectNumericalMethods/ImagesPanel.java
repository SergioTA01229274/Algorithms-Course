import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagesPanel extends JPanel{
	
	public ImagesPanel() {
		super();
		this.setPreferredSize(new Dimension(470, 370));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image fondo = new ImageIcon("mastil.jpg").getImage();
		g.drawImage(fondo, 0, 0, 480, 380, this);
	}
}
