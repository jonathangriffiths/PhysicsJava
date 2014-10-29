package module5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SquareMatrix {

	private double[][] matrix;
	private int nRows;
	private int nCols;

	public SquareMatrix(double[][] elements) throws Exception{
		nRows = elements.length;
		nCols = Array.getLength(elements[0]); //the 2D array is really just an array of arrays, check length of first array
		if(nRows!=nCols){throw new Exception("Not a square Matrix");}
		matrix=elements;
	}

	public SquareMatrix unitMatrix(int size) throws Exception{
		if(size<=0){throw new Exception("Can't do unit matrix of size <1");}
		double[][] array = new double[size][size];
		for(int i=0; i<size; i++) { array[i][i]=0; }
		return new SquareMatrix(array);
	}
	
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception{
		//Check dimensions
		if(sm1.nCols != sm2.nCols || sm1.nRows != sm2.nRows){
			throw new Exception("The matrices are not the same dimensions");
		}
		//create new matrix
		SquareMatrix newMatrix = new SquareMatrix(new double[sm1.nRows][sm1.nCols]);
		//populate matrix
		for(int i=0; i<sm1.nRows; i++){
			for(int j=0; j<sm1.nCols; j++){
				newMatrix.matrix[i][j] = sm1.matrix[i][j] + sm2.matrix[i][j];
			}
		}
		//finish
		return newMatrix;
	}
	
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception{
		//Check dimensions
		if(sm1.nCols != sm2.nCols || sm1.nRows != sm2.nRows){
			throw new Exception("The matrices are not the same dimensions");
		}
		//create new matrix
		SquareMatrix newMatrix = new SquareMatrix(new double[sm1.nRows][sm1.nCols]);
		//populate matrix
		for(int i=0; i<sm1.nRows; i++){
			for(int j=0; j<sm1.nCols; j++){
				newMatrix.matrix[i][j] = sm1.matrix[i][j] - sm2.matrix[i][j];
			}
		}
		//finish
		return newMatrix;
	}
	
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception{
		//Check dimensions
		if(sm1.nCols != sm2.nCols || sm1.nRows != sm2.nRows){ 
			throw new Exception("The matrices are not the same dimensions");
		}
		//create new matrix
		SquareMatrix newMatrix = new SquareMatrix(new double[sm1.nRows][sm1.nCols]);
		//populate matrix
		for(int i=0; i<sm1.nCols; i++){
			for(int j=0; j<sm1.nCols; j++){
				for(int k=0; k<sm1.nCols; k++){
					newMatrix.matrix[i][j] += sm1.matrix[i][k] * sm2.matrix[k][j]; //TODO make this work
				}
			}
		}
		//finish
		return newMatrix;
	}
	
	public String toString(){ //TODO get some formatting to stop things becoming misaligned.
		StringBuilder strb=new StringBuilder();
		for(int i=0; i<nRows; i++){
			String nextRow = Arrays.toString(matrix[i]);
			strb.append(nextRow + "\n");
		}
		return strb.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(matrix);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		return true;
	}


	
	
}