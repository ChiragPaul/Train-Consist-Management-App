package main.java;

import java.util.List;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    // UC15 Logic: Safe Cargo Assignment
    public String assignCargo(GoodsBogie bogie, String cargoType) {
        String result;
        try {
            // Validate compatibility: Petroleum cannot be in a Rectangular bogie
            if ("Rectangular".equalsIgnoreCase(bogie.getType()) && "Petroleum".equalsIgnoreCase(cargoType)) {
                throw new CargoSafetyException("Safety Violation: Petroleum cannot be assigned to a Rectangular bogie.");
            }

            bogie.setCargo(cargoType);
            result = "Success: Cargo " + cargoType + " assigned to " + bogie.getType() + " bogie.";
            System.out.println(result);

        } catch (CargoSafetyException e) {
            // Graceful handling of the safety violation [cite: 1]
            result = "Handled Exception: " + e.getMessage();
            System.err.println(result);
        } finally {
            // Mandatory completion log [cite: 1]
            System.out.println("Cargo assignment process completed for " + bogie.getType() + " bogie.");
        }
        return result;
    }

    // Existing Logic from UC12/Regex
    public boolean isTrainSafe(List<GoodsBogie> bogies) {
        if (bogies == null) return true;
        return bogies.stream().allMatch(bogie -> {
            if ("Cylindrical".equalsIgnoreCase(bogie.getType())) {
                return "Petroleum".equalsIgnoreCase(bogie.getCargo());
            }
            return true;
        });
    }

    public boolean validateTrainID(String id) {
        return Pattern.matches("TRN-\\d{4}", id);
    }

    public boolean validateCargoCode(String code) {
        return Pattern.matches("PET-[A-Z]{2}", code);
    }
}