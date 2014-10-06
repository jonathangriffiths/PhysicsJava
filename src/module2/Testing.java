package module2;

public class Testing {


	public static void main(String[] args) {
		SimpleCounter count1 = new SimpleCounter();
		count1.setCounter(25); //first method
		System.out.println("value of count1 is "+count1.getCounter()); 
		SimpleCounter count2 = new SimpleCounter(3);
		System.out.println("value of count2 is "+count2.getCounter()); 
		SimpleCounter count3 = new SimpleCounter();
		System.out.println("value of count3 is "+count3.getCounter()); 
		count3.setCounter(3000);
	} 
	
}
