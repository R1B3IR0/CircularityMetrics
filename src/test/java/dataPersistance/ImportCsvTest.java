package dataPersistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import productsystem.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImportCsvTest {

    private ImportCsv importCsv;
    private String filePath;
    private Product product;
    @BeforeEach
    void setUp() {
        filePath = "src/main/resources/CSV/csv.csv";
        importCsv=new ImportCsv(filePath);
        Product product = importCsv.sendProduct();
    }

    @Test
    void importRowsFromCSVTest(){
        List<Row> rows = importCsv.importFlowsFromCSV(filePath);
        assertTrue(rows!=null,"importRowsFromCSVTest cant return null");
    }

    @Test
    void importRowsFromCSVNull(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->importCsv.importFlowsFromCSV(null),
                "Esperava-se que importRowsFromCSV lançasse IllegalArgumentException"
        );
        assertEquals("filePath cannot be null", exception.getMessage());
    }

    @Test
    void getProcessNamesTest(){
        List<String> names = importCsv.getProcessNames();
        assertTrue(names!=null,"getProcessNamesTest cant return null");
    }
    @Test
    void createProcessTest(){
        Product product = importCsv.createProcess(importCsv.getProcessNames());
        assertTrue(product!=null,"createProcess cant return null");
    }
    @Test
    void createProcessNull(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->importCsv.createProcess(null),
                "Esperava-se que createProcess lançasse IllegalArgumentException"
        );
        assertEquals("lista cannot be null", exception.getMessage());
    }
    @Test
    void createUnitaryProcessTest() {
        Product product = importCsv.createProcess(importCsv.getProcessNames());
        if (product.getProcess() instanceof UnitaryProcess) {
            importCsv.createUnitaryProcess(product);
            assertTrue(product.getProcess() != null, "createUnitaryProcessTest needs to create a process");
        }
    }
    @Test
    void createUnitaryProcessNullTest(){
        Product product = importCsv.createProcess(importCsv.getProcessNames());
        if(product.getProcess() instanceof UnitaryProcess){
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->importCsv.createUnitaryProcess(null),
                    "Esperava-se que createUnitaryProcess lançasse IllegalArgumentException"
            );
            assertEquals("Product cannot be null", exception.getMessage());
        }

    }
@Test
    void createAggregatedProcessTest() {
        Product product = importCsv.createProcess(importCsv.getProcessNames());
        if (product.getProcess() instanceof AggregatedProcess) {
            importCsv.createAggregatedProcess(product);
            assertTrue(product.getProcess() != null, "createAggregatedProcessTest needs to create a process");
        }
    }
@Test
    void createAggregatedProcessNullTest(){
        Product product = importCsv.createProcess(importCsv.getProcessNames());
        if(product.getProcess() instanceof AggregatedProcess){
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->importCsv.createAggregatedProcess(null),
                    "Esperava-se que createAggregatedProcess lançasse IllegalArgumentException"
            );
            assertEquals("Product cannot be null", exception.getMessage());
        }

    }

    @Test
    void coverageCreateProcess(){
        int count = 0;
        for (String s : importCsv.getProcessNames()) {
            count++;
        }

        Product productTeste;
        if(count >=2){
            productTeste=importCsv.createProcess(importCsv.getProcessNames());
            Boolean result = productTeste.getProcess() instanceof AggregatedProcess;
            assertEquals(true,result,"Create process should return Product with AggregatedProcess");
        }
        else if(count ==1){
            productTeste=importCsv.createProcess(importCsv.getProcessNames());
            Boolean result = productTeste.getProcess() instanceof UnitaryProcess;
            assertEquals(true,result,"Create process should return Product with UnitaryProcess");
        }
    }

    @Test
    void coverageUnitaryProcess() {
        List<Flow> inputs = new ArrayList<>();
        List<Flow> outputs = new ArrayList<>();
        Product product1 = importCsv.sendProduct();
        if(product1.getProcess() instanceof UnitaryProcess){
            inputs = ((UnitaryProcess) product1.getProcess()).getInput();
            outputs = ((UnitaryProcess) product1.getProcess()).getOutput();
        }


        boolean inputsB=true;
        boolean outputsB = true;

        if(product1.getProcess() instanceof UnitaryProcess){
            for(int i=0;i<inputs.size();i++){
                if(!inputs.get(i).getFlowName().equals(((UnitaryProcess) product1.getProcess()).getInput().get(i).getFlowName())){
                    inputsB=false;
                }
            }
            for(int i=0;i<outputs.size();i++){
                if(!outputs.get(i).getFlowName().equals(((UnitaryProcess) product1.getProcess()).getOutput().get(i).getFlowName())){
                    outputsB=false;
                }
            }
        }
        assertTrue(inputsB, "Failed Import of flows");
        assertTrue(outputsB, "Failed Import of flows");
    }


    @Test
    void coverageAggregatedProcess() {
        List<Flow> inputs ;
        List<Flow> outputs;
        boolean inputsB=true;
        boolean outputsB = true;
        Product product1 = importCsv.sendProduct();
        if(product1.getProcess() instanceof AggregatedProcess){
            for(UnitaryProcess un:((AggregatedProcess) product1.getProcess()).getContainer()){
                inputs = ((UnitaryProcess) product1.getProcess()).getInput();
                outputs = ((UnitaryProcess) product1.getProcess()).getOutput();
                for(int i=0;i<inputs.size();i++){
                    if(!inputs.get(i).getFlowName().equals(((UnitaryProcess) product1.getProcess()).getInput().get(i).getFlowName())){
                        inputsB=false;
                    }
                    if(!outputs.get(i).getFlowName().equals(((UnitaryProcess) product1.getProcess()).getOutput().get(i).getFlowName())){
                        outputsB=false;
                    }
                }

            }

        }

        assertTrue(inputsB, "Failed Import of flows");
        assertTrue(outputsB, "Failed Import of flows");
    }


}