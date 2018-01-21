import java.util.*;
public class test {

	
	public static void main(String [] args){
		
	String s=	getLargestRotation("ADCADCAD");
	String S=getlargestrotation("ADCADCAD");
		System.out.println(s);
		System.out.println(S);
	}
	
	public static  String getlargestrotation(String s){
	SortedMap<Character,ArrayList<Integer>> m=new TreeMap<Character,ArrayList<Integer>>();
    for(int i=0; i<s.length(); i++){
	  if(!m.containsKey(s.charAt(i))){
		  ArrayList l=new ArrayList();
		  l.add(i);
		  m.put(s.charAt(i),l);
	  }
	  else {
		  ArrayList l=m.get(s.charAt(i));
		  l.add(i);
		  m.put(s.charAt(i),l);
	  }
    }
    ArrayList<Integer> l=m.get(m.lastKey());
    String largestrotation=s;
    for(int i:l){
    	String s1=s.substring(i)+s.substring(0, i);
		if(s1.compareTo(largestrotation)>0){
			largestrotation=s1;
		}	
    }
    
    
	return largestrotation;
		
		
	}
	
	public static String getLargestRotation(String s){
		int i;
		int j;
		int k;
		 String l,temp;
		char a,b;
		 int ret;
		 l=new String(s);
		
		 a=l.charAt(0);
		 if(l.length()>1)b=l.charAt(1);
		else b='a';
		
		for(j=0;j<s.length();j++)
		{
	
		 if(s.charAt(j)>=a)
		 if(l.length()>1 && s.charAt(j)>=b || l.length()<1)
		 {
		temp=s.substring(j)+s.substring(0,j);
	ret=temp.compareTo(l);
	 if(ret>0)
	 {
		 l=temp;
	 a=l.charAt(0);
		 if(l.length()>1) b=l.charAt(1);
		else b='a';
	 }
		 }
		}
	return l;
}
}