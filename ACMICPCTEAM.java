
public class ACMICPCTEAM {
	
	static int countOnes(String temp[]) {
		int result =0;
		for(int i=0;i<temp.length;i++) {
			if(temp[i].equals("1"))  result++;
		}
		return result;
	}
	
	static int countOnes(String temp) {
		int result =0;
		for(int i=0;i<temp.length();i++) {
			if(temp.charAt(i)=='1')  result++;
		}
		return result;
	}
	
	
	static int[] count(int a[]) {
		
		int numerify[] = new int[a.length];
		int out[] = new int[2];
		
		
		
		for(int i=0;i<a.length;i++) {
			String temp = a[i]+"";
			String[] tempx = temp.split("0");
			int countNumbers = tempx.length;
			numerify[i] = countNumbers;
		}
		
		for(int c: numerify) System.out.println(c);
		
		
//		int totalSubs = a[0]+"".length();
//		
//		int maxSubs = 0;
//		
//		for(int i=0;i<numerify.length-1;i++) {
//			for(int j=1;i<numerify.length;j++) {
//				int sum = numerify[i] +numerify[j];
//				maxSubs = Math.max(sum, maxSubs);
//			
//			}
//		}
//		
//		out[0] = maxSubs;
//		int mxi = 0;
//		int ans =0;
//		for(int j=0;j<a.length;j++) {
//		for(int i = a.length-1;i>=0;i--) {
//			ans ^= a[i]; 	
//		}
//		String temp = ans+"";
//		int count = countOnes(temp);
//		if(count==totalSubs) {
//			
//			out[1] =count;
//			}
//		}
//		
		
		return out;
	}
		
	
	
	public static void main(String[] args) {
		int a[] = {10101,11100,11010,00101};
		
		int out[] = count(a);
		
		for(int c:out) System.out.println(c);
		
		
		
	
	}

}
