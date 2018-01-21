package Strings;
// google-interview-questions
/*

Given a string with multiple spaces write a function to in-place trim all spaces leaving a single space between words
e.g.
_ _ _ Hello _ _ _ World _ _ _
Hello _ World _ _ _ _ _ _ _ _ _
*/
public class removing_spaces {

	public static void main(String[] args) {
		String s = " Hello  World                     ";
		remove_spaces(s);
	}

	static void remove_spaces(String s) {
		boolean spaceFound = false;
		int j = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {

				if (!spaceFound) {
					j++;
					spaceFound = true;
				}

			} else {
				if (spaceFound) {
					swap(s, j, i);

				}
			}

		}

	}

	private void swap(String a, int j, int i) {
		char tmp = a.charAt(i);
		a[i] = a[j];
		a[j] = tmp;
	}
}
