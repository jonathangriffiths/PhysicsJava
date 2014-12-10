package exam2LastYear;
/**
 * Class organism is a superclass for containers of plants and animals
 * @author Jonathan Griffiths
 *
 */
public class Organism {
	//init variables
private double lat;
private double lng;
private String ID;
private String name;
/** Constructor stores data according to name of arguments*/
public Organism(double latitude, double longitude, String identifier, String taxName){
	lat = latitude;
	lng=longitude;
	ID=identifier;
	name=taxName;
}

/**function simply returns private variable latitude to user*/
public double getLat(){
	return lat;
}

/**function simply returns private variable longitude to user*/
public double getLong(){
	return lng;
}

/**function simply returns private variable ID to user*/
public String getID(){
	return ID;
}

/**function simply returns private variable taxinomic name to user*/
public String getName(){
	return name;
}



public String toString(){
	String str;
	str = "NEW ORGANISM:\nName: "+name+"\nLatitude: "+lat+"\nLongitude: "+lng+"\nID: "+ID;
	return str;
}

}
