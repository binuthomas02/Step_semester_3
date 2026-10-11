public class Problem2_WarehouseGridSummary {
    public static int[] warehouseSummary(int[][] grid) {
        int total = 0, maxVal = -1, maxR = -1, maxC = -1;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > maxVal) {
                    maxVal = grid[r][c];
                    maxR = r;
                    maxC = c;
                }
            }
        }
        return new int[]{total, maxR, maxC};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        int[] res = warehouseSummary(grid);
        System.out.println("(" + res[0] + ", (" + res[1] + ", " + res[2] + "))"); // (49, (2, 1))
    }
}
