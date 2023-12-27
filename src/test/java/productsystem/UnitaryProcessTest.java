package productsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class UnitaryProcessTest {

    private UnitaryProcess up1;
    private Flow f1;
    private Flow f2;

    @BeforeEach
    void setUp() {
        up1 = new UnitaryProcess("up1");
        f1 = new Flow("f1",null,0,null,0);
        f2 = new Flow("f2",null,0,null,0);
    }

    @Test
    void addOutputTest() {
        // Case 1: addOutput() should add a Flow to the container
        up1.addFlowOutput(f1);
        assertEquals(1, up1.getCountOut(), "addOutput() should add a Flow to the container");
    }

    @Test
    void addNullOutputTest() {
        // Case 2: Flow cannot be null

        NullPointerException exception = assertThrows(NullPointerException.class, () -> up1.addFlowOutput(null), "Esperava-se que addFlowOutput lançasse NullPointerException");
        assertEquals("Flow cannot be null", exception.getMessage());
    }

    @Test
    void removeOutputTest() {
        // Case 1: Count should be 0
        up1.addFlowOutput(f1);
        up1.removeFlowOutput(f1.getFlowName());
        assertEquals(0, up1.getCountOut(), "removeOutput() should remove a Flow from the container");
    }

    @Test
    void findNotExistingOutputTest() {
        // Case 2: Removing a flow that doesn't exist
        String expected = "cascalho";
        int result = up1.findOutFlow(expected);
        assertEquals(-1, result, "removeOutput() should return -1(because the does not exist in the container)");

    }

    @Test
    void removeNullOutputTest() {
        // Case 3: removeOutput() name cannot be null.
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> up1.removeFlowOutput("cascalho"),
                "Esperava-se que removeNullOutput lançasse NoSuchElementException");
        assertEquals("cascalho", exception.getMessage());
    }

    @Test
    void addInputTest() {
        // Case 1: addInput() should add a Flow to the container
        up1.addFlowInput(f1);
        assertEquals(1, up1.getCountIn(), "addInput() should add a Flow to the container");
    }

    @Test
    void addNullInputTest() {
        // Case 2: Flow cannot be null
        NullPointerException exception = assertThrows(NullPointerException.class, () -> up1.addFlowInput(null), "Esperava-se que addFlowInput lançasse NullPointerException");
        assertEquals("Flow cannot be null", exception.getMessage());
    }

    @Test
    void removeInputTest() {
        // Case 1: Count should be 0
        up1.addFlowInput(f1);
        up1.removeFlowInput(f1.getFlowName());
        assertEquals(0, up1.getCountIn(), "removeInput() should remove a Flow from the container");
    }

    @Test
    void findNotExistingInputTest() {
        // Case 2: Removing a flow that doesn't exist
        String expected = "cascalho";
        int result = up1.findInFlow(expected);
        assertEquals(-1, result, "findInputTest should return -1(because the does not exist in the container)");

    }

    @Test
    void removeNullInputTest() {
        // Case 3: removeInput() name cannot be null.
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> up1.removeFlowInput("cascalho"),
                "Esperava-se que removeNullOutput lançasse NoSuchElementException");
        assertEquals("cascalho", exception.getMessage());
    }

    @Test
    void findOutFlowTest() {
        // Case 1: findOutFlow() should return 0.
        up1.addFlowOutput(f1);
        assertEquals(0, up1.findOutFlow(f1.getFlowName()), "findOutFlow() should return 0");
    }

    @Test
    void NotFoundOutFlowTest() {
        // Case 2: NotFoundOutFlow() should return -1.
        up1.findOutFlow(f1.getFlowName());
        assertEquals(-1, up1.findOutFlow(f1.getFlowName()), "NotFoundOutFlow() should return -1");
    }

    // Case 3: findOutFlow() id cannot be null.

    @Test
    void findInFlowTest() {
        // Case 1: findInFlow() should return 0.
        up1.addFlowInput(f1);
        assertEquals(0, up1.findInFlow(f1.getFlowName()), "findInFlow() should return 0");
    }

    @Test
    void NotFoundInFlowTest() {
        // Case 2: NotFoundInFlow() should return -1.
        up1.findInFlow(f1.getFlowName());
        assertEquals(-1, up1.findInFlow(f1.getFlowName()), "NotFoundInFlow() should return -1");
    }

    @Test
    void testeCoberturaInstrucoes(){
        up1.addFlowInput(f1);
        up1.removeFlowInput("f1");

        up1.addFlowOutput(f2);
        up1.removeFlowOutput("f2");

        assertEquals(0,up1.getCountOut());
        assertEquals(0,up1.getCountIn());

    }
    // Case 3: findInFlow() id cannot be null.
}