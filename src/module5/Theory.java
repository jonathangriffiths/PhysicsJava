package module5;

public class Theory {
	int n;
	public Theory(int order){
		n=order;
	}

	public double y(double x){
		return Math.pow(x, n);
	}
}

