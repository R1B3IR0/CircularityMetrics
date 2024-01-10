package circularityIndexCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.Flow;
import productsystem.Process;
import productsystem.UnitType;
import productsystem.UnitaryProcess;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaterialListTest {
    private Process process;
    private UnitaryProcess un;
    private Flow flow;
    private Flow flow1;
    private Flow flow2;
    private Flow flow3;
    private Flow flow4;
    private String name;

    @BeforeEach
    void setUp() {
        process = new UnitaryProcess("teste");
        flow = new Flow("teste","Transport",9,UnitType.unit,10);
        flow1 = new Flow("teste1","Materials",0,UnitType.unit,10);
        flow2 = new Flow("teste2","Recurso",8,UnitType.unit,10);
        flow3= new Flow("teste","Material Virgem(V)",10,UnitType.unit,10);
        flow4= new Flow("Material Virgem(V)","Material Virgem(V)",10,UnitType.unit,10);
        name = "teste";
        un = new UnitaryProcess("unitary");

    }

    @Test
    void getMaterialNameTest() {
        un.addFlowInput(flow1);
        un.addFlowInput(flow2);
        MaterialList materialList = new MaterialList(un);
        List<String> result= materialList.getMaterialName(un);
        assertEquals("teste1",result.get(0));
        assertEquals("teste2",result.get(1));

    }

    @Test
    void getMaterialNameProcessNullTest(){
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
    void getVirginMaterialTest(){
        un.addFlowInput(flow3);
        un.addFlowOutput(flow4);
        MaterialList materialList = new MaterialList(un);
        double result = materialList.getVirginMaterial(name,un);
        assertEquals(result ,10, "Material List should be equalt to quanttaty");
    }

    @Test
    void getVirginMaterialProcessNullTest() {
        MaterialList materialList = new MaterialList(process);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> materialList.getVirginMaterial(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getVirginMaterialStringNullTest(){
        MaterialList materialList = new MaterialList(process);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> materialList.getVirginMaterial(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("String cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecoveredMaterialTest(){
        Flow flows;
        Flow flows1;
        flows= new Flow("teste","Materiais recuperados EoL (Rr)",10,UnitType.unit,10);
        flows1= new Flow("Materiais recuperados EoL (Rr)","Materiais recuperados EoL (Rr)",10,UnitType.unit,10);


        un.addFlowInput(flows);
        un.addFlowOutput(flows1);
        MaterialList materialList = new MaterialList(un);
        double result = materialList.getRecoveredMaterial(name,un);
        assertEquals(result ,10, "Material List should be equal to quantaty");
    }

    @Test
    void getRecoveredMaterialProcessNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecoveredMaterial(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecoveredMaterialStringNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecoveredMaterial(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledWasteTest(){
        Flow flows;
        Flow flows1;
        flows= new Flow("teste","Waste produzido na reciclagem (Wc)",10,UnitType.unit,10);
        flows1= new Flow("Waste produzido na reciclagem (Wc)","Waste produzido na reciclagem (Wc)",10,UnitType.unit,10);


        un.addFlowInput(flows);
        un.addFlowOutput(flows1);
        MaterialList materialList = new MaterialList(un);
        double result = materialList.getRecycledWaste(name,un);
        assertEquals(result ,10, "Material List should be equal to quantaty");
    }

    @Test
    void getRecycledWasteProcessNullTest(){;
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecycledWaste(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledWasteStringNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecycledWaste(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRadioactiveWasteTest(){
        Flow flows;
        Flow flows1;
        flows= new Flow("teste","Waste radioactivo (Wr)",10,UnitType.unit,10);
        flows1= new Flow("Waste radioactivo (Wr)","Waste radioactivo (Wr)",10,UnitType.unit,10);


        un.addFlowInput(flows);
        un.addFlowOutput(flows1);
        MaterialList materialList = new MaterialList(un);
        double result = materialList.getRadioactiveWaste(name,un);
        assertEquals(result ,10, "Material List should be equal to quantaty");
    }

    @Test
    void getRadioactiveWasteProcessNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRadioactiveWaste(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRadioactiveWasteStringNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRadioactiveWaste(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledMaterialTest(){
        Flow flows;
        Flow flows1;
        flows= new Flow("teste","Materiais reciclados (R) (+ Burden Free) (-cr)",10,UnitType.unit,10);
        flows1= new Flow("Materiais reciclados (R) (+ Burden Free) (-cr)","Materiais reciclados (R) (+ Burden Free) (-cr)",10,UnitType.unit,10);


        un.addFlowInput(flows);
        un.addFlowOutput(flows1);
        MaterialList materialList = new MaterialList(un);
        double result = materialList.getRecycledMaterial(name,un);
        assertEquals(result ,10, "Material List should be equal to quantat");
    }

    @Test
    void getRecycledMaterialProcessNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecycledMaterial(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getRecycledMaterialStringNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getRecycledMaterial(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }


    @Test
    void getMainEnergyTest(){
        Flow flows;
        Flow flows1;
        flows= new Flow("teste","Energia necessária para produção das matérias/produtos principais",10,UnitType.unit,10);
        flows1= new Flow("Energia necessária para produção das matérias/produtos principais","Energia necessária para produção das matérias/produtos principais",10,UnitType.unit,10);


        un.addFlowInput(flows);
        un.addFlowOutput(flows1);
        MaterialList materialList = new MaterialList(un);
        double result = materialList.getMainEnergy(name,un);
        assertEquals(result ,10, "Material List should be equal to quantat");
    }

    @Test
    void getMainEnergyProcessNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getMainEnergy(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getMainEnergyStringNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getMainEnergy(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getSecondaryEnergyTest(){
        Flow flows;
        Flow flows1;
        flows= new Flow("teste","Energia necessária para produção das matérias/produtos secundário",10,UnitType.unit,10);
        flows1= new Flow("Energia necessária para produção das matérias/produtos secundário","Energia necessária para produção das matérias/produtos secundário",10,UnitType.unit,10);


        un.addFlowInput(flows);
        un.addFlowOutput(flows1);
        MaterialList materialList = new MaterialList(un);
        double result = materialList.getSecondaryEnergy(name,un);
        assertEquals(result ,10, "Material List should be equal to quantaty");
    }

    @Test
    void getgetSecondaryEnergyNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getSecondaryEnergy(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getSecondaryEnergyStringNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getSecondaryEnergy(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getWasteProductionTest(){
        Flow flows;
        Flow flows1;
        flows= new Flow("teste","Waste na produção de materiais (Wf) - ws",10,UnitType.unit,10);
        flows1= new Flow("Waste na produção de materiais (Wf) - ws","Waste na produção de materiais (Wf) - ws",10,UnitType.unit,10);


        un.addFlowInput(flows);
        un.addFlowOutput(flows1);
        MaterialList materialList = new MaterialList(un);
        double result = materialList.getWasteProduction(name,un);
        assertEquals(result ,10, "Material List should be equal to quantaty");
    }

    @Test
    void getWasteProductionNullTest() {
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getWasteProduction(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    @Test
    void getWasteProductionStringNullTest(){
        MaterialList materialList = new MaterialList(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->materialList.getWasteProduction(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }


    }
    @Test
    void TesteCoberturaGetMaterialName(){
        un.addFlowInput(flow);
        MaterialList materialList = new MaterialList(un);
        materialList.getMaterialName(un);

        List<String> result = materialList.getMaterialName(un);
        assertTrue(result.isEmpty());
    }
}



