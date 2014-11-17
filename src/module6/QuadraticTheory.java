package module6;

public class QuadraticTheory implements Theory {
	//Implements the Theory interface to do a(x^2) + bx + c relationships
	protected double a;
	protected double b;
	protected double c;
	

	public QuadraticTheory(double x2_coef, double x_coef, double constant){
		a=x2_coef;
		b=x_coef;
		c=constant;
	}
	
	@Override
	public double y(double x) {
		double result = a*x*x + b*x +c;
		return result;
	}

	public String toString(){
		String str = a + "x^2 + " + b + "x + " + c;
		return str;
	}
}
