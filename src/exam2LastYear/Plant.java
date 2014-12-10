package exam2LastYear;

/**
 * Plant is the same as Organism but implements a height double
 * @author Jonathan Griffiths
 *
 */

public class Plant extends Organism {
	
	private double height;
	
	
	/** Constructor stores data according to name of arguments*/
	public Plant(double latitude, double longitude, String identifier,
			String taxName, double height) {
		super(latitude, longitude, identifier, taxName);
		this.height=height;
	}
	/**function simply returns private variable height to user*/
	public double getHeight(){
		return height;
	}
	
	@Override
	public String toString(){
		String superStr = super.toString();
		String str = superStr+"\nHeight: "+height;
		return str;
	}

}
