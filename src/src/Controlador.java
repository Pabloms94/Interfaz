package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controlador implements ActionListener {
	private Interfaz vista;
	private Modelo modelo;

	public Controlador (Interfaz vista, Modelo modelo){
		this.vista = vista;
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		double []data = vista.getData();
		
		if (arg0.getActionCommand().equals("ENTER")){
			modelo.setValor(data);
			vista.writeData("Me ha llegado: " + data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4]);
			
			Runtime rt = Runtime.getRuntime();
			try {
				Process pr = rt.exec(new String[]{"../integralesV2/build/a.exe",String.valueOf(data[0]),String.valueOf(data[1]),String.valueOf(data[2]),String.valueOf(data[3]),String.valueOf(data[4])});
				
	            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
	            
	            String line = null;
	            
	            System.out.println("HOLA");
	            while((line=input.readLine()) != null) {
	                System.out.println(line);
	            }
	            
	            pr.waitFor();
	            System.out.println("Recibo: " + pr.exitValue());
	            
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else
			vista.writeData("ERROR");
	}

}
