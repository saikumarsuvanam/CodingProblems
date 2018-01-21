package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

import Arrays.finding_kth_largest_without_modifiy_given_max_heap.element;

//https://www.careercup.com/question?id=5658326589243392
/*Idea:
Use a modified Dijkstra's algorithm, and get O(klgk) algorithm.
Use the existed Selection algorithm, and get O(n) algorithm. [1]

Estimate and choose one algorithm, induce an O(min(klgk,n)) algorithm.

SelectKth(MaxHeap h, k)
	n = h.size;
	if ( klgk < n )
		return DijkstraKth(h,k)
	return SelectKthByDC(h,k)

A sample for the modified Dijkstra's algorithm.

Sample:				n = 7, k = 3
    	    [0]100			3 largest		priority queue
     [1]95	        [2] 80		100 95			90 85 80 
[3]90   [4]85       [5]75    [6]70

Sample code for the modified Dijkstra's algorithm

// 1. Memorize the index, so that we can know its child.
// 2. Use a pointer can avoid to spend additional space to memorize index. 
//    However, the space complexity remains O(k).
class HeapNode<Type> : IComparable where Type : IComparable
{ 	int i ; // index
	Type v; // value
	int CompareTo( HeapNode<Type> y){ return y.v - v; }
}

Type DijkstraKth(Heap<Type> h,int k) where Type: IComparable
{
	if ( k > h.size )
		throw Exception(“k must <= h.size”);
	if ( k <= 0 )
		throw Exception(“k must greater then 0);
	PriorityQueue queue = new PriorityQueue();
	queue.Add(h[0]);			// Add the root node
	while ( k>;1)				// k=1, return root
	{	HeapNode<Type> x = queue.ExtractMax();
		queue.Add(h[x.i*2 + 1]);	// left node
		queue.Add(h[x.i*2 + 2]);	// right node
		k --;
	}	
	return queue.max().v;
}
 * 
 * 
 */
public class finding_kth_largest_without_modifiy_given_max_heap {
//Approach...add elements to another maxheap to get k the largest from the given array.
	//(o(klogk)) time complexity
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		int[] heaparray=new int[]{15,14,7,13,10,6,3,12,11,9,8,5,4,2,1};
		int k=6;
		finding_kth_largest_without_modifiy_given_max_heap t=new finding_kth_largest_without_modifiy_given_max_heap();
		System.out.println(t.find_k_largest(heaparray,k));
	}

	class element  {
		int index;
		int val;
		public element(int val,int index){
			this.index=index;
			this.val=val;
		}
		
		
	}
	class elementcomparator implements Comparator<element>{

		@Override
		public int compare(element e1, element e2 ) {
			// TODO Auto-generated method stub
			if(e1.val-e2.val>0){
				return -1;
			}
			else if(e1.val-e2.val==0)return 0;
			else return 1;
		}
		
	}
	 int find_k_largest(int[] input,int k){
		
		PriorityQueue<element> q=new PriorityQueue<element>(new elementcomparator());
	    int value=input[0];
	    element e=new element(value,1);
		int i=0;
		//we need k elements  
		q.add(e);
		while(!q.isEmpty()){
			element root=q.poll();
			if(root.index*2-1 <input.length){
			int childval1=input[root.index*2-1];
			element child1=new element(childval1,root.index*2);
			q.add(child1);
			}
			if(root.index*2 <input.length){
			int childval2=input[root.index*2];
			element child2=new element(childval2,root.index*2+1);
			q.add(child2);
			}
			i++;
			if(i==k){
				return root.val;
			}
			if(i>k){
				break;
			}
		}
		return -1;
		
	}
}
