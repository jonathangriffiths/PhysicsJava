package module6;

public class DataPoint {
	//init var
	protected double x;
	protected double y;
	protected double ey;

	public DataPoint(double x, double y, double ey){
		this.x=x;
		this.y=y;
		this.ey=ey;
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

	public String toString(){
		String str= "x = " + x + ", y = " + y +" +- " + ey;
		return str;
	}
}
