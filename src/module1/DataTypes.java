package module1;

public class DataTypes {
	

	public static void main(String[] args) {

		//producing '10' in various types of representation
		double doubVar = 10;
		System.out.println("double: "+doubVar);
		float floatVar = 10;
		System.out.println("float: "+floatVar);
		int intVar = 10;
		System.out.println("integer: "+intVar);
		long longVar = 10;
		System.out.println("long: "+longVar);
		byte byteVar = 10;
		System.out.println("byte: "+byteVar);

		//types of variable work well with themselves:
		System.out.println("The double squared gives: "+doubVar*doubVar);
		System.out.println("The float squared gives: "+floatVar*floatVar);
		System.out.println("The int squared gives: "+intVar*intVar);
		System.out.println("The long squared gives: "+longVar*longVar);
		System.out.println("The byte squared gives: "+byteVar*byteVar);

		//Mixing types is unpredictable:
		char charVar = 'a';
		System.out.println("character a + 10 (int) is: "+charVar+intVar+". We have gone along 10 characters in the letter set");
		System.out.println("10 + a (reversed) gives: "+(intVar + charVar)+". Which is an int --> 10 + the value of 'a' (97)");
		System.out.println("Order clearly matters - the first variable in the addition determines the format for the result");
		System.out.println("Similarly, 10 (byte) + 'a' is: "+(byteVar+'a'));
		//add int's to doubles
		System.out.println("Integer plus double gives: "+(intVar+doubVar)+". Which looks like a double!");
		//add long to byte
		System.out.println("Long plus float gives: "+(longVar+floatVar)+". Which could be either, but is probably a long based on our knowledge");
		//boolean boolVar=true;
		//We can't use our arithmetic tools on bools, will throw errors
		//String plus int
		String stringVar="Hello!";
		System.out.println("String plus int gives: "+(stringVar+intVar)+". Which is a concatenation.");
		//String plus float:
		System.out.println("String plus float gives: "+(stringVar+floatVar)+". Which is a concatenation as well.");
		System.out.println("String plus char gives: "+(stringVar+charVar)+". Which is a concatenation also");
		System.out.println("All the other tests seem to verify that what we have deduced about order informing data type is correct.");


		//Uninitialised variable stuff:
		//int j=1; int i; j=i+1;
		//System.out.println("Here is j: "+j+". Here is i: "+i+".");
		//This will return an error as we have not initialised i.
		//i is a local variable because we have created it inside the public static void main part of the code
		//local variables are not assigned the default value (here 0 for int)
		
		//casts
		double dub4cast = 4.99;
		int intcast = (int) dub4cast;
		System.out.println("New integer: "+intcast); System.out.println("Old double: "+dub4cast);
		System.out.println("The number is not rounded up, but instead anything after the dec. point is lost.");
	}

}
