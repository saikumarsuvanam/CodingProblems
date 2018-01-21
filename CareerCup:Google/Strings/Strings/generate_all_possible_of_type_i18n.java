package Strings;
import java.util.HashSet;

//https://www.careercup.com/question?id=5733696185303040
/*i18n (where 18 stands for the number of letters between the first i and the last n in the 
 * word “internationalization,”) Wiki it.
Generate all such possible i18n strings for any given string. for eg. "careercup"=>"c7p",
"ca6p","c6up","car5p","ca5up","care4p","car4up","caree3p","care3up"..till the count is 
0 which means its the complete string again.*/
public class generate_all_possible_of_type_i18n {
	static HashSet h = new HashSet();// To avoid duplicates

	static void iterative_method(String s)// best method for this problem
	{
		// no need of extra space in iterative method
		for (int i = 1; i < s.length(); i++) {

			for (int j = i; j < s.length(); j++) {
				if (j - i != 0) {

					System.out.println(s.substring(0, i) + (j - i) + s.substring(j));
				}

			}
		}
		System.out.println(s);
	}

	static void found_i_count_n_type(String s, String prefix, String suffix, int first, int last) {
		int count = s.length() - prefix.length() - suffix.length();
		if (count == 0) {
			if (!h.contains(prefix + suffix)) {
				h.add(prefix + suffix);
				System.out.println(prefix + suffix);
			}
			return;
		} else if (!h.contains(prefix + count + suffix)) {
			h.add(prefix + count + suffix);
			System.out.println(prefix + count + suffix);
		}
		;

		if (first < last) {

			found_i_count_n_type(s, prefix + s.charAt(first + 1), suffix, first + 1, last);

			found_i_count_n_type(s, prefix, s.charAt(last - 1) + suffix, first, last - 1);
		}

	}

	public static void main(String[] args) {
		String prefix = "";
		String suffix = "";
		String input = "careercup";
		if (input.length() == 2) {
			System.out.println(input);
			return;
		} else {
			prefix = "" + input.charAt(0);
			suffix = "" + input.charAt(input.length() - 1);
			found_i_count_n_type(input, prefix, suffix, 0, input.length() - 1);

		}

		iterative_method(input);

	}

}
