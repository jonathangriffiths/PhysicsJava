package module4;

import java.io.*;

public class Testing {

	public static void main(String[] args) {
		int CARRIAGE_RETURN = 10;
		int av;
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		System.out.println("Please type something!");
		try {
		String s = b.readLine();
		System.out.println("You typed: "+s);
		}
		catch (IOException e) {
		System.out.println("Problem: "+e.getMessage());
		}


	}

}
