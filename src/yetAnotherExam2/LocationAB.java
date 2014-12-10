package yetAnotherExam2;

public class LocationAB extends Location {
	int aaa;
	int bbb;

	public LocationAB(int pop, String ID, String name, int xxx, int yyy,
			int zzz, int aaa, int bbb) {
		super(pop, ID, name, xxx, yyy, zzz);
		this.aaa=aaa;
		this.bbb=bbb;
		this.total_disease += (aaa+bbb);
	}

}
