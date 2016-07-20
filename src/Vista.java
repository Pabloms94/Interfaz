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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Datos", panel1);
		tabs.addTab("Resultado", panel2);
		
		getContentPane().add(tabs);
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[] {388, 388};
		gbl_panel1.rowHeights = new int[] {50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
		gbl_panel1.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel1.setLayout(gbl_panel1);
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		JLabel tittle = new JLabel("Introduzca los datos");
		tittle.setHorizontalAlignment(SwingConstants.CENTER);
		tittle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 0, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		panel1.add(tittle, constraints);
		
		GridBagConstraints constraints1 = new GridBagConstraints();
		JLabel lblE0 = new JLabel("E0");
		lblE0.setHorizontalAlignment(SwingConstants.CENTER);
		constraints1.fill = GridBagConstraints.BOTH;
		constraints1.insets = new Insets(0, 0, 5, 5);
		constraints1.gridx = 0;
		constraints1.gridy = 2;
		constraints1.gridwidth = 1;
		constraints1.gridheight = 1;
		panel1.add(lblE0, constraints1);
		
		GridBagConstraints constraints2 = new GridBagConstraints();
		JLabel lblEmin = new JLabel("E_min (primer valor para calcular)");
		lblEmin.setHorizontalAlignment(SwingConstants.CENTER);
		constraints2.fill = GridBagConstraints.BOTH;
		constraints2.insets = new Insets(0, 0, 5, 0);
		constraints2.gridx = 1;
		constraints2.gridy = 2;
		constraints2.gridwidth = 1;
		constraints2.gridheight = 1;
		panel1.add(lblEmin, constraints2);
		
		GridBagConstraints constraints3 = new GridBagConstraints();
		e0 = new JTextField();
		constraints3.fill = GridBagConstraints.HORIZONTAL;
		constraints3.insets = new Insets(0, 0, 5, 5);
		constraints3.gridx = 0;
		constraints3.gridy = 3;
		constraints3.gridwidth = 1;
		constraints3.gridheight = 1;
		panel1.add(e0, constraints3);
		
		GridBagConstraints constraints4 = new GridBagConstraints();
		e_min = new JTextField();
		constraints4.fill = GridBagConstraints.HORIZONTAL;
		constraints4.insets = new Insets(0, 0, 5, 0);
		constraints4.gridx = 1;
		constraints4.gridy = 3;
		constraints4.gridwidth = 1;
		constraints4.gridheight = 1;
		panel1.add(e_min, constraints4);
		
		GridBagConstraints constraints5 = new GridBagConstraints();
		JLabel lblTheta = new JLabel("Theta");
		lblTheta.setHorizontalAlignment(SwingConstants.CENTER);
		constraints5.fill = GridBagConstraints.BOTH;
		constraints5.insets = new Insets(0, 0, 5, 5);
		constraints5.gridx = 0;
		constraints5.gridy = 4;
		constraints5.gridwidth = 1;
		constraints5.gridheight = 1;
		panel1.add(lblTheta, constraints5);
		
		GridBagConstraints constraints6 = new GridBagConstraints();
		JLabel lblEinterval = new JLabel("E_intervalo(intervalo recorrido E_min - E_0)");
		lblEinterval.setHorizontalAlignment(SwingConstants.CENTER);
		constraints6.fill = GridBagConstraints.BOTH;
		constraints6.insets = new Insets(0, 0, 5, 0);
		constraints6.gridx = 1;
		constraints6.gridy = 4;
		constraints6.gridwidth = 1;
		constraints6.gridheight = 1;
		panel1.add(lblEinterval, constraints6);
		
		GridBagConstraints constraints7 = new GridBagConstraints();
		theta = new JTextField();
		constraints7.fill = GridBagConstraints.HORIZONTAL;
		constraints7.insets = new Insets(0, 0, 5, 5);
		constraints7.gridx = 0;
		constraints7.gridy = 5;
		constraints7.gridwidth = 1;
		constraints7.gridheight = 1;
		panel1.add(theta, constraints7);
		
		GridBagConstraints constraints8 = new GridBagConstraints();
		e_intervalo = new JTextField();
		constraints8.fill = GridBagConstraints.HORIZONTAL;
		constraints8.insets = new Insets(0, 0, 5, 0);
		constraints8.gridx = 1;
		constraints8.gridy = 5;
		constraints8.gridwidth = 1;
		constraints8.gridheight = 1;
		panel1.add(e_intervalo, constraints8);
		
		GridBagConstraints constraints9 = new GridBagConstraints();
		JLabel lblPhi = new JLabel("Phi");
		lblPhi.setHorizontalAlignment(SwingConstants.CENTER);
		constraints9.fill = GridBagConstraints.BOTH;
		constraints9.insets = new Insets(0, 0, 5, 5);
		constraints9.gridx = 0;
		constraints9.gridy = 6;
		constraints9.gridwidth = 1;
		constraints9.gridheight = 1;
		panel1.add(lblPhi, constraints9);
		
		GridBagConstraints constraints10 = new GridBagConstraints();
		phi = new JTextField();
		constraints10.fill = GridBagConstraints.HORIZONTAL;
		constraints10.insets = new Insets(0, 0, 5, 5);
		constraints10.gridx = 0;
		constraints10.gridy = 7;
		constraints10.gridwidth = 1;
		constraints10.gridheight = 1;
		panel1.add(phi, constraints10);
		
		GridBagConstraints constraints11 = new GridBagConstraints();
		lblResultado = new JLabel("RESULTADO");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		constraints11.fill = GridBagConstraints.BOTH;
		constraints11.insets = new Insets(0, 0, 5, 5);
		constraints11.gridx = 0;
		constraints11.gridy = 9;
		constraints11.gridwidth = 2;
		constraints11.gridheight = 1;
		panel1.add(lblResultado, constraints11);
		
		GridBagConstraints constraints12 = new GridBagConstraints();
		btnOk = new JButton("OK");
		btnOk.setActionCommand("ENTER");
		constraints12.fill = GridBagConstraints.CENTER;
		constraints12.insets = new Insets(0, 0, 0, 5);
		constraints12.gridx = 0;
		constraints12.gridy = 10;
		constraints12.gridwidth = 2;
		constraints12.gridheight = 1;
		panel1.add(btnOk, constraints12);
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
