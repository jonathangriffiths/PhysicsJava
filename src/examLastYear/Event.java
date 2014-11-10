package examLastYear;

import java.util.ArrayList;

public class Event {
	ArrayList<Particle> list;
	String event;
	int sizeFromData;
	String trigger;
public Event(String Trigger, String Event, int Size){
	event=Event;
	trigger=Trigger;
	sizeFromData=Size;
}

public void addToEvent(Particle particle){
	list.add(particle);
}

public Particle getFromList(int index) throws Exception{
	if(index>=list.size()||index<0){throw new Exception("Index does not exist");}
	return list.get(index);
}

public ArrayList<Double> getParticlePairs() throws Exception{
	ArrayList<Double> PairMasses = new ArrayList<Double>();
	for(int loop1=0; loop1<sizeFromData; loop1++){
		Particle part1=this.getFromList(loop1);
		if(part1.charge>0){
			for(int loop2=0; loop2<sizeFromData; loop2++){
				Particle part2=this.getFromList(loop2);
				if(part2.charge<0){
					double invMass=Particle.getInvMassPair(part1, part2);
					PairMasses.add(invMass);
				}
			}
		}
	}
	return PairMasses;
}

}
