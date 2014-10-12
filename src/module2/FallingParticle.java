package module2;

public class FallingParticle {
	//INIT -
	final private double m;
	final private double d;
	private double t;
	private double z;
	private double v;//Measured upwards
	private static double g = 9.80665; //all other variables will change between instances.

	//CONSTRUCTOR
	public FallingParticle(double mass, double drag){
		m=mass;
		d=drag;
	}

	///NON-STATIC METHODS - these make more sense for what we are doing.
	public void setZ(double height){
		z=height;
	}
	public double getZ(){
		return z;
	}
	public void setV(double vel){
		v=vel;
	}
	public double getV(){
		return v;
	}
	public double getT(){
		return t;
	}
	public void doTimeStep(double deltaT){
		double a=(d*v*v/m)-g; //similarly measured upwards
		v+=a*deltaT;
		z+=v*deltaT;
		t+=deltaT;
	}
	public void drop(double deltaT){
		while(z>0){this.doTimeStep(deltaT);}
	}
	public String toString(){
		String str="z pos: "+this.getZ()+". Time: "+this.getT();
		return str;
	}

}
