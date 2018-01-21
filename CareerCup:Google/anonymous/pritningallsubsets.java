import java.util.*;

public class pritningallsubsets {

public static ArrayList<ArrayList<Character>> powersetprint(ArrayList<Character> a, int size){
	
	
	
if(size==0){
	
	ArrayList<ArrayList<Character>> subset= new ArrayList<ArrayList<Character>>();
	ArrayList<Character> e=new ArrayList<Character> ();
	subset.add(e);
	return subset;
	
	}
	
	ArrayList<ArrayList<Character>> ssubset=powersetprint(a,size-1);
	
	ArrayList<ArrayList<Character>> allset=new ArrayList<ArrayList<Character>>();
	for(int i=0; i<ssubset.size(); i++){
		
		ArrayList<Character> c=new ArrayList<Character> ();
		c.addAll(ssubset.get(i));
		
		
		c.add(a.get(size-1));
		
		allset.add(c);
		
	}
	
	for(int i=0; i<ssubset.size(); i++){
		
		allset.add(ssubset.get(i));
	}
	
	System.out.println(allset);
	
	return allset;
		
	}
	
	
	
	

	
	
	public static void main(String[] args){
		
		 ArrayList<Character> a=new ArrayList<Character>();
		 a.add('a');
		 a.add('b');
		
		 a.add('c');
		 ArrayList<ArrayList<Character>> d=powersetprint(a,a.size());
		 System.out.println(d);
		
	}
	
	
}
