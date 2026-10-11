/**
 * Part B (Quiz answers) and Part C (Concept answers).
 * Run this file to print everything.
 */
public class PartB_PartC_Answers {

    public static void main(String[] args) {
        System.out.println("===== PART B: QUIZ ANSWERS =====");
        String[] quiz = {
            "Q1.  B  O(1)",
            "Q2.  C  Insertion",
            "Q3.  C  Matching required operations and constraints to the strengths of different data structures",
            "Q4.  C  Time vs space trade-offs",
            "Q5.  B  O(m + n)",
            "Q6.  C  Linear data structure",
            "Q7.  C  O(n)",
            "Q8.  D  Linked list",
            "Q9.  B  O(m x n)",
            "Q10. C  To organize, store, and access data efficiently for specific operations"
        };
        for (String line : quiz) System.out.println(line);

        System.out.println();
        System.out.println("===== PART C: CONCEPT ANSWERS =====");

        System.out.println("\nQ1. Unsorted vs sorted search (1D array)");
        System.out.println(
            "Unsorted: O(n) linear search, because the element could be anywhere so every position may\n" +
            "have to be checked. Sorted: O(log n) binary search, because comparing with the middle element\n" +
            "tells us which half cannot contain the target, so the search space halves each step.\n" +
            "The difference exists because sorted order carries information that lets us discard large parts\n" +
            "of the data; unsorted data gives no such guidance.");

        System.out.println("\nQ2. Why 2n is O(n), not O(2n)");
        System.out.println(
            "Big-O describes how an algorithm GROWS as input size grows, not exact operation counts.\n" +
            "A constant multiplier like 2 only changes the speed by a fixed factor (it depends on hardware,\n" +
            "language, etc.) and does not change the growth shape: doubling n still doubles the work.\n" +
            "So 2n and n are the same linear class, and O(n) is the simplified form.");

        System.out.println("\nQ3. Traversal in linear vs non-linear structures");
        System.out.println(
            "Linear structures (arrays) have each element related to one predecessor and one successor,\n" +
            "so traversal is a single sequential pass from first to last. Non-linear structures (trees)\n" +
            "relate an element to several others (a parent and multiple children), so there is no single\n" +
            "next element; traversal needs a strategy such as depth-first (inorder, preorder, postorder)\n" +
            "or breadth-first (level order), usually using recursion, a stack or a queue.");
    }
}
