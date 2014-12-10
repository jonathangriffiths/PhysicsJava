package yetAnotherExam2;

/**
 * Container class simply holds the raw data and offers some getting methods
 * @author Jonathan Griffiths
 *
 */
public class Location {
	


	int pop;
	String ID;
	String name;
	int xxx;
	int yyy;
	int zzz;
	int total_disease;

	public Location(int pop, String ID, String name, int xxx, int yyy, int zzz){
		this.pop=pop;
		this.ID=ID;
		this.name=name;
		this.xxx=xxx;
		this.yyy=yyy;
		this.zzz=zzz;
		total_disease = xxx+yyy+zzz;
	}

	
	public String toString(){
		String str;
		str = "The region is "+name;
		return str;
	}
}
