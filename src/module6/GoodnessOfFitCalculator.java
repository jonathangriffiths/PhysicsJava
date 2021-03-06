package module6;

import java.util.Collection;

public interface GoodnessOfFitCalculator {
	//very basic interface for use with ChiSquared for measuring goodness of fit
	//could be used to implement alternative statistical methods (e.g. some sort of weighting) using the same function defined below:
	double goodnessOfFit(Collection<DataPoint> data, Theory theory);
	
}
