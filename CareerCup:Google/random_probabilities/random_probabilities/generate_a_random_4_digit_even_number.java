package random_probabilities;

//https://www.careercup.com/question?id=5717409575993344
/*write a function to generate a random 4 digit unique even number*/
public class generate_a_random_4_digit_even_number {
	/* Random number between lower and higher, inclusive */
	public static int rand(int lower, int higher) { 
		return lower + (int)(Math.random() * (higher - lower + 1));
	}
	public static void main(String[] args){
		int [] evennumbers={0,2,4,6,8};
		generate(evennumbers);
		
	}
	static void generate(int []evennumbers){
		//even numbers are 5 .generate a randomnumber from 0 to 4 index in 
		//evennumbersarray
		String s="";
		int index=rand(0, 4);
		int last_even_digit=evennumbers[index];
		int  first_three_digits= rand(100,999);
	    s=s+ new Integer(first_three_digits).toString()+ new Integer(last_even_digit).toString(); 
	    System.out.println(s);
  }
}
