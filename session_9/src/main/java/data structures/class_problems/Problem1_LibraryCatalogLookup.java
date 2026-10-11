import java.util.*;
public class Problem1_LibraryCatalogLookup {

    public static String findBook(List<String[]> catalog, String targetIsbn) {
        int lo = 0, hi = catalog.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = catalog.get(mid)[0].compareTo(targetIsbn);
            if (cmp == 0) return catalog.get(mid)[1];
            if (cmp < 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        List<String[]> catalog = new ArrayList<>();
        catalog.add(new String[]{"0001112223", "Introduction to Algebra"});
        catalog.add(new String[]{"0002223334", "Beginning Python"});
        catalog.add(new String[]{"0003334445", "Classic Mythology"});
        catalog.add(new String[]{"0004445556", "Data and Society"});
        catalog.add(new String[]{"0005556667", "European History"});

        System.out.println(findBook(catalog, "0003334445")); // Classic Mythology
        System.out.println(findBook(catalog, "0009998887")); // Not Found
    }
}
