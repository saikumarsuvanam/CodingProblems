//http://www.geeksforgeeks.org/area-of-a-polygon-with-given-n-ordered-vertices/

/*Area of a polygon with given n ordered vertices

Given ordered coordinates of a polygon with n vertices. Find area of the polygon. Here ordered mean that the coordinates are given either in clockwise manner or anticlockwise from first vertex to last.

Examples:

Input :  X[] = {0, 4, 4, 0}, Y[] = {0, 0, 4, 4};
Output : 16

Input : X[] = {0, 4, 2}, Y[] = {0, 0, 4}
Output : 8

We can compute area of a polygon using Shoelace formula.

Area
formula
 = | 1/2 [ (x1y2 + x2y3 + ... + xn-1yn + xny1) -
           (x2y1 + x3y2 + ... + xnyn-1 + x1yn) ] |

*/
package geometric_algorithms;

public class area_of_polygon {

	// (X[i], Y[i]) are coordinates of i'th point.
	static double polygonArea(double X[], double Y[], int n)
	{
	    // Initialze area
	    double area = 0.0;
	 
	    // Calculate value of shoelace formula
	    int j = n - 1;
	    for (int i = 0; i < n; i++)
	    {
	        area += (X[j] + X[i]) * (Y[j] - Y[i]);
	        j = i;  // j is previous vertex to i
	    }
	 
	    // Return absolute value
	    return Math.abs(area / 2.0);
	}
	 
	// Driver program to test above function
	public static void main(String[] args) {
	
	
	    double X[] = new double[]{0, 2, 4};
	    double Y[] = new double[]{1, 3, 7};
	 
	    
	 
	    System.out.println(polygonArea( X, Y, X.length));
	}
}
