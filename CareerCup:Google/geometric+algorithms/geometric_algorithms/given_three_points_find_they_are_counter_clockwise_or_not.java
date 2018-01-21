package geometric_algorithms;

import geometric_algorithms.find_four_points_form_a_sqaure.Point;

//http://www.geeksforgeeks.org/orientation-3-ordered-points/
//http://www.mathopenref.com/coordtrianglearea.html
/*Slope of line segment (p1, p2): σ = (y2 - y1)/(x2 - x1)
Slope of line segment (p2, p3): τ = (y3 - y2)/(x3 - x2)

If  σ < τ, the orientation is counterclockwise (left turn)
If  σ = τ, the orientation is collinear
If  σ > τ, the orientation is clockwise (right turn)

Using above values of σ and τ, we can conclude that, 
the orientation depends on sign of  below expression: 

(y2 - y1)*(x3 - x2) - (y3 - y2)*(x2 - x1)

Above expression is negative when σ < τ, i.e., counterclockwise
Above expression is 0 when σ = τ, i.e., collinear
Above expression is positive when σ > τ, i.e., clockwise
 * 
 * 
 */
//https://www.cs.princeton.edu/~rs/AlgsDS07/16Geometric.pdf
/* find the 16Geometric.pdf document in this folder for more details.
Implementing CCW
CCW.  
Given three point a, b, and c, is a-b-c a counterclockwise turn?
•
Determinant gives twice area of triangle.
•
If area > 0 then a-b-c is counterclockwise.
•
If area < 0, then a-b-c is clockwise.
•
If area = 0, then a-b-c are collinear.
 * 
 */
public class given_three_points_find_they_are_counter_clockwise_or_not {
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
	
	given_three_points_find_they_are_counter_clockwise_or_not f=new given_three_points_find_they_are_counter_clockwise_or_not();
	
	Point p1 = f.new Point(0, 0);
    Point  p2 = f.new Point(10, 0),
          p3 = f.new Point(0, 20);
	    int o = orientation(p1, p2, p3);
	    if (o==0)         System.out.println("co-Linear");
	    else if (o == 1)  System.out.println("Clockwise");
	    else              System.out.println( "CounterClockwise");
	   
	}
	
}
