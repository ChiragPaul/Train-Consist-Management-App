package test.java;

import main.java.*;
import main.java.TrainConsistManagementApp.PassengerBogie;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // --- UC12: Safety Compliance Tests ---
    @Test
    void testSafety_ValidCylindrical() {
        List<GoodsBogie> bogies = Collections.singletonList(new GoodsBogie("Cylindrical", "Petroleum"));
        assertTrue(app.isTrainSafe(bogies));
    }

    @Test
    void testSafety_InvalidCylindrical() {
        List<GoodsBogie> bogies = Collections.singletonList(new GoodsBogie("Cylindrical", "Coal"));
        assertFalse(app.isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedValid() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Grain")
        );
        assertTrue(app.isTrainSafe(bogies));
    }

    // --- UC14: Custom Exception Tests ---
    @Test
    void testException_NegativeCapacity() {
        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", -1);
        });
    }

    @Test
    void testException_ZeroCapacity() {
        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("General", 0);
        });
    }

    @Test
    void testException_ValidCapacity() {
        assertDoesNotThrow(() -> new PassengerBogie("AC", 50));
    }

    // --- Regex Validation Tests ---
    @Test
    void testRegex_TrainID() {
        assertTrue(app.validateTrainID("TRN-1234"));
        assertFalse(app.validateTrainID("TRN-123")); // Too short
        assertFalse(app.validateTrainID("ABC-1234")); // Wrong prefix
    }

    @Test
    void testRegex_CargoCode() {
        assertTrue(app.validateCargoCode("PET-AB"));
        assertFalse(app.validateCargoCode("PET-12")); // Should be letters
        assertFalse(app.validateCargoCode("PET-abc")); // Should be uppercase
    }
}