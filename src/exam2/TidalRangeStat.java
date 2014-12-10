package exam2;

import java.util.List;
/**
 * TodalRangeStat implements Stat and calculates the tidal range for all ports separately
 * @author Jonathan Griffiths
 *
 */
public class TidalRangeStat implements Stat {

	public TidalRangeStat(){};
	@Override
	/**
	 * calculates tidal range for one subset (according to ID) of a set of data List<Tide>
	 */
	public double statistic(List<Tide> data, String ID) throws Exception {
		List<Tide> dataSubset = AnalysisMethods.subsetByPort(data, ID);
		double lowest_tide = AnalysisMethods.getLowestTide(dataSubset).getLevel();
		double highest_tide = AnalysisMethods.getHighestTide(dataSubset).getLevel();
		return highest_tide-lowest_tide;
	}

}
