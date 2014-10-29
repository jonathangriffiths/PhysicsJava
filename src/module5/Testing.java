package module5;

import java.util.ArrayList;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello"); // add to end
		list.add("and"); // add to end
		list.add("welcome"); // add to end
		list.add(2,"another"); // add 3 at position 2
		list.set(3,"word");
		System.out.println(list);
		String o = list.get(1);
		list.remove(2);
		System.out.println(list);

		list.clear();
		System.out.println(list);

		boolean contains_and = list.contains("and");
		int location = list.indexOf("and");

	}

}
