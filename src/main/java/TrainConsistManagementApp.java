package main.java;

import java.util.List;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    // UC12: Safety Compliance Logic
    public boolean isTrainSafe(List<GoodsBogie> bogies) {
        if (bogies == null) return true;
        return bogies.stream().allMatch(bogie -> {
            if ("Cylindrical".equalsIgnoreCase(bogie.getType())) {
                return "Petroleum".equalsIgnoreCase(bogie.getCargo());
            }
            return true;
        });
    }

    // UC14: Capacity Validation Logic
    public static class PassengerBogie {
        private String type;
        private int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }
    }

    public boolean validateTrainID(String id) {
        return Pattern.matches("TRN-\\d{4}", id);
    }

    public boolean validateCargoCode(String code) {
        return Pattern.matches("PET-[A-Z]{2}", code);
    }
}