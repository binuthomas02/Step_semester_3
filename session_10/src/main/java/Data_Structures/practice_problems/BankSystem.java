import java.util.*;

abstract class Account {
    String id;
    int balance;

    Account(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    abstract int limit();

    abstract String reason();

    void withdraw(int amount) {
        if (balance - amount < limit()) {
            System.out.println(id + " rejected: " + reason());
        } else {
            balance -= amount;
            System.out.println(id + " balance " + balance);
        }
    }
}

class Savings extends Account {
    Savings(String id, int balance) {
        super(id, balance);
    }

    int limit() {
        return 1000;
    }

    String reason() {
        return "minimum balance 1000";
    }
}

class Current extends Account {
    Current(String id, int balance) {
        super(id, balance);
    }

    int limit() {
        return -5000;
    }

    String reason() {
        return "overdraft limit 5000";
    }
}

class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] p = line.split("\\s+");
            if (p[0].equals("Savings")) {
                accounts.put(p[1], new Savings(p[1], Integer.parseInt(p[2])));
            } else if (p[0].equals("Current")) {
                accounts.put(p[1], new Current(p[1], Integer.parseInt(p[2])));
            } else if (p[0].equals("WITHDRAW")) {
                Account a = accounts.get(p[1]);
                if (a == null) {
                    System.out.println("Account not found");
                } else {
                    a.withdraw(Integer.parseInt(p[2]));
                }
            }
        }
    }
}
