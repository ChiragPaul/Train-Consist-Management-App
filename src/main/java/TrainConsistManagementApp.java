package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // --- UC12: Safety Compliance Logic ---
    public boolean isTrainSafe(List<GoodsBogie> bogies) {
        if (bogies == null) return true;
        return bogies.stream().allMatch(bogie -> {
            if ("Cylindrical".equalsIgnoreCase(bogie.getType())) {
                return "Petroleum".equalsIgnoreCase(bogie.getCargo());
            }
            return true;
        });
    }

    public List<GoodsBogie> filterBogiesByLoop(List<GoodsBogie> bogies) {
        List<GoodsBogie> filtered = new ArrayList<>();
        if (bogies == null) return filtered;
        for (GoodsBogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                filtered.add(bogie);
            }
        }
        return filtered;
    }

    public List<GoodsBogie> filterBogiesByStream(List<GoodsBogie> bogies) {
        if (bogies == null) return new ArrayList<>();
        return bogies.stream()
                .filter(bogie -> bogie.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public boolean validateTrainID(String id) {
        return id != null && Pattern.matches("TRN-\\d{4}", id);
    }

    public boolean validateCargoCode(String code) {
        return code != null && Pattern.matches("PET-[A-Z]{2}", code);
    }
}