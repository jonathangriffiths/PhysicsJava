package exam2;

import java.util.List;
/**
 * interface for a general statistical method
 * @author Jonathan Griffiths
 *
 */
public interface Stat {
	/**
	 * interface to take data and produce a real number statistic output
	 * @param data a List<Tide> of data
	 * @param ID a string used to subset data for the questions asked in exam2
	 * @return a double real number stat.
	 * @throws Exception to stay in line with implementations
	 */
	 double statistic(List<Tide> data, String ID) throws Exception;
}
