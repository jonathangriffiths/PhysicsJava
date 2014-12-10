package anotherExam2;

import java.io.IOException;

public class Analysis {



	public static void main(String[] args) {
		String ggURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt";
		String zzURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt";
		String dataURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt";

		try {
			Channel ZZ = new Channel(dataURL, zzURL, "ZZ");
			Channel GG = new Channel(dataURL, ggURL, "GG");	
		} catch (IOException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}



	}

}
