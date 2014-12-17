package module8;

import java.awt.Color;

/**
 * Subclass of OrbitalObject to represent planets
 * @author Jonathan Griffiths
 *
 */
public class Planet extends OrbitalObject {
	protected double eccentricity;
	protected double angle;
	protected Planet planet;
	/**
	 * Constructor makes planet objects to hold data only
	 * @param orbitPeriod The orbital period of the object in days
	 * @param objRadius the radius of the object in km
	 * @param objMass the mass of the object in kg (was not needed in this implementation in the end)
	 * @param orbitRadius the average radius of the orbit of the object
	 * @param colForPlot a Color object which holds the colour of the object when added to the orrery.
	 */
	public Planet(double orbitPeriod, double objRadius, double objMass, double orbitRadius,
			Color colForPlot) {
		super(orbitPeriod, objRadius, objMass, orbitRadius, colForPlot);
		angle=0;
	}
	/**
	 * addTime adds time to the planet by adjusting its angle to the sun
	 * @param days is the number of days added (integer)
	 */
	public void addTime(int days){
		this.angle += 2 * Math.PI * days/this.getOrbitPeriod();
	}
	/** simple get method */
	public double getEccentricity(){return eccentricity;}
	/** simple get method */
	public double getAngle(){return angle;}
}
