package module1;

public class Testing {

	public static void main(String[] args) {
		int integer = 10;
		double doub =  integer;
		System.out.println(doub);
		
		
		double[] anArray  = {1.1, 2.3, 3.3};
		System.out.println(anArray[1]);
		
		
		
			//for loop prints 1-10
			for (int i=0; i<=10; i++){
				System.out.println(i);
			}
			//while loop prints 5 to -15
			int j=5;
			while (j>=-15){
				System.out.println(j);
				j--;
			}
			//either loop prints 2.4 to 14.9 step 0.5
			double k=2.4;
			while (k<15){
				System.out.println(k);
				k+=0.5;
			}	
			
			long timeNow=System.currentTimeMillis();
			System.out.println(timeNow);

	

	}

}
