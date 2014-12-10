package module8;

import java.awt.*;
import javax.swing.*;

public class SolarSystem extends JPanel {

	private static void createAndDisplayGui() {
		JFrame frame = new JFrame("Solar System Orrery");
		// Exit application if window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Hello Java programmers!");
		frame.add(label); // Add label to frame
		frame.pack(); // Set component sizes and layout
		frame.setVisible(true); // Display the resulting frame
	}

	public static void main(String[] args) {
		//ARGS: double orbitPeriod, double objRadius, double objMass, Color colForPlot, double eccentricity
		Planet Mercury = new Planet(87.969, 2439.7, 3.3e23, new Color(104,110,108), 0.206);
		Planet Venus = new Planet(224.7, 6051.8, 4.87e24, new Color(227,222,145), 0.0067);
		Planet Earth = new Planet(365.26, 6371, 5.97e24, new Color(113,134,240), 0.017);
		Planet Mars = new Planet(779.96, 3389.5, 6.4185e23, new Color(232,95,113), 0.0934);
		double sunRadius = 695800;

		createAndDisplayGui();

	}

}
