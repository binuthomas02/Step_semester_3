import java.util.*;

class MarksGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<int[]> rows = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] p = line.replace("[", " ").replace("]", " ").replace(",", " ").trim().split("\\s+");
            names.add(p[0]);
            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                marks[i] = Integer.parseInt(p[i + 1]);
            }
            rows.add(marks);
        }
        int n = names.size();
        int[][] grid = rows.toArray(new int[n][]);
        int[] totals = new int[n];
        double[] sums = new double[3];
        int top = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                totals[i] += grid[i][j];
                sums[j] += grid[i][j];
            }
            if (totals[i] > totals[top]) {
                top = i;
            }
        }
        StringBuilder t = new StringBuilder("Totals ");
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                t.append(", ");
            }
            t.append(names.get(i)).append(" ").append(totals[i]);
        }
        System.out.println(t);
        System.out.println("averages " + String.format("%.2f, %.2f, %.2f", sums[0] / n, sums[1] / n, sums[2] / n));
        System.out.println("topper " + names.get(top) + " (" + totals[top] + ")");
    }
}
