import java.io.*;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Modelo {

	public double[] valor;
	public String[] options;
	public XYDataset dataset1;
	public int numElem;
	double []X = null;
	double []Y = null;
	XYSeriesCollection collection = new XYSeriesCollection();
	XYSeries series = new XYSeries("");
	
	public double[] getValor() {
		return valor;
	}

	public void setValor(double[] valor) {
		this.valor = valor;
	}

    public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}
	
	public XYDataset getDataset1() {
		return dataset1;
	}

	public void setDataset1(XYDataset dataset1) {
		this.dataset1 = dataset1;
	}

	public int getNumElem() {
		return numElem;
	}

	public void setNumElem(int numElem) {
		this.numElem = numElem;
	}

	public double[] getX() {
		return X;
	}

	public void setX(double[] x) {
		X = x;
	}

	public double[] getY() {
		return Y;
	}

	public void setY(double[] y) {
		Y = y;
	}
	
	public void Atenuar(){
		double []xNew = new double [500];
		double []yNew = new double [500];
		
		series.clear();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("data/mu/"+options[0]));
			String str = in.readLine();
			String []tok = str.split(",");
			
			for(int i = 0; i < tok.length; i++)
				xNew[i] = Double.parseDouble(tok[i]);
			
			str = in.readLine();
			tok = str.split(",");
			
			for(int i = 0; i < tok.length; i++)
				yNew[i] = Double.parseDouble(tok[i]);

			for(int i = 0; i < numElem; i++){
				Y[i] = (Y[i] * Math.exp ( (interpolar1D(X[i], xNew, yNew, numElem))* Double.parseDouble(options[1]) * (-1)));
				series.addOrUpdate(X[i], Y[i]);
			}
			//collection.addSeries(series);
			//setDataset1(collection);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public double interpolar1D(double x, double[]Xa, double []Ya, int lit){
		double r = 0, y1, y2;
		int i;

		for (i = 0; i < lit; i++){
			if ((Xa[i] <= x) && (x <= Xa[i+1]))
				break;
		}
		
		y1 = Ya[i];
		y2 = Ya[i+1];
		
		r = ((x - Xa[i]) / (Xa[i + 1] - Xa[i])) * (y2 - y1) + y1;

		return r;
	}
}
