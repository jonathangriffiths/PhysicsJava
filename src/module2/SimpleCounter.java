package module2;

public class SimpleCounter { 
	private int counter; // member variable public SimpleCounter() {} // constructor (ignore for now) 
	private static int max = 1000;
	public SimpleCounter(int val) { counter = val; } // set counter to whatever value you want 
	public SimpleCounter() {}
	int getCounter() {return counter;} // method to set value 
	void setCounter(int val) {if(val<=max) counter = val; else System.out.println("The value input was above the max");} // retrieve value
} 