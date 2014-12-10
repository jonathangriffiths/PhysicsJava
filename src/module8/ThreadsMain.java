package module8;

import java.util.List;

public class ThreadsMain {
/**
 * Runs a prime checking algorithm for 5 seconds and provides a List of all primes found.
 * Some summary statistics are also printed.
 * @author Jonathan Griffiths
 * @version 1.0
 */
	
	public static void main(String[] args) {
		//init classes and threads
		CountdownTask timer = new CountdownTask(5);
		Thread fiveSecs=new Thread(timer);

		PrimeNumberTask numChecker = new PrimeNumberTask();
		Thread numCheckThread = new Thread(numChecker);

		//start the two threads
		fiveSecs.start();
		numCheckThread.start();

		//wait until the five seconds are up
		try {
			fiveSecs.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		//once time is up, stop the prime checker
		numCheckThread.interrupt();
	
		//print results
		System.out.println("The largest number checked so far is: "+numChecker.getNumberChecking());
		List<Integer> primeList=numChecker.getList();
		System.out.println("The highest prime found is: "+primeList.get(primeList.size()-1));
		System.out.println("The total number of primes found is: "+primeList.size());
		
		
	}

}
