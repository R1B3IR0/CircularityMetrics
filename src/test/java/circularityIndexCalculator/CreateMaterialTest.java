package circularityIndexCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.Process;
import productsystem.UnitaryProcess;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateMaterialTest {
    private Process process;
    private String name;

    @BeforeEach
    void setUp() {
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
}
