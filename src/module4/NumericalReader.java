package module4;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class NumericalReader {
	private double minValue;
	private double maxValue;
	private int nValues;
	private double sumValues;
	private File outFileName = new File("/Users/Jono/Dropbox/Work/Java/PHAS3459/sampleData/numbers.txt");//default output
	private FileWriter fw;
	private BufferedWriter b;
	private PrintWriter pw;

	public NumericalReader(){}//empty constructor, just holds the values we have already laid out.

	//returns buffered reader from a URL - argument is a string with the url
	public static BufferedReader brFromURL(String urlName) throws IOException{
		URL u = new URL (urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}
	//returns buffered reader from a file - argument is a string with the file location
	public static BufferedReader brFromFile(String filename) throws FileNotFoundException{
		FileReader fr = new FileReader(filename);
		BufferedReader b = new BufferedReader(fr);
		return b;
	}

	//allows setting of output file for analysis for an instance
	public void setOutFile(File output){
		outFileName=output;
	}

	//initialises values for the class instance, and creates the writer for moving numbers to hard drive
	public void analysisStart() throws IOException{
		minValue=Double.POSITIVE_INFINITY;//will be overwritten by first number 
		maxValue=Double.NEGATIVE_INFINITY;
		nValues=0;
		sumValues=0;

		fw = new FileWriter(outFileName);
		b = new BufferedWriter(fw);
		pw = new PrintWriter(b);
	}
	//does the analysis one line at a time, each line should be the argument as a string
	public void analyseData(String s) throws IOException{
		if(!s.isEmpty() && Character.isDigit(s.charAt(0))){//non empty, numeric starting row as per format definition in exercise page
			Scanner scan = new Scanner(s); //values separated by whitespace in file formatting
			while (scan.hasNext()){
				float token=scan.nextFloat(); //automatically formats token to float
				System.out.println(token); //prints to screen
				//print to file, one per line
				pw.println(token);
				//Update the tracking values
				nValues++;
				if(token>maxValue){maxValue=token;}
				if(token<minValue){minValue=token;}
				sumValues+=token;
			}
			scan.close();
		}
	}
	//closes the writer and prints summary statistics to screen
	public void analysisEnd(){
		//note that our data has max d.p. 2, therefore producing stats with this level of precision.
		System.out.println("Number of values: "+nValues);
		System.out.format("Sum of values: %.2f%n",sumValues);
		System.out.format("Max value: %.2f%n",maxValue);
		System.out.format("Min value: %.2f%n", minValue);
		pw.close();
	}

	public static void main(String[] args) {
		NumericalReader data1 = new NumericalReader();
		data1.setOutFile(new File("/Users/Jono/Dropbox/Work/Java/PHAS3459/sampleData/module4OutputData1.txt"));
		//haven't used numbers.txt but commenting out the line above will achieve this
		try {
			BufferedReader reader = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			String line = "";
			data1.analysisStart(); // initialize minValue etc.
			while ((line = reader.readLine()) != null) { 
				data1.analyseData(line); // analyze lines, check for comments etc.
			}
			data1.analysisEnd(); // print min, max, etc.

		} catch (IOException e) {
			System.out.println(e.getMessage());
			//this doesn't return very useful things when you mess up the url...
		}
		
		NumericalReader data2=new NumericalReader();
		data2.setOutFile(new File("/Users/Jono/Dropbox/Work/Java/PHAS3459/sampleData/module4OutputData2.txt"));
		//haven't used numbers.txt but commenting out the line above will achieve this
		try {
			BufferedReader reader = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
			String line = "";
			data2.analysisStart(); // initialize minValue etc.
			while ((line = reader.readLine()) != null) { 
				data2.analyseData(line); // analyze lines, check for comments etc.
			}
			data2.analysisEnd(); // print min, max, etc.

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}


	}
}


