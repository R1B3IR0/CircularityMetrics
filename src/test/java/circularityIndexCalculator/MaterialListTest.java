package circularityIndexCalculator;

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
    void getMaterialNameTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getMaterialName",Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        double result = (double) method.invoke(materialList,process);
        assertTrue(result >=0,"GetMaterialName.size should be more then 0");
    }
    void getMaterialNameProcessNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getMaterialName",Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,null),
                "Esperava-se que getMaterialName lançasse NullPointerException");
        assertEquals("Process in getMaterialName cannot be null", exception.getMessage());

    }


    void getVirginMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = MaterialList.class.getDeclaredMethod("getVirginMaterial",String.class,Process.class);
            method.setAccessible(true);
            MaterialList materialList = new MaterialList();
            double result = (double) method.invoke(materialList,process,name);
            assertTrue(result >=0,"GetVirginMaterial should be 0 or more");
        }

        void getVirginMaterialProcessNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = MaterialList.class.getDeclaredMethod("getVirginMaterial",String.class,Process.class);
            method.setAccessible(true);
            MaterialList materialList = new MaterialList();
            NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,null,name),
                    "Esperava-se que getVirginMaterial lançasse NullPointerException");
            assertEquals("Process in getVirginMaterial cannot be null", exception.getMessage());

        }

        void getVirginMaterialStringNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = MaterialList.class.getDeclaredMethod("getVirginMaterial",String.class,Process.class);
            method.setAccessible(true);
            MaterialList materialList = new MaterialList();
            NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,process,null),
                    "Esperava-se que getVirginMaterial lançasse NullPointerException");
            assertEquals("Name in getVirginMaterial cannot be null", exception.getMessage());

        }
        void getRecoveredMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = MaterialList.class.getDeclaredMethod("getRecoveredMaterial",String.class,Process.class);
            method.setAccessible(true);
            MaterialList materialList = new MaterialList();
            double result = (double) method.invoke(materialList,process,name);
            assertTrue(result >=0,"GetRecoveredMaterial should be 0 or more");
        }

        void getRecoveredMaterialProcessNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = MaterialList.class.getDeclaredMethod("getRecoveredMaterial",String.class,Process.class);
            method.setAccessible(true);
            MaterialList materialList = new MaterialList();
            NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,null,name),
                    "Esperava-se que getRecoveredMaterial lançasse NullPointerException");
            assertEquals("Process in getRecoveredMaterial cannot be null", exception.getMessage());

        }

        void getRecoveredMaterialStringNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = MaterialList.class.getDeclaredMethod("getRecoveredMaterial",String.class,Process.class);
            method.setAccessible(true);
            MaterialList materialList = new MaterialList();
            NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,process,null),
                    "Esperava-se que getRecoveredMaterial lançasse NullPointerException");
            assertEquals("Name in getRecoveredMaterial cannot be null", exception.getMessage());

        }
    void getRecycledWasteTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledWaste",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        double result = (double) method.invoke(materialList,process,name);
        assertTrue(result >=0,"GetRecycledWaste should be 0 or more");
    }

    void getRecycledWasteProcessNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledWaste",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,null,name),
                "Esperava-se que getRecycledWaste lançasse NullPointerException");
        assertEquals("Process in getRecycledWaste cannot be null", exception.getMessage());

    }

    void getRecycledWasteStringNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledWaste",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,process,null),
                "Esperava-se que getRecycledWaste lançasse NullPointerException");
        assertEquals("Name in getRecycledWaste cannot be null", exception.getMessage());

    }
    void getRadioactiveWasteTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRadioactiveWaste",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        double result = (double) method.invoke(materialList,process,name);
        assertTrue(result >=0,"GetRadioactiveWaste should be 0 or more");
    }

    void getRadioactiveWasteProcessNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRadioactiveWaste",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,null,name),
                "Esperava-se que getRadioactiveWaste lançasse NullPointerException");
        assertEquals("Process in getRadioactiveWaste cannot be null", exception.getMessage());

    }

    void getRadioactiveWasteStringNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRadioactiveWaste",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,process,null),
                "Esperava-se que getRadioactiveWaste lançasse NullPointerException");
        assertEquals("Name in getRadioactiveWaste cannot be null", exception.getMessage());

    }
    void getRecycledMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledMaterial",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        double result = (double) method.invoke(materialList,process,name);
        assertTrue(result >=0,"GetRecycledMaterial should be 0 or more");
    }

    void getRecycledMaterialProcessNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledMaterial",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,null,name),
                "Esperava-se que getRecycledMaterial lançasse NullPointerException");
        assertEquals("Process in getRecycledMaterial cannot be null", exception.getMessage());

    }

    void getRecycledMaterialStringNullTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MaterialList.class.getDeclaredMethod("getRecycledMaterial",String.class,Process.class);
        method.setAccessible(true);
        MaterialList materialList = new MaterialList();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> method.invoke(materialList,process,null),
                "Esperava-se que getRecycledMaterial lançasse NullPointerException");
        assertEquals("Name in getRecycledMaterial cannot be null", exception.getMessage());

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

