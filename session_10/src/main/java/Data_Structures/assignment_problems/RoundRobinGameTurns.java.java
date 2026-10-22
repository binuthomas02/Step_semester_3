import java.util.*;

class RoundRobinGameTurns {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    Node tail;

    void addLast(String name) {
        Node n = new Node(name);
        if (tail == null) {
            n.next = n;
        } else {
            n.next = tail.next;
            tail.next = n;
        }
        tail = n;
    }

    void printTurns(int turns) {
        StringBuilder sb = new StringBuilder();
        Node cur = tail.next;
        for (int i = 0; i < turns; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(cur.data);
            cur = cur.next;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinGameTurns game = new RoundRobinGameTurns();
        String first = sc.nextLine().trim();
        int turns = Integer.parseInt(sc.nextLine().trim());
        for (String s : first.split("\\s+")) {
            game.addLast(s);
        }
        game.printTurns(turns);
    }
}
