import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OutputPanel extends JPanel{
	public JTextField FResult, dResult, VResult, TResult, HResult, degreeResult;
	private JLabel FLabel, dLabel, VLabel, TLabel, HLabel, DegreeLabel;
	
	public OutputPanel() {
		super();
		this.setPreferredSize(new Dimension(470, 160));
		this.FResult = new JTextField(15);
		this.FResult.setEditable(false);
		this.dResult = new JTextField(15);
		this.dResult.setEditable(false);
		this.VResult = new JTextField(15);
		this.VResult.setEditable(false);
		this.TResult = new JTextField(15);
		this.TResult.setEditable(false);
		this.HResult = new JTextField(15);
		this.HResult.setEditable(false);
		this.degreeResult = new JTextField(15);
		this.degreeResult.setEditable(false);
		
		this.FLabel = new JLabel("Fuerza total equivalente: ");
		this.dLabel = new JLabel("Localizacion de F: ");
		this.VLabel = new JLabel("Reaccion desconocida sobre el mastil ( V ): ");
		this.TLabel = new JLabel("Tension requerida: ");
		this.HLabel = new JLabel("Reaccion desconocida sobre el mastil ( H ): ");
		this.DegreeLabel = new JLabel("Angulo requerido del cable: ");
		
		this.add(this.FLabel);
		this.add(this.FResult);
		this.add(new JLabel("lb/ft                "));
		this.add(this.dLabel);
		this.add(this.dResult);
		this.add(new JLabel("ft"));
		this.add(this.VLabel);
		this.add(this.VResult);
		this.add(this.HLabel);
		this.add(this.HResult);
		this.add(new JLabel("         "));
		this.add(this.TLabel);
		this.add(this.TResult);
		this.add(new JLabel("lb/ft    "));
		this.add(this.DegreeLabel);
		this.add(this.degreeResult);
		this.add(new JLabel("grados"));
	}
	
}
