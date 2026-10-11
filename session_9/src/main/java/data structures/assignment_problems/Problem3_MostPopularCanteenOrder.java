import java.util.*;

/**
 * Problem 3: Most Popular Canteen Order
 *
 * Re-scan approach (count each item by scanning the whole list again):
 *   Time: O(n^2)   Space: O(1)
 *
 * Hash-based approach (used below):
 *   Pass 1: count every item in a HashMap.
 *   Pass 2: walk the orders in original order and pick the first item with the highest count,
 *           so ties go to the item that appears first.
 *   Time: O(n) average   Space: O(k) where k = number of distinct items (at most n)
 */
public class Problem3_MostPopularCanteenOrder {

    /** Returns {item, count}. */
    public static Map.Entry<String, Integer> mostPopular(String[] orders) {
        Map<String, Integer> counts = new HashMap<>();
        for (String item : orders) {
            counts.merge(item, 1, Integer::sum);
        }

        int maxCount = 0;
        for (int c : counts.values()) maxCount = Math.max(maxCount, c);

        for (String item : orders) {
            if (counts.get(item) == maxCount) {
                return new AbstractMap.SimpleEntry<>(item, maxCount);
            }
        }
        return null; // not reachable for non-empty input
    }

    private static void show(Map.Entry<String, Integer> e) {
        System.out.println("(\"" + e.getKey() + "\", " + e.getValue() + ")");
    }

    public static void main(String[] args) {
        show(mostPopular(new String[]{"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"})); // ("dosa", 3)
        show(mostPopular(new String[]{"tea", "coffee", "coffee", "tea"}));                      // ("tea", 2)
    }
}
