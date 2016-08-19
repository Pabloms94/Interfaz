/**
 * @brief Clase ColeccionEspectros es la encargada de crear un histOrico de espectros para poder recuperarlos.
 */

import java.util.ArrayList;
import java.util.List;

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

	public String[] getOptions() {
		return listaEspectros.get(indice - 1).getOptions();
	}

	public Modelo getEspectro(int i) {
		System.out.println("COGE ESPECTRO " + i);
		return listaEspectros.get(i);
	}

	/**
	 * @function FunciOn setEspectro nos permite almacenar un nuevo espectro en
	 *           la colecciOn.
	 * @param m
	 *            serA el espectro a almacenar.
	 */
	public void setEspectro(Modelo m) {
		Modelo newEspectro = new Modelo(m.getNumElem(), m.getX(), m.getY());
		newEspectro.setOptions(m.getOptions());
		this.listaEspectros.add(newEspectro);

		System.out.println("TRAS CADA SET");
		for (int i = 0; i < newEspectro.getNumElem(); i++) {

			System.out.println("X " + newEspectro.X[i] + " Y " + newEspectro.Y[i]);
		}
		indice++;
	}

	/**
	 * @function FunciOn revert que eliminarA los elementos posteriores al
	 *           seleccionado por el usuario.
	 * @param i
	 *            serA el Indice que ha seleccionado el usuario.
	 */
	public void revert(int i) {
		if (i == -1) {
			listaEspectros.clear();
		} else {
			for (int j = i + 1; j < listaEspectros.size(); j++)
				listaEspectros.remove(j);
		}
		indice = i + 1;

		System.out.println("QUEDAN " + indice + " ELEMENTOS");
	}
}
