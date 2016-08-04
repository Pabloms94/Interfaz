import org.jfree.data.xy.XYDataset;

public interface Interfaz {

	void setControlador(Controlador c);
	void start();
	
	double[] getData();
	String[] getOptions();

	void writeData(String s);
	
	void graphics(XYDataset dataset1, String opt1, String opt2, int i);
	void showHelp();
	void showAbout();
	
	int getTarget();
	void modificarLista(int i);
	void setElementos(String[] cadena, int contador);
}
