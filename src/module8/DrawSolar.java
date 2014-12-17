package module8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class to be called when drawing the Orrery
 * Contains methods to draw, redraw and time updates
 * @author Jonathan Griffiths
 *
 */

public class DrawSolar extends JPanel implements ActionListener{
	double sunRadius;
	ArrayList<Planet> planets = new ArrayList<Planet>();
	ArrayList<Moon> moons = new ArrayList<Moon>();
	ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	//These are essential to scale the distances involved to something visible
	//As such, planet radii are accurate with respect to each other
	//Similarly, planet orbit distances are correct proportionally
	//however, the two are not accurate to each other, else we could not see anything at this scale.
	double radiusCorrectionFactor;
	double orbitCorrectionFactor;
	double sunRadiusCorrectionFactor;
	double moonOrbitCorrectionFactor;
	
	/**
	 * Method draws the solar system according to arguments:
	 * @param width Width of window in pixels
	 * @param height Height of window in pixels
	 * @param sunRadius Radius of sun in km to be drawn
	 * @param planets ArrayList of Planet objects
	 * @param moons ArrayList of Moon objects
	 */
	public DrawSolar(int width, int height, double sunRadius, ArrayList<Planet> planets, ArrayList<Moon> moons, ArrayList<Asteroid> asteroids) {
		//set size for window
		setPreferredSize(new Dimension(width,height));
		this.sunRadius=sunRadius;
		//factors needed to make all objects actually visible
		radiusCorrectionFactor = 1.0/1e3;
		orbitCorrectionFactor = 1.0/1e6;
		moonOrbitCorrectionFactor = 3.0/1e5;
		sunRadiusCorrectionFactor = 3.0/1e5;
		this.planets = planets;
		this.moons = moons;
		this.asteroids = asteroids;
		//start timer for updates
		Timer animationTimer = new Timer(25,this);
		animationTimer.start();
	}
	/** replacement method draws a black background, paints sun in centre and adds all objects*/
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // call superclass method first
		//get info
		int width = getWidth();
		int height = getHeight();
		//paint back
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		//transform
		g.translate(width/2, height/2);
		//paint Sun
		g.setColor(Color.WHITE);
		int sunDiam = (int) (2*sunRadius*sunRadiusCorrectionFactor);
		g.fillOval((int) (-sunRadius*sunRadiusCorrectionFactor),(int) (-sunRadius*sunRadiusCorrectionFactor), sunDiam, sunDiam);

		//Loop through planets and paint them
		for(Planet p : planets){
			g.setColor(p.getCol());
			int planetDiam = (int) (2*p.getObjectRadius()*radiusCorrectionFactor);
			//in case it is infinitessimal, make it visible
			if(planetDiam==0){planetDiam=5;}
			int planetX = (int) (p.getOrbitRadius()*Math.sin(p.getAngle())*orbitCorrectionFactor - planetDiam/2);
			int planetY = (int) (p.getOrbitRadius()*Math.cos(p.getAngle())*orbitCorrectionFactor - planetDiam/2);
			g.fillOval(planetX, planetY, planetDiam, planetDiam);
		}
		//and for moons
		for(Moon m : moons){
			g.setColor(m.getCol());
			int moonDiam = (int) (2*m.getObjectRadius()*radiusCorrectionFactor);
			//in case it is infinitessimal, make it visible
			if(moonDiam==0){moonDiam=5;}
			int moonX = (int) (m.getPlanetX()*orbitCorrectionFactor + m.getMoonX()*moonOrbitCorrectionFactor);
			int moonY = (int) (m.getPlanetY()*orbitCorrectionFactor + m.getMoonY()*moonOrbitCorrectionFactor);
			g.fillOval(moonX, moonY, moonDiam, moonDiam);
		}
		//and for asteroids
		for(Asteroid a : asteroids){
			g.setColor(a.getCol());
			int asteroidDiam = (int) (2*a.getObjectRadius());
			//in case it is infinitessimal, make it visible
			if(asteroidDiam==0){asteroidDiam=3;}
			int asteroidX = (int) (a.getOrbitRadius()*Math.sin(a.getAngle()) - asteroidDiam/2);
			int asteroidY = (int) (a.getOrbitRadius()*Math.cos(a.getAngle()) - asteroidDiam/2);
			g.fillOval(asteroidX, asteroidY, asteroidDiam, asteroidDiam);
		}


	}
	/** replacement method adds time (1 day) to each object and redraws*/
	@Override
	public void actionPerformed(ActionEvent e) {
		for(Planet p : planets){
			p.addTime(1);
		}
		for(Moon m : moons){
			m.addTime(1);
			System.out.println(Math.sin(m.getAngle())*m.getOrbitRadius());
		}
		for(Asteroid a : asteroids){
			a.addTime(1);
		}
		repaint();
	}
}
