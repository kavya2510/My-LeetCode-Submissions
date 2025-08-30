class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int startRow = n - 1; startRow >= 0; startRow--) {
            List<Integer> diagonal = new ArrayList<>();
            int r = startRow, c = 0;
            while (r < n && c < n) {
                diagonal.add(grid[r][c]);
                r++;
                c++;
            }
            diagonal.sort((a, b) -> b - a);

            r = startRow;
            c = 0;
            int pos = 0;
            while (r < n && c < n) {
                grid[r][c] = diagonal.get(pos++);
                r++;
                c++;
            }
        }

        for (int startCol = 1; startCol < n; startCol++) {
            List<Integer> diagonal = new ArrayList<>();
            int r = 0, c = startCol;
            while (r < n && c < n) {
                diagonal.add(grid[r][c]);
                r++;
                c++;
            }
            diagonal.sort(Integer::compareTo);

            r = 0;
            c = startCol;
            int pos = 0;
            while (r < n && c < n) {
                grid[r][c] = diagonal.get(pos++);
                r++;
                c++;
            }
        }

        return grid;
    }
}