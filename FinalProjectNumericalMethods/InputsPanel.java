import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputsPanel extends JPanel implements ActionListener{
	
	public JTextField alturaMastil, distanciaCentro;
	public JButton calculate;
	private JLabel aMastil, dMCentro;
	private Simpson calculator;
	private OutputPanel output;
	
	public InputsPanel(OutputPanel res) {
		super();
		this.setPreferredSize(new Dimension(470, 60));
		this.alturaMastil = new JTextField(5);
		this.distanciaCentro = new JTextField(5);
		this.aMastil = new JLabel("Altura mastil (ft) : ");
		this.dMCentro = new JLabel("Distancia Mastil / centro (ft): ");
		this.calculate = new JButton("Calcular");
		this.calculator = new Simpson();
		this.output = res;
		this.calculate.addActionListener(this);
		
		
		this.add(this.aMastil);
		this.add(this.alturaMastil);
		this.add(this.dMCentro);
		this.add(this.distanciaCentro);
		this.add(new JLabel("    "));
		this.add(this.calculate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.calculate) {
			try {
				double alturaMastil = Double.parseDouble(this.alturaMastil.getText());
				double distanciaC = Double.parseDouble(this.distanciaCentro.getText());
				double[] variablesSolved = this.calculator.calculateF(alturaMastil, distanciaC);
				
				this.output.FResult.setText(variablesSolved[0] + "");
				this.output.dResult.setText(variablesSolved[1] + "");
				this.output.VResult.setText(variablesSolved[2] + "");
				this.output.TResult.setText(variablesSolved[3] + "");
				this.output.HResult.setText(variablesSolved[4] + "");
				
				double grados = variablesSolved[5] * (180 / Math.PI);
				
				this.output.degreeResult.setText(grados + "");
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Ambos datos deben ser valores numericos");
			}
		}
	}
}
