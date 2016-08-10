public class Main {

	public static void main(String[] args) {

		Interfaz vista = new Vista();
		ColeccionEspectros coleccion = new ColeccionEspectros();
		Controlador controlador = new Controlador(vista, coleccion);
		vista.setControlador(controlador);
		
		vista.start();

	}

}
