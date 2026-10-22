import java.util.*;

class CancelledOrdersCleanup {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node removeAll(Node head, int code) {
        while (head != null && head.data == code) {
            head = head.next;
        }
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.data == code) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.hasNextLine() ? sc.nextLine().trim() : "";
        int code = Integer.parseInt(sc.nextLine().trim());
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
        head = removeAll(head, code);
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        System.out.println(sb + "null");
    }
}
