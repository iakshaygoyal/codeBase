package dp;

public class maxmSquareSubArrayWith1s {

	public static void main(String[] args) {
		int[][] arr =  {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
		
		int[][] temp = new int[arr.length][arr[0].length];
		for(int i=0; i<temp.length; i++){
			for(int j=0; j<temp[0].length; j++){
				if(i == 0 || j == 0){
					temp[i][j] = arr[i][j];
				}
				else if(arr[i][j] == 1){
					temp[i][j] = Math.min(temp[i-1][j], Math.min(temp[i][j-1], temp[i-1][j-1])) + 1;
				}
				else{
					temp[i][j] = 0;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<temp.length; i++){
			for(int j=0; j<temp[0].length; j++){
				if(temp[i][j] > max){
					max = temp[i][j];
				}
			}
		}
		
		for(int i=0; i<max; i++){
			for(int j=0; j<max; j++){
				System.out.print("1 ");
			}
			System.out.println();
		}
	}

}
