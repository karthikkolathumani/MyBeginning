import java.util.*;
public class GCD {

	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int a [] = {2,3,6};
	int b[] = {42,84};
	
//	int l = lcm(a);
//	int g = gcd(b);
//	System.out.println(l);
//	System.out.println(g);
//	int count = 0;
//	for(int i=l;i<=g;i = i+l) {
//		if(g%i==0) count++;
//	}
//	System.out.println(count);
	
	System.out.println(96%72);
	
    }
	
	public static int lcm(int a[]) {
		int result = a[0];
		for(int i=1;i<a.length;i++) {
			result = lcm(result,a[i]);
		}
		return result;
	}
	
	
	public static int gcd(int a[]) {
		int result = a[0];
		for(int i=1;i<a.length;i++) {
			result = gcd(result,a[i]);
		}
		return result;
	}
	
	
	public static int lcm(int a,int b) {
		return (a*b)/gcd(a,b);
	}
	
	public static int gcd(int a,int b) {
		while(a!=b) {
			if(a>b) a = a-b;
			else b = b-a;
		}
		return a;
	}
}
