package module8;

import java.awt.Color;

public class Planet extends OrbitalObject {
	private double eccentricity;

	public Planet(double orbitPeriod, double objRadius, double objMass,
			Color colForPlot, double eccentricity) {
		super(orbitPeriod, objRadius, objMass, colForPlot);
		this.eccentricity=eccentricity;
	}
	
	public double getEccentricity(){return eccentricity;}

}
