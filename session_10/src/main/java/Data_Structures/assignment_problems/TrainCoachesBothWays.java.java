import java.util.*;

class TrainCoachesBothWays {
    static class Node {
        String data;
        Node prev;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    void addLast(String name) {
        Node n = new Node(name);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    void remove(String name) {
        Node cur = head;
        while (cur != null && !cur.data.equals(name)) {
            cur = cur.next;
        }
        if (cur == null) {
            return;
        }
        if (cur.prev == null) {
            head = cur.next;
        } else {
            cur.prev.next = cur.next;
        }
        if (cur.next == null) {
            tail = cur.prev;
        } else {
            cur.next.prev = cur.prev;
        }
    }

    void printForward() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur != head) {
                sb.append(" <-> ");
            }
            sb.append(cur.data);
        }
        System.out.println("Forward: " + sb);
    }

    void printBackward() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = tail; cur != null; cur = cur.prev) {
            if (cur != tail) {
                sb.append(" <-> ");
            }
            sb.append(cur.data);
        }
        System.out.println("Backward: " + sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrainCoachesBothWays train = new TrainCoachesBothWays();
        String first = sc.nextLine().trim();
        String name = sc.nextLine().trim();
        for (String s : first.split("\\s+")) {
            train.addLast(s);
        }
        train.remove(name);
        train.printForward();
        train.printBackward();
    }
}
