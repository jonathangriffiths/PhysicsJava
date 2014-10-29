package module5;

import java.util.Arrays;

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
				{-1, 0, -1}
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
		SquareMatrix sum = SquareMatrix.add(A, B);
		System.out.println("A+B:\n"+sum.toString());
		SquareMatrix difference = SquareMatrix.subtract(A, B);
		System.out.println("A-B:\n"+difference.toString());
		SquareMatrix AB = SquareMatrix.multiply(A, B);
		SquareMatrix BA = SquareMatrix.multiply(B, A);
		System.out.println("AB:\n"+AB.toString());
		System.out.println("BA:\n"+BA.toString());
		

		} catch (Exception e){
			System.out.println("EXCEPTION!");
		}
		
	}

}
