import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        Set<String> bogieIds = new HashSet<>();

        System.out.println("Adding bogie IDs...");
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");

        System.out.println("Attempting to add duplicate: BG101");
        boolean isAdded = bogieIds.add("BG101");

        if (!isAdded) {
            System.out.println("Bogie ID BG101 already exists. HashSet ignored the duplicate.");
        }

        System.out.println("\nFinal List of Unique Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println("Bogie ID: " + id);
        }

        System.out.println("\nTotal Unique Bogies: " + bogieIds.size());
        System.out.println("UC3 uniqueness validation completed.........");
    }
}