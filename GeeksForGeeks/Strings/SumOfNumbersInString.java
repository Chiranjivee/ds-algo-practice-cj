class SumOfNumbersInString {

	static int findSum(String str) {

		String temp = "";
		int sum = 0;
		for (int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isDigit(ch))
				temp += ch;
			else {  
				sum += Integer.parseInt(temp);
				temp = "0";
			}
		}

		return sum + Integer.parseInt(temp);
	}

	// Driver code  
	public static void main(String[] args) {

		// input alphanumeric string  
		String str = "12abc20yz68";

		System.out.println(findSum(str));
	}
}
