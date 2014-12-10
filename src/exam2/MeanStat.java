package exam2;

import java.util.List;
/**
 * MeanStat implements Stat and calculates the mean tidal level for all ports separately
 * @author Jonathan Griffiths
 *
 */
public class MeanStat implements Stat {

	public MeanStat(){};
	
	@Override
	/**
	 * calculates mean tide level for one subset (according to ID) of a set of data List<Tide>
	 */
	public double statistic(List<Tide> data, String ID) {
		List<Tide> dataSubset = AnalysisMethods.subsetByPort(data, ID);
		double counter = 0;
		double total = 0;
		for(Tide t : dataSubset){
			counter++;
			total+=t.getLevel();
		}
		return total/counter;
	}

}
