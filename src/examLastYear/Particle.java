package examLastYear;

public class Particle {
public final int charge;
public final double energy;
public final double px;
public final double py;
public final double pz;

public Particle(int Charge, double Momentum, double Theta, double Phi){//constructor from data
	charge=Charge;
	px=Momentum * Math.cos(Theta) * Math.sin(Phi);
	py=Momentum * Math.sin(Theta) * Math.sin(Phi);
	pz=Momentum * Math.cos(Phi);
	energy = Math.sqrt(px*px + py*py + pz*pz);
}

public Particle (double Px, double Py, double Pz, double E, int Charge){ //alternate constructor for existing object
	px=Px;
	py=Py;
	pz=Pz;
	energy=E;
	charge=Charge;
}

public static Particle combineParticles(Particle part1, Particle part2){ //adds the four-vectors
	Particle part = new Particle(part1.px+part2.px, part1.py+part2.py, part1.pz+part2.pz, part1.energy+part2.energy, 0);
	return part;
}

public static double getInvMassPair(Particle part1, Particle part2){
	Particle newPart=combineParticles(part1, part2);
	double invMass = newPart.energy * newPart.energy - (newPart.px*newPart.px + newPart.py * newPart.py + newPart.pz * newPart.pz);
	return invMass;
}

}
