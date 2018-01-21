import java.util.*;

/*https://www.careercup.com/question?id=5754527530614784

Given a list of manager and employee information represented in hashMap entries {AAA->BBB,CCC,EEE},{CCC->DDD}.
Print company structure tree with proper indentations. BBB, CCC and EEE directly reports to AAA, so they have one white space before "-", DDD reports to CCC, it has two whitespace before "-". The input is map<String,List<String>>

-AAA
 -BBB
 -CCC
  -DDD
 -EEE
  
  1. First find the root of all - this could be one or more.
2. Use recursive call to simply print the child.
  
 */
public class company_managers_in_tree_structure {

public static void main(String[] args){	
	
	HashMap<String, List<String>> map=new HashMap<String, List<String>>();
	
	List <String> l=new ArrayList<String>();
	//l.add("BBB");
	l.add("DDD");
	l.add("EEE");
	List <String> l1=new ArrayList<String>();
	l1.add("CCC");
	map.put("CCC",l);
	map.put("BBB",l1);
	
	List <String> l2=new ArrayList<String>();
	l2.add("ggg");
	l2.add("BBB");
	map.put("AAA", l2);
	
	print(map);
	
}

public static List<String> findRoots(HashMap<String, List<String>> map)
{
	
	HashSet<String> h=new HashSet<String>();
	for(String s: map.keySet())
	{
		h.add(s);
	}
	for(List<String> l:map.values())
	{
		for(int i=0;i<l.size();i++)
		{
			String s =l.get(i);
			if(h.contains(s))
				h.remove(s);
		}
	}
	
	List<String> rootlist=new ArrayList<String>();
	for(String s:h)
	{
		rootlist.add(s);
	}
	
	return rootlist;
}



static void print(HashMap<String, List<String>> map){
		
		List<String> roots=findRoots(map);
		for(int i=0; i<roots.size(); i++){
			
			printing(map,0,roots.get(i));
			
			
		}
		
			
		
	}
		
		
	

	
	
static void printing(HashMap<String, List<String>> map,int space, String s){	
	
	if(map.containsKey(s)){
		
		for(int i=0; i<space; i++){
			System.out.print(" ");
		}
		System.out.println(s);
	
	List<String> l=map.get(s);
	
	   for(int j=0; j<l.size(); j++){
		 printing(map, space+1,l.get(j));
		
		
	}
	

	}
	
	else{
		for(int i=0; i<space; i++){
			System.out.print(" ");
		}
		System.out.println(s);
		
	}
		
	}
	
	
	
	
	
}
	

