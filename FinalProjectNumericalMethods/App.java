import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App extends JFrame{
	
	public App() {
		super("Calculador de tensiones");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OutputPanel outputs = new OutputPanel();
		InputsPanel inputs = new InputsPanel(outputs);
		ImagesPanel images = new ImagesPanel();
		
		this.add(inputs, BorderLayout.NORTH);
		this.add(images, BorderLayout.CENTER);
		this.add(outputs, BorderLayout.SOUTH);
		this.pack();
		
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		App calculate = new App();
	}
}
