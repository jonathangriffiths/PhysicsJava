package module8;

import java.awt.Color;

/**
 * 
 * @author Jonathan Griffiths
 * superclass holds a few variables important for creating our digital orrery
 * variables are only those which EVERY object needs
 * essential methods included
 */
public abstract class OrbitalObject {
	private double orbitalPeriod; //DAYS
	private double objectRadius; //KM
	private double objectMass; //KG
	private Color colourForPlot;//use the Color class in RGB
	
	public OrbitalObject(double orbitPeriod, double objRadius, double objMass, Color colForPlot){
		orbitalPeriod=orbitPeriod;
		objectRadius=objRadius;
		objectMass=objMass;
		colourForPlot=colForPlot;
	}
	
	public double getOrbitPeriod(){return orbitalPeriod;}
	public double getObjectRadius(){return objectRadius;}
	public double getObjectMass(){return objectMass;}
	public Color getCol(){return colourForPlot;}
	
	//TODO: methods to draw object; move object along; impact detection?; 
}
