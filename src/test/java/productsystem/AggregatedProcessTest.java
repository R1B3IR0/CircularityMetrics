package productsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AggregatedProcessTest {

    private AggregatedProcess ag1;
    private AggregatedProcess ag2;
    private UnitaryProcess up1;
    private UnitaryProcess up2;


    @BeforeEach
    void setUp() {
        ag1 = new AggregatedProcess("ag1");
        ag2 = new AggregatedProcess("ag2");
        up1 = new UnitaryProcess("up1");
        up2 = new UnitaryProcess("up2");
    }

    @Test
    void addProcess() {
        // Case 1: addProcess() should add a UnitaryProcess to the container
        UnitaryProcess[] expected = {up1};
        ag1.addProcess(up1);
        UnitaryProcess[] result = ag1.getContainer();
        assertEquals(expected, result, "addProcess() should add a UnitaryProcess to the container");

        // Case 2: addProcess
        try {
            ag1.addProcess(null);
            fail("addProcess() should throw an exception when adding a null UnitaryProcess");
        } catch (IllegalArgumentException e) {
        }
        assertEquals(1, ag1.getCount(), "addProcess() should not add a null UnitaryProcess to the container");
    }



    @Test
    void removeProcess() {
    }

    @Test
    void expandCapacity() {

    }

    @Test
    void findUnitaryProcess() {

    }
}