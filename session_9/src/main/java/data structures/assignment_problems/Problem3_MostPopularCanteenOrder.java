import java.util.*;
public class Problem3_MostPopularCanteenOrder {
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
        return null; 
    }

    private static void show(Map.Entry<String, Integer> e) {
        System.out.println("(\"" + e.getKey() + "\", " + e.getValue() + ")");
    }

    public static void main(String[] args) {
        show(mostPopular(new String[]{"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"})); 
        show(mostPopular(new String[]{"tea", "coffee", "coffee", "tea"}));                    
    }
}
