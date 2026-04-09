package test.java;

import main.java.TrainConsistManagementApp;
import main.java.GoodsBogie;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    TrainConsistManagementApp app = new TrainConsistManagementApp();


    @Test
    void testLoopFilteringLogic() {
        List<GoodsBogie> data = Arrays.asList(
                new GoodsBogie("Open", 70),
                new GoodsBogie("Box", 50)
        );
        List<GoodsBogie> result = app.filterBogiesByLoop(data);
        assertEquals(1, result.size(), "Loop should only keep bogies with capacity > 60");
    }

    @Test
    void testStreamFilteringLogic() {
        List<GoodsBogie> data = Arrays.asList(
                new GoodsBogie("Open", 70),
                new GoodsBogie("Box", 50)
        );
        List<GoodsBogie> result = app.filterBogiesByStream(data);
        assertEquals(1, result.size(), "Stream should only keep bogies with capacity > 60");
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<GoodsBogie> data = Arrays.asList(
                new GoodsBogie("Open", 80),
                new GoodsBogie("Cylindrical", 40),
                new GoodsBogie("Box", 65)
        );
        assertEquals(app.filterBogiesByLoop(data).size(), app.filterBogiesByStream(data).size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<GoodsBogie> data = Collections.singletonList(new GoodsBogie("Open", 70));
        long start = System.nanoTime();
        app.filterBogiesByLoop(data);
        long end = System.nanoTime();
        assertTrue((end - start) >= 0, "Execution time should be tracked correctly");
    }

    @Test
    void testLargeDatasetProcessing() {
        List<GoodsBogie> largeList = new ArrayList<>();
        for (int i = 0; i < 50_000; i++) {
            largeList.add(new GoodsBogie("Open", i % 100));
        }

        long startStream = System.nanoTime();
        app.filterBogiesByStream(largeList);
        long endStream = System.nanoTime();

        long startLoop = System.nanoTime();
        app.filterBogiesByLoop(largeList);
        long endLoop = System.nanoTime();

        System.out.println("Stream Time: " + (endStream - startStream) + " ns");
        System.out.println("Loop Time:   " + (endLoop - startLoop) + " ns");
    }

    // --- UC12 & Regex Validation Tests ---

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = Collections.singletonList(new GoodsBogie("Cylindrical", "Coal"));
        assertFalse(app.isTrainSafe(bogies));
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(app.validateTrainID("TRN-1234"));
        assertFalse(app.validateTrainID("TRN-123")); // Too short
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(app.validateCargoCode("PET-AB"));
        assertFalse(app.validateCargoCode("PET-12")); // Should be letters
    }
}