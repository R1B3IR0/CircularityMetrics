package dataPersistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import productsystem.AggregatedProcess;
import productsystem.Product;
import productsystem.UnitaryProcess;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImportCsvTest {

    private ImportCsv importCsv;
    private String filePath;
    @BeforeEach
    void setUp() {
        filePath = "src/main/resources/CSV/csv.csv";
        importCsv=new ImportCsv(filePath);
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
            assertEquals("product cannot be null", exception.getMessage());
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


}