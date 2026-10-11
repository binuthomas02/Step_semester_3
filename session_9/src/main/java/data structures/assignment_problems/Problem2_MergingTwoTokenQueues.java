import java.util.Arrays;

/**
 * Problem 2: Merging Two Token Queues
 *
 * Approach: Two pointers. Copy the smaller current value and advance that pointer
 * (using <= keeps duplicates, taking from A first on ties). Then copy whatever remains.
 *
 * Time complexity : O(m + n)
 * Space           : O(m + n) for the output list, O(1) extra besides it
 *
 * Compared with "join + sort": that costs O((m + n) log(m + n)) because it ignores the fact
 * that both lists are already sorted. The two-pointer merge is strictly faster.
 */
public class Problem2_MergingTwoTokenQueues {

    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        int[] result = new int[counterA.length + counterB.length];
        int i = 0, j = 0, k = 0;

        while (i < counterA.length && j < counterB.length) {
            if (counterA[i] <= counterB[j]) result[k++] = counterA[i++];
            else result[k++] = counterB[j++];
        }
        while (i < counterA.length) result[k++] = counterA[i++];
        while (j < counterB.length) result[k++] = counterB[j++];

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            mergeTokens(new int[]{3, 8, 15, 20}, new int[]{5, 8, 12}))); // [3, 5, 8, 8, 12, 15, 20]
        System.out.println(Arrays.toString(
            mergeTokens(new int[]{}, new int[]{4, 9})));                 // [4, 9]
    }
}
