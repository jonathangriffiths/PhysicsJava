package module8;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
/**
 * Class implements the solar system and send commands for it to be drawn
 * @author Jonathan Griffiths
 *
 */
public class SolarSystem extends JPanel{

	static double sunRadius = 695800;
	static Planet Mercury = new Planet(87.969, 2439.7, 3.3e23, 58e6, new Color(104,110,108));
	static Planet Venus = new Planet(224.7, 6051.8, 4.87e24, 108e6, new Color(227,222,145));
	static Planet Earth = new Planet(365.26, 6371, 5.97e24, 150e6, new Color(113,134,240));
	static Planet Mars = new Planet(779.96, 3389.5, 6.4185e23, 228e6, new Color(232,95,113));
	//Larger planets are so far away that we would lose detail on the inner ones.
	static Moon EarthMoon = new Moon(27.3, 1737.1,  7.35e22,  384e3, new Color(150,150,150), Earth);
	//Mars' moons orbit too quickly to be shown properly at this scale.
	static ArrayList<Planet> planets = new ArrayList<Planet>();
	static ArrayList<Moon> moons = new ArrayList<Moon>();
	static ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
/**
 * Method generates a number of asteroids distributed around the central point with random sizes and angles and colours
 * The asteroids generated will be different every time the program is run!
 * @param innerRadius gives inner bound for asteroids in pixels from centre
 * @param outerRadius gives outer bound for asteroids in pixels from centre
 * @param number gives number of asteroids to be created
 * @return
 */
	private static ArrayList<Asteroid> makeAsteroidBelt(double innerRadius, double outerRadius, int number){
		Random generator = new Random();
		ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
		for(int i = 1; i<=number; i++){
			//set radius to be 95% likely to be between outer and inner radius
			double orbitRadius = (outerRadius - innerRadius)/2*generator.nextGaussian() + (innerRadius + outerRadius)/2;
			//set angle to be randomly distributed all around circle
			double startAngle = generator.nextDouble()*2*Math.PI;
			//set period randomly from 4000 to 6000 days
			int period = generator.nextInt(2000)+4000;
			//set asteroid radius between 1 and 3
			int radius = generator.nextInt(2)+1;
			//generate a gray color
			int RGB=generator.nextInt(160)+40;
			Color asteroidColor = new Color (RGB, RGB, RGB);

			Asteroid asteroid = new Asteroid(orbitRadius, startAngle, period, asteroidColor, radius);
			asteroids.add(asteroid);
		}
		return asteroids;
	}



	/** Constructor sets size for the Orrery*/
	public SolarSystem(int width, int height){
		setPreferredSize(new Dimension(width,height));
	}

	/**
	 * Method creates an Orrery of the size given, using the information provided in this file.
	 * @param width in pixels of Orrery
	 * @param height in pixels or Orrery
	 */
	private static void createAndDisplayGui(int width, int height) {
		JFrame frame = new JFrame("Orrery");
		// Exit application if window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Draw solar system
		DrawSolar system = new DrawSolar(width, height, sunRadius, planets, moons, asteroids);
		frame.add(system); // Add system to frame
		frame.pack(); // Set component sizes and layout
		frame.setVisible(true); // Display the resulting frame
	}





	public static void main(String[] args) {
		int width = 1024;
		int height = 768;

		planets.add(Earth);
		planets.add(Mercury);
		planets.add(Venus);
		planets.add(Mars);
		moons.add(EarthMoon);
		//NOTE: the height/2 part may need to change if the width & height are altered.
		ArrayList<Asteroid> newAsteroids = makeAsteroidBelt(height/2, height/2 + 50, 1000);
		asteroids.addAll(newAsteroids);



		createAndDisplayGui(width, height);


	}


}
