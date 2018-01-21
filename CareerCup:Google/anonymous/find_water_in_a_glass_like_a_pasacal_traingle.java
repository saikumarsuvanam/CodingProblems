//www.geeksforgeeks.org/find-water-in-a-glass/
	/*There are some glasses with equal capacity as 1 litre. The glasses are kept as follows:

		   1
      2   3
   4    5    6
 7    8    9   10

You can put water to only top glass. If you put more than 1 litre water to 1st glass, water overflows and fills equally in both 2nd and 3rd glasses. Glass 5 will get water from both 2nd glass and 3rd glass and so on.
If you have X litre of water and you put that water in top glass, how much water will be contained by jth glass in ith row?

Example. If you will put 2 litre on top.
1st – 1 litre
2nd – 1/2 litre
3rd – 1/2 litre
	//carrercup google question
	 * 
	 */
public class find_water_in_a_glass_like_a_pasacal_traingle {

	
	
	public static void main(String[] args){
		
	//want to find for jth glass
		//total capacitywater=9;
		float capacitywater=9;
		int j=6;
		int row=0;
		//jth would be in which row?
		for(int i=1; i<=j; i++){
	
			i=i+row-1;
			row=row+1;
		}
	
		int totalrows=row-1;
		//total no of glasses possible for all rows
		int totalglasses=0;
		for(int i=1;i<=totalrows; i++){
			totalglasses=totalglasses+i;
		}
		//intiate those many glasses
	
		
		float[]glasses=new float[totalglasses+1];
		
		System.out.println(find_water_in_j_glass( j, capacitywater,totalrows,glasses));
		
	}
	static float find_water_in_j_glass(int j,float water,int rows,float[]glasses ){
		int endindex=2;//end index of each row
		
		int index=1;
		
	    glasses[index]=water;
		//put all water in 1st glass
		for(int row=2; row<=rows; row++){
			
			for(int k=endindex; k<row+endindex&& index<endindex; k++ ){
			     water=glasses[index];
			     if(water>1)
			    	 glasses[index]=1;
			         water=water-1;
			     glasses[k]=glasses[k]+water/2;
			     
			     glasses[k+1]=glasses[k+1]+water/2;
			     
			     index++;
						   
			   }
			
			endindex=row+endindex;
		}
	return glasses[j];
   }
}