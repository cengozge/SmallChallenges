

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.IntStream;

public class FindPathIndex {

	public static void main(String[] args) {
		
		int[] array = {7,3,7,3,1,3,4,1};
		solution(array);
		
	}

	public static int solution(int[] A) {
        
		List<Integer> list = Arrays.asList(7,3,7,3,1,3,4,1);
        Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        Set<Integer> set = new HashSet<>();
        set.addAll(list);
		int[] indices1 = null;
		
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			indices1 = IntStream.range(0, list.size()).filter(i -> list.get(i) == integer).toArray();
			map1 = put(indices1, map1);
		}
		
		int maxValueInMap=(Collections.max(map1.keySet()));
		int minValueInMap=(Collections.min(map1.values()));
		System.out.println(minValueInMap + " " + maxValueInMap);
		return 0;
	}
	
	public static Map<Integer,Integer> put(int[] indices1, Map<Integer,Integer> map1){
		
		Arrays.asList(indices1);
		//find max 
		OptionalInt a = IntStream.of(indices1).max();
		int max = a.getAsInt();
		
		//find min
		OptionalInt b = IntStream.of(indices1).min();
		int min = b.getAsInt();
		
		map1.put(min, max);
		
		return map1;
	}
	
}
