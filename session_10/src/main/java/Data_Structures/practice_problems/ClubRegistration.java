import java.util.*;

class Student {
    String roll;
    String name;

    Student(String roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Student)) {
            return false;
        }
        return roll.equals(((Student) o).roll);
    }

    public int hashCode() {
        return roll.hashCode();
    }
}

class ClubRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> members = new HashSet<>();
        List<Student> checks = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] p = line.split("\\s+");
            Student s = new Student(p[1], p[2]);
            if (p[0].equals("ADD")) {
                if (members.add(s)) {
                    System.out.println("Added");
                } else {
                    System.out.println("duplicate rejected");
                }
            } else if (p[0].equals("CONTAINS")) {
                checks.add(s);
            }
        }
        System.out.println("member count " + members.size());
        for (Student s : checks) {
            System.out.println("contains: " + members.contains(s));
        }
    }
}
