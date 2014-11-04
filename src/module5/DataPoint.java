package module5;

public class DataPoint {
	double x;
	double y;
	double ey;

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
