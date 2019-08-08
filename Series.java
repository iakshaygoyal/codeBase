
public class Series {

	public static void main(String[] args) {
		int n=0,m=0,term;
		while(m<20)
		{
			term=3*n+2;
			if(term%4==0)
			{
				n++;
				continue;
			}
			System.out.print(term+"\t");
			n++;
			m++;
		}

	}

}
