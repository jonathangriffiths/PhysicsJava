package module8;

public class CountdownTask implements Runnable {
	/**
	 * @author Jonathan Griffiths
	 * @version 1.0
	 */
	//init var
	private int time;

	/**
	 * Constructs CountdownTask object for use with Thread() to count down for a number of seconds.
	 * @param seconds gives the length of time that the countdown will run for in its thread.
	 */
	public CountdownTask(int seconds){
		time=seconds;
	}
	
	/**
	 * run() is called by the thread.start() procedure after initialising the thread
	 * Prints to screen every second, as well as at the start stating the timer length
	 */
	@Override
	public void run() {
		
		//tell user what they input
		System.out.println("The timer is for "+time+" seconds.");

		//loop through each second
		for(int i = time; i>0; i--){
			System.out.println("There are "+(i)+" seconds remaining.");
			//delay for a second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			if(i==1){System.out.println("Timer finished.");}
		}
	}

}
