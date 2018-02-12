package Medium;

import java.util.ArrayList;

public class MaxSumWithNoTwoContinousNumbers {

	public int maxSumwithnoTwoContinous(int a[]) {

		int dp[] = new int[a.length];
		dp[0] = a[0];
		dp[1] = Math.max(a[0], a[1]);
		for (int i = 2; i < a.length; i++) {
			dp[i] = Math.max(a[i] + dp[i - 2], dp[i - 1]);
		}
		ArrayList<ArrayList<Integer>> allSequences=new ArrayList<ArrayList<Integer>>();
		
		recursivePrint( dp,a,allSequences,new ArrayList<Integer>(),dp.length-1);
		for(int i=0;i<allSequences.size();i++){
			System.out.println(allSequences.get(i));
		}
		return dp[a.length - 1];
	}

	public void recursivePrint(int [] dp,int a[],ArrayList<ArrayList<Integer>>  allSequences,ArrayList<Integer> curSeq,int i){
		if(i==0||i==1){
			if(i==1){
			curSeq.add(Math.max(dp[i], dp[i-1]));
		   }
			if(i==0){
				curSeq.add(a[0]);
			}
			allSequences.add((ArrayList<Integer>) curSeq.clone());
			curSeq.remove(curSeq.size()-1);
			return;
		}
		
		
		if(dp[i]==dp[i-2]+a[i]){
			curSeq.add(a[i]);
			recursivePrint(dp,a,allSequences,curSeq,i-2);
			curSeq.remove(curSeq.size()-1);
		}
		if(dp[i]==dp[i-1]) {
			recursivePrint(dp,a,allSequences,curSeq,i-1);	
			}
	}
	public static void main(String [] args){
		MaxSumWithNoTwoContinousNumbers m=new MaxSumWithNoTwoContinousNumbers();
		int [] a=new int []{5,6,7,6};
		System.out.println(m.maxSumwithnoTwoContinous(a));
		
	}
}
