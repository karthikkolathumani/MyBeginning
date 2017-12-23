import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class isSubstring {
static String a = "devops";
static String b = "evo";
public static void main(String[] args) {
	isSub(a,b);
	
}
public static boolean isSub(String a,String b) {
Pattern pattern  = Pattern.compile("(evo){1,}");
Matcher match = pattern.matcher(a);
int start=-1;
int end=-1;
while(match.find()) {
start = match.start();
end = match.end();
}

if(start<0 && end<0) {
	return false;
}
System.out.println("Starts at : " + start);
return true;
}

}

