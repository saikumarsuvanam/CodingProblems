import java.util.*;

public class string_manipulations {
	public static void main(String[] args){
		
		System.out.println(reformat("abc",2));
	}
	private static String reformat(String s, int k) {
        int len = s.length();
        StringBuilder res = new StringBuilder();

        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                if (count == k) {
                    res.insert(0,"-");
                    count = 0;
                    i++;
                } else {
                    res.insert(0,c);
                    count++;
                }
            }
        }

        return res.toString();
    }
}
