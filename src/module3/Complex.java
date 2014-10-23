package module3;

public class Complex {
	//INIT
	private double re;
	private double im;
	//CONTRUCTOR - with arguments (2x double, real then imag)
	public Complex(double real, double imaginary){
		re=real;
		im=imaginary;
	}
	//CONSTRUCTOR - no arguments defaults to 0+0i
	public Complex(){
		re=0;
		im=0;
	}
	////STATIC VARIABLES
	static final Complex ONE=new Complex(1,0);
	static final Complex ZERO=new Complex(0,0);
	static final Complex I=new Complex(0,1);

	////STATIC METHODS
	//Return real part
	public static double real(Complex number){
		return number.re;
	}
	//Return imaginary part
	public static double imag(Complex number){
		return number.im;
	}
	//Return modulus
	public static double modulus(Complex number){
		double reSq=number.re*number.re; //broken down for readability
		double imSq=number.im*number.im;
		double modulus=Math.sqrt(reSq + imSq);
		return modulus; 
	}
	//Return argument
	public static double angle(Complex number){
		return Math.atan2(number.im, number.re);
	}
	//Complex Conjugate
	public static Complex conjugate(Complex number){
		return new Complex(number.re, -number.im);
	}
	//Normalise - modulus=1
	public static Complex normalise(Complex number) throws Exception{
		if(number==Complex.ZERO){
			throw new Exception("Complex: Can't normalise 0");
		}
		double mod=modulus(number);
		return new Complex(number.re/mod, number.im/mod);
	}
	//Equality tester
	public static boolean equals(Complex number1, Complex number2){
		if(number1.re==number2.re && number1.im==number2.im){return true;}
		else{return false;}
	}
	//toString (suspect this isn't needed at all,a non-static one does the job)
	//However, since the non-static one refers to this, I'll just leave it in.
	public static String toString(Complex number){
		String str=""+number.re+" + "+number.im+"i";
		return str;
	}
	//set from mod/arg
	public static Complex setFromModulusAngle(double mag, double ang){
		double real=mag*Math.cos(ang);
		double imag=mag*Math.sin(ang);
		return new Complex(real, imag);
	}
	//addition
	public static Complex add(Complex number1, Complex number2){
		double newRe=number1.re + number2.re;
		double newIm=number1.im + number2.im;
		return new Complex(newRe, newIm);
	}
	//subtraction - subtract 2 from 1
	public static Complex subtract(Complex number1, Complex number2){
		double newRe=number1.re - number2.re;
		double newIm=number1.im - number2.im;
		return new Complex(newRe, newIm);
	}
	//multiplication
	public static Complex multiply(Complex number1, Complex number2){
		double newIm=number1.re*number2.im + number2.re*number1.im;
		double newRe=number1.re*number2.re - number1.im*number2.im;
		return new Complex(newRe, newIm);
	}
	//division - NOTE: arguments are in the order number1/number2
	public static Complex divide(Complex number1, Complex number2) throws Exception{
		//method is multiply top and bottom by conj(number1)
		if(number2 == ZERO){
			throw new Exception("Complex: Can't divide by zero");
		}
		Complex top=(multiply(number1, conjugate(number2)));
		double bottom=number2.re*number2.re + number2.im*number2.im;
		return new Complex(top.re/bottom, top.im/bottom);
	}

	////NON-STATIC METHODS
	public double real(){
		return real(this);
	}
	public double imag(){
		return imag(this);
	}
	public double modulus(){
		return modulus(this);
	}
	public double angle(){
		return angle(this);
	}
	public Complex conjugate(){
		return conjugate(this);
	}
	public Complex normalise() throws Exception{
		return normalise(this);
	}
	public boolean equals(Complex number){
		return equals(this, number);
	}
	//non-static toString (very important!)
	public String toString(){
		return toString(this);
	}
	public Complex add(Complex number){
		return add(this, number);
	}
	public Complex subtract(Complex number){
		return subtract(this, number);
	}
	public Complex multiply(Complex number){
		return multiply(this, number);
	}
	public Complex divide(Complex number) throws Exception{
		return divide(this, number);
	}
}

