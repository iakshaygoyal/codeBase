package lect23;

import java.util.HashMap;

public class Client {

	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.addWord("bear");
		trie.addWord("bell");
		trie.addWord("bid");
		trie.addWord("bull");
		trie.addWord("buy");
		trie.addWord("sell");
		trie.addWord("stop");
		trie.addWord("stock");
		
		System.out.println(trie.containsWord("buy"));
		System.out.println(trie.containsWord("sel"));
		
		trie.removeWord("sel");
		System.out.println(trie.containsWord("sell"));
		
		System.out.println(trie.containsWord("stock"));
		System.out.println(trie.containsWord("stop"));
		trie.removeWord("stock");
		System.out.println(trie.containsWord("stock"));
		System.out.println(trie.containsWord("stop"));
	}

	public static int bruteForceSearch(String source, String pattern) {
		int retVal = -1;

		int i = 0;
		while (i <= source.length() - pattern.length()) {
			int j = 0;
			while (j < pattern.length()) {
				if (source.charAt(i + j) != pattern.charAt(j)) {
					break;
				}

				j++;
			}

			if (j == pattern.length()) {
				retVal = i;
				break;
			}

			i++;
		}

		return retVal;
	}

	public static int boyerMoore(String source, String pattern) {
		int retVal = -1;
		HashMap<Character, Integer> charMap = getCharacterMap(pattern);

		int i = 0;
		while (i <= source.length() - pattern.length()) {
			int j = pattern.length() - 1;
			while (j >= 0) {
				if (source.charAt(i + j) != pattern.charAt(j)) {
					Character misMatch = source.charAt(i + j);

					if (!charMap.containsKey(misMatch)) {
						i = i + j + 1;
					} else {
						Integer psi = charMap.get(misMatch);

						if (j > psi) {
							i = i + j - psi;
						} else {
							i = i + 1;
						}
					}
					
					break;
				}

				j--;
			}

			if (j == -1) {
				retVal = i;
				break;
			}
		}

		return retVal;
	}

	public static HashMap<Character, Integer> getCharacterMap(String pattern) {
		HashMap<Character, Integer> retVal = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			retVal.put(pattern.charAt(i), i);
		}

		return retVal;
	}
}

