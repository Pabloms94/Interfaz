package src;

public class Main {

	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		Interfaz vista = new Vista();
		Controlador controlador = new Controlador(vista, modelo);
		vista.setControlador(controlador);
		
		vista.start();

	}

}
