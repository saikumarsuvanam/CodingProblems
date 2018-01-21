
/*http://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 * https://www.youtube.com/watch?v=KJnhAUkxAho
 * 
 */
//optimized approach is table but space complexity is there.
//if you used k group then complexity is 0(logn)/k and space complexity is o(2power k)
//not implemented here .check above video.
public class count_set_bits_in_an_integer {

	public static void main(String[] args){
     int number=423;
     naive_approach(number);
	Brian_Kernighans_Algorithm(number);
	}
	//Time Complexity: (-)(logn) (Theta of logn)
	static void naive_approach(int number){
		int count=0;
		
		while(number>0){
			if((number&1)==1){
				count++;
			}
			number=number>>1;
		}
		System.out.println(count);
	}
	/*Example for Brian Kernighan’s Algorithm:

   n =  9 (1001)
   count = 0

   Since 9 > 0, subtract by 1 and do bitwise & with (9-1)
   n = 9&8  (1001 & 1000)
   n = 8
   count  = 1

   Since 8 > 0, subtract by 1 and do bitwise & with (8-1)
   n = 8&7  (1000 & 0111)
   n = 0
   count = 2

   Since n = 0, return count which is 2 now.

Time Complexity: O(logn)
	 * 
	 */
	static void Brian_Kernighans_Algorithm(int n){
		int count=0;
		while(n>0){
		n=n&n-1;
		count++;
		}
		System.out.println(count);
		
		/*int mask=1<<(3)-1;
		int out=43&mask;
		 //System.out.println(out);
		  int mask2=-1<<(3);
		  System.out.println(87&mask2);
		  int mask3=(1<<(3))-1;
		  System.out.println(87&(~mask3));*/
		int c1=565;//1000110101
		int c2=34;//100010
	   int i=2;
	   int j=8;
	 int x=c2<<i;
	 System.out.println(x);
	 int y=c1|x;
	System.out.println(y);
    
     	
	 
		
	    }
	
	
	
}
