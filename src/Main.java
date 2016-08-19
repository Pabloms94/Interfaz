/**
 * @brief Clase Main con la cual se inicia la aplicaciOn
 * @author Pablo
 *
 */

public class Main {

	public static void main(String[] args) {

		Interfaz vista = new Vista();
		ColeccionEspectros coleccion = new ColeccionEspectros();
		Controlador controlador = new Controlador(vista, coleccion);
		vista.setControlador(controlador);

		vista.start();

	}

}
