package module6;

public class PowerLawTheory implements Theory {
	//implements Theory interface to do x^n relationships
	protected double n;

	public PowerLawTheory(double power){
		n=power;
	}
	
	
	@Override
	public double y(double x) {
		return Math.pow(x, n);
	}
	
	public String toString(){
		String str = "x^"+n;
		return str;
	}

}
