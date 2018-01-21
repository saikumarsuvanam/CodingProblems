package random_probabilities;

import java.util.Random;

/*
This is a two part question related to Markov string generation.

Part 1: Read a training set of strings. For each character in any of the strings, 
calculate the probability of seeing that character and store it for later use.
(this part is about coming up with the right data structure and correct probability 
		calculation).

Part 2: Based on the training set from Part 1, generate a random string of length N.*/

public class random_number_probability_markov_string {
	public static void main(String[] args){
	String[] strings = { "Read" };
	int[] counts = new int[27];
	int total = 0;
	for (String s : strings) {
		total += s.length();
		for (int i=0; i<s.length(); i++) {
			int index = (int)Character.toLowerCase(s.charAt(i))-97;
			index = index < 0 ? 26 : index;
			counts[index]++;
		}
	}
	for (int i=1; i<counts.length; i++) counts[i] += counts[i-1];
	int n = 4;
	StringBuilder sb = new StringBuilder();
	for (int i=0; i<n; i++) {
		int r = (new Random()).nextInt(total);
		for (int j=0; j<counts.length; j++) {
			if (r > counts[j]) continue;
			int value = j == 26 ? ' ' : j+97;
			sb.append((char)(value));
			break;
		}
	}
			System.out.println(sb.toString());
}
}