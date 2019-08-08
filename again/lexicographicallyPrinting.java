package again;

public class lexicographicallyPrinting {

	public static void main(String[] args) {
		lexicographicallyPrinting(1);

	}
	
	public static void lexicographicallyPrinting(int x){
		if(x>10){
			return;
		}
		System.out.println(x);
		lexicographicallyPrinting(x*10);
		
		if(x%10==0){
			for(int i=1; i<10; i++){
				lexicographicallyPrinting(x+i);
			}
		}
		else if(x==1){
			for(int i=1; i<9; i++){
				lexicographicallyPrinting(x+i);
			}
		}
		
		//Wrong Process
//		for(int i=1; i<10; i++){
//			lexicographicallyPrinting(x+i);
//		}

	}

}
