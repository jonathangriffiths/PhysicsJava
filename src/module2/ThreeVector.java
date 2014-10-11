package module2;

public class ThreeVector {
	//Initialise variables
	private double xCoord;
	private double yCoord;
	private double zCoord;
	//Constructor - allows input of user-selected values
	public ThreeVector(double x, double y, double z){
		xCoord = x;
		yCoord = y;
		zCoord = z;
		if(x==0 && y==0 && z==0) 
			System.out.println("WARNING: value of 0 input for all terms! Beware div0.");
	}
	//Empty constructor forms vector value 1 in each x,y,z
	public ThreeVector(){
		xCoord=1.0;
		yCoord=1.0;
		zCoord=1.0;
	}
	//Static magnitude function, returns as double
	public static double magnitude(ThreeVector vector){
		double sumsquareX=vector.xCoord*vector.xCoord; // much more readable split up
		double sumsquareY=vector.yCoord*vector.yCoord;
		double sumsquareZ=vector.zCoord*vector.zCoord;
		double sumsquaretot=sumsquareX + sumsquareY + sumsquareZ;
		double result=Math.sqrt(sumsquaretot);
		return result;
	}
	//Non-Static magnitude function uses static form.	
	public double magnitude(){
		return magnitude(this);
	}
	//Static Unit Vector creator
	public static ThreeVector unitVector(ThreeVector vector){
		double mag=ThreeVector.magnitude(vector);
		ThreeVector unit=new ThreeVector(vector.xCoord/mag, vector.yCoord/mag, vector.zCoord/mag);
		return unit;
	}
	//Non-static Unit Vector creator
	public ThreeVector unitVector(){
		return unitVector(this);
	}

	//Print components as string
	public static String toString(ThreeVector vector){
		String str="The vector is: ("+vector.xCoord+", "+vector.yCoord+", "+vector.zCoord+")";
		return str;
	}
	//String non-static
	public String toString(){
		return toString(this);
	}
	//Static dot product
	public static double scalarProduct(ThreeVector vector1, ThreeVector vector2){
		double multX=vector1.xCoord*vector2.xCoord; //much more readable if split up
		double multY=vector1.yCoord*vector2.yCoord;
		double multZ=vector1.zCoord*vector2.zCoord;
		double dotprod=multX + multY + multZ;
		return dotprod;
	}
	//Non-static dot product
	public double scalarProduct(ThreeVector vector){
		return scalarProduct(this, vector);
	}
	//vector product function
	public static ThreeVector vectorProduct(ThreeVector vector1, ThreeVector vector2){
		double newX = vector1.yCoord * vector2.zCoord - vector1.zCoord*vector2.yCoord;
		double newY = -(vector1.xCoord * vector2.zCoord - vector1.zCoord*vector2.xCoord);
		double newZ = vector1.xCoord * vector2.yCoord - vector1.yCoord*vector2.xCoord;
		ThreeVector vecprod=new ThreeVector(newX, newY, newZ);
		return vecprod;
	}
	//Non static vector product
	public ThreeVector vectorProduct(ThreeVector vector){
		return vectorProduct(this, vector);
	}
	//vector addition
	public static ThreeVector add(ThreeVector vector1, ThreeVector vector2){
		double newX=vector1.xCoord+vector2.xCoord;
		double newY=vector1.yCoord+vector2.yCoord;
		double newZ=vector1.zCoord+vector2.zCoord;
		ThreeVector result= new ThreeVector(newX, newY, newZ);
		return result;
	}

}


