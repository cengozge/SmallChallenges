import java.util.HashMap;
import java.util.Map;

public class ElevatorPeople {

	public static void main(String[] args) {

		int[] A = {60,80,40};
		int[] B = {2,3,5};
		int M = 5, X = 2, Y = 200;
		solution(A, B, M, X, Y);
	}

	public static int solution(int[] A, int[] B, int M, int X, int Y) {

		int totalW = 0;
		int count = 0;
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		int indx = 0;
		int totalPerson = 0;
		while(indx <= A.length){

			if(indx == A.length){
				count += map.size();
				count ++;//to ground floor
				totalW = 0;
				totalPerson = 0;
				map = new HashMap<Integer, Integer>();
				break;
			}
			else if(totalPerson != X && totalW < Y && (totalW + A[indx] < Y)){
				
				totalW += A[indx];
				if(!map.containsKey(B[indx]))
					map.put(B[indx], A[indx]);
				else
					map.put(B[indx], map.get(B[indx]) + A[indx]);
				indx++;
				totalPerson++;
			}
			else{
				count += map.size();
				count ++;//to ground floor
				totalW = 0;
				totalPerson = 0;
				map = new HashMap<Integer, Integer>();
			}
			
		}
		System.out.println(count);
		return count;
	}
}
