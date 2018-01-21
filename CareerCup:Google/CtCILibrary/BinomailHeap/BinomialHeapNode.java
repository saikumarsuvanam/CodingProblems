package BinomailHeap;
import java.util.Scanner;

class BinomialHeapNode<E extends Comparable>{
	E key; int degree;
	BinomialHeapNode parent;
	BinomialHeapNode sibling;
	BinomialHeapNode child;

	public BinomialHeapNode(E k) {
		key = k;
		degree = 0;
		parent = null;
		sibling = null;
		child = null;
	}

	public BinomialHeapNode reverse(BinomialHeapNode sibl) {
		BinomialHeapNode ret;
		if (sibling != null)
			ret = sibling.reverse(this);
		else
			ret = this;
		sibling = sibl;
		return ret;
	}

	public BinomialHeapNode findMinNode() {
		BinomialHeapNode x = this, y = this;
		  E min = (E) x.key;

		while (x != null) {
			if(compare((E)x.key,min)<0){
			
				y = x;
				min = (E)x.key;
			}
			x = x.sibling;
		}

		return y;
	}
private int compare(E x,E y){
	if(x.compareTo(y)>0){
		return 1;
	}
	else if(x.compareTo(y)<0){
		return -1;
	}
	else return 0;
}
	public BinomialHeapNode findANodeWithKey(E value) {
		BinomialHeapNode temp = this, node = null;

		while (temp != null) {
			if (temp.key == value) {
				node = temp;
				break;
			}
			if (temp.child == null)
				temp = temp.sibling;
			else {
				node = temp.child.findANodeWithKey(value);
				if (node == null)
					temp = temp.sibling;
				else
					break;
			}
		}

		return node;
	}

	public int getSize() {
		return (1 + ((child == null) ? 0 : child.getSize()) + ((sibling == null) ? 0 : sibling.getSize()));
	}
}
