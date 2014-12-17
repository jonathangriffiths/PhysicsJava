package module8;

import java.awt.Color;

/**
 * @author Jonathan Griffiths
 * superclass holds a few variables important for creating our digital orrery
 * variables are only those which EVERY object needs
 * essential get methods included too
 * This was meant to have the 'Asteroid' class come off as well as the planet class but this was not implemented
 */

public abstract class OrbitalObject {
	protected double orbitalPeriod; //DAYS
	protected double objectRadius; //KM
	protected double objectMass; //KG
	protected Color colourForPlot;//use the Color class in RGB
	protected double orbitRadius;//KM
	/**
	 * Constructor
	 * @param orbitPeriod The orbital period of the object in days
	 * @param objRadius the radius of the object in km
	 * @param objMass the mass of the object in kg (was not needed in this implementation in the end)
	 * @param orbitRadius the average radius of the orbit of the object
	 * @param colForPlot a Color object which holds the colour of the object when added to the orrery.
	 */
	public OrbitalObject(double orbitPeriod, double objRadius, double objMass, double orbitRadius, Color colForPlot){
		orbitalPeriod=orbitPeriod;
		objectRadius=objRadius;
		objectMass=objMass;
		colourForPlot=colForPlot;
		this.orbitRadius = orbitRadius;
	}
	/**simple get method*/
	public double getOrbitPeriod(){return orbitalPeriod;}
	/**simple get method*/
	public double getObjectRadius(){return objectRadius;}
	/**simple get method*/
	public double getObjectMass(){return objectMass;}
	/**simple get method*/
	public Color getCol(){return colourForPlot;}
	/**simple get method*/
	public double getOrbitRadius(){return orbitRadius;}

}
