package assignmentHeapsandHashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
	public class ainvay {
		public static void main(String[] args){
			int[] a={2,12,9,16,10,5,3,20,25,11,1,8,6};
			int[] b=longestConsecutiveSequence(a);
			System.out.println(Arrays.toString(b));
		}
		
		public static int[] longestConsecutiveSequence(int[] arr) {
		    // Keep track of each value we've seen in the array. Duplicates
		    // would screw up the algorithm, so we'll skip over them.
		    Set<Integer> seen = new HashSet<Integer>();
		    // Store the consecutive intervals we've seen so far. If we've
		    // seen all integers in the range [i, j] and haven't seen the
		    // integers i-1 or j+1, then (i, j) and (j, i) will both be in
		    // the map.
		    Map<Integer, Integer> intervals = new HashMap<Integer, Integer>();
		    for (int i : arr) {
		        if (seen.contains(i)) {
		            continue;
		        }
		        seen.add(i);
		        int lo = i, hi = i;
		        if (intervals.containsKey(i + 1)) {
		            // Coalesce with the interval above us.
		            hi = intervals.remove(i + 1);
		        }
		        if (intervals.containsKey(i - 1)) {
		            // Coalesce with the interval below us.
		            lo = intervals.remove(i - 1);
		        }
		        // Insert our new intervals. This will finish coalescing by
		        // overwriting the other half that we have not removed.
		        intervals.put(lo, hi);
		        intervals.put(hi, lo);
		    }
		    int lo = 0, hi = 0;
		    for (Entry<Integer, Integer> pair : intervals.entrySet()) {
		        if ((long)hi - lo < (long)pair.getKey() - pair.getValue()) {
		            lo = pair.getValue();
		            hi = pair.getKey();
		        }
		    }
		    int[] ret = new int[hi - lo + 1];
		    for (int i = 0; i < ret.length; i++) {
		        ret[i] = i + lo;
		    }
		    return ret;
		}
	}
