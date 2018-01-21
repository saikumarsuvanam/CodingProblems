import java.util.*;

/*n points on a 2D space. You observe the points from (0,0) with viewing direction and viewing 
 * angle.Given an array (xn,yn), and a viewing angle v (45 degree), 
 * find the direction that can observe max number of points.

*/

public class find_max_no_of_points_that_at_given_direction_from_origin {

   	class Point{
		
		int x;
		int y;
		Point(){};
		Point(int x, int y){
			
		this.x=x;
		this.y=y;
		}
	}
public static void main(String[] args){
	find_max_no_of_points_that_at_given_direction_from_origin f=new find_max_no_of_points_that_at_given_direction_from_origin ();
    Point p1=f.new Point(1,1);
    Point p2=f.new Point(3,1);
    Point p3=f.new Point(2,1);
    Point p4=f.new Point(1,2);
    Point p5=f.new Point(-2,5);
    Point p6=f.new Point(-1,6);
    Point p7=f.new Point(-1,3);
    Point p8=f.new Point(1,3);
    Point p9=f.new Point(0,4);
    ArrayList<Point> a=new ArrayList<Point>();
    a.add(p1);a.add(p2);a.add(p3);a.add(p4);a.add(p5);a.add(p6);a.add(p7);a.add(p8);a.add(p9);
    int viewangledirection=45;
    System.out.println(maxpoints(a,viewangledirection));
}
static ArrayList<Point>maxpoints(ArrayList<Point> a,int v){
	double[]angles=new double[a.size()];
	for(int i=0; i<a.size(); i++){
	  Point p=a.get(i);
	  double angle=Math.atan2(p.y,p.x);
	  if(angle<0){
		  angle=360+angle;
		  
	  }
      angles[i]=angle;        
	}
	Arrays.sort(angles);
	
	start=0;
end=angles.length-1;
    System.out.println(maxpointshelper(angles,start,end,v));
    ArrayList<Point> result=new ArrayList<Point>();
    for(int i=start; i<=end; i++){
    	System.out.println(angles[i]);
    	//System.out.println(a.get(i).x+" "+a.get(i).y);
    	result.add(a.get(start));
    	
    }
    return result;
}
static int start;
static int end;
static int	maxpointshelper(double []angles,int start,int end,int v){
	while(end<angles.length){
		double window_angle=angles[end]-angles[start];
		System.out.println(window_angle);
		if(window_angle>v){
	    return Math.max(maxpointshelper(angles, start+1,end,v),maxpointshelper(angles,start,end-1,v));	  
			
		}
		else end=end+1;
		
	}
	return end-start;
}
	
	
	
	
}
