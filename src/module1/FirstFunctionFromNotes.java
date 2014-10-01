package module1;
import java.util.Date;
public class FirstFunctionFromNotes {

	public static void main(String[] args) {

		//First we have the date stuff

		System.out.println("Program starting");
		Date myDate = new Date();
		System.out.println(myDate);
		System.out.println("Program date part finished");

		//then we have the printing stuff

		int x = 100; int y = 200;
		// Print the value of x to the screen
		System.out.println(x);
		// Prefix the printing of the value with some descriptive
		// information:
		System.out.println("The value of x is "+x);
		// Note the "" for any words
		// The + means append to the output going to the screen
		System.out.println(" x = "+x+" and y = "+y);
		// We can have any number of things appended using a +

		//Then we'll assign some variables

		// built-in variable type declaration
		int n;   // an integer
		float e; // a 32 bit real number
		float E; // "e" and "E are different variables
		// Remember - Java is case sensitive !
		float mass,momentum;  // meaningful names make code easier to read

		//some information about data types:

		// built-in integer data types
		// range     ([MIN,MAX])
		byte   ib;  // 8-bits    ([-128,+127])
		short  is;  // 16-bits   ([-32768,+32767])
		int    ii;  // 32-bits   ([approx-2.1e9,+2.1e9])
		long   il;  // 64-bits   ([approx-9e18,+9e18])
		//built-in floating point (real) data types
		// range     +/- ([SMALLEST,LARGEST])
		float  fw;  // 32-bits   +/- ([1.4e-45,3.4e38])
		double dw;  // 64-bits   +/- ([4.9e-324,1.8e308])

		//Variable assignment

		// The assignment operator = assigns a value to a variable,
		// or assigns the value of one variable to another
		double xd = 100.234;
		int    ix = 100;
		int    ia = ix;

		int ix1 = 1234567890;
		int iy = 10*ix1;        // Starts from the bottom end of the values allowed
		long ixl = 1234567890;
		long iyl = 10*ixl;     // Continues as is within capacity
		System.out.println("Printing values at edges of allowed values");
		System.out.println(iy);
		System.out.println(iyl);

		//Some conversion fun

		int larger_integer= 123456789;
		int smaller_integer = 123456788;
		System.out.println(larger_integer);
		System.out.println(smaller_integer);
		System.out.println("Differences between integers");
		System.out.println(larger_integer-smaller_integer);
		float large_int_float = larger_integer;   // this is a widening conversion
		float small_int_float = smaller_integer;
		System.out.println(large_int_float);
		System.out.println(small_int_float);
		System.out.println("Difference between the converted floats");
		System.out.println(large_int_float-small_int_float);
		double large_int_doub = larger_integer;   // this is a widening conversion
		double small_int_doub = smaller_integer;
		System.out.println(large_int_doub);
		System.out.println(small_int_doub);
		System.out.println("Difference between the converted floats");
		System.out.println(large_int_doub-small_int_doub);
		// What happens when you make these doubles instead of floats ?


		//shortening
		short shrt=1000;
		byte bt= (byte) shrt;
		System.out.println(bt);


		//mod test
		int a_little_mod=17%3;
		System.out.println(a_little_mod);

		//boolean testing
		int nothing=0;
		int one=1;
		int two=2;
		System.out.println(nothing<<one);
		System.out.println(one>>nothing);
		System.out.println("power test");
		System.out.println(2^17);
		
		//month stuff
		
		int month = 2;
		// Note the syntax of the "case" statement including the colon.
		//
		// Note the required "break" after the code for each case, which
		// jumps to the code immediately following the final "}" at the
		// end of the switch construction.
		switch (month) {
		case 1:
			System.out.println("Jan");
			break;
		case 2:
			System.out.println("Feb");
			break;
		case 3:
			System.out.println("Mar");
			break;
		default:
			System.out.println("???");
			break;
		}

		
		
		
	}

}
