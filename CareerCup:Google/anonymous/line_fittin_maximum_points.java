import java.util.*;
public class line_fittin_maximum_points {

	
	
	  class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	  }
	 
	
	    public static int maxPoints(Point[] points) {
	        if(points.length <= 0) return 0;
	        if(points.length <= 2) return points.length;
	        int result = 0;
	        for(int i = 0; i < points.length; i++){
	            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
	            int samex = 1;
	            int samep = 0;
	            for(int j = 0 ; j < points.length; j++){
	                if(j != i){
	                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
	                        samep++;
	                    }
	                    if(points[j].x == points[i].x){
	                        samex++;
	                        continue;
	                    }
	                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
	                    if(hm.containsKey(k)){
	                        hm.put(k,hm.get(k) + 1);
	                    }else{
	                        hm.put(k, 2);
	                    }
	                    result = Math.max(result, hm.get(k) + samep);
	                }
	            }
	            System.out.println(hm);
	            result = Math.max(result, samex);
	        }
	       
	        return result;
	    }
	    

	  static  public int  maxpoints(Point[] p){
	    	HashMap hm=new HashMap();
		  for(int i=0; i<p.length;i++){
int count=1;			  
			  for(int j=i+1; j<p.length; j++){
			
	             double numerator=p[j].y-p[i].y;
	             double denominator=p[j].x-p[i].x;
	            if(denominator==0){
	            	if(hm.containsKey("infinte")){
	            	double x=(double)hm.get("infinite");
	            	if(x==p[j].x) { x++;hm.put("infinite",x);}
	            	else{
	            	hm.put();	
	            	}
	            	}
	            	
	            	}
	            	
	            hm.put("infinte",p[j].x);	
	            }
	            else{
	            	
	            	
	            	
	            }
	             
		
				 
				 
				  
				  
			  }
			  
			  
			  
			  
		  }
	    	
	    	
	    }
	    
	    
	    public static void main(String[] args){
	    	line_fittin_maximum_points l=new line_fittin_maximum_points();
	    	Point a=l.new Point(3,9);
	    	Point a1=l.new Point(1,5);
	    	Point a2=l.new Point(4,13);
	    	Point a3=l.new Point(2,9);
	    	Point a4=l.new Point(100,203);
	    	
	    	Point[] p=new Point[5];
	    	p[0]=a;
	    	p[1]=a1;
	    	p[2]=a2;
	    	p[3]=a3;
	    	p[4]=a4;
	  System.out.println(maxPoints(p));
	    	
	    }
	    
	    
	    
	}
	
	

