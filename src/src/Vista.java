package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class Vista extends JFrame implements Interfaz{
	private JTextField e0;
	private JButton btnOk;
	private JTextField theta;
	private JTextField phi;
	private JTextField e_min;
	private JTextField e_intervalo;
	private JLabel lblResultado;
	/**
	 * Create the application.
	 */
	public Vista() {
		super("Mi aplicaciOn");
		setBounds(100,100,800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Datos", panel1);
		tabs.addTab("Resultado", panel2);
		
		getContentPane().add(tabs);
		e0 = new JTextField();
		e0.setBounds((int) (this.getWidth() * 0.1), (int) (this.getHeight() * 0.2), 116, 22);
		panel1.add(e0);
		e0.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.setActionCommand("ENTER");
		btnOk.setBounds(350, 453, 100, 25);
		panel1.add(btnOk);
		
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos");
		lblIntroduzcaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIntroduzcaLosDatos.setBounds(186, 31, 406, 39);
		panel1.add(lblIntroduzcaLosDatos);
		
		JLabel lblNewLabel = new JLabel("E0");
		lblNewLabel.setBounds(78, 100, 56, 16);
		panel1.add(lblNewLabel);
		
		JLabel lblTheta = new JLabel("Theta");
		lblTheta.setBounds(78, 200, 56, 16);
		panel1.add(lblTheta);
		
		theta = new JTextField();
		theta.setBounds(78, 229, 116, 22);
		panel1.add(theta);
		theta.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Phi");
		lblNewLabel_1.setBounds(78, 300, 56, 16);
		panel1.add(lblNewLabel_1);
		
		phi = new JTextField();
		phi.setBounds(78, 329, 116, 22);
		panel1.add(phi);
		phi.setColumns(10);
		
		JLabel lblEminprimerValor = new JLabel("E_min (primer valor para calcular)");
		lblEminprimerValor.setBounds(476, 100, 213, 16);
		panel1.add(lblEminprimerValor);
		
		e_min = new JTextField();
		e_min.setBounds(476, 129, 116, 22);
		panel1.add(e_min);
		e_min.setColumns(10);
		
		JLabel lblEintervalointervaloParaRecorrer = new JLabel("E_intervalo(intervalo recorrido E_min hasta E_0)");
		lblEintervalointervaloParaRecorrer.setBounds(476, 200, 294, 16);
		panel1.add(lblEintervalointervaloParaRecorrer);
		
		e_intervalo = new JTextField();
		e_intervalo.setBounds(476, 229, 116, 22);
		panel1.add(e_intervalo);
		e_intervalo.setColumns(10);
		
		lblResultado = new JLabel("RESULTADO");
		lblResultado.setBounds(186, 409, 406, 16);
		panel1.add(lblResultado);
	}	

	public double[] getData() {
		double []data = {0.0D,0.0D,0.0D,0.0D,0.0D};
		
		try {
			data[0] = Double.parseDouble(e0.getText());
			data[1] = Double.parseDouble(theta.getText());
			data[2] = Double.parseDouble(phi.getText());
			data[3] = Double.parseDouble(e_min.getText());
			data[4] = Double.parseDouble(e_intervalo.getText());
			
			return data;
		}catch (NumberFormatException e) {
			e.printStackTrace();
			return data;
		}
	}
	
	public void writeData(String s){
		lblResultado.setText(s);
	}
	
	public void setControlador(Controlador c){
		btnOk.addActionListener(c);
		
	}
	
	public void start(){
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
