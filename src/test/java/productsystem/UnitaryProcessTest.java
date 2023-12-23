package productsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitaryProcessTest {

    private UnitaryProcess up1;
    private Flow f1;

    @BeforeEach
    void setUp() {
        up1 = new UnitaryProcess("up1");
        f1 = new Flow();
    }

    @Test
    void addOutputTest() {
        // Case 1: addOutput() should add a Flow to the container
        up1.addOutput(f1);
        assertEquals(1, up1.getCount(), "addOutput() should add a Flow to the container");
    }

    @Test
    void addNullOutputTest() {
        // Case 2: Flow cannot be null
        assertThrows(IllegalArgumentException.class, () -> up1.addOutput(null), "Flow cannot be null");
    }

    @Test
    void removeOutputTest() {
        // Case 1: Count should be 0
        up1.addOutput(f1);
        up1.removeOutput(f1.getName());
        assertEquals(0, up1.getCount(), "removeOutput() should remove a Flow from the container");
    }

    @Test
    void removeNotExistingOutputTest() {
        // Case 2: Removing a flow that doesn't exist
        int expected = -1;
        int result = up1.findOutFlow(expected);
        assertEquals(expected, result, "removeOutput() should return -1(because the does not exist in the container)");
    }

    @Test
    void removeNullOutputTest() {
        // Case 3: removeOutput() name cannot be null.
        assertThrows(IllegalArgumentException.class, () -> up1.removeOutput(null), "Flow cannot be null");
    }

    @Test
    void addInputTest() {
        // Case 1: addInput() should add a Flow to the container
        up1.addInput(f1);
        assertEquals(1, up1.getCount(), "addInput() should add a Flow to the container");
    }

    @Test
    void addNullInputTest() {
        // Case 2: Flow cannot be null
        assertThrows(IllegalArgumentException.class, () -> up1.addInput(null), "Flow cannot be null");
    }

    @Test
    void removeInputTest() {
        // Case 1: Count should be 0
        up1.addInput(f1);
        up1.removeInput(f1.getName());
        assertEquals(0, up1.getCount(), "removeInput() should remove a Flow from the container");
    }

    @Test
    void removeNotExistingInputTest() {
        // Case 2: Removing a flow that doesn't exist
        int expected = -1;
        int result = up1.findInFlow(expected);
        assertEquals(expected, result, "removeInput() should return -1(because the does not exist in the container)");

    }

    @Test
    void removeNullInputTest() {
        // Case 3: removeInput() name cannot be null.
        assertThrows(IllegalArgumentException.class, () -> up1.removeInput(null), "Flow cannot be null");
    }

    @Test
    void findOutFlowTest() {
        // Case 1: findOutFlow() should return 0.
        up1.addOutput(f1);
        assertEquals(0, up1.findOutFlow(f1.getId()), "findOutFlow() should return 0");
    }

    @Test
    void NotFoundOutFlowTest() {
        // Case 2: NotFoundOutFlow() should return -1.
        up1.findOutFlow(f1.getId());
        assertEquals(-1, up1.findOutFlow(f1.getId()), "NotFoundOutFlow() should return -1");
    }

    // Case 3: findOutFlow() id cannot be null.

    @Test
    void findInFlowTest() {
        // Case 1: findInFlow() should return 0.
        up1.addInput(f1);
        assertEquals(0, up1.findInFlow(f1.getId()), "findInFlow() should return 0");
    }

    @Test
    void NotFoundInFlowTest() {
        // Case 2: NotFoundInFlow() should return -1.
        up1.findInFlow(f1.getId());
        assertEquals(-1, up1.findInFlow(f1.getId()), "NotFoundInFlow() should return -1");
    }

    // Case 3: findInFlow() id cannot be null.
}