package module4;
import java.io.*;
import java.net.URL;
import java.util.Scanner;
public class WordCounter {

	public static String getStringFromKeyword() throws IOException{
		InputStreamReader r = new InputStreamReader (System.in);
		BufferedReader b = new BufferedReader(r);
		System.out.println("Type your message now!:");
		String str=b.readLine();
		return str;
	}

	public static int countWordsInResource(String urlName) throws IOException{
			//INIT streams/buffers/scanners
			URL u = new URL (urlName);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader b = new BufferedReader(isr);
			Scanner s = new Scanner(b); // going to the test URL demonstrates we are fine looking for whitespace for our design
			//sum word loop
			int sum=0;
			while(s.hasNext()){ //function returns true or false by itself
				sum++;
				s.next();
			}
			s.close(); // not strictly necessary for function but surely good practice
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
