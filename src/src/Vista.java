package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

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
		getContentPane().setLayout(null);
		
		e0 = new JTextField();
		e0.setBounds(78, 129, 116, 22);
		getContentPane().add(e0);
		e0.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.setActionCommand("ENTER");
		btnOk.setBounds(350, 453, 100, 25);
		getContentPane().add(btnOk);
		
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos");
		lblIntroduzcaLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIntroduzcaLosDatos.setBounds(260, 31, 406, 39);
		getContentPane().add(lblIntroduzcaLosDatos);
		
		JLabel lblNewLabel = new JLabel("E0");
		lblNewLabel.setBounds(78, 100, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTheta = new JLabel("Theta");
		lblTheta.setBounds(78, 200, 56, 16);
		getContentPane().add(lblTheta);
		
		theta = new JTextField();
		theta.setBounds(78, 229, 116, 22);
		getContentPane().add(theta);
		theta.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Phi");
		lblNewLabel_1.setBounds(78, 300, 56, 16);
		getContentPane().add(lblNewLabel_1);
		
		phi = new JTextField();
		phi.setBounds(78, 329, 116, 22);
		getContentPane().add(phi);
		phi.setColumns(10);
		
		JLabel lblEminprimerValor = new JLabel("E_min (primer valor para calcular)");
		lblEminprimerValor.setBounds(476, 100, 213, 16);
		getContentPane().add(lblEminprimerValor);
		
		e_min = new JTextField();
		e_min.setBounds(476, 129, 116, 22);
		getContentPane().add(e_min);
		e_min.setColumns(10);
		
		JLabel lblEintervalointervaloParaRecorrer = new JLabel("E_intervalo(intervalo recorrido E_min hasta E_0)");
		lblEintervalointervaloParaRecorrer.setBounds(476, 200, 294, 16);
		getContentPane().add(lblEintervalointervaloParaRecorrer);
		
		e_intervalo = new JTextField();
		e_intervalo.setBounds(476, 229, 116, 22);
		getContentPane().add(e_intervalo);
		e_intervalo.setColumns(10);
		
		lblResultado = new JLabel("RESULTADO");
		lblResultado.setBounds(186, 409, 406, 16);
		getContentPane().add(lblResultado);
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
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
