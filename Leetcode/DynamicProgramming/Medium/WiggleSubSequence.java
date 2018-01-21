package DynamicProgramming.Medium;
/*https://leetcode.com/problems/wiggle-subsequence/description/
 * 
 * https://leetcode.com/problems/wiggle-subsequence/solution/
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
 * 
 * Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
 * 
 * 
 * 
 * 
 * 
 * 
 * In Wiggle Subsequence, think that the solution we need should be in a way that we get alternative higher, lower,higher number.
Eg: 2, 5, 3, 8, 6, 9
In above example, the sequence of numbers is small,big,small,big,small,big numbers (In shape of hill).

Now for explanation, we take example series:
2,1,4,5,6,3,3,4,8,4

First we check if the series is starting as (big, small) or (small, big). So as 2,1 is big, small. So we will start the loop as we need small number first that is 1 as 2 is already there.

Step 1: First we check our requirement is to get small number. As 1<2 so the series will be
 2,1
Step 2: Now we need big number that is  greater than 1. As 4>1 so series  will be
2,1,4
Step 3: Now we need small number. But 5>4 so 4 will be replaced by 5. So the series will become
2,1,5
Step 4:  We need small number. But 6>5. Series will be
2,1,6
Step 5: Require small number. 3<6. Series will be
2,1,6,3
Step 6: Require big number. 3=3. No change in series
2,1,6,3
Step 7: Require big number. 4>3. Series will become
2,1,6,3,4
Step 8:  Require small number. 8>4. 8 will  replace 4 and series will become
2,1,6,3,8
Step 9: Require small number. 4<8. So final series will  be
2,1,6,3,8,4
 */
//
////We need not necessarily need dp to solve this problem. 
////This problem is equivalent to finding the number of alternating max. and min. 
////peaks in the array. Since, if we choose any other intermediate number to be a part of the current 
//wiggle subsequence, the maximum length of that wiggle subsequence will always be less than or equal
//to the one obtained by choosing only the consecutive max. and min. elements.
public class WiggleSubSequence {
	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int prevdiff = nums[1] - nums[0];
		int count = prevdiff != 0 ? 2 : 1;
		for (int i = 2; i < nums.length; i++) {
			int diff = nums[i] - nums[i - 1];
			if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
				count++;
				prevdiff = diff;
			}
		}
		return count;
	}
}
