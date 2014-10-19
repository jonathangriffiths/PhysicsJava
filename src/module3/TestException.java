package module3;

public class TestException {

	public static void main(String[] args) throws Exception {//Need to announce that we might throw an exception for declaring particle correctly
		//If we do try blocks we can have the output a bit prettier
		//COMPLEX
		try {
			Complex failComplex1=Complex.normalise(Complex.ZERO);
		} catch (Exception ex1) {
			System.out.println(ex1);
		}

		try {
			Complex failComplex2=Complex.divide(Complex.I, Complex.ZERO);
		} catch (Exception ex2) {
			System.out.println(ex2);
		}
		//FALLING PARTICLE
		try {
			FallingParticle failParticle = new FallingParticle(-1,-1);
		} catch (Exception ex3) {
			System.out.println(ex3);
		}

		try {
			FallingParticle failParticle = new FallingParticle(1,-1);
		} catch (Exception ex3) {
			System.out.println(ex3);
		}

		FallingParticle particle = new FallingParticle(1,1);

		try {
			particle.setZ(-3);
		} catch (Exception ex4) {
			System.out.println(ex4);
		}
		//THREEVECTOR
		try{
			ThreeVector.unitVector(ThreeVector.ZERO);
		} catch (Exception ex5) {
			System.out.println(ex5);
		}
		try{
			ThreeVector.angle(ThreeVector.ZERO, new ThreeVector(1,1,1));
		} catch (Exception ex6) {
			System.out.println(ex6);
		}
		try{
			ThreeVector.angle(new ThreeVector(1,1,1), ThreeVector.ZERO);
		} catch (Exception ex7) {
			System.out.println(ex7);
		}
	}

}
