package module2;

public class ParticleMain {

	public static void main(String[] args) {
		//INIT
		FallingParticle coarser=new FallingParticle(5.3,2.1);
		FallingParticle coarse=new FallingParticle(5.3,2.1);
		FallingParticle medium=new FallingParticle(5.3,2.1);
		FallingParticle fine=new FallingParticle(5.3,2.1);
		FallingParticle finer=new FallingParticle(5.3,2.1);
		coarser.setZ(10);
		coarse.setZ(10);
		medium.setZ(10);
		fine.setZ(10);
		finer.setZ(10);

		coarser.drop(0.5);
		coarse.drop(0.1);
		medium.drop(0.01);
		fine.drop(0.001);
		finer.drop(0.0001);

		System.out.println("In order of least fine to most fine, the final (stops when z<=0) positions are:");
		System.out.println(coarser);
		System.out.println(coarse);
		System.out.println(medium);
		System.out.println(fine);
		System.out.println(finer);
		System.out.println("Coarse time increments result in more 'incorrect' answers as we are not recalculating a and v quickly enough");
		System.out.println("The finer we go, the closer we get to the analytical solution. There's an analogy to integration here (lim dx --> 0).");
	}

}
