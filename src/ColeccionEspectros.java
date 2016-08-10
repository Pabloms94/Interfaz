import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.data.xy.XYDataset;

public class ColeccionEspectros {
	private List<Modelo> listaEspectros = new ArrayList<Modelo>();
	private int indice = 0;
	
	public int getIndice() {
		System.out.println("INDICe");

		return indice;
	}

	public List<Modelo> getListaEspectros() {
		System.out.println("GLESPECTRO");

		return listaEspectros;
	}

	public void setListaEspectros(List<Modelo> listaEspectros) {
		System.out.println("SLESPECTRO");

		this.listaEspectros = listaEspectros;
	}

	public Modelo getEspectro(int i) {
		System.out.println("GESPECTRO");

		return listaEspectros.get(i);
	}

	public void setEspectro(Modelo m) {
		Modelo newEspectro = new Modelo(m.getDataset1(), m.getNumElem(), m.getX(), m.getY(), m.collection, m.series);
		newEspectro.setOptions(m.getOptions());
		this.listaEspectros.add(newEspectro);
		indice++;
	}
	
	public XYDataset getDataset() {		
		System.out.println("DATA");

		return listaEspectros.get(indice-1).getDataset1();
	}
	
	public void revert(int i){
		System.out.println("REVERT");

		for(int j = i+1;j<listaEspectros.size(); j++)
			listaEspectros.remove(j);
		indice = i+1;
		
		System.out.println("HAY " + indice + " espectros");
	}
	
	public String[] getOptions(){
		System.out.println("OPCIONES");

		return listaEspectros.get(indice-1).getOptions();
	}	
}
