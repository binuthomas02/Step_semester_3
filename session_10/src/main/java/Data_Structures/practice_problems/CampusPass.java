import java.util.*;

interface Chargeable {
    void charge();
}

abstract class Vehicle {
    String pass;
    String owner;
    String type;

    Vehicle(String type, String pass, String owner) {
        this.type = type;
        this.pass = pass;
        this.owner = owner;
    }

    abstract int fee();
}

class Bike extends Vehicle {
    Bike(String type, String pass, String owner) {
        super(type, pass, owner);
    }

    int fee() {
        return 300;
    }
}

class Car extends Vehicle {
    Car(String type, String pass, String owner) {
        super(type, pass, owner);
    }

    int fee() {
        return 1000;
    }
}

class EBike extends Bike implements Chargeable {
    EBike(String type, String pass, String owner) {
        super(type, pass, owner);
    }

    public void charge() {
        System.out.println(pass + " charging bay allotted");
    }
}

class ECar extends Car implements Chargeable {
    ECar(String type, String pass, String owner) {
        super(type, pass, owner);
    }

    public void charge() {
        System.out.println(pass + " charging bay allotted");
    }
}

class CampusPass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] p = line.split("\\s+");
            if (p[0].equals("PASS")) {
                String type = p[1];
                String key = type.replace("-", "");
                Vehicle v;
                if (key.equals("Bike")) {
                    v = new Bike(type, p[2], p[3]);
                } else if (key.equals("Car")) {
                    v = new Car(type, p[2], p[3]);
                } else if (key.equals("EBike")) {
                    v = new EBike(type, p[2], p[3]);
                } else {
                    v = new ECar(type, p[2], p[3]);
                }
                vehicles.put(p[2], v);
                System.out.println(v.pass + " (" + v.type + ") pass fee " + v.fee());
            } else if (p[0].equals("CHARGE")) {
                Vehicle v = vehicles.get(p[1]);
                if (v == null) {
                    System.out.println("Vehicle not found");
                } else if (v instanceof Chargeable) {
                    ((Chargeable) v).charge();
                } else {
                    System.out.println(v.pass + " rejected: charging unsupported");
                }
            }
        }
    }
}
