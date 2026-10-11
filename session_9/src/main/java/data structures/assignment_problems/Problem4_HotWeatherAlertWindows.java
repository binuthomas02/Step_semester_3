/**
 * Problem 4: Hot Weather Alert Windows
 *
 * Recalculating every block's sum from scratch:
 *   Time: O(n * k)   Space: O(1)
 *
 * Sliding window (used below): keep the current block's sum; when the window moves forward,
 * add the new reading and subtract the one that left. Compare sum >= k * threshold so no
 * decimal division is needed.
 *   Time: O(n)   Space: O(1)
 */
public class Problem4_HotWeatherAlertWindows {

    public static int countAlerts(int[] readings, int k, int threshold) {
        long target = (long) k * threshold;
        long sum = 0;
        int count = 0;

        for (int i = 0; i < readings.length; i++) {
            sum += readings[i];                  // new reading enters the window
            if (i >= k) sum -= readings[i - k];  // old reading leaves the window
            if (i >= k - 1 && sum >= target) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(countAlerts(readings, 3, 4)); // 3
    }
}
