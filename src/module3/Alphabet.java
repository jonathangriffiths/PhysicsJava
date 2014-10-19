package module3;

import java.util.Random;



public class Alphabet {
	//INIT Random Number generator
	static Random generator = new Random();
	
	//INIT random character function
	public static char randomCharacter(){
		int value=generator.nextInt(128);
		char character = (char) value;
		return character;
	}


	public static void main(String[] args) {	
		//INIT
		StringBuilder str = new StringBuilder(1000); //pre-allocating memory like this is better, don't need to declare public/private etc. for what we have been asked to do
		int exceptionCount = 0;
		int runningTotal = 0;
		//LOOP
		for(int i=1; i<=1000; i++){
			char character=randomCharacter();//generate char
			if(Character.isLetterOrDigit(character)==true){//check if alphanumeric
				str.append(character);//append
				try{
					String charAsString = Character.toString(character);//needs to be string class to pass to parseInt
					int intValue=Integer.parseInt(charAsString);
					runningTotal+=intValue;
				} catch( Exception e ){
					exceptionCount++;
				}
			}
		}

		System.out.println("The string is: "+str+"\nThe length is: "+str.length());
		System.out.println("The number of exceptions is: "+exceptionCount);
		System.out.println("This is the total number of alphabetic characters");
		System.out.println("The total of the parseInts is: "+runningTotal);
		System.out.println("This is the sum of all the numeric elements of the string");
		
	}

}
