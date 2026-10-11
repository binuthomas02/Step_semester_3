/**
 * Problem 5: Ticket Price Slot Finder
 *
 * Linear scan:   Time: O(n)       Space: O(1)
 * Binary search (used below): halve the search range each step using the sorted order.
 *   Time: O(log n)   Space: O(1)
 *
 * If the price is not found, the loop ends with 'lo' sitting exactly where it belongs.
 */
public class Problem5_TicketPriceSlotFinder {

    public static int findSlot(int[] prices, int newPrice) {
        int lo = 0, hi = prices.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (prices[mid] == newPrice) return mid;
            if (prices[mid] < newPrice) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};
        System.out.println(findSlot(prices, 150)); // 1
        System.out.println(findSlot(prices, 210)); // 3
        System.out.println(findSlot(prices, 300)); // 4
    }
}
