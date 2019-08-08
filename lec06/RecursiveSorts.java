package lec06;

import lec03.ArrayBasic;

public class RecursiveSorts {

	public static void main(String[] args) {
		int[] a=new int[] {5,4,3,2,1};
//		REC_B_S(a,0,a.length-1);
//		REC_S_S(a,0,1);
		REC_I_S(a,1,1);
		ArrayBasic.PRINT_ARRAY(a);
	}
	public static void REC_B_S(int[] a,int si,int li)
	{
		if(li==0)
			return;
		else
			{
			if(si==li)
			{
				REC_B_S(a,0,li-1);
			}
			else
			{
				if(a[si]>a[si+1])
					ArrayBasic.SWAP(a,si,si+1);
				REC_B_S(a,si+1,li);
			}
		}
	}
	public static void REC_S_S(int[] a,int fi,int si)
	{
		if(fi==a.length-1)
			return;
		if(si==a.length)
		{
			REC_S_S(a,fi+1,fi+2);
		}
		else
		{
			if(a[fi]>a[si])
				ArrayBasic.SWAP(a, fi, si);
			REC_S_S(a,fi,si+1);
		}
	}
	public static void REC_I_S(int[] a,int fi,int prevfi)
	{
		if(prevfi==a.length)
			return;
		if(fi==0)
		{
			REC_I_S(a,prevfi+1,prevfi+1);
		}
		else
		{
			if(a[fi-1]>a[fi])
			{
				ArrayBasic.SWAP(a,fi-1,fi);
				REC_I_S(a,fi-1,prevfi);
			}
			else
			{
				REC_I_S(a,prevfi+1,prevfi+1);
			}
		}
	}

}
