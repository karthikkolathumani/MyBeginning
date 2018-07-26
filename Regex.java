import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Regex {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        String s = cs.nextLine();
        cs.close();
        getByteString(s);
    }
    
    public static void getByteString(String s) {
    	for(byte b: s.getBytes()) System.out.println(b);   
    	}
}