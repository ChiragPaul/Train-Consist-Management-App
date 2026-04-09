package test.java;

import main.java.TrainConsistManagementApp;
import main.java.GoodsBogie;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // --- UC12: Safety Compliance Tests ---

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );
        assertTrue(app.isTrainSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = Collections.singletonList(
                new GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(app.isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Open", "Grain"),
                new GoodsBogie("Box", "Coal")
        );
        assertTrue(app.isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal") // The violation
        );
        assertFalse(app.isTrainSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        assertTrue(app.isTrainSafe(Collections.emptyList()));
    }

    // --- Existing Regex Tests ---

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(app.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(app.validateCargoCode("PET-AB"));
    }
// --- Rest of the Regex Validation Tests ---

    @Test
    void testRegex_InvalidTrainIDFormat() {
        // Test wrong prefix or missing hyphen
        assertFalse(app.validateTrainID("TRAIN12"));
        assertFalse(app.validateTrainID("TRN12A"));
        assertFalse(app.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        // Must be exactly 4 digits
        assertFalse(app.validateTrainID("TRN-123"));
        assertFalse(app.validateTrainID("TRN-12345"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        // Missing hyphen or wrong prefix
        assertFalse(app.validateCargoCode("PET123"));
        assertFalse(app.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        // Must be exactly 2 UPPERCASE letters
        assertFalse(app.validateCargoCode("PET-ab"));
        assertFalse(app.validateCargoCode("pet-AB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(app.validateTrainID(""));
        assertFalse(app.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Ensures no extra characters are allowed at the end
        assertFalse(app.validateTrainID("TRN-1234 Extra"));
        assertFalse(app.validateCargoCode("PET-ABC"));
    }
}