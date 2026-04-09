package main.java;

public class GoodsBogie {
    private String type;
    private String cargo;
    private int capacity;

    // Constructor for UC12 (Safety Logic)
    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
        this.capacity = 0; // Default value
    }

    // Constructor for UC13 (Performance/Filtering Logic)
    public GoodsBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.cargo = "None"; // Default value
    }

    // Full Constructor
    public GoodsBogie(String type, String cargo, int capacity) {
        this.type = type;
        this.cargo = cargo;
        this.capacity = capacity;
    }

    // Getters
    public String getType() { return type; }
    public String getCargo() { return cargo; }
    public int getCapacity() { return capacity; }
}