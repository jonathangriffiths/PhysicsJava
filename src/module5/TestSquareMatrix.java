package module5;


public class TestSquareMatrix {

	public static void main(String[] args) {
		
		//init matrices
		try{
		double[][] elementsA = { 
				{1, 0, 2}, 
				{0, 1, 0},
				{-3, 0, -1}
		};
			SquareMatrix A = new SquareMatrix(elementsA);
			
		double[][] elementsB = { 
				{0, 0, 1}, 
				{0, 1, 0},
				{-1, 0, 1}
		};
			SquareMatrix B = new SquareMatrix(elementsB);
			
		double[][] elementsC = { 
				{4, 3}, 
				{3, 2}
		};
			SquareMatrix C = new SquareMatrix(elementsC);
			
		double[][] elementsD = { 
				{-2, 3}, 
				{3, -4}
		};
			SquareMatrix D = new SquareMatrix(elementsD);

		
		//calculations
		SquareMatrix AplusB = SquareMatrix.add(A, B);
		SquareMatrix AminusB = SquareMatrix.subtract(A, B);
		SquareMatrix AB = SquareMatrix.multiply(A, B);
		SquareMatrix BA = SquareMatrix.multiply(B, A);
		SquareMatrix commAB=SquareMatrix.subtract(AB, BA);	
		SquareMatrix CD=SquareMatrix.multiply(C, D);
		
		System.out.println("A+B:\n"+AplusB.toString());
		System.out.println("A-B:\n"+AminusB.toString());
		System.out.println("AB:\n"+AB.toString());
		System.out.println("BA:\n"+BA.toString());
		System.out.println("[A,B]:\n"+commAB.toString());
		if(CD.equals(SquareMatrix.unitMatrix(2))){
			System.out.println("CD is equal to the unit matrix of its size.");
		}
		else {
			System.out.println("CD is not equal to the unit matrix of its size.");
		}
		
		} catch (Exception e){
			System.out.println("EXCEPTION! Error message: \n"+e.getMessage());
		}
		
	}

}
