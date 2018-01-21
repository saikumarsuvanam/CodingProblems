package Strings;

public class suffixessort {
	
	

	    private String[] text;

	    private int length;

	    private int[] index;

	    private String[] suffix;

	 

	    public  void  SuffixArray(String text)

	    {

	        this.text = new String[text.length()]; 

	 

	        for (int i = 0; i < text.length(); i++)

	        {

	            this.text[i] = text.substring(i, i+1);

	        } 

	 

	        this.length = text.length();

	        this.index = new int[length];

	        for (int i = 0; i < length; i++)

	        {

	            index[i] = i;

	        }	

	 

	     this.   suffix = new String[length];

	    }

	 

	    public void createSuffixArray()

	    {   

	        for(int index = 0; index < length; index++)	

	        {

	            String text = "";

	            for (int text_index = index; text_index < length; text_index++)

	            {

	                text+=this.text[text_index];

	            } 

	            suffix[index] = text;

	        }

	 

	        int back;

	        for (int iteration = 1; iteration < length; iteration++)

	        {

	            String key = suffix[iteration];

	            int keyindex = index[iteration];

	 

	            for (back = iteration - 1; back >= 0; back--)

	            {

	                if (suffix[back].compareTo(key) > 0)

	                {

	                    suffix[back + 1] = suffix[back];

	                    index[back + 1] = index[back];

	                }

	                else

	                {

	                    break;

	                }

	            }

	            suffix[ back + 1 ] = key;

	            index[back + 1 ] = keyindex;

	        }

	 

	       // System.out.println("SUFFIX \t INDEX");

	        for (int iterate = 0; iterate < length; iterate++)

	        {		

	         //   System.out.println(suffix[iterate] + "\t" + index[iterate]);

	        }

	    }

	 

	 

	    public static void main(String[] arg)
	    {
	    	
	    	
	    	

	    	String a="abaacaacb";
	    	String b="bbccaaavx";
	        String text = a+b;

	        
	        suffixessort s1=new suffixessort();  
  s1.SuffixArray(text);
	        s1.createSuffixArray();
	        int l=0;
	        int[] array=new int[s1.index.length];
	        for(int i=0; i<s1.index.length;i++){
	        	
	        	array[s1.index[i]]=l;
	        	l=l+1;
	        }
	      
	        String res = "";
	        int pos1=0, pos2=0;
	        while (true)
	        {
	            if (pos1 > (a.length()-1) && pos2 > (b.length()-1))
	            {
	                break;
	            }
	            if (pos1 > (a.length()-1))
	            {
	                res += b.charAt(pos2);
	                pos2++;
	                continue;
	            }
	            if (pos2 > (b.length()-1))
	            {
	                res += a.charAt(pos1);
	                pos1=pos1+1;
	                continue;
	            }
	            if (array[pos1] < array[a.length() + pos2])
	                {res += a.charAt(pos1);
	            pos1++;}
	            else{
	                res += b.charAt(pos2);
	                pos2=pos2+1;
	            }
	        }
	        
System.out.println(res);
	    }	

	}
	
