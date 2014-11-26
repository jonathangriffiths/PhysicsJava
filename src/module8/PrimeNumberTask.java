package module8;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberTask implements Runnable {
	/**
	 * @author Jonathan Griffiths
	 * @version 1.0
	 */

	//init prime list for class
	private List<Integer> primes = new ArrayList<Integer>();
	private int numberChecking=1;


	/**
	 * Simple constructor
	 */
	public PrimeNumberTask(){}

	/**
	 * function checks if an integer is prime
	 * function will be used in the run() function, performance improvements can be made here.
	 * @param n = integer to be tested
	 * @return boolean true/false for whether the number is prime
	 */
	public static boolean isPrime(int n){
		//start true
		boolean answer = true;
		//1, 2 weird cases, easiest to get out of the way here and start later
		if(n==1 || n==2){return true;}
		//if number is even, know it is not prime. Allows removal of even numbers from for loop
		if(n%2==0){return false;}
		//smallest prime factor of a non-prime n is always less than sqrt(n)
		//proof e.g. http://bit.ly/1xFZh4O
		for(int i=3; i<Math.sqrt(n); i+=2){
			if(n%i==0){answer=false; break;}
		}
		return answer;
	}

	/**
	 * Simple list getter for an instance of the class
	 * @return an ArrayList of the prime numbers; will be empty unless instance started in a Thread.
	 */
	public List<Integer> getList(){return primes;}

	/**
	 * Simple number getter for an instance of the class
	 * @return the integer that the thread was checking before termination
	 */
	public int getNumberChecking(){return numberChecking;}
	
	/**
	 * run method in a Thread will go though all integers checking for primality until terminated.
	 * the list 'primes' used by the class instance will be updated with those prime numbers found.
	 */
	@Override
	public void run() {
		//while we are not interrupted...
		while(!Thread.currentThread().isInterrupted()){
			//add numbers and continue
			if(isPrime(numberChecking)){primes.add(numberChecking);}
			numberChecking++;
		}
		return;
	}
}

