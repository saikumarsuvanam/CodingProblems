
import java.util.*;
/* https://www.careercup.com/question?id=5711620404674560
 * 
 * Given N stacks, each stack contains Si elements, find the maximum sum of the M numbers in the N stacks. To get the number of the stack, only supporting get the top number. For example, S=[1,200,1,2,3], if you want to get the number 200, you need choose 3,2,1 first.
	 EX:
	 S1=[1,1,100,3]
	 S2=[2000,2,3,1]
	 S3=[10,1,4]
	 the maximum sum of the 3 numbers in the above stacks is 3+100+3=107.
	 Any better solution for this problem?
	*/


public class maximumsum_of_m_numbers_in_N_stacks {

	    static List<Integer> stacks[] = new ArrayList[3];
	    
	    static  ArrayList<String>sb=new ArrayList<String>();
	    static int N = 2, m = 3;
	    static Map<String, Integer> map = new HashMap<>();

	  public static void main(String s[]){
	        stacks[0] = new ArrayList<>();
	        stacks[0].add(1);
	       
	        stacks[1] = new ArrayList<>();
	        stacks[1].add(23);
	     //  stacks[1].add(6);
	        
	       /* stacks[2] = new ArrayList<>();
	        stacks[2].add(10);
	        stacks[2].add(99);
	        stacks[2].add(15);
	        stacks[2].add(12);
	        stacks[2].add(13);
*/
	        Integer sum[] = new Integer[2];
	        for(int i = 0;i<sum.length;i++)
	            sum[i] = -1;

System.out.println(recurr(0, sum));

//System.out.println(map);
System.out.println(tm);


	    }
	static  TreeMap tm = new TreeMap();
public static int recurr(int n, Integer sum[]){
	    	
	if(n == N){
        return 0;
    }
    String s = Arrays.toString(sum) + n;
    if(map.containsKey(s)){
        return map.get(s);
    }
    int max = 0;
    for(int i = 0;i<sum.length;i++){
        sum[i]++;
        if(stacks[i].size() > sum[i]) {
        	 System.out.println(sum[0]+""+sum[1]+"");
       
       
      
            max = Math.max(recurr(n + 1, sum)+stacks[i].get(sum[i]), max);
           
            		 if(n+1==N)
            		 tm.put(Arrays.toString(sum),max);
            		 
            		 
            	 }
            	
        
        
        
        
        sum[i]--;
    }
    map.put(s,max);
    return max;

}
	    





	

	public static void mainn(String[] args){
		Stack<Integer> s1=new Stack<Integer>();
		Stack<Integer> s2=new Stack<Integer>();
		Stack <Integer> s3=new Stack<Integer>();
		 s1.add(1);
        s1.add(2);
                s1.add(3);
        s1.add(57);

       
        
        s2.add(4);
         s2.add(5);
           s2.add(6);
        s2.add(11);
      
       
       
           s3.add(13);
                s3.add(12);
        s3.add(15);
        
        s3.add(99);
             s3.add(10);
   
      
		
	
		ArrayList<Stack<Integer>> a=new ArrayList<Stack<Integer>>();
		a.add(s1);
		a.add(s2);
		a.add(s3);
		int numbers=3;
		int sum=0;
		//Integer [] result=new Integer[a.size()];
		int []result=new int [a.size()];
		for(int i=0; i<result.length; i++){
		result[i]=-1;
		}
		int max=0;
		//System.out.println(result[0]);
		System.out.println(maxsum(a,numbers,sum,result, max));
		
	}
	
	static int maxsum(ArrayList<Stack<Integer>> a,int m,int sum,int [] result,int max){
		
	if(m==0) return sum;	
   
   int maxindex=0;
   for(int i=0; i<a.size(); i++){
	
	if(!a.get(i).isEmpty()){
		
		if(result[i]<a.get(i).peek())
		result[i]=((Integer)a.get(i).peek());
		}
	}

for(int i=0; i<result.length; i++){
	
	
if(max<result[i]){
	
	max=result[i];
	maxindex=i;

}}

 sum+=(Integer)a.get(maxindex).pop();

 
 
 m=m-1;
 
 return maxsum(a,m,sum,result,max);
	}
	


		
	}
	

