package lect24;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(FibP(50).fibN);
		// System.out.println(Fib(6, new int[7]));
		// System.out.println(CountClimb(40));
		// System.out.println(CountClimbP(40).ccn);

		// System.out.println(lcs("abcdef", "agciejkfl"));
		// System.out.println(lcs("abcdef", "agciejkfl", new
		// int["abcdef".length() + 1]["agciejkfl".length() + 1]));
		// System.out.println(lcsIterative("abcdef", "aghcef"));
		// System.out.println(lcsP("abcdef", "aghcef", "abcdef", "aghcef").ij);
		System.out.println(editDistance("abche", "bbghi"));
//		System.out.println(editDistance("abc", "bbghi", new int["abc".length() + 1]["bbghi".length() + 1]));
		System.out.println(editDistanceIterative("abche", "bbghi"));
	}

	public static int Fib(int num) {
		if (num == 0 || num == 1) {
			return num;
		}

		int retVal;

		retVal = Fib(num - 1) + Fib(num - 2);

		return retVal;
	}

	private static class FibPair {
		int fibN;
		int fibNM1;

		FibPair(int fibN, int fibNM1) {
			this.fibN = fibN;
			this.fibNM1 = fibNM1;
		}
	}

	public static FibPair FibP(int num) {
		if (num == 0) {
			return new FibPair(0, 0);
		} else if (num == 1) {
			return new FibPair(1, 0);
		}

		FibPair resultM1 = FibP(num - 1);

		int fibN = resultM1.fibN + resultM1.fibNM1;
		int fibNM1 = resultM1.fibN;

		return new FibPair(fibN, fibNM1);
	}

	public static int Fib(int num, int[] storage) {
		if (num == 0 || num == 1) {
			return num;
		}

		int retVal;

		if (storage[num] != 0) {
			retVal = storage[num];
		} else {
			retVal = Fib(num - 1, storage) + Fib(num - 2, storage);
			storage[num] = retVal;
		}

		return retVal;
	}

	// Fibonnaci Iterative - O(n)

	public static int CountClimb(int num) {
		if (num == 1) {
			return 1;
		} else if (num == 2) {
			return 2;
		} else if (num == 3) {
			return 4;
		}

		int retVal;

		retVal = CountClimb(num - 1) + CountClimb(num - 2) + CountClimb(num - 3);

		return retVal;
	}

	public static class CCPair {
		int ccn;
		int ccnm1;
		int ccnm2;

		CCPair(int ccn, int ccnm1, int ccnm2) {
			this.ccn = ccn;
			this.ccnm1 = ccnm1;
			this.ccnm2 = ccnm2;
		}
	}

	public static CCPair CountClimbP(int num) {
		if (num == 1) {
			return new CCPair(1, 0, 0);
		} else if (num == 2) {
			return new CCPair(2, 1, 0);
		} else if (num == 3) {
			return new CCPair(4, 2, 1);
		}

		CCPair resultM1 = CountClimbP(num - 1);

		int ccn = resultM1.ccn + resultM1.ccnm1 + resultM1.ccnm2;
		int ccnm1 = resultM1.ccn;
		int ccnm2 = resultM1.ccnm1;

		return new CCPair(ccn, ccnm1, ccnm2);
	}

	public static int CountClimb(int num, int[] storage) {
		if (num == 1) {
			return 1;
		} else if (num == 2) {
			return 2;
		} else if (num == 3) {
			return 4;
		}

		int retVal;

		if (storage[num] != 0) {
			retVal = storage[num];
		} else {
			retVal = CountClimb(num - 1, storage) + CountClimb(num - 2, storage) + CountClimb(num - 3, storage);
			storage[num] = retVal;
		}

		return retVal;
	}

	// CountClimb Iterative - O(n)

	// Longest Common SS
	public static int lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		int retVal;

		if (s1.charAt(0) == s2.charAt(0)) {
			retVal = 1 + lcs(s1.substring(1), s2.substring(1));
		} else {
			int f1 = lcs(s1, s2.substring(1));
			int f2 = lcs(s1.substring(1), s2);

			retVal = Math.max(f1, f2);
		}

		return retVal;
	}

	public static int lcs(String s1, String s2, int[][] storage) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		int retVal;

		if (storage[s1.length()][s2.length()] != 0) {
			retVal = storage[s1.length()][s2.length()];
		} else {
			if (s1.charAt(0) == s2.charAt(0)) {
				retVal = 1 + lcs(s1.substring(1), s2.substring(1), storage);
			} else {
				int f1 = lcs(s1, s2.substring(1), storage);
				int f2 = lcs(s1.substring(1), s2, storage);

				retVal = Math.max(f1, f2);
			}

			storage[s1.length()][s2.length()] = retVal;
		}

		return retVal;
	}

	public static int lcsIterative(String s1, String s2) {
		int[][] storage = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(s1.length() - i) == s2.charAt(s2.length() - j)) {
					storage[i][j] = 1 + storage[i - 1][j - 1];
				} else {
					storage[i][j] = Math.max(storage[i - 1][j], storage[i][j - 1]);
				}
			}
		}

		return storage[s1.length()][s2.length()];
	}

	private static class LCSPair {
		Integer ij;
		ArrayList<Integer> iDim;
		ArrayList<Integer> jDim;

		LCSPair(int ij, ArrayList<Integer> iDim, ArrayList<Integer> jDim) {
			this.ij = ij;
			this.iDim = iDim;
			this.jDim = jDim;
		}
	}

	public static LCSPair lcsP(String s1, String s2, String os1, String os2) {
		if (s1.length() == 0 && s2.length() == 0) {
			int ij = 0;
			ArrayList<Integer> iDim = new ArrayList<>();
			ArrayList<Integer> jDim = new ArrayList<>();

			for (int i = 1; i <= os1.length(); i++) {
				iDim.add(0);
			}

			for (int j = 1; j <= os2.length(); j++) {
				jDim.add(0);
			}

			return new LCSPair(ij, iDim, jDim);
		}

		LCSPair resultM1 = lcsP(s1.substring(1), s2.substring(1), os1, os2);

		int ij;
		ArrayList<Integer> iDim = new ArrayList<>();
		ArrayList<Integer> jDim = new ArrayList<>();

		// calculating ij
		if (s1.charAt(0) == s2.charAt(0)) {
			ij = 1 + resultM1.ij;
		} else {
			ij = Math.max(resultM1.iDim.get(0), resultM1.jDim.get(0));
		}

		// calculating iDim
		for (int i = 1; i <= os1.length() - s1.length(); i++) {
			int num;

			if (os1.charAt(os1.length() - i - 1) == s2.charAt(0)) {
				num = 1 + resultM1.iDim.get(i - 1);
			} else {
				if (i == 1) {
					num = Math.max(resultM1.iDim.get(i), ij);
				} else {
					num = Math.max(resultM1.iDim.get(i), iDim.get(i - 2));
				}
			}

			iDim.add(num);
		}

		// calculating jDim
		for (int j = 1; j <= os2.length() - s2.length(); j++) {
			int num;

			if (s1.charAt(0) == os2.charAt(os2.length() - j - 1)) {
				num = 1 + resultM1.jDim.get(j - 1);
			} else {
				if (j == 1) {
					num = Math.max(resultM1.jDim.get(j), ij);
				} else {
					num = Math.max(resultM1.jDim.get(j), jDim.get(j - 2));
				}
			}

			jDim.add(num);
		}

		return new LCSPair(ij, iDim, jDim);
	}

	public static int editDistance(String s1, String s2) {
		if (s1.length() == 0) {
			return s2.length();
		} else if (s2.length() == 0) {
			return s1.length();
		}

		int retVal;

		if (s1.charAt(0) == s2.charAt(0)) {
			retVal = editDistance(s1.substring(1), s2.substring(1));
		} else {
			int costRp = 1 + editDistance(s1.substring(1), s2.substring(1));
			int costRm = 1 + editDistance(s1.substring(1), s2);
			int costAd = 1 + editDistance(s1, s2.substring(1));

			retVal = Math.min(costRp, Math.min(costRm, costAd));
		}

		return retVal;
	}

	public static int editDistance(String s1, String s2, int[][] storage) {
		if (s1.length() == 0) {
			return s2.length();
		} else if (s2.length() == 0) {
			return s1.length();
		}

		int retVal;

		if (storage[s1.length()][s2.length()] != 0) {
			retVal = storage[s1.length()][s2.length()];
		} else {
			if (s1.charAt(0) == s2.charAt(0)) {
				retVal = editDistance(s1.substring(1), s2.substring(1));
			} else {
				int costRp = 1 + editDistance(s1.substring(1), s2.substring(1), storage);
				int costRm = 1 + editDistance(s1.substring(1), s2, storage);
				int costAd = 1 + editDistance(s1, s2.substring(1), storage);

				retVal = Math.min(costRp, Math.min(costRm, costAd));
			}
			storage[s1.length()][s2.length()] = retVal;
		}

		return retVal;
	}

	public static int editDistanceIterative(String s1, String s2) {
		int[][] storage = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0) {
					storage[i][j] = j;
					continue;
				} else if (j == 0) {
					storage[i][j] = i;
					continue;
				}

				if (s1.charAt(s1.length() - i) == s2.charAt(s2.length() - j)) {
					storage[i][j] = storage[i - 1][j - 1];
				} else {
					int costRp = 1 + storage[i - 1][j - 1];
					int costRm = 1 + storage[i - 1][j];
					int costAd = 1 + storage[i][j - 1];

					storage[i][j] = Math.min(costRp, Math.min(costRm, costAd));
				}
			}
		}

		return storage[s1.length()][s2.length()];
	}
}
