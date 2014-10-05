package module1;

public class AlgorithmControl {



	public static void loop(){
		//for loop prints 1-20
		for (int i=0; i<=20; i++){
			System.out.println(i);
		}
	}
	
	public static void decrement(){
		//while loop prints 5 to -10
		int j=5;
		while (j>-11){
			System.out.println(j);
			j--;
		}
	}
	
	public static void increment(){
		//either loop prints 2.4 to 14.9 step 0.5
		double k=2.4;
		while (k<15){
			System.out.println(k);
			k+=0.5;
		}	
	}
	
	public static void incrementfor(){
		//Alternative method
		for(double l=2.4; l<=14.9; l+=0.5){
			System.out.println(l);
		}
	}
	
	public static int timer(){
		long timeNow=System.currentTimeMillis();
		int loop_counter=0;
		while(System.currentTimeMillis()<timeNow+4000){
			if(loop_counter%100==0){
				System.out.println("This many loops have run: "+loop_counter);
			}
			loop_counter++;
		}
		return loop_counter;
	}
	
	public static int timerImproved(long maxTime, int LoopSteps){
		long timeNow=System.currentTimeMillis();
		int loop_counter=0;
		while(System.currentTimeMillis()<timeNow+maxTime){
			if(loop_counter%LoopSteps==0){
				System.out.println("This many loops have completed: "+loop_counter);
			}
			loop_counter++;
		}
		return loop_counter;
	}

	public static void main(String[] args) {
		System.out.println("Loop:");
		loop();
		System.out.println("Decrement:");
		decrement();
		System.out.println("Increment:");
		increment();
		System.out.println("Increment alternative:");
		incrementfor();
		System.out.println("Timer");
		timer();
		System.out.println("Improved Timer: ");
		int moreprints =timerImproved(4000, 100);
		int fewerprints=timerImproved(4000, 50000);
		System.out.println("Loops for printing every hundred = "+moreprints+". Loops for printing every 50k = "+fewerprints+". Ratio (roughly!! - as an int) = "+(fewerprints/moreprints));
		System.out.println("We get through many more loops when we have less printing. This is because we are asking the CPU to do less work.");
		System.out.println("Because the CPU is doing less work (the printing is an extra command that must be run though), it can do more of the 'empty' cycles where it does not print to screen.");
		System.out.println("As a result, we get through more loops in the same amount of time.");
	}
}