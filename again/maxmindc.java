package again;

public class maxmindc {

	public static void main(String[] args) {		
		mm(0, a.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(max);
		System.out.println(min);
	}
	
	static int max, min;
	static int[] a = new int[]{5,4,3,2,1,7,12,4,3};
	
	public static void mm(int si, int fi, int m1, int m2){
		if(si == fi){
			m1 = m2 = a[si];
		}
		else if(si == fi-1){
			if(a[si] > a[fi]){
				if(max < a[si]){
					max = a[si];
				}
				if(min > a[fi])
				min = a[fi];
			}
			else{
				if(max < a[fi]){
					max = a[fi];
				}
				if(min > a[si])
				min = a[si];
			}
		}
		else{
			int mid = (si + fi) / 2;
			mm(si, mid, max, min);
			mm(mid+1, fi, max, min);
		}
	}

}
