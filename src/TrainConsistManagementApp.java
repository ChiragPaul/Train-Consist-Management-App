import java.util.LinkedList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        LinkedList<String> trainConsist = new LinkedList<>();


        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist: " + trainConsist);


        trainConsist.add(2, "Pantry Car");
        System.out.println("After Adding Pantry Car at position 2: " + trainConsist);


        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("After Removing First and Last Bogie: " + trainConsist);

        System.out.println("UC4 ordered consist operations completed...");
    }
}