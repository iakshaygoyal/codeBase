package back;
import java.util.*;
public class Sudoku {

	static int[][] matrix;
	static int row;
	static int col;
	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			matrix=new int[9][9];
			for(int j=0;j<9;j++){
				for(int k=0;k<9;k++){
					matrix[j][k]=scn.nextInt();
				}
			}
			row=0;
			col=0;
			if(isSolution()){
				for(int j=0;j<9;j++){
					for(int k=0;k<9;k++){
						System.out.print(matrix[j][k]+" ");
					}
				}
			}
			else{
				System.out.println("no");
			}
			System.out.println();
		}
	}
	
	static boolean isComplete(){
		for(;row<9;row++){
			for(;col<9;col++){
				if(matrix[row][col]==0){
					return false;
				}
			}
			col=0;
		}
		return true;
	}
	
	
	static boolean isSolution(){
		if(isComplete()){
			return true;
		}
		int ROW=row;
		int COL=col;
		for(int value=1;value<=9;value++){
			if(isSafe(value)){
				matrix[row][col]=value;
				if(isSolution()){
					return true;
				}
				row=ROW;
				col=COL;
				matrix[row][col]=0;
			}
		}
		return false;
	}
	
	static boolean isSafe(int value){
		for(int i=0;i<9;i++){
			if(matrix[i][col]==value){
				return false;
			}
		}
		
		for(int i=0;i<9;i++){
			if(matrix[row][i]==value){
				return false;
			}
		}
		
		int ROW=(row-(row%3));
		int COL=(col-(col%3));
		for(int i=ROW;i<(ROW+3);i++){
			for(int j=COL;j<(COL+3);j++){
				if(matrix[i][j]==value){
					return false;
				}
			}
		}
		return true;
	}
	
}