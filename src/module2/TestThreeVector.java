package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		//Assign Variables
		ThreeVector v1 = new ThreeVector(3,4,1);
		ThreeVector v2 = new ThreeVector(5,3,2);
		ThreeVector v3 = new ThreeVector(0,0,0);

		ThreeVector unit_v1 = ThreeVector.unitVector(v1);
		ThreeVector unit_v2 = ThreeVector.unitVector(v2);
		ThreeVector unit_v3 = ThreeVector.unitVector(v3);
		//Print vectors
		System.out.println("Vector 1:");
		System.out.println(v1);
		System.out.println("Vector 2:");
		System.out.println(v2);
		System.out.println("Vector 3:");
		System.out.println(v3+"\n");
		//Print unit vectors
		System.out.println("Unit Vector 1:");
		System.out.println(unit_v1);
		System.out.println("Unit Vector 2:");
		System.out.println(unit_v2);
		System.out.println("Unit Vector 3:");
		System.out.println(unit_v3+"\n");
		//Print dot/cross products:
		System.out.println("Vector 1 . Vector 2:");
		System.out.println(ThreeVector.scalarProduct(v1, v2));
		System.out.println("Vector 1 . Vector 3:");
		System.out.println(ThreeVector.scalarProduct(v1, v3));
		System.out.println("Vector 1 x Vector 2:");
		System.out.println(ThreeVector.vectorProduct(v1, v2));
		System.out.println("Vector 1 x Vector 3:");
		System.out.println(ThreeVector.vectorProduct(v1, v3)+"\n");
		//Print angles
		System.out.println("Angle Vector 1 to Vector 2: (radians)");
		System.out.println(ThreeVector.angle(v1, v2));
		System.out.println("Angle Vector 1 to Vector 3: (radians, and div0...)");
		System.out.println(ThreeVector.angle(v1, v3)+"\n");
		//No toString present - you get somehting along the lines of module2.ThreeVector@7f31245a
		//First two are self explanatory - the @ location presumably refers to a memory address.

	}

}
