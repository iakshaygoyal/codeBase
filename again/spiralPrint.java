package again;

import lec04.TwoDimArray;

public class spiralPrint {

	public static void main(String[] args) {
		int[][] a = TwoDimArray.TAKE_INPUT();
		horizontalSpiralPrint(a);

	}
	
	public static void horizontalSpiralPrint(int[][] a){
		int rMin=0, rMax=a.length-1;
		int cMin=0, cMax=a[0].length-1;
		int nElements=a.length*a[0].length;
		int counter=0;
		
		while(counter<nElements){
			
			for(int i=cMin; i<=cMax && counter<nElements; i++){
				System.out.print(a[rMin][i]+", ");
				counter++;
			}
			rMin++;
			System.out.println();
			
			for(int i=rMin; i<=rMax && counter<nElements; i++){
				System.out.print(a[i][cMax]+", ");
				counter++;
			}
			cMax--;
			System.out.println();
			
			for(int i=cMax; i>=cMin && counter<nElements; i--){
				System.out.print(a[rMax][i]+", ");
				counter++;
			}
			rMax--;
			System.out.println();
			
			for(int i=rMax; i>=rMin && counter<nElements; i--){
				System.out.print(a[i][cMin]+", ");
				counter++;
			}
			cMin++;
			System.out.println();
		}
	}

}
