/*
what is time complexity of concatenating two int in java example :-

int a=18965;
int b=78521369741;
after concatenation i want ans in primitive integer data types like,

int c=1896578521369741;
i want to know what is the fastest way to do this and what will be the time complexity ?*/
public class concatenating_two_integers_to_two_strings {

	public static void main(String[] args) {
		System.out.println(combine(18965,78523));

	}

	static int combine(int a, int b) {
		   int times = 1;
		   while (times <= b)
		      times *= 10;
		   return a*times + b;
		} 
}
