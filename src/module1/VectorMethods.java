package module1;


public class VectorMethods {



	//function dotProduct takes the arguments v1a v1b v1c v2a v2b v2c
	//corresponding to the elements (a,b,c) in each of two vectors (1 and 2).
	//v1a is vector 1 element a, v2c vector 2 element c etc., input each as a double
	//The dot product will be calculated and returned as a double.
	double dotProduct (double v1a, double v1b, double v1c, double v2a, double v2b, double v2c){
		double answer = v1a*v2a + v1b*v2b + v1c*v2c;
		return answer;
	}

	//function dotProductArray takes the arguments vector1 and vector2 (both arrays of doubles)
	//arrays must be one dimensional, the function will find the dot product of the first three elements
	//This is returned as a double
	double dotProductArray (double[] vector1, double[] vector2){
		double answer=vector1[0]*vector2[0] + vector1[1]*vector2[1] + vector1[2]*vector2[2];
		return answer;
	}
	// Function takes arguments v1a v1b v1c for each of the three elements of a 3d column vector
	//input doubles for maximum compatibility. Returns magnitude of the vector
	double magnitude (double v1a, double v1b, double v1c){
		double answer= Math.sqrt(v1a*v1a + v1b*v1b + v1c*v1c);
		return answer;
	}
	//Function takes an array (must be one dimensional, contents as double, please.) Magnitude of
	//a 3d vector constructed from the first three elements will be returned.
	double magnitudeArray (double[] vector1){
		double answer = Math.sqrt(vector1[0]*vector1[0] + vector1[1]*vector1[1] + vector1[2]*vector1[2]);
		return answer;
	}
	//function dotProduct takes the arguments v1a v1b v1c v2a v2b v2c
	//corresponding to the elements (a,b,c) in each of two vectors (1 and 2).
	//v1a is vector 1 element a, v2c vector 2 element c etc., input each as a double
	//The angle between the vectors will be calculated and returned as a double, in degrees.
	double angle (double v1a, double v1b, double v1c, double v2a, double v2b, double v2c){
		double dot_product=dotProduct(v1a, v1b, v1c, v2a, v2b, v2c);
		double magA=magnitude(v1a, v1b, v1c);
		double magB=magnitude(v2a, v2b, v2c);
		double radians = Math.acos(dot_product/(magA*magB));
		double degrees = radians*180/Math.PI;
		return degrees;
	}

	//now we see when the array method becomes easier (many many fewer arguments):
	//Function takes two arrays (must be one dimensional, contents as double, please.) Angle between
	// the 3D vectors formed from the first three elements of each will be returned, in degrees.
	double angleArray (double[] vector1, double[] vector2){
		double dot_product = dotProductArray(vector1, vector2);
		double magA=magnitudeArray(vector1);
		double magB=magnitudeArray(vector2);
		double radians = Math.acos(dot_product/(magA*magB));
		double degrees = radians*180/Math.PI;
		return degrees;
	}

	public static void main(String[] args) {
		VectorMethods vm = new VectorMethods();

		//Vector assignment
		//By the way I understand that naming variables the same as the argument names
		//is very confusing/bad but it saves me some time as I type out the functions later!
		//would not do this on more complicated scripts
		double[] vector1 = {6,5,1};
		double[] vector2 = {2,4,3};
		double v1a = 6;
		double v1b = 5;
		double v1c = 1;
		double v2a = 2;
		double v2b = 4;
		double v2c = 3;

		//Vector assignment to fail:
		double[] failvector1 = {1,4,1};
		double[] failvector2 = {0,0,0};
		double fv1a = 1;
		double fv1b = 4;
		double fv1c = 1;
		double fv2a = 0;
		double fv2b = 0;
		double fv2c = 0;

		//Example solutions to the supplied vectors:
		System.out.println("The vectors we are using are {6,5,1} and {2,4,3}");
		System.out.println("The element wise dot product is: "+vm.dotProduct(v1a, v1b, v1c, v2a, v2b, v2c));
		System.out.println("The array wise dot product is: "+vm.dotProductArray(vector1, vector2));
		System.out.println("");
		System.out.println("The magnitude of the first vector by element is: "+vm.magnitude(v1a, v1b, v1c));
		System.out.println("The magnitude of the second vector by element is: "+vm.magnitude(v2a, v2b, v2c));
		System.out.println("The magnitude of the first vector by array is: "+vm.magnitudeArray(vector1));
		System.out.println("The magnitude of the second vector by array is: "+vm.magnitudeArray(vector2));
		System.out.println("");
		System.out.println("The angle between the vectors is (by element, in degrees): "+vm.angle(v1a, v1b, v1c, v2a, v2b, v2c));
		System.out.println("The angle between the vectors is (by array, in degrees): "+vm.angleArray(vector1, vector2));
		System.out.println("");
		System.out.println("We now switch to vectors {1,4,1} and {0,0,0}");
		System.out.println("The angle done element-wise returns: "+vm.angle(fv1a, fv1b, fv1c, fv2a, fv2b, fv2c)+" degrees");
		System.out.println("The angle done array-wise returns: "+vm.angleArray(failvector1, failvector2)+" degrees");
		System.out.println("Both return NaN (not a number) because of 0/0. Here is 0/0: "+0.0/0.0+". Meanwhile, 1/0: "+1.0/0.0+" (all in doubles)");
		System.out.println("Integer maths which fails like this throws errors, doubles gives us the Infinity/NaN");
	}

}
