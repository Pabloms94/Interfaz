import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class Controlador implements ActionListener{
	private Interfaz vista;
	private static Modelo modelo;
	static boolean first =true;
	/*static XYSeriesCollection collection = new XYSeriesCollection();
	static XYSeries series = new XYSeries("");*/
	
	public Controlador (Interfaz vista, Modelo modelo){
		this.vista = vista;
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
				
		if (arg0.getActionCommand().equals("ENTER1")){
			double []data = vista.getData();
			modelo.setValor(data);
			vista.writeData("Me ha llegado: " + data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4]);
			
			Runtime rt = Runtime.getRuntime();
			try {
				Process pr = rt.exec(new String[]{"a.exe",String.valueOf(data[0]),String.valueOf(data[1]),String.valueOf(data[2]),String.valueOf(data[3]),String.valueOf(data[4])});
				
	            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
	            
	            String line = null;
	            
	            while((line=input.readLine()) != null) {
	                System.out.println(line);
	            }
	            
	            pr.waitFor();
	            System.out.println("Recibo: " + pr.exitValue());
	            
	            if(pr.exitValue() == 0){
	            	try {
	            		readData();
	            		vista.graphics(modelo.getDataset1());
	            	} catch (FileNotFoundException e) {
	            		e.printStackTrace();
	            	}
	            }else{
	            	vista.writeData("Introduzca los datos correctamente.");
	            }
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}else if (arg0.getActionCommand().equals("ENTER2")){
        	String []options = vista.getOptions();
        	modelo.setOptions(options);
        	
        	modelo.Atenuar();
        	
        	vista.graphics(modelo.getDataset1());        	
		}else
			vista.writeData("ERROR");
		
	}

	public void readData() throws FileNotFoundException{
		JsonParser parser = new JsonParser();
		FileReader fr = new FileReader("x.json");
		JsonElement datos1 = parser.parse(fr);
		
		fr = new FileReader("y.json");
		JsonElement datos2 = parser.parse(fr);
		modelo.setDataset1(crearDataset(datos1, datos2));
	}
	
	public static XYDataset crearDataset (JsonElement datos1, JsonElement datos2){
		double []x = new double [500];
		double []y = new double [500];
		int i = 0;
		
		modelo.series.clear();
		JsonArray array1 = datos1.getAsJsonArray();
        java.util.Iterator<JsonElement> iter1 = array1.iterator();
        JsonArray array2 = datos2.getAsJsonArray();
        java.util.Iterator<JsonElement> iter2 = array2.iterator();
        
        while (iter1.hasNext()) {
            JsonElement entrada = iter1.next();
            JsonPrimitive valor = entrada.getAsJsonPrimitive();
    		x[i] = valor.getAsDouble();
    		entrada = iter2.next();
    		valor = entrada.getAsJsonPrimitive();
    		y[i] = valor.getAsDouble();
    		modelo.series.addOrUpdate(x[i],y[i]);
    		i++;
        }
        modelo.setX(x);
        modelo.setY(y);
        modelo.setNumElem(i);
        if(first)
        	modelo.collection.addSeries(modelo.series);
        first = false;
        return modelo.collection;
	}
}
