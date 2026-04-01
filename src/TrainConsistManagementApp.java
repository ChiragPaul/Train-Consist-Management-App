import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        HashMap<String, Integer> bogieCapacityMap = new HashMap<>();


        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 56);
        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("General", 90);

        System.out.println("--- Bogie to Capacity Mapping ---");


        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            String bogieName = entry.getKey();
            Integer capacity = entry.getValue();
            System.out.println("Bogie: " + bogieName + " | Capacity: " + capacity + " seats");
        }


        String searchBogie = "Sleeper";
        if (bogieCapacityMap.containsKey(searchBogie)) {
            System.out.println("\nFast Lookup: The capacity of " + searchBogie + " is " + bogieCapacityMap.get(searchBogie));
        }
        System.out.println("UC6 boogie-capacity mapping completed...");
    }
}