import java.util.*;
public class Problem4_PairWithTargetSumArray {

    public static boolean bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((long) nums[i] + nums[j] == target) return true;
            }
        }
        return false;
    }

    public static boolean sortTwoPointers(int[] nums, int target) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l < r) {
            long sum = (long) arr[l] + arr[r];
            if (sum == target) return true;
            if (sum < target) l++;
            else r--;
        }
        return false;
    }

    public static boolean hashSet(int[] nums, int target) {
        Set<Long> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains((long) target - x)) return true;
            seen.add((long) x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] s1 = {2, 7, 11, 15};
        int[] s2 = {3, 4, 6};
        System.out.println(hashSet(s1, 9));          
        System.out.println(hashSet(s2, 20));         
        System.out.println(sortTwoPointers(s1, 9));  
        System.out.println(sortTwoPointers(s2, 20)); 
        System.out.println(bruteForce(s1, 9));       
        System.out.println(bruteForce(s2, 20));     
    }
}
