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
		return indice;
	}

	public List<Modelo> getListaEspectros() {
		return listaEspectros;
	}

	public void setListaEspectros(List<Modelo> listaEspectros) {
		this.listaEspectros = listaEspectros;
	}

	public Modelo getEspectro(int i) {
		System.out.println("COGE ESPECTRO "+i);
		return listaEspectros.get(i);
	}

	public void setEspectro(Modelo m) {
		Modelo newEspectro = new Modelo(m.getNumElem(), m.getX(), m.getY());
		newEspectro.setOptions(m.getOptions());
		this.listaEspectros.add(newEspectro);
		
		System.out.println("TRAS CADA SET");
		for(int i = 0; i< newEspectro.getNumElem(); i++){
			
			System.out.println("X " + newEspectro.X[i]+ " Y "+newEspectro.Y[i]);
		}
		indice++;
	}
	
	/*public XYDataset getDataset() {	
		return listaEspectros.get(indice-1).getDataset1();
	}*/
	
	public void revert(int i){
		if (i == -1){
			listaEspectros.clear();
		}else{
			for(int j = i+1;j<listaEspectros.size(); j++)
				listaEspectros.remove(j);
		}
		indice = i+1;
		
		System.out.println("QUEDAN "+indice+" ELEMENTOS");
	}
	
	public String[] getOptions(){
		return listaEspectros.get(indice-1).getOptions();
	}	
}
