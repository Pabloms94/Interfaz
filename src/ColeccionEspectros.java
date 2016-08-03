import org.jfree.data.xy.XYDataset;

public class ColeccionEspectros {
	private int TAM = 100;
	private Modelo[] listaEspectros = new Modelo[TAM];
	private int indice = 0;
	
	public int getIndice() {
		return indice;
	}

	public Modelo[] getListaEspectros() {
		return listaEspectros;
	}

	public void setListaEspectros(Modelo[] listaEspectros) {
		this.listaEspectros = listaEspectros;
	}

	public Modelo getEspectro(int i) {
		return listaEspectros[i];
	}

	public void setEspectro(Modelo espectro) {
		this.listaEspectros[indice] = espectro;
		indice++;
	}
	
	public XYDataset getDataset() {
		return listaEspectros[indice-1].getDataset1();
	}
	
	public void revert(int i){
		for(int j = i+1;j<TAM; j++)
			listaEspectros[j] = null;
		indice = i+1;
	}
	
	public String[] getOptions(int i){
		return listaEspectros[i].getOptions();
	}
	
}
