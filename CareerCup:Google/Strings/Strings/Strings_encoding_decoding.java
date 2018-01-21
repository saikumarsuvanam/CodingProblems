package Strings;

import java.util.ArrayList;
import java.util.List;

public class Strings_encoding_decoding {
	// encoding
	static char SEPARATOR = ',';

	public static String serialize(List<String> strs) {
		if (strs == null)
			return null;
		StringBuilder ret = new StringBuilder();

		for (String str : strs) {
			ret.append(str.length());
			ret.append(SEPARATOR);
			ret.append(str);
		}

		return ret.toString();
	}

	// decoding
	public static List<String> deserialize(String s) {
		if (s == null)
			return null;
		List<String> strs = new ArrayList<String>();

		int i = 0, n = s.length();

		while (i < n) {
			int j = i;
			while (s.charAt(j) != SEPARATOR) {
				j++;
			}
			int len = Integer.parseInt(s.substring(i, j));
			i = j + len + 1;
			if (len == 0)
				strs.add("");
			else
				strs.add(s.substring(j + 1, i));
		}
		return strs;
	}

	public static void main(String[] args) {
		List<String> Strings = new ArrayList<String>();
		Strings.add("vbkjdbgk");
		Strings.add("vdvfg45455,545,");
		Strings.add(",5");
		Strings.add("5,");
		String encoded = serialize(Strings);
		System.out.println(encoded);
		ArrayList decoded = (ArrayList) deserialize(encoded);
		for (int i = 0; i < decoded.size(); i++)
			System.out.println(decoded.get(i));
	}
}
