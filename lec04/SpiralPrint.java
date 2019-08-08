package lec04;

public class SpiralPrint {

	public static void main(String[] args) {
		int[][] a=TwoDimArray.TAKE_INPUT();
		HOR_SPIRAL_PRINT(a);

	}
	public static void HOR_SPIRAL_PRINT(int[][] a)
	{
		int rmin=0,cmin=0;
		int rmax=a.length-1;
		int cmax=a[0].length-1;
		int counter=0;
		int n=(a.length)*(a[0].length);
		while(counter<n)
		{
			if(counter<n)
			{
			for(int col=cmin;col<=cmax;col++)
			{
				System.out.print(a[rmin][col]+"\t");
				counter++;
			}
			rmin++;
			System.out.println();
			}
			if(counter<n)
			{
			for(int row=rmin;row<=rmax;row++)
			{
				System.out.print(a[row][cmax]+"\t");
				counter++;
			}
			cmax--;
			System.out.println();
			}
			if(counter<n)
			{
			for(int col=cmax;col>=cmin;col--)
			{
				System.out.print(a[rmax][col]+"\t");
				counter++;
			}
			rmax--;
			System.out.println();
			}
			if(counter<n)
			for(int row=rmax;row>=rmin;row--)
			{
				System.out.print(a[row][cmin]+"\t");
				counter++;
			}
			cmin++;
			System.out.println();
		    }
		}
	}

