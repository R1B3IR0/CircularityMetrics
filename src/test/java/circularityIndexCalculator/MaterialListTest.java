package circularityIndexCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.Process;
import productsystem.UnitaryProcess;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaterialListTest {
    private Process process;
    private String name;

    @BeforeEach
    void setUp() {
        process = new UnitaryProcess("teste");
        name = "teste";
    }

    @Test
    void getMaterialNameTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MaterialList materialList = new MaterialList(process);
        List<String> result = materialList.getMaterialName(process);
        assertTrue(result.size() >= 0, "GetMaterialName.size should be more then 0");
    }

    @Test
    void getMaterialNameProcessNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        UnitaryProcess un = null;

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() ->
                        materialList.getMaterialName(un), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getVirginMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MaterialList materialList = new MaterialList(process);
        double result = materialList.getVirginMaterial(name,process);
        assertTrue(result >= 0, "GetVirginMaterial should be 0 or more");
    }

    @Test
    void getVirginMaterialProcessNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> materialList.getVirginMaterial(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getVirginMaterialStringNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> materialList.getVirginMaterial(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("String cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecoveredMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MaterialList materialList = new MaterialList(process);
        double result = materialList.getRecoveredMaterial(name,process);
        assertTrue(result >= 0, "GetRecoveredMaterial should be 0 or more");
    }

    @Test
    void getRecoveredMaterialProcessNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecoveredMaterial(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecoveredMaterialStringNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecoveredMaterial(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledWasteTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MaterialList materialList = new MaterialList(process);
        double result = materialList.getRecycledMaterial(name,process);
        assertTrue(result >= 0, "GetRecycledWaste should be 0 or more");
    }

    @Test
    void getRecycledWasteProcessNullTest() throws NoSuchMethodException {;
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecycledMaterial(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledWasteStringNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecycledMaterial(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRadioactiveWasteTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MaterialList materialList = new MaterialList(process);
        double result = materialList.getRadioactiveWaste(name,process);
        assertTrue(result >= 0, "GetRadioactiveWaste should be 0 or more");
    }

    @Test
    void getRadioactiveWasteProcessNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRadioactiveWaste(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRadioactiveWasteStringNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecoveredMaterial(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MaterialList materialList = new MaterialList(process);
        double result = materialList.getRecycledMaterial(name,process);
        assertTrue(result >= 0, "GetRecycledMaterial should be 0 or more");
    }

    @Test
    void getRecycledMaterialProcessNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecycledMaterial(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledMaterialStringNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecycledMaterial(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }


    @Test
    void getMainEnergyTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MaterialList materialList = new MaterialList(process);
        double result = materialList.getMainEnergy(name,process);
        assertTrue(result >= 0, "GetMainEnergy should be 0 or more");
    }

    @Test
    void getMainEnergyProcessNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getMainEnergy(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getMainEnergyStringNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getMainEnergy(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getSecondaryEnergyTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MaterialList materialList = new MaterialList(process);
        double result = materialList.getSecondaryEnergy(name,process);
        assertTrue(result >= 0, "getSecondaryEnergy should be 0 or more");
    }

    @Test
    void getgetSecondaryEnergyNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getSecondaryEnergy(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getSecondaryEnergyStringNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getSecondaryEnergy(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getWasteProductionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MaterialList materialList = new MaterialList(process);
        double result = materialList.getWasteProduction(name,process);
        assertTrue(result >= 0, "getWasteProduction should be 0 or more");
    }

    @Test
    void getWasteProductionNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getWasteProduction(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getWasteProductionStringNullTest() throws NoSuchMethodException {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getWasteProduction(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    }



