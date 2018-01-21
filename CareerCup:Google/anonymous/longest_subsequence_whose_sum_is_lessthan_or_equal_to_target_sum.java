/*

Let's say I have a word "I love chicken", I can break the number of characters in each word, 
like so: [1] [4] [7]
[1,4] [4,7], [1,4,7].

Now let's say I have a max = 5. The phrases with equal or fever than 5 characters 
are "[I], [love], and [I, love]. The longest phrase is [I,love], 
which contains 2 words.

Complete the Length function given. It has 2 parameters:

1) An array of integers, named array
2) A maximum number, named max.

int Careercup( int [] array, int max) {
}

Example test case 1:

[3,1,2,3]
4

Output expected : 2*/
public class longest_subsequence_whose_sum_is_lessthan_or_equal_to_target_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a=new int []{2, 3, 2, 5, 8, 7, 12, 13, 8, 7};
		System.out.println("the max subsequence length is "+longestSubseqMaxSum(a,4));
	}
	
	static int longestSubseqMaxSum(int[]arr, int maxSum)
	{
	        int start =0, end = 0;
	  int S = arr[0];
	  int maxLen = 0;

	  if(S <= maxSum)
	    maxLen = 1;

	  while(end < arr.length - 1){
	    if(S <= maxSum){
	      S += arr[++end];
	    }
	    else {
	      S -= arr[start++];
	    }

	    if(S <= maxSum && end - start + 1 > maxLen)
	      maxLen = end - start + 1;
	  }

	  return maxLen;
	}

}
