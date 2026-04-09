package main.java;

import java.util.regex.Pattern;


public class TrainConsistManagementApp {
    // Validates TRN- followed by 4 digits
    public boolean validateTrainID(String id) {
        return Pattern.matches("TRN-\\d{4}", id);
    }

    // Validates PET- followed by 2 uppercase letters
    public boolean validateCargoCode(String code) {
        return Pattern.matches("PET-[A-Z]{2}", code);
    }
}