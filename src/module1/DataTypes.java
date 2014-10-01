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
		char charVar = 'a'+10;
		System.out.println(charVar+". We have gone along 10 characters in the letter set");
		

	}

}
