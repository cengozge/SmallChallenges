

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class NonrepetetiveChar {

	public static void main(String[] args) {
		String s = "tfa";
		char c = findFirstNonRepetetiveChar(s);
		System.out.println(c);
	}

	public static char findFirstNonRepetetiveChar(String s){

		Map<Character,Integer> map = new LinkedHashMap<>(s.length());
		char[] charArray = s.toCharArray();

		for (char c : charArray) {
			map.put(c, map.containsKey(c) ? map.get(c)+1 : 1 );
		}
		
		/**
		for (Entry<Character,Integer> entry : map.entrySet()) { if (entry.getValue() == 1) { return entry.getKey(); } }
		**/
		
		Comparator<? super Entry<Character, Integer>> valueComparator = (entry1,
				entry2) -> entry1.getValue().compareTo(entry2.getValue());

		Optional<Entry<Character, Integer>> minValue = map.entrySet().stream().min(valueComparator);

		return minValue.get().getKey();
	}
}
