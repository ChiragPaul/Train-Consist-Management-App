import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        Set<String> trainFormation = new LinkedHashSet<>();


        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");


        System.out.println("Attempting to add duplicate: Sleeper...");
        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println("Duplicate detected! Bogie 'Sleeper' was not added.\n");
        }


        System.out.println("Final Train Formation (Insertion Order Preserved):");
        for (String bogie : trainFormation) {
            System.out.println("- " + bogie);
        }

        System.out.println("\nComplete Formation List: " + trainFormation);
        System.out.println("UC5 formation setup completed");
    }
}