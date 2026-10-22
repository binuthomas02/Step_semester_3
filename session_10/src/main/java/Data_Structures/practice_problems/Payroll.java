import java.util.*;

abstract class Staff {
    String name;
    String type;

    Staff(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract int pay();

    public String toString() {
        return "Payslip[name=" + name + ", type=" + type + ", pay=" + pay() + "]";
    }
}

class FullTime extends Staff {
    int salary;

    FullTime(String name, int salary) {
        super(name, "FullTime");
        this.salary = salary;
    }

    int pay() {
        return salary;
    }
}

class PartTime extends Staff {
    int hours;
    int rate;

    PartTime(String name, int hours, int rate) {
        super(name, "PartTime");
        this.hours = hours;
        this.rate = rate;
    }

    int pay() {
        return hours * rate;
    }
}

class Intern extends Staff {
    int stipend;

    Intern(String name, int stipend) {
        super(name, "Intern");
        this.stipend = stipend;
    }

    int pay() {
        return stipend;
    }
}

class Payroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Staff> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] p = line.split("\\s+");
            if (p[0].equals("FullTime")) {
                list.add(new FullTime(p[1], Integer.parseInt(p[2])));
            } else if (p[0].equals("PartTime")) {
                list.add(new PartTime(p[1], Integer.parseInt(p[2]), Integer.parseInt(p[3])));
            } else if (p[0].equals("Intern")) {
                list.add(new Intern(p[1], Integer.parseInt(p[2])));
            }
        }
        Staff[] staff = list.toArray(new Staff[0]);
        int total = 0;
        Staff top = staff[0];
        for (Staff s : staff) {
            System.out.println(s);
            total += s.pay();
            if (s.pay() > top.pay()) {
                top = s;
            }
        }
        System.out.println("Total " + total);
        System.out.println("top earner " + top.name);
    }
}
