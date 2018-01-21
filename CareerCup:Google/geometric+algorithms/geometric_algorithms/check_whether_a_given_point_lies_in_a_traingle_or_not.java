package geometric_algorithms;

import geometric_algorithms.given_three_points_find_they_are_counter_clockwise_or_not.Point;

//http://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
/*Let the coordinates of three corners be (x1, y1), (x2, y2) and (x3, y3). And coordinates of the given 
 * point P be (x, y)

1) Calculate area of the given triangle, i.e., area of the triangle ABC in the above diagram. Area 
A = [ x1(y2 – y3) + x2(y3 – y1) + x3(y1-y2)]/2
2) Calculate area of the triangle PAB. We can use the same formula for this. Let this area be A1.
3) Calculate area of the triangle PBC. Let this area be A2.
4) Calculate area of the triangle PAC. Let this area be A3.
5) If P lies inside the triangle, then A1 + A2 + A3 must be equal to A.

2)SECOND METHOD(Good) :other method which is good is
Point P lies inside a triangle ABC
If and only if:

1. Point P and A lie on the same side of line BC
2. Point P and B lie on the same side of line AC
3. Point P and C lie on the same side of line AB

For above 3 we can use a utility function which computes if 2 points are on the same side of a line:

boolean arePointsOnSameSide(Point p,Point a,Point b,Point c){

LineEquation e = new LineEquation(b,c); // equation of line BC
int pValue = e.compute(p);
int aValue = e.compute(a);
if(pValue * aValue > 0)
return true; // both are of same sign
else
return false;
}
 * 
 * 
 */
public class check_whether_a_given_point_lies_in_a_traingle_or_not {
	class Point
	{
	    int x, y;
	    Point(int x, int y){
	    	this.x=x;
	    	this.y=y;
	    }
	};
	 
	// To find orientation of ordered triplet (p1, p2, p3).
	// The function returns following values
	// 0 --> p, q and r are colinear
	// 1 --> Clockwise
	// 2 --> Counterclockwise
static	int orientation(Point p1, Point p2, Point p3)
	{
	    // See 10th slides from the pdf in the folder for the derviation
	    // of the formula
	    int val = (p2.y - p1.y) * (p3.x - p2.x) -
	              (p2.x - p1.x) * (p3.y - p2.y);
	 
	    if (val == 0) return 0;  // colinear
	 
	    return (val > 0)? 1: 2; // clock or counterclock wise
	}
	 
	// Driver program to test above functions
public static void main(String[] args) {
	
	check_whether_a_given_point_lies_in_a_traingle_or_not f=new check_whether_a_given_point_lies_in_a_traingle_or_not();
	
	Point p1 = f.new Point(0, 0);
    Point  p2 = f.new Point(10, 0),
          p3 = f.new Point(0, 20);
    
	    int o = orientation(p1, p2, p3);
	    if (o==0)         System.out.println("co-Linear");
	    else if (o == 1)  System.out.println("Clockwise");
	    else              System.out.println( "CounterClockwise");
	   
	}
	
}

	
	

