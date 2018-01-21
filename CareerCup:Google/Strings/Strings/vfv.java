package Strings;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class vfv {
	

	
	public static void main(String[] args) {
		final String regex = "(foo){1}";
		final String string = "kjhfooaaaaafoo";
		final String subst = "";

		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(string);
        int count=0;
		// The substituted value will be contained in the result variable
	    while(matcher.find()){
	    	count++;
	     }
	    System.out.println(count);
	}
}
