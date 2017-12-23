import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class isSubstring {
static String a = "devops";
static String b = "evo";
public static void main(String[] args) {
	boolean index = isSub(a,b);
	System.out.println(index);
}
public static boolean isSub(String a,String b) {
Pattern pattern  = Pattern.compile("(evo){1,}");
Matcher match = pattern.matcher(a);

while(match.find()) {
	System.out.println(match.start()+" "+ match.end());
}
return true;

}

}

