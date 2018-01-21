package geometric_algorithms;

import java.util.HashMap;

public class find_the_max_no_of_points_on_the_same_line {
	/**
	 * Definition for a point.*/
	  class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	  }
	 

	    public int maxPoints(Point[] points) {
	        if(points.length <= 0) return 0;
	        if(points.length <= 2) return points.length;
	        int result = 0;
	        HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
	        for(int i = 0; i < points.length; i++){
	            
	            int samex = 1;
	            int samep = 0;
	            for(int j = i+1; j < points.length; j++){
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
	            result = Math.max(result, samex);
	        }
	        return result;
	    }
	}

