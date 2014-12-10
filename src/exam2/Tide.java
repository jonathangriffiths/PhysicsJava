package exam2;

//import java.util.Calendar;
//import java.util.GregorianCalendar;
/**
 * Class is the container for tidal information for exam2
 * @author Jonathan Griffiths
 *
 */
public class Tide {
	private String ID;
	private String port;
	//private Calendar time; sadly this was giving me issues but would be a better implementation, I've left it in but commented out in case I try to fix it later
	private double sea_level;
	private double predicted_level;
	private double tidal_surge;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	/**
	 * empty constructor for setting up an empty object
	 */
	public Tide(){
		this.ID = "NA";
		this.port = "NA";
		//this.time=new GregorianCalendar(0, 0, 0, 0, 0);
		this.sea_level = 0;
		this.predicted_level = 0;
	}
/**
 * 
 * @param ID port ID
 * @param port port name
 * @param year year of recording
 * @param month month of recording
 * @param day day of recording
 * @param hour hour of recording
 * @param minutes minute of recording
 * @param sea_level recorded sea level
 * @param predicted_level predicted sea_level
 */
	public Tide(String ID, String port, int year, int month, int day, int hour, int minutes, double sea_level, double predicted_level){
		this.ID = ID;
		this.port = port;
		//this.time=new GregorianCalendar(year, month, day, hour, minutes);
		this.sea_level = sea_level;
		this.predicted_level = predicted_level;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute=minutes;
		this.tidal_surge=sea_level - predicted_level;
	}
	/**
	 * gets sea level
	 * @return sea level from object
	 */
	public double getLevel(){
		return sea_level;
	}
	/**
	 * gets tidal surge
	 * @return tidal surge from object
	 */
	public double getTidalSurge(){
		return tidal_surge;
	}
	/**
	 * gets ID 
	 * @return ID from object
	 */
	public String getID(){
		return ID;
	}
/**
 * simple toString method
 */
	public String toString(){
		String str;
		StringBuilder stb = new StringBuilder();
		stb.append("ID: ");
		stb.append(this.ID+"\n");
		stb.append("Port: ");
		stb.append(this.port+"\n");
		stb.append("Observed level (m): ");
		stb.append(this.sea_level+"\n");
		stb.append("Predicted level (m): ");
		stb.append(this.predicted_level+"\n");
		stb.append("Tidal surge (m): ");
		stb.append(this.tidal_surge +"\n");
		stb.append("Date (Y/M/D): ");
		//stb.append(this.time.get(Calendar.YEAR)+"/"+this.time.get(Calendar.MONTH)+"/"+this.time.get(Calendar.DAY_OF_MONTH)+"\n");
		stb.append(this.year+"/"+this.month+"/"+this.day+"\n");
		stb.append("Time (H:M): ");
		stb.append(this.hour+":"+this.minute);
		str=stb.toString();
		return str;
	}
}
