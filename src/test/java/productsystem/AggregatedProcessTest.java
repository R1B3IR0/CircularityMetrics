package productsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AggregatedProcessTest {

    private AggregatedProcess ag1;
    private UnitaryProcess up1;


    @BeforeEach
    void setUp() {
        ag1 = new AggregatedProcess("ag1");
        up1 = new UnitaryProcess("up1");
    }

    @Test
    void addProcessTest() {
        // Case 1: addProcess() should add a UnitaryProcess to the container
        ag1.addUnitaryProcess(up1);
        assertEquals(1, ag1.getCount(), "addProcess() should add a UnitaryProcess to the container");

    }

    @Test
    public void addNullProcessTest() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> ag1.addUnitaryProcess(null),
                "Expected addUnitaryProcess to throw NullPointerException"
        );
        assertEquals("Unitary Process cannot be null", exception.getMessage());
    }

    @Test
    void removeProcessTest() {
        // Case 1: Count should be 0
        ag1.addUnitaryProcess(up1);
        ag1.removeUnitaryProcess(up1.getId());
        assertEquals(0, ag1.getCount(), "removeProcess() should remove a UnitaryProcess from the container");
    }

    @Test
    void removeNotExistingProcessTest() {
        // Case 2: removeProcess() should return -1(because the does not exist in the container)
        int expected = -1;
        int result = ag1.findUnitaryProcess(expected);
        assertEquals(expected, result, "removeProcess() should return -1(because the does not exist in the container)");
    }

    //Case 3: removeProcess() id cannot be null.

    @Test
    void findUnitaryProcessTest() {
        //Case 1: findUnitaryProcess() should return 0.
        ag1.addUnitaryProcess(up1);
        assertEquals(0, ag1.findUnitaryProcess(up1.getId()), "findUnitaryProcess() should return 0");
    }

    @Test
    void NotFoundUnitaryProcessTest() {
        //Case 2: NotFoundUnitaryProcess() should return -1.
        ag1.findUnitaryProcess(up1.getId());
        assertEquals(-1, ag1.findUnitaryProcess(up1.getId()), "NotFoundUnitaryProcess() should return -1");

    }

    //Case 3: findUnitaryProcess() id cannot be null.

}