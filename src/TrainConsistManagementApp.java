import java.util.*;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // Key Requirement: Create a List<Bogie> to store passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        // Actor adds bogies like Sleeper, AC Chair, and First Class
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        bogies.forEach(System.out::println);

        // Key Concept: Use Comparator.comparingInt() for custom sorting [cite: 1]
        // Goal: Sort passenger bogies based on seating capacity [cite: 1]
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nAfter Sorting by Capacity (Ascending):");
        // Flow: Sorted bogies are displayed in order [cite: 1]
        bogies.forEach(System.out::println);

        // Optional: Sorting in descending order to "Identify high-capacity bogies first" [cite: 1]
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\nAfter Sorting by Capacity (Descending - High Capacity First):");
        bogies.forEach(System.out::println);
        System.out.println("UC7 sorting completed....");
    }
}