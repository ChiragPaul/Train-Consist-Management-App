package test.java;

import main.java.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    TrainConsistManagementApp app = new TrainConsistManagementApp();


    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical", "None");
        String result = app.assignCargo(bogie, "Petroleum");

        assertTrue(result.contains("Success"));
        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular", "None");
        String result = app.assignCargo(bogie, "Petroleum");

        assertTrue(result.contains("Handled Exception"));
        assertNotEquals("Petroleum", bogie.getCargo(), "Cargo should NOT be assigned on failure.");
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie unsafeBogie = new GoodsBogie("Rectangular", "None");
        GoodsBogie safeBogie = new GoodsBogie("Open", "None");

        app.assignCargo(unsafeBogie, "Petroleum");
        String safeResult = app.assignCargo(safeBogie, "Coal");

        assertTrue(safeResult.contains("Success"));
        assertEquals("Coal", safeBogie.getCargo());
    }


    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(app.isTrainSafe(bogies));
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(app.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(app.validateCargoCode("PET123"));
    }
}