import org.jfree.data.xy.XYDataset;

public interface Interfaz {

	void setControlador(Controlador c);
	void start();
	
	double[] getData();
	String[] getOptions();

	void writeData(String s);
	
	void graphics(XYDataset dataset1);
	void showHelp();
	void showAbout();
}
