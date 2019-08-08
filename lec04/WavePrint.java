package lec04;

public class WavePrint {

	public static void main(String[] args) {
		int[][] a=TwoDimArray.TAKE_INPUT();
		//HOR_WAVE_PRINT(a);
		VER_WAVE_PRINT(a);

	}
	public static void HOR_WAVE_PRINT(int[][] a)
	{
		int rows=a.length;
		int cols=a[0].length;
		for(int i=0;i<rows;i++)
		{
			if(i%2==0)
			{
				for(int j=0;j<cols;j++)
					System.out.print(a[i][j]+"\t");
			}
			else
			{
				for(int j=cols-1;j>=0;j--)
					System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static void VER_WAVE_PRINT(int[][] a)
	{
		int rows=a.length;
		int cols=a[0].length;
		for(int i=0;i<cols;i++)
		{
			if(i%2==0)
			{
				for(int j=0;j<rows;j++)
					System.out.print(a[j][i]+"\t");
			}
			else
			{
				for(int j=rows-1;j>=0;j--)
					System.out.print(a[j][i]+"\t");
			}
			System.out.println();
		}
	}

}
