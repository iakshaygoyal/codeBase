package LL;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		
		list.addLast("Hello");
		list.display();
		list.addLast("there");
		list.display();
		list.addLast("universe");
		list.display();
		
		list.addFirst("bingo");
		list.display();
		list.addFirst("whatelse");
		list.display();
		
		list.addAt("abracadabra", 3);
		list.display();
		
//		while(!list.isEmpty()){
//			System.out.println(list.removeFirst());
//			list.display();
//		}
		
//		System.out.println(list.removeAt(3));
//		list.display();
//		
//		System.out.println(list.removeAt(3));
//		list.display();
//		
//		System.out.println(list.removeAt(3));
//		list.display();
//		
//		System.out.println(list.removeAt(2));
//		list.display();
//		
//		
//		System.out.println(list.removeAt(0));
//		list.display();
//		
//		System.out.println(list.removeAt(0));
//		list.display();
		
//		System.out.println(countClimb(4));
		
		System.out.println(subsetSum(new int[] {1, 2, 3, 4, 5}, 0, 5));
	}
	
	public static int countClimb(int num){
		if(num < 0){
			return 0;
		}
		else if (num == 0){
			return 1;
		}
		
		return countClimb(num - 1) + countClimb(num - 2) + countClimb(num - 3);
	}
	
	public static int cC2(int num){
		if(num == 3){
			return 4;
		}
		else if(num == 2){
			return 2;
		}
		else if(num == 1){
			return 1;
		}
		
		return countClimb(num - 1) + countClimb(num - 2) + countClimb(num - 3);
	}

	public static ArrayList<ArrayList<Integer>> subsetSum(int[] arr, int si, int sum){
		if(si == arr.length - 1){
			if(arr[si] == sum){
				ArrayList<ArrayList<Integer>> retVal = new ArrayList<>();
				ArrayList<Integer> item = new ArrayList<>();
				
				item.add(arr[si]);
				retVal.add(item);
				
				return retVal;
			}
			else if(sum == 0){
				ArrayList<ArrayList<Integer>> retVal = new ArrayList<>();
				ArrayList<Integer> item = new ArrayList<>();
				
				retVal.add(item);
				
				return retVal;
			}
			else{
				ArrayList<ArrayList<Integer>> retVal = new ArrayList<>();
				return retVal;
			}
		}
		
		ArrayList<ArrayList<Integer>> excluders = subsetSum(arr, si + 1, sum);
		ArrayList<ArrayList<Integer>> includers = subsetSum(arr, si + 1, sum - arr[si]);
		
		ArrayList<ArrayList<Integer>> current = new ArrayList<>();
		
		current.addAll(excluders);
		for(int i = 0; i < includers.size(); i++){
			ArrayList<Integer> newList = new ArrayList<>();
			
			newList.addAll(includers.get(i));
			newList.add(arr[si]);
			
			current.add(newList);
		}
		
		return current;
	}
}
