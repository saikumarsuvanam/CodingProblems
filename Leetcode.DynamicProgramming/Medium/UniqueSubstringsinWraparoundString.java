package Medium;
/*
 * 467. Unique Substrings in Wraparound String https://leetcode.com/problems/unique-substrings-in-wraparound-string/description/
 */


/*
 * if we know the max number of unique substrings in p ends with 'a', 'b', ..., 'z', then the summary of them is the answer. Why is that?

The max number of unique substring ends with a letter equals to the length of max contiguous substring ends with that letter. Example "abcd", the max number of unique substring ends with 'd' is 4, apparently they are "abcd", "bcd", "cd" and "d".
If there are overlapping, we only need to consider the longest one because it covers all the possible substrings. Example: "abcdbcd", the max number of unique substring ends with 'd' is 4 and all substrings formed by the 2nd "bcd" part are covered in the 4 substrings already.
No matter how long is a contiguous substring in p, it is in s since s has infinite length.
Now we know the max number of unique substrings in p ends with 'a', 'b', ..., 'z' and those substrings are all in s. Summary is the answer, according to the question.
 */
public class UniqueSubstringsinWraparoundString {
	 public int findSubstringInWraproundString(String p) {
	        // count[i] is the maximum unique substring end with ith letter.
	        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
	        int[] count = new int[26];
	        // store longest contiguous substring ends at current position.
	        int maxLengthCur = 0; 
            for (int i = 0; i < p.length(); i++) {
	            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
	                maxLengthCur++;}
	            else {
	                maxLengthCur = 1;
	            }
	            int index = p.charAt(i) - 'a';
	            count[index] = Math.max(count[index], maxLengthCur);
	        }
	        // Sum to get result
	        int sum = 0;
	        for (int i = 0; i < 26; i++) {
	            sum += count[i];
	        }
	        return sum;
	    }
    public static void main(String[] args){
    	UniqueSubstringsinWraparoundString u=new UniqueSubstringsinWraparoundString();
    	System.out.println(u.findSubstringInWraproundString("cac"));
    }
}
