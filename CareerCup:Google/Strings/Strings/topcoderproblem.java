package Strings;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class topcoderproblem {

	
	
	static class Pair {
		BigInteger value;
		String name;
		Pair( BigInteger value, String name){
		this.value=value;
		this.name=name;

		}
	}

	
public static void main(String[] args) {
	String[] rules=new String[]{"INDIGO: 93 8 T F",
			 "ORANGE: 29 8 F T",
			 "VIOLET: 76 6 F F",
			 "BLUE: 100 8 T T",
			 "RED: 99 8 T T",
			 "GREEN: 78 6 F T",
			 "YELLOW: 75 6 F F"}
	;
String s[]=	sortByOdds(rules);
for(String a:s)
	System.out.println(a);
}
		
	
	
	public static String[] sortByOdds(String[] rules){
		ArrayList<Pair> r=new ArrayList<Pair> ();
		for(int i=0; i<rules.length;i++){
		 r.add(process(rules[i]));
		  
		}
        Collections.sort(r,new Comparator<Pair>(){

			@Override
			public int compare(Pair o1, Pair o2) {
				
				if(o1.value.compareTo(o2.value)==0){
					if(o1.name.compareTo( o2.name)==-1){
						return -1;
					}
					else return 1;
					
				}
				// TODO Auto-generated method stub
				else return o1.value.compareTo(o2.value);
					
				
				
			
			}
		});
        
        String Result[]=new String[rules.length];
        for(int i=0; i<r.size();i++){
        	Result[i]=r.get(i).name;
        }
		return Result;
		}
	
	

		public static Pair  process(String rule){
		String b[]=rule.split(":");
		String c[]=b[1].trim().split(" ");
		String name= b[0];
		BigInteger choices= new BigInteger(c[0]);
		int blanks=Integer.valueOf(c[1])
		;
		
		BigInteger totalpairs = new BigInteger("1"); 
		
		for(int i=1; i<=blanks;i++)
		  totalpairs=choices.multiply( totalpairs);
		BigInteger possible=totalpairs;
		if("F".equals(c[2]) &&"T".equals(c[3])){
		possible=totalpairs.subtract(choices);

		}
		if("T".equals(c[2])){
		possible=choices.multiply(choices.add(new BigInteger("1")));
		possible=possible.divide(new BigInteger("2"));
		if("T".equals(c[3])){
		possible=possible.subtract(choices);
		}
		}
		return new Pair(possible,name);

		}

	


		}


