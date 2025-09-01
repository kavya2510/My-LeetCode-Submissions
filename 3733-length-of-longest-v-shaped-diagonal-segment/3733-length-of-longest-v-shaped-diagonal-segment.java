class Solution {
    private int n, m;
    private int[][] grid;
    private final int[] di = {1, 1, -1, -1};
    private final int[] dj = {1, -1, -1, 1};
    private int[][][][] dp;
    private int nextVal (int v){
        return (v == 2) ? 0 : 2;
    };
    private int dfs(int x, int y, int turned, int dir){
        if (dp[x][y][dir][turned] != -1)
            return dp[x][y][dir][turned];
        int res = 1;
        int need = nextVal(grid[x][y]);
        int nx = x + di[dir], ny = y + dj[dir];
        if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == need){
            res = Math.max(res, 1 + dfs(nx, ny, turned, dir));
        }
        if (turned == 0){
            int ndir = (dir +1) & 3;
            int tx = x + di[ndir], ty = y + dj[ndir];
            if (0 <= tx && tx < n && 0 <= ty && ty < m && grid[tx][ty] == need){
                res = Math.max(res, 1 + dfs(tx, ty, 1, ndir));
            }
        }
        return dp[x][y][dir][turned] = res;
    };

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][4][2];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int d = 0; d < 4; d++){
                    java.util.Arrays.fill(dp[i][j][d], -1);
                }
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] != 1) continue;
                int[] tm = {n - i, j + 1,i + 1, m - j};
                for (int d = 0; d < 4; d++){
                    if (tm[d] > total){
                        total = Math.max(total, dfs(i, j, 0, d));
                    }
                }
            }
        }
        return total;
    }
}