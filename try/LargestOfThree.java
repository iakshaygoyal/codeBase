
public class LargestOfThree {

	public static void main(String[] args) {
		int firstNum, secondNum, thirdNum;
		
		firstNum = 25;
		secondNum = 15;
		thirdNum = 35;
		
		if(firstNum >= secondNum && firstNum >= thirdNum){
			System.out.println(firstNum);
			return;
		}
		
		if(secondNum >= firstNum && secondNum >= thirdNum){
			System.out.println(secondNum);
			return;
		}
		
		System.out.println(thirdNum);
		
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

}
