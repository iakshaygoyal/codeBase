package lect3;

public class LargestOfThree {

	public static void main(String[] args) {
		int firstNum, secondNum, thirdNum;
		
		firstNum = 25;
		secondNum = 15;
		thirdNum = 35;
		
		int answer = largestOfThree(firstNum, secondNum, thirdNum);
		
		System.out.println(answer);
		/*
		if(firstNum >= secondNum && firstNum >= thirdNum){
			System.out.println(firstNum);
		}
		else {
			if(secondNum >= firstNum && secondNum >= thirdNum){
				System.out.println(secondNum);
			}
			else{
				System.out.println(thirdNum);
			}
		}
		*/
	}
	
	public static int largestOfThree(int firstNum, int secondNum, int thirdNum){
		if(firstNum >= secondNum && firstNum >= thirdNum){
			return firstNum;
		}
		
		if(secondNum >= firstNum && secondNum >= thirdNum){
			return secondNum;
		}
		
		return thirdNum;
	}

}
