package module8;

import java.awt.Color;
/**
 * Simple class extending planet for the asteroid belt implementation
 * @author Jonathan Griffiths
 *
 */
public class Asteroid extends Planet {
	/**
	 * Constructor simply removes mass which is not used for asteroid objects and allows input of a certain starting angle.
	 * @param orbitRadius is the radius of the object (km)
	 * @param angle is the initial angle of the asteroid
	 * @param period is the orbital period of the asteroid in days.
	 * @param color is the color of the asteroid
	 * @param objRadius this is the radius of the asteroid IN PIXELS (because the asteroids are generated randomly for this we don't care about the real mass)
	 */
	public Asteroid(double orbitRadius, double angle, double period, Color color, double objRadius){
		super(period, objRadius, 1, orbitRadius, color);
		this.angle = angle;
	}

}
