import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class Controlador implements ActionListener{
	private Interfaz vista;
	private static Modelo espectro = new Modelo();
	private static ColeccionEspectros coleccion;
	private XYDataset dataset1;
	static XYSeriesCollection collection = new XYSeriesCollection();
	static XYSeries series = new XYSeries("");
	static boolean first =true;

	String[] cadena = new String[50];
	/*static XYSeriesCollection collection = new XYSeriesCollection();
	static XYSeries series = new XYSeries("");*/
	
	public Controlador (Interfaz vista, ColeccionEspectros coleccion){
		this.vista = vista;
		this.coleccion = coleccion;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
				
		if (arg0.getActionCommand().equals("ENTER1")){
			double []data = vista.getData();
			vista.writeData("Me ha llegado: " + data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4]);
			
			Runtime rt = Runtime.getRuntime();
			try {
				Process pr = rt.exec(new String[]{"xpectraC.exe",String.valueOf(data[0]),String.valueOf(data[1]),String.valueOf(data[2]),String.valueOf(data[3]),String.valueOf(data[4])});
				
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
	            		int contador = readElementos();
	            		vista.setElementos(cadena, contador);
	            		vista.graphics(dataset1,"", "", 0);
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
			
		}else if (arg0.getActionCommand().equals("ATENUAR")){
        	String []options = vista.getOptions();
        	
        	if(options[0] != "------" && !options[1].isEmpty() && Double.parseDouble(options[1]) > 0){
				Modelo newEspectro = new Modelo(coleccion.getEspectro(coleccion.getIndice()-1).getNumElem(), coleccion.getEspectro(coleccion.getIndice()-1).getX(), coleccion.getEspectro(coleccion.getIndice()-1).getY());
        		newEspectro.setOptions(options);
        		
        		System.out.println("VAMOS A ATENUAR QUE TIENE DE INDICE "+coleccion.getIndice());
        		for(int i = 0; i< newEspectro.getNumElem(); i++){
        			
        			System.out.println("X " + newEspectro.X[i]+ " Y "+newEspectro.Y[i]);
        		}
        		
        		
        		newEspectro.Atenuar();
        		series.clear();
        		for(int i = 0; i< newEspectro.getNumElem(); i++){
        			series.addOrUpdate(newEspectro.X[i], newEspectro.Y[i]);
        		}
        		
        		coleccion.setEspectro(newEspectro);
        		
        		vista.graphics(dataset1, options[0], options[1], coleccion.getIndice()-1);  
        	}
        	
        	
		}else if (arg0.getActionCommand().equals("REVERTIR")){
			int target = vista.getTarget();

			if(coleccion.getIndice()-1 > target && target!=0){
				coleccion.revert(target);
				String []options = coleccion.getOptions();
        	
				System.out.println("PINTAR TARGET " + target + " E INDICE " + coleccion.getIndice());
				System.out.println("OPCIONES " + options[0] + " " + options[1]);
				
				vista.modificarLista(target);
				Modelo mostrar = new Modelo(coleccion.getEspectro(target).getNumElem(), coleccion.getEspectro(target).getX(), coleccion.getEspectro(target).getY());

				mostrar.imprimir();
				//mostrar.actualizar();
				series.clear();
				for(int i = 0; i< mostrar.getNumElem(); i++){
        			series.addOrUpdate(mostrar.X[i], mostrar.Y[i]);
        			System.out.println("X " + series.getX(i)+ " Y "+series.getY(i));
        		}
				
				vista.graphics(dataset1, options[0], options[1], target);  
			}else if(coleccion.getIndice()-1 > target && target == 0){
				coleccion.revert(target);
        	
				System.out.println("PINTAR TARGET " + target + " E INDICE " + coleccion.getIndice());
				
				vista.modificarLista(target);
				Modelo mostrar = new Modelo(coleccion.getEspectro(target).getNumElem(), coleccion.getEspectro(target).getX(), coleccion.getEspectro(target).getY());

				mostrar.imprimir();
				//mostrar.actualizar();
				series.clear();
				for(int i = 0; i< mostrar.getNumElem(); i++){
        			series.addOrUpdate(mostrar.X[i], mostrar.Y[i]);
        			System.out.println("X " + series.getX(i)+ " Y "+series.getY(i));
        		}
				
				vista.graphics(dataset1, "", "", target); 
			}
        	      	
		}else if (arg0.getActionCommand().equals("exportar")){
			try {
				FileOutputStream fos = new FileOutputStream("Resultado.xlsx");
				XSSFWorkbook wb = new XSSFWorkbook();
				XSSFSheet sheet = wb.createSheet("Primera hoja");
		
				int rowNum = sheet.getLastRowNum();
				
				for(int i = 0; i < espectro.getNumElem(); i++){
					Row row = sheet.createRow(rowNum++);
					int cellNum = 0;
					for (int j = 0; j < 2; j++){
						Cell cell = row.createCell(cellNum++);
						if(j==0)
							cell.setCellValue(espectro.X[i]);
						else
							cell.setCellValue(espectro.Y[i]);

					}
				}
				
				wb.write(fos);
				fos.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (arg0.getActionCommand().equals("ayudaGral")){
			vista.showHelp();
		}else if (arg0.getActionCommand().equals("acercaDe")){
			vista.showAbout();
		}else if (arg0.getActionCommand().equals("salir")){
			System.exit(0);
		}else
			vista.writeData("ERROR");
		
	}

	public void readData() throws FileNotFoundException{
		JsonParser parser = new JsonParser();
		FileReader fr = new FileReader("x.json");
		JsonElement datos1 = parser.parse(fr);
		
		fr = new FileReader("y.json");
		JsonElement datos2 = parser.parse(fr);
		dataset1 = (crearDataset(datos1, datos2));
		coleccion.setEspectro(espectro);
	}
	
	public static XYDataset crearDataset (JsonElement datos1, JsonElement datos2){
		double []x = new double [500];
		double []y = new double [500];
		int i = 0;
		
		series.clear();
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
    		series.addOrUpdate(x[i],y[i]);
    		i++;
        }
        espectro.setX(x);
        espectro.setY(y);
        espectro.setNumElem(i);
        if(first)
        	collection.addSeries(series);
        else{
        	coleccion.revert(-1);
        	System.out.println("BORRADO");
        }
        first = false;
        return collection;
	}
	
	public int readElementos(){
		File folder = new File("data/mu");
		File[] listOfFiles = folder.listFiles();
		int contador = 1, fila = 0;
		String nombre, extension;
		boolean copiar = false;
		
		cadena[0] = "------";
		for(int i = 0; i < listOfFiles.length; i++){
			nombre = listOfFiles[i].getName();
			extension = nombre.substring(nombre.lastIndexOf(".")+1, nombre.length());
			if (extension.equals("csv")){
				contador++;
				cadena[i+1] = listOfFiles[i].getName();
				cadena[i+1] = cadena[i+1].replaceFirst("[.][^.]+$", "");
			}
		}
		
		try {
			FileInputStream fis = new FileInputStream("data/Elementos.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			
			while (rowIterator.hasNext()){
				Row row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()){
					Cell cell = cellIterator.next();
					if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
						for(int i = 0; i<contador;i++){
							if(isInteger(cadena[i]))
								if(cell.getNumericCellValue() == Integer.parseInt(cadena[i])){
									copiar = true;
									fila = i;
								}
						}
					}
					if(cell.getCellType() == Cell.CELL_TYPE_STRING){
							if (copiar){
								cadena[fila] = cell.getRichStringCellValue().getString();
								copiar = false;
							}
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contador;
	}
	
	public boolean isInteger(String s){
		try{
			Integer.parseInt(s);
		} catch(NumberFormatException e){
			return false;
		} catch (NullPointerException e){
			return false;
		}
		return true;
	}
}