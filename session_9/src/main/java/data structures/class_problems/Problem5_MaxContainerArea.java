public class Problem5_MaxContainerArea {

    public static long bruteForce(int[] heights) {
        long best = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                best = Math.max(best, (long) Math.min(heights[i], heights[j]) * (j - i));
            }
        }
        return best;
    }

    public static long maxContainerArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        long best = 0;
        while (l < r) {
            long area = (long) Math.min(heights[l], heights[r]) * (r - l);
            best = Math.max(best, area);
            if (heights[l] < heights[r]) l++;
            else r--;
        }
        return best;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights)); 
        System.out.println(bruteForce(heights));      
    }
}
