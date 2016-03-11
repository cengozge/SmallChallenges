

public class StringBlowUp {

/**
 * 	Returns a version of the original string as follows: 
 * 	each digit 0-9 that appears in the original string is 
 *  replaced by that many occurrences of the character to 
 *  the right of the digit. So the string "a3tx2z" yields
 *  "attttxzzz", and "12x" yields "2xxx". A digit not 
 *  followed by a character (i.e. at the end of the string) 
 * 	is replaced by nothing.	
 * @param args
 */
	
	public static void main(String[] args) {

		String input = "a3tx2z";
		//String input = "12x";
		String[] array = input.split("");

		String[] newArray = replace(array);
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i]);
		}
	}

	public static String[] replace(String[] array){
		String newChar = "";
		int tempIndex = 0;
		for (int i = tempIndex; i < array.length; i++) {

			char c = array[i].charAt(0);

			if(Character.isDigit(c) ){
				newChar = "";
				for (int j = 0; j < Integer.parseInt(String.valueOf(array[i].charAt(0))); j++) {
					newChar += (String.valueOf(array[i+1]));
				}
				tempIndex = i-1 + Integer.parseInt(String.valueOf(array[i].charAt(0)));
				array[i] = newChar;
			}
		}
		return array;
	}

}
