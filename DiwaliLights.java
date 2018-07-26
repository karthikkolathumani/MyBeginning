import java.math.BigInteger;

public class DiwaliLights {
	
	
	
	static BigInteger factorial(BigInteger bg) {
		
		BigInteger res;
		
		if(bg.equals(BigInteger.ZERO) || bg.equals(BigInteger.ONE)) return BigInteger.ONE;
		
		res =  factorial(bg.subtract(BigInteger.ONE)).multiply(bg);
		return res;
		
	}
	
	static long combination(int n) {
		BigInteger b ;
		b = BigInteger.valueOf(n);
		BigInteger num;
		BigInteger rAns;
		BigInteger last;
		BigInteger result = BigInteger.ZERO;
		for(int i=1;i<=n;i++) {
			
		BigInteger r = BigInteger.valueOf(i);
		num	= factorial(b);
		rAns = factorial(r);
		last = factorial(b.subtract(r));
		
		result = result.add(num.divide(rAns.multiply(last)));
			
		}
		
		result = result.mod(BigInteger.valueOf(100000));
		
		return result.longValue();
		
	}
	
public static void main(String[] args) {

	System.out.println(combination(3));
}

}
