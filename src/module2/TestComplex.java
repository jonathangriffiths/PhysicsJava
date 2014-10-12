package module2;

public class TestComplex {

	public static void main(String[] args) {
		Complex c1=new Complex(-1,2);
		Complex c2=new Complex(2,-1);
		
		System.out.println("c1 is: "+c1);
		System.out.println("c2 is: "+c2+"\n");
		System.out.println("c1*c2 is: "+Complex.multiply(c1,c2));
		//non-static alternative is c1.multiply(c2) which is probably prettier but I've done it like this now!
		System.out.println("c1/c2 is: "+Complex.divide(c1, c2)+"\n");
		System.out.println("c1*I is: "+Complex.multiply(c1, Complex.I));
		System.out.println("c1/0 is: "+Complex.divide(c1, Complex.ZERO)+"\n");
		System.out.println("c1*conjugate(c2) (stars would be confusing!) is: "+Complex.multiply(c1, Complex.conjugate(c2)));
		System.out.println("c2*conjugate(c2) is (mod squared): "+Complex.multiply(c2, Complex.conjugate(c2)));
	}

}
