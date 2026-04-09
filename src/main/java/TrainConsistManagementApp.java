package main.java;

import java.util.List;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    // UC12: Safety Compliance Logic
    // Rules: Cylindrical bogies MUST carry Petroleum.
    // Open/Box bogies can carry anything.
    public boolean isTrainSafe(List<GoodsBogie> bogies) {
        if (bogies == null) return true;

        return bogies.stream().allMatch(bogie -> {
            if ("Cylindrical".equalsIgnoreCase(bogie.getType())) {
                return "Petroleum".equalsIgnoreCase(bogie.getCargo());
            }
            return true;
        });
    }

    // Existing Regex Validations
    public boolean validateTrainID(String id) {
        return Pattern.matches("TRN-\\d{4}", id);
    }

    public boolean validateCargoCode(String code) {
        return Pattern.matches("PET-[A-Z]{2}", code);
    }
}

