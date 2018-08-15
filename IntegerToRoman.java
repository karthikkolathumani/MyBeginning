package leetcode;

public class IntegerToRoman {

	public static String getRoman(int num) {
		int values[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String roman[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuilder str = new StringBuilder();
		for(int i = 0 ;i < values.length ;i++) {
			while(num>=values[i]) {
				num -= values[i];
				str.append(roman[i]);
			}
		}
		
		return str.toString();
	}
	
	
	
	
	public static void main(String[] args) {
		int num = 1994;
		
		System.out.println(getRoman(num));
	}
}
