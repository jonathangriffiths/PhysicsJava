package dummy;

import java.util.ArrayList;
import java.util.List;

public class Testing {

	public static void main(String[] args) {
int int1=1;
int int2=2;
List<Integer> list =new ArrayList<Integer>();
list.add(int1);
list.add(int2);
int2+=5;
System.out.println(list.get(1));

	}

}