package circularityIndexCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.*;
import productsystem.Process;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateMaterialTest {
    private Flow flow1;
    private Flow flow2;
    private Process process;
    private String name;

    @BeforeEach
    void setUp() {
        flow1 = new Flow("teste", "Materials", 1, null, 1);
        flow2 = new Flow("Material Virgem (V)", "Materials", 1, null, 1);
        process = new UnitaryProcess("teste");
        name = "teste";
    }

    @Test
    void createMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CreateMaterials createMaterials = new CreateMaterials(process);
        Material result = createMaterials.createMaterial(name,process);
        assertTrue(result != null, "createMaterial should create a Material");
    }

    @Test
    void createMaterialNullTest() throws NoSuchMethodException {
        CreateMaterials createMaterials = new CreateMaterials(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createMaterials.createMaterial(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void createMaterialStringNullTest() throws NoSuchMethodException {
        CreateMaterials createMaterials = new CreateMaterials(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createMaterials.createMaterial(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getMaterialsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        CreateMaterials createMaterials = new CreateMaterials(process);
        List<Material> result = createMaterials.getMaterials();
        assertTrue(result != null, "createMaterial should create a List<Material>");
    }

    @Test
    void createAllMaterialNullTest() throws NoSuchMethodException {
        CreateMaterials createMaterials = new CreateMaterials(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createMaterials.createAllMaterial(null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }
    }

    @Test
    public void CreateAllMaterialUnitaryProcess() {
        UnitaryProcess unitaryProcess = new UnitaryProcess("test");
        unitaryProcess.addFlowInput(flow1);
        unitaryProcess.addFlowOutput(flow2);
        CreateMaterials createMaterials = new CreateMaterials(unitaryProcess);
        int count = 0;
        for (Material material : createMaterials.getMaterials()) {
            count++;
        }
        assertEquals(1, count);
    }

    @Test
    public void CreatAllMaterialAggregatedProcess() {
        AggregatedProcess aggregatedProcess = new AggregatedProcess("test");
        UnitaryProcess unitaryProcess1 = new UnitaryProcess("test");
        UnitaryProcess unitaryProcess2 = new UnitaryProcess("test");
        unitaryProcess1.addFlowInput(flow1);
        unitaryProcess1.addFlowOutput(flow2);
        unitaryProcess2.addFlowInput(flow1);
        unitaryProcess2.addFlowOutput(flow2);
        aggregatedProcess.addUnitaryProcess(unitaryProcess1);
        aggregatedProcess.addUnitaryProcess(unitaryProcess2);


        CreateMaterials createMaterials = new CreateMaterials(aggregatedProcess);
        int count = 0;

        for (Material material : createMaterials.getMaterials()) {
            count++;
        }


        assertEquals(2, count);
    }

}
