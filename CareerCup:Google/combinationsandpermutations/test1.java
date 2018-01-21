class test1 {

	public static void main(String[] args) {

		String[] grid = new String[] { "KCBVNRXSPVEGUEUFCODMOAXZYWEEWNYAAXRBKGACSLKYRVRKIO",
				"DIMCZDMFLAKUUEPMPGRKXSUUDFYETKYQGQHNFFEXFPXNYEFYEX",
				"DMFRPZCBOWGGHYAPRMXKZPYCSLMWVGMINAVRYUHJKBBRONQEXX",
				"ORGCBHXWMTIKYNLFHYBVHLZFYRPOLLAMBOPMNODWZUBLSQSDZQ",
				"QQXUAIPSCEXZTTINEOFTJDAOBVLXZJLYOQREADUWWSRSSJXDBV",
				"PEDHBZOVMFQQDUCOWVXZELSEBAMBRIKBTJSVMLCAABHAQGBWRP",
				"FUSMGCSCDLYQNIXTSTPJGZKDIAZGHXIOVGAZHYTMIWAIKPMHTJ",
				"QMUEDLXSREWNSMEWWRAUBFANSTOOJGFECBIROYCQTVEYGWPMTU",
				"FFATSKGRQJRIQXGAPLTSXELIHXOPUXIDWZHWNYUMXQEOJIAJDH",
				"LPUTCFHYQIWIYCVOEYHGQGAYRBTRZINKBOJULGYCULRMEOAOFP",
				"YOBMTVIKVJOSGRLKTBHEJPKVYNLJQEWNWARPRMZLDPTAVFIDTE",
				"OOBFZFOXIOZFWNIMLKOTFHGKQAXFCRZHPMPKGZIDFNBGMEAXIJ",
				"VQQFYCNJDQGJPYBVGESDIAJOBOLFPAOVXKPOVODGPFIYGEWITS",
				"AGVBSRLBUYOULWGFOFFYAAONJTLUWRGTYWDIXDXTMDTUYESDPK",
				"AAJOYGCBYTMXQSYSPTBWCSVUMNPRGPOEAVVBGMNHBXCVIQQINJ",
				"SPEDOAHYIDYUJXGLWGVEBGQSNKCURWYDPNXBZCDKVNRVEMRRXC",
				"DVESXKXPJBPSJFSZTGTWGAGCXINUXTICUCWLIBCVYDYUPBUKTS",
				"LPOWAPFNDRJLBUZTHYVFHVUIPOMMPUZFYTVUVDQREFKVWBPQFS",
				"QEASCLDOHJFTWMUODRKVCOTMUJUNNUYXZEPRHYOPUIKNGXYGBF",
				"XQUPBSNYOXBPTLOYUJIHFUICVQNAWFMZAQZLTXKBPIAKXGBHXX" };
		System.out.println(length(grid));
		
	   
	}

	public static int length(String[] grid) {

		int[] row = { +1, 1, 1, 0, 0, -1, -1, -1 };
		int[] col = { 1, 0, -1, 1, -1, 0, 1, -1 };
		boolean visited[][] = new boolean[grid.length][grid[0].length()];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				if (grid[i].charAt(j) == 'A') {
					visited[i][j] = true;
					int res = 1 + find(i, j, grid, visited, row, col);
					if (max < res) {
						max = res;
					}
				}

			}

		}
		return max;
	}

	public static int find(int row, int col, String[] grid, boolean[][] visited, int[] r, int[] c) {
		int a = 0;

		for (int l = 0; l < r.length && l < c.length; l++) {
			if (row + r[l] < grid.length && col + c[l] < grid[0].length() && col + c[l] >= 0 && row + r[l] >= 0) {
				if (!visited[row + r[l]][col + c[l]]) {
					if (grid[row + r[l]].charAt(col + c[l]) == grid[row].charAt(col) + 1) {
						visited[row + r[l]][col + c[l]] = true;
						a = 1 + find(row + r[l], col + c[l], grid, visited, r, c);
						visited[row + r[l]][col + c[l]] = false;
						return a;
					}
				}
			}
		}

		return a;
	}
}
