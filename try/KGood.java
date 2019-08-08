import java.util.*;

public class KGood {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabddcdadadaeefecffg";
		int k = 4;
		
		int[] freq = new int[26];
		for(int i = 0; i < str.length(); i++){
			freq[str.charAt(i) - 'a']++;
		}
		
		// key is frequency and value is number of distinct characters 
		SortedMap<Integer, Integer> freqMap = new TreeMap<>();
		for(int i = 0; i < freq.length; i++){
			if(freq[i] != 0){
				if(!freqMap.containsKey(freq[i])){
					freqMap.put(freq[i], 1);
				}
				else{
					int numDistinctChars = freqMap.get(freq[i]);
					freqMap.put(freq[i], numDistinctChars + 1);
				}
			}
		}
		
		int numCharsToRemove = 0;
		while(freqMap.lastKey() - freqMap.firstKey() > k){
			int numCharsToRemoveOnLowerEnd = freqMap.get(freqMap.firstKey()) * freqMap.firstKey();
			int numCharsToRemoveOnHigherEnd = freqMap.get(freqMap.lastKey());
			
			if(numCharsToRemoveOnHigherEnd <= numCharsToRemoveOnLowerEnd){
				int newLastKey = freqMap.lastKey() - 1;
				
				numCharsToRemove += numCharsToRemoveOnHigherEnd;
				freqMap.remove(freqMap.lastKey());
				
				Integer numCharsOnNextSpot = freqMap.get(newLastKey);
				numCharsOnNextSpot = numCharsOnNextSpot == null? 0: numCharsOnNextSpot;
				
				freqMap.put(newLastKey, numCharsOnNextSpot + numCharsToRemoveOnHigherEnd);
			}
			else{
				numCharsToRemove += numCharsToRemoveOnLowerEnd;
				freqMap.remove(freqMap.firstKey());
			}
		}
		
		System.out.println(numCharsToRemove);
	}
}
