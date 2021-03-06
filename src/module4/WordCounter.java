package module4;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class WordCounter {

	//returns user input as a string (return to end input)
	public static String getStringFromKeyword() throws IOException{
		InputStreamReader r = new InputStreamReader (System.in);
		BufferedReader b = new BufferedReader(r);
		System.out.println("Type your message now!:");
		String str=b.readLine();
		return str;
	}

	//does what it says - technically counts tokens, not just words
	public static int countWordsInResource(String urlName) throws IOException{
			//INIT streams/buffers/scanners
			URL u = new URL (urlName);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader b = new BufferedReader(isr);
			Scanner s = new Scanner(b); // going to the test URL demonstrates we are fine looking for whitespace for our design
			//sum word loop
			int sum=0;
			while(s.hasNext()){ 
				sum++;
				s.next();
			}
			s.close(); 
			return sum;

	}

	public static void main(String[] args) {
		try {
			String webpage = getStringFromKeyword();		
			int result=countWordsInResource(webpage);
			System.out.println("There were "+result+" words at: "+webpage);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}




	}

}
