package lect8;

public class Basic2 {
	String name;
	private char c;
	final int rollno;
	final static int yearofadm=2014;
	boolean b;
	private static int numstudents;
	public static final int MaxStudentsAllowed=2;
	public Basic2(String nam,int rolln)
	{
		if(numstudents==MaxStudentsAllowed)
		{
			throw new RuntimeException("Max limit reached");
		}
		Basic2.numstudents++;
		name=nam;
		rollno=rolln;
	}

}
