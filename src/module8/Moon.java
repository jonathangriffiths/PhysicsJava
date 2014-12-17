package module8;

import java.awt.Color;

/**
 * Class works like a planet but is associated with a planet object for it to orbit
 * @author Jonathan Griffiths
 *
 */
public class Moon extends Planet {

	protected Planet planet;
	/**
	 * Constructor is as the Planet one but with a planet for the moon to follow
	 * @param orbitPeriod The orbital period of the object in days
	 * @param objRadius the radius of the object in km
	 * @param objMass the mass of the object in kg (was not needed in this implementation in the end)
	 * @param orbitRadius the average radius of the orbit of the object
	 * @param colForPlot a Color object which holds the colour of the object when added to the orrery.
	 * @param planet is the Planet that the moon will orbit
	 */
	public Moon(double orbitPeriod, double objRadius, double objMass, double orbitRadius,
			Color colForPlot, Planet planet){
		super(orbitPeriod, objRadius, objMass, orbitRadius, colForPlot);
		this.planet=planet;
	}
	/** gets the X position of the moon (km) relative to its planet*/
	public double getMoonX(){
		double moonX = Math.sin(this.getAngle())*this.getOrbitRadius();
		return moonX;
	}
	/** gets the Y position of the moon (km) relative to its planet*/

	public double getMoonY(){
		double moonY = Math.cos(this.getAngle())*this.getOrbitRadius();
		return moonY;
	}
	/** gets the X position of the moon's planet*/
	public double getPlanetX(){
		double planetX = Math.sin(planet.getAngle())*planet.getOrbitRadius();
		return planetX;
	}
	/** gets the Y position of the moon's planet*/
	public double getPlanetY(){
		double planetY = Math.cos(planet.getAngle())*planet.getOrbitRadius();
		return planetY;
	}

}
