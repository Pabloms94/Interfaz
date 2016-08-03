public class Main {

	public static void main(String[] args) {

		Modelo modelo = new Modelo();
		Interfaz vista = new Vista();
		ColeccionEspectros coleccion = new ColeccionEspectros();
		Controlador controlador = new Controlador(vista, modelo, coleccion);
		vista.setControlador(controlador);
		
		vista.start();

	}

}
