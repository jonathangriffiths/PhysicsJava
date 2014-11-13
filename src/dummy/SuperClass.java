package dummy;

public class SuperClass {
	
	protected String name = "SuperClass";

	protected void print(String text) {
		System.out.println("SuperClass print: "+text);
	}
	protected String className() {return name;}

}
