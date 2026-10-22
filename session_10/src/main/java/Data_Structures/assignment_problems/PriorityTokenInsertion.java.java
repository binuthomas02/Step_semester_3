import java.util.*;

class PriorityTokenInsertion {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    void addFirst(int token) {
        Node n = new Node(token);
        n.next = head;
        head = n;
    }

    void addLast(int token) {
        Node n = new Node(token);
        if (head == null) {
            head = n;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = n;
    }

    void insertAt(int index, int token) {
        if (index == 0) {
            addFirst(token);
            return;
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node n = new Node(token);
        n.next = prev.next;
        prev.next = n;
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        System.out.println(sb + "null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityTokenInsertion list = new PriorityTokenInsertion();
        String first = sc.hasNextLine() ? sc.nextLine().trim() : "";
        if (!first.isEmpty()) {
            for (String s : first.split("\\s+")) {
                list.addLast(Integer.parseInt(s));
            }
        }
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] p = line.split("\\s+");
            if (p[0].equals("addFirst")) {
                list.addFirst(Integer.parseInt(p[1]));
            } else if (p[0].equals("addLast")) {
                list.addLast(Integer.parseInt(p[1]));
            } else if (p[0].equals("insertAt")) {
                list.insertAt(Integer.parseInt(p[1]), Integer.parseInt(p[2]));
            }
        }
        list.print();
    }
}
