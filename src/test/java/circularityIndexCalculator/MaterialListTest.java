package circularityIndexCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.Process;
import productsystem.UnitaryProcess;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        Method method = MaterialList.class.getDeclaredMethod("getMaterialName", Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        List<String> result = (List<String>) method.invoke(materialList, process);
        assertTrue(result.size() >= 0, "GetMaterialName.size should be more then 0");
    }

    @Test
    void getMaterialNameProcessNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getMaterialName", Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        UnitaryProcess un = null;

        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class,
                () -> method.invoke(materialList, un),
                "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getVirginMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getVirginMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        double result = (double) method.invoke(materialList, name, process);
        assertTrue(result >= 0, "GetVirginMaterial should be 0 or more");
    }

    @Test
    void getVirginMaterialProcessNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getVirginMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);

        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, name, null), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getVirginMaterialStringNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getVirginMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, null, process), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Name cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecoveredMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRecoveredMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        double result = (double) method.invoke(materialList, name, process);
        assertTrue(result >= 0, "GetRecoveredMaterial should be 0 or more");
    }

    @Test
    void getRecoveredMaterialProcessNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getRecoveredMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, name, null), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecoveredMaterialStringNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getRecoveredMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, null, process), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Name cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledWasteTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledWaste", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        double result = (double) method.invoke(materialList, name, process);
        assertTrue(result >= 0, "GetRecycledWaste should be 0 or more");
    }

    @Test
    void getRecycledWasteProcessNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledWaste", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, name, null), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledWasteStringNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledWaste", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, null, process), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Name cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRadioactiveWasteTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRadioactiveWaste", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        double result = (double) method.invoke(materialList, name, process);
        assertTrue(result >= 0, "GetRadioactiveWaste should be 0 or more");
    }

    @Test
    void getRadioactiveWasteProcessNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getRadioactiveWaste", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, name, null), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRadioactiveWasteStringNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getRadioactiveWaste", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, null, process), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Name cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        double result = (double) method.invoke(materialList, name, process);
        assertTrue(result >= 0, "GetRecycledMaterial should be 0 or more");
    }

    @Test
    void getRecycledMaterialProcessNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, name, null), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledMaterialStringNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, null, process), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Name cannot be null", cause.getMessage());
        }

    }

    @Test
    void getMainEnergyTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getMainEnergy", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        double result = (double) method.invoke(materialList, name, process);
        assertTrue(result >= 0, "GetMainEnergy should be 0 or more");
    }

    @Test
    void getMainEnergyProcessNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getMainEnergy", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, name, null), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getMainEnergyStringNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getMainEnergy", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, null, process), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Name cannot be null", cause.getMessage());
        }

    }

    @Test
    void getSecondaryEnergyTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getSecondaryEnergy", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        double result = (double) method.invoke(materialList, name, process);
        assertTrue(result >= 0, "getSecondaryEnergy should be 0 or more");
    }

    @Test
    void getgetSecondaryEnergyNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getSecondaryEnergy", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, name, null), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getSecondaryEnergyStringNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getSecondaryEnergy", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, null, process), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Name cannot be null", cause.getMessage());
        }

    }

    @Test
    void getWasteProductionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getWasteProduction", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        double result = (double) method.invoke(materialList, name, process);
        assertTrue(result >= 0, "getWasteProduction should be 0 or more");
    }

    @Test
    void getWasteProductionNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getWasteProduction", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, name, null), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getWasteProductionStringNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("getWasteProduction", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, null, process), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Name cannot be null", cause.getMessage());
        }

    }

    @Test
    void createMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("createMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        Material result = (Material) method.invoke(materialList, name, process);
        assertTrue(result != null, "createMaterial should create a Material");
    }

    @Test
    void createMaterialNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("createMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, name, null), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void createMaterialStringNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("createMaterial", String.class, Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, null, process), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Name cannot be null", cause.getMessage());
        }
    }

    @Test
    void getMaterialsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getMaterials");
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        List<Material> result = (List<Material>) method.invoke(materialList);
        assertTrue(result != null, "createMaterial should create a List<Material>");
    }

    @Test
    void createAllMaterialNullTest() throws NoSuchMethodException {
        Method method = MaterialList.class.getDeclaredMethod("createAllMaterial", Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList(process);
        UnitaryProcess un = null;
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> method.invoke(materialList, un), "Expected InvocationTargetException");

        Throwable cause = invocationTargetException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }


}



