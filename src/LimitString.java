

public class LimitString {

	public static void main(String[] args) {
		
		String s = "I have to do my foo";
		int limit = 10;
		
		//print until 7.character and . for others
		
		char[] charArray = s.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			if(i <= limit){
				System.out.print(charArray[i]);
			}
			else{
				System.out.print(".");
			}
		}
		
	}

}
