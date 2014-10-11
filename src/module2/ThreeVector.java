package module2;

public class ThreeVector {
	//INIT
	private double xCoord;
	private double yCoord;
	private double zCoord;
	//CONSTRUCTOR - with arguments (3x double, x y & z)
	public ThreeVector(double x, double y, double z){
		xCoord = x;
		yCoord = y;
		zCoord = z;
		if(x==0 && y==0 && z==0) 
			System.out.println("WARNING: value of 0 for all terms! Beware div0.");
	}
	//CONSTRUCTOR - empty
	public ThreeVector(){
		xCoord=1.0;
		yCoord=1.0;
		zCoord=1.0;
	}

	//MAGNITUDE
	public static double magnitude(ThreeVector vector){
		double sumsquareX=vector.xCoord*vector.xCoord; // much more readable split up
		double sumsquareY=vector.yCoord*vector.yCoord;
		double sumsquareZ=vector.zCoord*vector.zCoord;
		double sumsquaretot=sumsquareX + sumsquareY + sumsquareZ;
		double result=Math.sqrt(sumsquaretot);
		return result;
	}
	//non-static
	public double magnitude(){
		return magnitude(this);
	}

	//UNIT VECTOR
	public static ThreeVector unitVector(ThreeVector vector){
		double mag=ThreeVector.magnitude(vector);
		ThreeVector unit=new ThreeVector(vector.xCoord/mag, vector.yCoord/mag, vector.zCoord/mag);
		return unit;
	}
	//non-static
	public ThreeVector unitVector(){
		return unitVector(this);
	}

	//TOSTRING
	public static String toString(ThreeVector vector){
		String str="("+vector.xCoord+"; "+vector.yCoord+"; "+vector.zCoord+")";
		return str;
	}
	//non-static
	public String toString(){
		return toString(this);
	}

	//DOT PRODUCT
	public static double scalarProduct(ThreeVector vector1, ThreeVector vector2){
		double multX=vector1.xCoord*vector2.xCoord; //much more readable if split up
		double multY=vector1.yCoord*vector2.yCoord;
		double multZ=vector1.zCoord*vector2.zCoord;
		double dotprod=multX + multY + multZ;
		return dotprod;
	}
	//non-static
	public double scalarProduct(ThreeVector vector){
		return scalarProduct(this, vector);
	}

	//VECTOR PRODUCT function
	public static ThreeVector vectorProduct(ThreeVector vector1, ThreeVector vector2){
		double newX = vector1.yCoord * vector2.zCoord - vector1.zCoord*vector2.yCoord;
		double newY = -(vector1.xCoord * vector2.zCoord - vector1.zCoord*vector2.xCoord);
		double newZ = vector1.xCoord * vector2.yCoord - vector1.yCoord*vector2.xCoord;
		ThreeVector vecprod=new ThreeVector(newX, newY, newZ);
		return vecprod;
	}
	//non-static
	public ThreeVector vectorProduct(ThreeVector vector){
		return vectorProduct(this, vector);
	}

	//ADDITION
	public static ThreeVector add(ThreeVector vector1, ThreeVector vector2){
		double newX=vector1.xCoord+vector2.xCoord;
		double newY=vector1.yCoord+vector2.yCoord;
		double newZ=vector1.zCoord+vector2.zCoord;
		ThreeVector result= new ThreeVector(newX, newY, newZ);
		return result;
	}
	//non-static
	public ThreeVector add(ThreeVector vector){
		return add(this, vector);
	}

	//ANGLE between vectors - radians
	public static double angle(ThreeVector vector1, ThreeVector vector2){
		double dotprod = scalarProduct(vector1, vector2);
		double magA=magnitude(vector1);
		double magB=magnitude(vector2);
		double costheta=dotprod/(magA*magB);
		double theta=Math.acos(costheta);
		return theta;
	}
	//non-static
	public double angle(ThreeVector vector){
		return angle(this, vector);
	
	}

}


