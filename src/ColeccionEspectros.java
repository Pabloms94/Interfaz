import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.data.xy.XYDataset;

public class ColeccionEspectros {
	private int TAM = 100;
	private Modelo[] listaEspectros = new Modelo[TAM];
	private int indice = 0;
	
	public int getIndice() {
		System.out.println("INDICe");

		return indice;
	}

	public Modelo[] getListaEspectros() {
		System.out.println("GLESPECTRO");

		return listaEspectros;
	}

	public void setListaEspectros(Modelo[] listaEspectros) {
		System.out.println("SLESPECTRO");

		this.listaEspectros = listaEspectros;
	}

	public Modelo getEspectro(int i) {
		System.out.println("GESPECTRO");

		return listaEspectros[i];
	}

	public void setEspectro(Modelo espectro) {
		System.out.println("ANTES");

		for (int j = 0; j < indice; j++){
			System.out.println("ESPECTRO " + j);
			for(int i = 0; i < listaEspectros[j].getNumElem(); i++)
				System.out.println("X " + listaEspectros[j].X[i] + " Y " + listaEspectros[j].Y[i]);
			}
		this.listaEspectros[indice] = espectro;
		indice++;
		System.out.println("DESPUES");
		
		for (int j = 0; j < indice; j++){
			System.out.println("ESPECTRO " + j);
			for(int i = 0; i < listaEspectros[j].getNumElem(); i++)
				System.out.println("X " + listaEspectros[j].X[i] + " Y " + listaEspectros[j].Y[i]);
			}
	}
	
	public XYDataset getDataset() {		System.out.println("DATA");

		return listaEspectros[indice-1].getDataset1();
	}
	
	public void revert(int i){
		System.out.println("REVERT");

		for(int j = i+1;j<TAM; j++)
			listaEspectros[j] = null;
		indice = i+1;
		
		System.out.println("HAY " + indice + " espectros");
	}
	
	public String[] getOptions(int i){
		System.out.println("OPCIONES");

		return listaEspectros[i].getOptions();
	}	
}
