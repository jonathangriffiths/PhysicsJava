package yetAnotherExam2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Analysis {

	public static void main(String[] args) {
String abURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/occurrencesAB.txt";
String xyzURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/occurrencesXYZ.txt";
String popURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/populations.txt";
String regURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/regions.txt";

try {
	//List<Location> data = AnalysisMethods.harvestData(regURL, popURL, xyzURL, abURL);
	
	Map<String, String> regions = AnalysisMethods.getRegionMap(regURL);
	System.out.println(regions.get("A10"));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	}

}
