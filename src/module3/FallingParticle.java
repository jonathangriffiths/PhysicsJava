package module3;

public class FallingParticle {
	//INIT -
	final private double m;
	final private double d; //These shouldn't change within an instance!
	private double t;
	private double z;
	private double v;//Measured upwards
	private static double g = 9.80665; //all other variables will change between instances.

	//CONSTRUCTOR
	public FallingParticle(double mass, double drag) throws Exception{
		if(mass<=0){
			throw new Exception("FallingParticle: Mass must be >0");
		}
		if(drag<0){
			throw new Exception("FallingParticle: We don't have accelerating gel yet, drag must be >=0");
		}
		m=mass;
		d=drag;
	}

	///NON-STATIC METHODS - these make more sense for what we are doing, always want to refer to one instance.
	public void setZ(double height) throws Exception{
		if(height<0){
			throw new Exception("FallingParticle: Can't set height <0!");
		}
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
