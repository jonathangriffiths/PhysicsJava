package module6;

import java.util.Collection;

public class ChiSquared implements GoodnessOfFitCalculator {
	//ChiSquared uses GoodnessOfFitCalculator to return the Chi Squared value for a Collection of DataPoints and one theory
	
	// empty constructor, don't need to init anything
	public ChiSquared(){};

	//returns ChiSq value for a single point: tidies up the next function
	public double ChiSqOnePoint(DataPoint dp, Theory th){
		double yTheory = th.y(dp.getX());
		//find chi
		double value = (dp.getY() - yTheory)/dp.getEY();
		//then square it, easier to read this way since there is not a standard ^ operator in Java
		value = value * value;
		return value;
	}

	@Override
	public double goodnessOfFit(Collection<DataPoint> data, Theory theory) {
		//init counter
		double chiSq=0;
		//loop through data
		for(DataPoint i : data){
			chiSq+=ChiSqOnePoint(i,theory);
		}
		return chiSq;
	}

}
