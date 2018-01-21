import java.util.*;


public class string_matches_a_pattern {

	
	
	public static void main(String[] args){
		
		String s="redredredred";
		String pattern="a";
		System.out.println( ismatch(s,pattern,0,0));
		
	
		
	}
	
	
	static HashMap hm=new HashMap();
static boolean	ismatch(String s,String p,int i,int j){

	if (i == s.length() && j == p.length()) return true;
    if (i == s.length() || j == p.length()) return false;
	
	char  c=p.charAt(j);
	
	if(hm.containsKey(c)){
	String str=(String)	hm.get(c);
	if(str.length()+i>s.length()|| !s.substring(i,str.length()+i).equals(str)){
		return false;
		}
	
	return ismatch(s,p,i+str.length(),j+1);

	}
	
	for(int l=i; l<s.length(); l++){
		hm.put(c,s.substring(i,l+1));
		if(ismatch(s,p,l+1,j+1)){
			return true;
			
		}
	
	}
	hm.remove(c);
	
	return false; 
	
	
		

	
	
	
	
}
	



}
