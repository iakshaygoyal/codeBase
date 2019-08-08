package again.oops;

public class stu1 {
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name != null && name != "") {
			this.name = name;
		}
		else{
			// throw exception
		}
	}

	public final int rollNo;

	private static int numstu1 = 0;
	
//	public int getnumstu1(){
	// static and non-static all kind of data members are allowed
//		return stu1.numstu1;
//	}
	
	public static int getnumstu1(){
		// this and non-static data members not allowed
		return stu1.numstu1;
	}
	
	public static final int Maxstu1sAllowed = 1000;

	public stu1(String name, int rollNo) {
		if(stu1.numstu1 == stu1.Maxstu1sAllowed){
			throw new RuntimeException("Max limit reached");
		}
		stu1.numstu1++;
		this.setName(name);
		this.rollNo = rollNo;
	}
	
	public stu1(stu1 s){
		if(stu1.numstu1 == stu1.Maxstu1sAllowed){
			throw new RuntimeException("Max limit reached");
		}
		stu1.numstu1++;
		this.setName(s.name);
		this.rollNo = s.rollNo;
	}
}
