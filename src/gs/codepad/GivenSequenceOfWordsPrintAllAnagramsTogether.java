package gs.codepad;// Java code tp print all anagrams together
import java.util.*;

public class GivenSequenceOfWordsPrintAllAnagramsTogether {

	private static HashSet<HashSet<String>> findAnagrams(ArrayList<String> list) {
		HashMap<HashMap<Character, Integer>, HashSet<String>> anaMap = new HashMap<>();
		for (String s: list) {
			HashMap<Character, Integer> map = new HashMap<>();
				for(int i = 0; i < s.length(); i++) {
					Character c = s.charAt(i);
					Integer count = map.get(c);
					if(count == null) {
						map.put(c, 1);
					} else {
						map.put(c, ++count);
					}
				}

				if(anaMap.containsKey(map)) {
					anaMap.get(map).add(s);
				} else {
					HashSet<String> al  = new HashSet<>();
					al.add(s);
					anaMap.put(map, al);
				}
		}

		HashSet<HashSet<String>> lists = new HashSet<>();
		for (HashMap map:anaMap.keySet()) {
			lists.add(anaMap.get(map));
		}
		return lists;
	}

	// Drivers Method
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("cat");
		list.add("dog");
		list.add("god");
		list.add("cat");

		System.out.println(findAnagrams(list));
	}
}

// This code is contributed by Arijit Basu(ArijitXfx)

