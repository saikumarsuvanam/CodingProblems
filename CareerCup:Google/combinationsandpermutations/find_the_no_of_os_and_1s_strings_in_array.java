import java.util.ArrayList;
import java.util.HashMap;

/*
https://www.careercup.com/question?id=10660876
Given an array of strings of 0s and 1s. X and Y are also given. Return the maximum number of elements in a subset of the array elements which will X number of zeroes and Y number of 1s when combined. For eg: if array[] = {"01", "10", "0", "110"} X=3, Y=2
Answer should be 3 since first 3 strings when combined will give the required number of 0s and 1s.
 * 
 */
public class find_the_no_of_os_and_1s_strings_in_array {

	public static void main(String[] args) {
		String a[] = {"01", "100", "110","0","10","0","1"};
		System.out.println(find_subset( a,3,2,0));
	}
	public static int count0s(String s) {
		char[] c = s.toCharArray();
		int n = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '0') n++;
		}
		return n;
	}
	static HashMap<String ,ArrayList <String>> h=new HashMap<String ,ArrayList <String>>();
	static ArrayList <String>  find_subset(String[] a,int x, int y,int i){
		
		if(i<a.length){
			if(h.containsKey(x+"+"+y)){
				return h.get(x+"+"+y);
			}
			
		 if(x==0&&y==0){
			
		    return new ArrayList<String>();
		}
		else if(x<0&&y>0){
			int zeros=count0s(a[i]);
			int ones=a[i].length()-zeros;
			ArrayList<String> ar= find_subset(a,x,  y-ones, i+1);
               
			ArrayList<String> condition2=	find_subset(a,x,y,i+1);
			if(ar==null||condition2==null){
				h.put(x+"+"+y, new ArrayList<String>());
				 return new ArrayList<String>();
            }
	             int res= Math.max(1+ar.size(), condition2.size());
	             
	             ArrayList<String> p=new ArrayList<String>();
				 if(res==1+ar.size()){
					 ar.add(a[i]);
					 h.put(x+"+"+y,ar);
					 return ar;
				 }
				 else {h.put(x+"+"+y,condition2 );
				 return condition2;
				 }
		}
		else if(y<0&&x>0){
			int zeros=count0s(a[i]);
			
			ArrayList<String> ar= find_subset(a,x-zeros,  y, i+1);
            
			ArrayList<String> condition2=	find_subset(a,x,y,i+1);
			if(ar==null||condition2==null){
				h.put(x+"+"+y, new ArrayList<String>());
				 return new ArrayList<String>();
            }
			
	             int res= Math.max(1+ar.size(), condition2.size());
	             
	             ArrayList<String> p=new ArrayList<String>();
				 if(res==1+ar.size()){
					 ar.add(a[i]);
					 h.put(x+"+"+y,ar);
					 return ar;
				 }
				 else {h.put(x+"+"+y,condition2 );
				 return condition2;
				 }
			 
		}
		else{
			int zeros=count0s(a[i]);
			int ones=a[i].length()-zeros;
			
			ArrayList<String> ar= find_subset(a,x-zeros,  y-ones, i+1);
               
			ArrayList<String> condition2=	find_subset(a,x,y,i+1);
			if(ar==null||condition2==null){
				h.put(x+"+"+y, new ArrayList<String>());
				 return new ArrayList<String>();
            }
			
			
	             int res= Math.max(1+ar.size(), condition2.size());
	             
	             ArrayList<String> p=new ArrayList<String>();
				 if(res==1+ar.size()){
					 ar.add(a[i]);
					 h.put(x+"+"+y,ar);
					 return ar;
				 }
				 else {h.put(x+"+"+y,condition2 );
				 return condition2;
				 }
		}
	}
		return null;
	}
	
}
