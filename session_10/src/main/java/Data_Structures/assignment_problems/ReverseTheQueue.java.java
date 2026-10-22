import java.util.*;

class ReverseTheQueue {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.hasNextLine() ? sc.nextLine().trim() : "";
        Node head = null;
        Node tail = null;
        if (!first.isEmpty()) {
            for (String s : first.split("\\s+")) {
                Node n = new Node(Integer.parseInt(s));
                if (head == null) {
                    head = n;
                } else {
                    tail.next = n;
                }
                tail = n;
            }
        }
        head = reverse(head);
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        System.out.println(sb + "null");
    }
}
