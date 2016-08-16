import java.io.*;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Modelo {
	
	private String[] options;
	//private XYDataset dataset1;
	private int numElem;
	double []X = null;
	double []Y = null;
	/*XYSeriesCollection collection = new XYSeriesCollection();
	XYSeries series = new XYSeries("");*/
	boolean first = true;
	
	public Modelo(){
		
	}	
	
	public Modelo (int numElem, double[] X, double[] Y){
		this.numElem = numElem;
		this.X = X.clone();
		this.Y = Y.clone();
	}

	/*public Modelo (int numElem, double[] X, double[] Y, XYSeries series){
		this.numElem = numElem;
		this.X = X.clone();
		this.Y = Y.clone();
		try {
			this.series = (XYSeries) series.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.collection.addSeries(series);
		this.dataset1 = this.collection;
	}*/
	
    public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}
	
	/*public XYDataset getDataset1() {
		return dataset1;
	}

	public void setDataset1(XYDataset dataset1) {
		this.dataset1 = dataset1;
	}*/

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
		this.X = x;
	}

	public double[] getY() {
		return Y;
	}

	public void setY(double[] y) {
		this.Y = y;
	}
	
	/*public XYSeriesCollection getCollection() {
		return collection;
	}

	public void setCollection(XYSeriesCollection collection) {
		this.collection = collection;
	}
	
	public XYSeries getSeries() {
		return series;
	}*/
	
	public void Atenuar(){
		double []xNew = new double [500];
		double []yNew = new double [500];
		
		//series.clear();
		String name = getNameFile(options[0]);
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("data/mu/"+name));
			String str = in.readLine();
			String []tok = str.split(",");
			
			for(int i = 0; i < tok.length; i++)
				xNew[i] = Double.parseDouble(tok[i]);
			
			str = in.readLine();
			tok = str.split(",");
			
			for(int i = 0; i < tok.length; i++)
				yNew[i] = Double.parseDouble(tok[i]);

			for(int i = 0; i < numElem; i++){
				Y[i] = (Y[i] * Math.exp ( (interpolar1DLogLog(X[i], xNew, yNew, numElem))* Double.parseDouble(options[1]) * (-1)));
				//series.addOrUpdate(X[i], Y[i]);
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
	
	public double interpolar1DLogLog(double x, double[]Xa, double []Ya, int lit){
		double r = 0, y1, y2;
		int i;

		for (i = 0; i < lit; i++){
			if ((Xa[i] <= x) && (x <= Xa[i+1]))
				break;
		}
		
		y1 = Ya[i];
		y2 = Ya[i+1];
		
		r = Math.exp(((Math.log(x) - Math.log(Xa[i])) / (Math.log(Xa[i + 1]) - Math.log(Xa[i]))) * (Math.log(y2) - Math.log(y1)) + Math.log(y1));

		return r;
	}
	
	public void imprimir(){
		for(int i = 0; i < numElem; i++){
			System.out.println("X " + X[i] + " Y " +Y[i]);
		}
	}
	
	public String getNameFile(String s){
		int fila = 0;
		boolean salir= false;
		XSSFSheet sheet = null;
		try {
			FileInputStream fis = new FileInputStream("data/Elementos.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			
			while (rowIterator.hasNext()){
				fila++;
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()){
					Cell cell = cellIterator.next();
					if(cell.getCellType() == Cell.CELL_TYPE_STRING){
						if(cell.getStringCellValue().trim().equals(s)){
							salir = true;
							break;
						}
					}
				}
				if(salir)
					break;
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CellReference ref = new CellReference(fila-1,1);
		Row r = sheet.getRow(ref.getRow());
		return (Integer.toString((int) r.getCell(0).getNumericCellValue())+".csv");
	}
	
	/*public void actualizar(){
		for(int i = 0; i < numElem; i++)
			series.addOrUpdate(X[i], Y[i]);
	}*/
}
