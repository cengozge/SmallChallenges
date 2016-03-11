
public class FormatPhoneNumber {

	public static void main(String[] args) {
		
		System.out.println(format("00-44  48 5555 8361")); //output: 004-448-555-583-61
		System.out.println(format("0 - 22 1985--324")); //output: 022-198-53-24
		System.out.println(format("555372654")); //output: 555-372-654
	}
	
	public static String format(String s){
		
		s = s.replaceAll("-", "").replaceAll(" ", "");
		
		String toBeReturned = "", lastDigitString = "";
		int lastDigitNum = 0, newLength = 0, realLength = s.length();
		
		//It must include at least 2 digits
		if(realLength <= 2)
			toBeReturned = "Must be at least 2 digits for formatting";
		
		//Find how many last digits except 3digits groups
		if(realLength % 3 == 0){
			lastDigitNum = 0;
		}
		else if(realLength % 3 == 2){
			lastDigitNum = 2;
		}
		else if(realLength % 3 == 1){
			lastDigitNum = 4;
		}
		
		newLength = s.length()-lastDigitNum;// will be grouped in 3 digits from start to index of the start of last digits
		char[] exceptLastDigitsArray = new char[newLength], lastDigitArray = new char[lastDigitNum];
		s.getChars(0, newLength, exceptLastDigitsArray, 0);// copy first part into array
		s.getChars(newLength, s.length(),lastDigitArray, 0);// copy second part into array
		int j = 0;
		while(newLength > 0)
		{
			toBeReturned = toBeReturned.concat(s.substring(j,j+3));
			newLength -= 3;
			if(lastDigitNum != 0 || newLength != 0){
				toBeReturned = toBeReturned.concat("-");
			}
			j+=3;
		}
		lastDigitString = String.valueOf(lastDigitArray);
		if(lastDigitNum == 4){// çakallýk started
			lastDigitString = lastDigitString.substring(0, 2)+"-"+lastDigitString.toString().substring(2, 4);
		}
		toBeReturned = toBeReturned.concat(lastDigitString);
		return toBeReturned;
	}
}
