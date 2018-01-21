package missionaries_and_cannibles;

public class enumeration {

	public static void main(String[] args) {

		System.out.println(magicalStrings(10));
	}

	static int magicalStrings(int n) {

		char a[] = new char[] { 'a', 'e', 'i', 'o', 'u' };

		int count=0;
		for(int i=1; i<=n;i++){
		   count =count+helper(a, i, "");}

		int m=(int)Math.pow(10, 9)+7;
		return count%m;
	

	}

	static int count = 0;

	static void helper(char[] a, int n, String s) {

		
		if (s.length() == n) {
			count++;
			return;
		}
		 helper(a,n+1,s+a[n-1]);
		
		
		for (int i = 0; i <a.length; i++) {
			
			if(s==""){
				helper(a, n, s + a[i]);
			}

			else if (s.charAt(s.length() - 1) == 'a') {
				if (a[i] == 'e') {
					helper(a, n, s + a[i]);
				}
			}
				
			else if (s.charAt(s.length() - 1) == 'e') {
				if (a[i] == 'a' || a[i] == 'i') {
					helper(a, n, s + a[i]);
				}

			}

			else if (s.charAt(s.length() - 1) == 'i') {
				if (a[i] == 'a' || a[i] == 'e' || a[i] == 'o' || a[i] == 'u') {
					helper(a, n, s + a[i]);
				}

			} else if (s.charAt(s.length() - 1) == 'o') {
				if (a[i] == 'i' || a[i] == 'u') {
					helper(a, n, s + a[i]);
				}

			} else if (s.charAt(s.length() - 1) == 'u') {
				if (a[i] == 'a') {
					helper(a, n, s + a[i]);
				}

			}
	
			

			
			
		}
	
			
			
			
			
		
		return ;
	}

}
