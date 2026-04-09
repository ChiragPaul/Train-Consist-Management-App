import java.util.ArrayList;
import java.util.List;

class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Create a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 72));

        // 2. Convert list to stream, map to capacity, and reduce to sum
        int totalSeatingCapacity = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);       // reduce() sums the capacities

        // 3. Display the total seating capacity
        System.out.println("Total Seating Capacity of the Train: " + totalSeatingCapacity);
    }
}