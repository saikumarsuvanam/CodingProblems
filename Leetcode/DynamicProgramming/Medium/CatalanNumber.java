package Medium;

public class CatalanNumber {
//https://www.geeksforgeeks.org/program-nth-catalan-number/
	public int catalan(int n) {
		int[] catalan = new int[n + 1];
		catalan[0]=1;
		//catalan[1]=1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				catalan[i] = catalan[i] + (catalan[j-1] * catalan[i - j]);
			}
		}
		return catalan[n];
	}

	public static void main(String[] args) {
		CatalanNumber c=new CatalanNumber();
		int n=4;
		System.out.println(c.catalan(n));
	}

}
