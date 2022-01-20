package gs.codepad;// Java code tp print all anagrams together
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {

	private static ArrayList<ArrayList<String>> findAnagrams(ArrayList<String> list) {
		HashMap<HashMap<Character, Integer>, ArrayList<String>> anaMap = new HashMap<>();
		for (String s: list) {
			HashMap<Character, Integer> map = new HashMap<>();
				for(int i = 0; i < s.length(); i++){

					Character c = s.charAt(i);
					Integer count = map.get(c);
					if(count == null){
						map.put(c, 1);
					}else{
						map.put(c, ++count);
					}
				}

				if(anaMap.containsKey(map)){
					anaMap.get(map).add(s);
				}else{
					ArrayList<String> al  = new ArrayList<>();
					al.add(s);
					anaMap.put(map, al);
				}
		}

		ArrayList<ArrayList<String>> lists = new ArrayList<>();
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
		list.add("ogd");
		list.add("god");
		list.add("atc");

		System.out.println(findAnagrams(list));
	}
}

// This code is contributed by Arijit Basu(ArijitXfx)

