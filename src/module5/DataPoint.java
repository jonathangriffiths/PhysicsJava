package module5;

public class DataPoint {
	private double x;
	private double y;
	private double ey;

	public DataPoint(double X, double Y, double EY){
		x=X;
		y=Y;
		ey=EY;
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double getEY(){
		return ey;
	}
}
