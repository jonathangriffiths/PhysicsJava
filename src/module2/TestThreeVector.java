package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double x = 2;
		double y=2;
		int z=2;
		ThreeVector vector = new ThreeVector(x,y,z);
		System.out.println(vector.magnitude());
		System.out.println(ThreeVector.magnitude(vector));
		ThreeVector unit_vector=ThreeVector.unitVector(vector);
		System.out.println(ThreeVector.toString(vector));
		System.out.println(ThreeVector.toString(unit_vector));

	}

}
