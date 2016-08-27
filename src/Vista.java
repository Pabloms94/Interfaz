
/**
 * @brief Clase Vista implementarA todo lo relacionado con la interfaz.
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;

import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;

public class Vista extends JFrame implements Interfaz {
	private JTextField e0;
	private JButton btnOk;
	private JTextField theta;
	private JTextField phi;
	private JTextField e_min;
	private JTextField e_intervalo;
	private JLabel lblResultado;

	private boolean first = true;

	JMenuBar menu = new JMenuBar();
	JMenu programa = new JMenu("Programa");
	JMenu ayuda = new JMenu("Ayuda");
	JMenuItem exportar = new JMenuItem("Exportar");
	JMenuItem salir = new JMenuItem("Salir");
	JMenuItem ayudaGral = new JMenuItem("Ayuda General");
	JMenuItem acercaDe = new JMenuItem("Acerca de...");

	private JTabbedPane tabs;
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();

	private JComboBox<String> comboBox;
	private JTextField textField;
	private JButton btnAtenuar;

	DefaultListModel<String> listaModelo = new DefaultListModel<>();
	private JList<String> lista = new JList<>(listaModelo);
	private JScrollPane jsp = new JScrollPane(lista);
	private JButton btnRevertir;

	/**
	 * Create the application.
	 */
	public Vista() {
		super("Xpectra");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("icon.png");
		setIconImage(img.getImage());

		setJMenuBar(menu);
		menu.add(programa);
		menu.add(ayuda);
		programa.add(exportar);
		programa.addSeparator();
		programa.add(salir);
		ayuda.add(ayudaGral);
		ayuda.add(acercaDe);
		exportar.setActionCommand("EXPORTAR");
		exportar.setEnabled(false);
		salir.setActionCommand("SALIR");
		ayudaGral.setActionCommand("AYUDAGRAL");
		acercaDe.setActionCommand("ACERCADE");

		tabs = new JTabbedPane();
		tabs.addTab("Datos", panel1);
		tabs.addTab("Resultado", panel2);
		getContentPane().add(tabs);

		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[] { 388, 388 };
		gbl_panel1.rowHeights = new int[] { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
		gbl_panel1.columnWeights = new double[] { 0, 0 };
		gbl_panel1.rowWeights = new double[] { Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE,
				Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE,
				Double.MIN_VALUE, Double.MIN_VALUE };
		panel1.setLayout(gbl_panel1);

		GridBagLayout gbl_panel2 = new GridBagLayout();
		gbl_panel2.columnWidths = new int[] { 200, 577 };
		gbl_panel2.rowHeights = new int[] { 200, 50, 50, 50, 50, 50, 50 };
		gbl_panel2.columnWeights = new double[] { 0, Double.MIN_VALUE };
		gbl_panel2.rowWeights = new double[] { Double.MIN_VALUE, 0, 0, 0, 0, 0 };
		panel2.setLayout(gbl_panel2);

		GridBagConstraints constraints = new GridBagConstraints();

		JLabel tittle = new JLabel("Introduzca los datos");
		tittle.setHorizontalAlignment(SwingConstants.CENTER);
		tittle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		panel1.add(tittle, constraints);

		GridBagConstraints constraints1 = new GridBagConstraints();
		JLabel lblE0 = new JLabel("E0");
		lblE0.setHorizontalAlignment(SwingConstants.CENTER);
		constraints1.fill = GridBagConstraints.BOTH;
		constraints1.gridx = 0;
		constraints1.gridy = 2;
		constraints1.gridwidth = 1;
		constraints1.gridheight = 1;
		panel1.add(lblE0, constraints1);

		GridBagConstraints constraints2 = new GridBagConstraints();
		JLabel lblEmin = new JLabel("E_min");
		lblEmin.setHorizontalAlignment(SwingConstants.CENTER);
		constraints2.fill = GridBagConstraints.BOTH;
		constraints2.gridx = 1;
		constraints2.gridy = 2;
		constraints2.gridwidth = 1;
		constraints2.gridheight = 1;
		panel1.add(lblEmin, constraints2);

		GridBagConstraints constraints3 = new GridBagConstraints();
		e0 = new JTextField();
		e0.setHorizontalAlignment(SwingConstants.CENTER);
		e0.setText("100");
		constraints3.insets = new Insets(0, 10, 0, 10);
		constraints3.fill = GridBagConstraints.HORIZONTAL;
		constraints3.gridx = 0;
		constraints3.gridy = 3;
		constraints3.gridwidth = 1;
		constraints3.gridheight = 1;
		panel1.add(e0, constraints3);

		GridBagConstraints constraints4 = new GridBagConstraints();
		e_min = new JTextField();
		e_min.setHorizontalAlignment(SwingConstants.CENTER);
		e_min.setText("5");
		constraints4.insets = new Insets(0, 10, 0, 10);
		constraints4.fill = GridBagConstraints.HORIZONTAL;
		constraints4.gridx = 1;
		constraints4.gridy = 3;
		constraints4.gridwidth = 1;
		constraints4.gridheight = 1;
		panel1.add(e_min, constraints4);

		GridBagConstraints constraints5 = new GridBagConstraints();
		JLabel lblTheta = new JLabel("Theta");
		lblTheta.setHorizontalAlignment(SwingConstants.CENTER);
		constraints5.fill = GridBagConstraints.BOTH;
		constraints5.gridx = 0;
		constraints5.gridy = 4;
		constraints5.gridwidth = 1;
		constraints5.gridheight = 1;
		panel1.add(lblTheta, constraints5);

		GridBagConstraints constraints6 = new GridBagConstraints();
		JLabel lblEinterval = new JLabel("E_intervalo");
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
		theta.setText("0");
		theta.setHorizontalAlignment(SwingConstants.CENTER);
		constraints7.insets = new Insets(0, 10, 0, 10);
		constraints7.fill = GridBagConstraints.HORIZONTAL;
		constraints7.gridx = 0;
		constraints7.gridy = 5;
		constraints7.gridwidth = 1;
		constraints7.gridheight = 1;
		panel1.add(theta, constraints7);

		GridBagConstraints constraints8 = new GridBagConstraints();
		e_intervalo = new JTextField();
		e_intervalo.setText("5");
		e_intervalo.setHorizontalAlignment(SwingConstants.CENTER);
		constraints8.insets = new Insets(0, 10, 0, 10);
		constraints8.fill = GridBagConstraints.HORIZONTAL;
		constraints8.gridx = 1;
		constraints8.gridy = 5;
		constraints8.gridwidth = 1;
		constraints8.gridheight = 1;
		panel1.add(e_intervalo, constraints8);

		GridBagConstraints constraints9 = new GridBagConstraints();
		JLabel lblPhi = new JLabel("Phi");
		lblPhi.setHorizontalAlignment(SwingConstants.CENTER);
		constraints9.fill = GridBagConstraints.BOTH;
		constraints9.gridx = 0;
		constraints9.gridy = 6;
		constraints9.gridwidth = 1;
		constraints9.gridheight = 1;
		panel1.add(lblPhi, constraints9);

		GridBagConstraints constraints10 = new GridBagConstraints();
		phi = new JTextField();
		phi.setText("12");
		phi.setHorizontalAlignment(SwingConstants.CENTER);
		constraints10.insets = new Insets(0, 10, 0, 10);
		constraints10.fill = GridBagConstraints.HORIZONTAL;
		constraints10.gridx = 0;
		constraints10.gridy = 7;
		constraints10.gridwidth = 1;
		constraints10.gridheight = 1;
		panel1.add(phi, constraints10);

		GridBagConstraints constraints11 = new GridBagConstraints();
		lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		constraints11.fill = GridBagConstraints.BOTH;
		constraints11.insets = new Insets(0, 0, 5, 5);
		constraints11.gridx = 0;
		constraints11.gridy = 9;
		constraints11.gridwidth = 2;
		constraints11.gridheight = 1;
		panel1.add(lblResultado, constraints11);

		GridBagConstraints constraints12 = new GridBagConstraints();
		btnOk = new JButton("Calcular");
		btnOk.setActionCommand("ENTER1");
		constraints12.fill = GridBagConstraints.CENTER;
		constraints12.gridx = 0;
		constraints12.gridy = 10;
		constraints12.gridwidth = 2;
		constraints12.gridheight = 1;
		panel1.add(btnOk, constraints12);

		GridBagConstraints constraints13 = new GridBagConstraints();
		constraints13.insets = new Insets(0, 0, 5, 0);
		JLabel lbl = new JLabel("Elija:");
		constraints13.gridx = 0;
		constraints13.gridy = 2;
		panel2.add(lbl, constraints13);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "------", "4.csv", "13.csv", "29.csv", "50.csv", "73.csv", "74.csv" }));
		GridBagConstraints constraints14 = new GridBagConstraints();
		constraints14.insets = new Insets(0, 10, 5, 10);
		constraints14.fill = GridBagConstraints.HORIZONTAL;
		constraints14.gridx = 0;
		constraints14.gridy = 3;
		comboBox.setEnabled(false);
		panel2.add(comboBox, constraints14);

		JLabel lblEspesor = new JLabel("Espesor:");
		GridBagConstraints constraints15 = new GridBagConstraints();
		constraints15.insets = new Insets(0, 0, 5, 0);
		constraints15.gridx = 0;
		constraints15.gridy = 4;
		panel2.add(lblEspesor, constraints15);

		textField = new JTextField();
		textField.setEnabled(false);
		GridBagConstraints constraints16 = new GridBagConstraints();
		constraints16.insets = new Insets(0, 10, 5, 10);
		constraints16.fill = GridBagConstraints.HORIZONTAL;
		constraints16.gridx = 0;
		constraints16.gridy = 5;
		panel2.add(textField, constraints16);

		btnAtenuar = new JButton("Atenuar");
		btnAtenuar.setEnabled(false);
		btnAtenuar.setActionCommand("ATENUAR");
		GridBagConstraints constraints17 = new GridBagConstraints();
		constraints17.insets = new Insets(0, 0, 5, 0);
		constraints17.fill = GridBagConstraints.CENTER;
		constraints17.gridx = 0;
		constraints17.gridy = 6;
		panel2.add(btnAtenuar, constraints17);

		GridBagConstraints constraints18 = new GridBagConstraints();
		constraints18.insets = new Insets(0, 0, 5, 0);
		constraints18.fill = GridBagConstraints.BOTH;
		constraints18.gridx = 0;
		constraints18.gridy = 0;
		panel2.add(jsp, constraints18);

		btnRevertir = new JButton("Revertir a la seleccion");
		btnRevertir.setEnabled(false);
		btnRevertir.setActionCommand("REVERTIR");
		GridBagConstraints constraints19 = new GridBagConstraints();
		constraints19.insets = new Insets(0, 0, 5, 0);
		constraints19.fill = GridBagConstraints.CENTER;
		constraints19.gridx = 0;
		constraints19.gridy = 1;
		panel2.add(btnRevertir, constraints19);
	}

	/**
	 * @function getData recoge los datos que el usuario ha introducido.
	 */
	public double[] getData() {
		double[] data = { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };

		try {
			data[0] = Double.parseDouble(e0.getText());
			data[1] = Double.parseDouble(theta.getText());
			data[2] = Double.parseDouble(phi.getText());
			data[3] = Double.parseDouble(e_min.getText());
			data[4] = Double.parseDouble(e_intervalo.getText());

			return data;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return data;
		}
	}

	/**
	 * @function writeData mostrarA los mensajes que la aplicaciOn tenga que
	 *           comunicar al usuario.
	 */
	public void writeData(String s) {
		lblResultado.setText(s);
	}

	/**
	 * @function setControlador establece el controlador que responderA a los
	 *           eventos.
	 */
	public void setControlador(Controlador c) {
		btnOk.addActionListener(c);
		btnAtenuar.addActionListener(c);
		exportar.addActionListener(c);
		salir.addActionListener(c);
		ayudaGral.addActionListener(c);
		acercaDe.addActionListener(c);
		btnRevertir.addActionListener(c);
	}

	/**
	 * @function start iniciarA la aplicaciOn de manera que se haga visible.
	 */
	public void start() {
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * @function graphics pintarA la grAfica correspondiente en el apartado
	 *           generado para ello.
	 * @param dataset1
	 *            contiene las coordenadas a representar.
	 * @param opt1
	 *            usada para crear el historial estableciendo las opciones
	 *            introducidas como marcas distintivas de los espectros.
	 * @param opt2
	 *            usada para crear el historial estableciendo las opciones
	 *            introducidas como marcas distintivas de los espectros.
	 * @param i
	 *            marca a la aplicaciOn el Indice actual en la lista de
	 *            espectros.
	 */
	public void graphics(XYDataset dataset1, String opt1, String opt2, int i) {
		JFreeChart chart = ChartFactory.createScatterPlot("Espectro", "X", "Y", dataset1);
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setDrawSeriesLineAsPath(true);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setRenderer(renderer);
		ChartPanel panel = new ChartPanel(chart);

		GridBagConstraints constraints1 = new GridBagConstraints();
		constraints1.fill = GridBagConstraints.BOTH;
		constraints1.gridx = 1;
		constraints1.gridy = 0;
		constraints1.gridwidth = 1;
		constraints1.gridheight = 7;
		panel2.add(panel, constraints1);

		comboBox.setEnabled(true);
		textField.setEnabled(true);
		btnAtenuar.setEnabled(true);
		btnRevertir.setEnabled(true);
		exportar.setEnabled(true);

		if (opt1.isEmpty() && opt2.isEmpty()) {
			first = true;
		}

		if (first) {
			listaModelo.removeAllElements();
			listaModelo.addElement("Original");
		} else
			listaModelo.addElement("Atenuado: " + opt2 + "cm de " + opt1);

		first = false;
		lista.setSelectedIndex(i);
		tabs.setSelectedIndex(1);
	}

	/**
	 * @function getOptions recoge las opciones introducidas para un espectro
	 *           cuando se quiere atenuar.
	 */
	public String[] getOptions() {
		String[] options = { null, null };

		options[0] = comboBox.getSelectedItem().toString();
		options[1] = textField.getText();

		return options;
	}

	/**
	 * @function showHelp muestra la ayuda cuando el controlador se lo ordene.
	 */
	public void showHelp() {
		String longMessage = "Xpectra implementa modelos de fuentes de rayos X.\n"
				+ "La primera pestaña nos permite introducir datos:\n"
				+ "\tE0: energía con la que el haz de electrones penetra el ánodo de tungsteno.\n"
				+ "\tTheta: ángulo de emisión en grados, estando la normal situada a 90º.\n"
				+ "\tPhi: ángulo de elevación en grados, estando la normal situada a 0º.\n"
				+ "\tE_min: será el primer valor para el que se calculará la función.\n"
				+ "\tE_intervalo: se recorrerá desde E_min hasta E0 en intervalos de la cantidad indicada en este campo.\n\n"
				+ "La segunda pestaña será la que nos represente gráficamente los resultados.\n"
				+ "Podremos atenuar los resultados seleccionando el archivo mu y un valor de atenuación deseados.\n\n"
				+ "Si queremos exportar los datos a un fichero .csv podremos hacerlo desde el menú programa, y la opción exportar.\n";
		JTextArea textArea = new JTextArea(15, 40);
		textArea.setText(longMessage);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		JOptionPane.showMessageDialog(tabs, scrollPane);
	}

	/**
	 * @function showAbout muestra la informaciOn relacionada con la aplicaciOn
	 *           cuando se le ordene.
	 */
	public void showAbout() {
		String longMessage = "Xpectra es un TFG que implementa modelos de fuentes de rayos X.\n" + "Su autor es: \n"
				+ "\tPablo Martín Sánchez\n" + "Sus tutores son: \n" + "\tGuillermo Hernández\n"
				+ "\tMaría Belén Pérez Lancho\n" + "Universidad de Salamanca\n" + "2015-2016";
		JTextArea textArea = new JTextArea(15, 40);
		textArea.setText(longMessage);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		JOptionPane.showMessageDialog(tabs, scrollPane);
	}

	/**
	 * @function getTarget indica al controlador quE elemento de la lista es el
	 *           seleccionado.
	 */
	public int getTarget() {
		return lista.getSelectedIndex();
	}

	/**
	 * @function modificarLista elimina los espectros posteriores al
	 *           seleccionado cuando el usuario quiere revertir a otro espectro.
	 */
	public void modificarLista(int i) {
		int lim = listaModelo.size();

		for (int j = i + 1; j <= lim; j++) {
			try {
				listaModelo.remove(i + 1);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("");
			}
		}
		lista.setSelectedIndex(i);
	}

	/**
	 * @function setElementos crea la lista desplegable de posibles elementos
	 *           con los que atenuar.
	 * @param cadena[]
	 *            es un array de Strings con todos los nombres de los elementos
	 *            que se disponen.
	 * @param contador
	 *            serA el nUmero de elementos que contenga el array;
	 */
	public void setElementos(String[] cadena, int contador) {
		String[] mostrar = new String[contador];

		for (int i = 0; i < contador; i++)
			mostrar[i] = cadena[i];

		comboBox.setModel(new DefaultComboBoxModel<String>(mostrar));
	}
}
