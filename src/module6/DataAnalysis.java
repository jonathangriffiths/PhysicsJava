package module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataAnalysis {
	//From assignment:
	private static Theory bestTheory(Collection<DataPoint> data, 
			Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		//init var
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		//loop over theories
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(data, theory);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}

	public static void main(String[] args) {
		//init data - list because we might want to sort data if expanding the analysis
		List<DataPoint> data = null;
		try {
			data = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		} catch (IOException e) {
			System.out.println("The URL probably has issues. Exception message:");
			System.out.println(e.getMessage());
		}

		//init theories
		Collection<Theory> theories = new ArrayList<Theory>();
		theories.add(new PowerLawTheory(2));
		theories.add(new PowerLawTheory(2.05));
		theories.add(new QuadraticTheory(1, 10, 0));

		//init chi squared calculator
		GoodnessOfFitCalculator gofCalculator = new ChiSquared();

		Theory bestTheory = bestTheory(data, theories, gofCalculator);
		System.out.println("The best theory is: " + bestTheory.toString());

	}

}
