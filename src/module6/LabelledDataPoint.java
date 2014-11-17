package module6;

public class LabelledDataPoint extends DataPoint {
	protected String label;
	
	public LabelledDataPoint(double x, double y, double ey, String name){
		//call previous constructor to init x,y,ey then add label
		super(x,y,ey);
		label = name;
	}
	
	//completes the set of get*() functions:
	public String getLabel(){
		return label;
	}

	
	@Override
	public String toString(){
		String stringFromSuper = super.toString();
		String str = label + ": " + stringFromSuper;
		return str;
	}

}
