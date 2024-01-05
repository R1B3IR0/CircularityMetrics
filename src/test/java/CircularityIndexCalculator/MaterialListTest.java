package CircularityIndexCalculator;

import org.junit.jupiter.api.BeforeEach;
import productsystem.Process;
import productsystem.UnitaryProcess;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MaterialListTest {
    private MaterialList list;
    private Process process;
    private String name;
    @BeforeEach
    void setUp() {
        list=new MaterialList();
        process=new UnitaryProcess("teste");
        name="teste";
    }

    void getMainEnergyTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getMainEnergy",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        double result = (double) method.invoke(materialList,process,name);
        assertTrue(result >=0,"GetMainEnergy should be 0 or more");
    }

    void getMainEnergyProcessNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getMainEnergy",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,null,name),
                "Esperava-se que getMainEnergy lançasse NullPointerException");
        assertEquals("Process in getMainEnergy cannot be null", exception.getMessage());

    }

    void getMainEnergyStringNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getMainEnergy",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,process,null),
                "Esperava-se que getMainEnergy lançasse NullPointerException");
        assertEquals("Name in getMainEnergy cannot be null", exception.getMessage());

    }

    void getSecondaryEnergyTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getSecondaryEnergy",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        double result = (double) method.invoke(materialList,process,name);
        assertTrue(result >=0,"getSecondaryEnergy should be 0 or more");
    }

    void getgetSecondaryEnergyNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getSecondaryEnergy",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,null,name),
                "Esperava-se que getSecondaryEnergy lançasse NullPointerException");
        assertEquals("Process in getSecondaryEnergy cannot be null", exception.getMessage());

    }

    void getSecondaryEnergyStringNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getSecondaryEnergy",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,process,null),
                "Esperava-se que getSecondaryEnergy lançasse NullPointerException");
        assertEquals("Name in getSecondaryEnergy cannot be null", exception.getMessage());

    }




    void getWasteProductionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getWasteProduction",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        double result = (double) method.invoke(materialList,process,name);
        assertTrue(result >=0,"getWasteProduction should be 0 or more");
    }

    void getWasteProductionNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getWasteProduction",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,null,name),
                "Esperava-se que getWasteProduction lançasse NullPointerException");
        assertEquals("Process in getWasteProduction cannot be null", exception.getMessage());

    }

    void getWasteProductionStringNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getWasteProduction",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,process,null),
                "Esperava-se que getWasteProduction lançasse NullPointerException");
        assertEquals("Name in getWasteProduction cannot be null", exception.getMessage());

    }


    void createMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getWasteProduction",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        Material result = (Material) method.invoke(materialList,process,name);
        assertTrue(result != null,"createMaterial should create a Material");
    }

    void createMaterialNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("createMaterial",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,null,name),
                "Esperava-se que createMaterial lançasse NullPointerException");
        assertEquals("Process in createMaterial cannot be null", exception.getMessage());

    }

    void createMaterialStringNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("createMaterial",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,process,null),
                "Esperava-se que createMaterial lançasse NullPointerException");
        assertEquals("Name in createMaterial cannot be null", exception.getMessage());
    }


    void createAllMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("createAllMaterial",Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        List<Material> result = (List<Material>) method.invoke(materialList,process);
        assertTrue(result != null,"createMaterial should create a List<Material>");
    }

    void createAllMaterialNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("createMaterial",Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,null),
                "Esperava-se que createAllMaterial lançasse NullPointerException");
        assertEquals("Process in createAllMaterial cannot be null", exception.getMessage());

    }



}

