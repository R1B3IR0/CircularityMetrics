package dataPersistance;

import circularityIndexCalculator.Material;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.Product;
import productsystem.UnitaryProcess;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExportCsvTest {
    private ExportCsv exportCsv;
    private Product product;
    private String filePath;
    private ImportCsv importCsv;
    @BeforeEach
    void setUp() {
        importCsv=new ImportCsv("src/main/resources/CSV/csv.csv");
        filePath = "src/main/resources/CSV/result.csv";
        product=importCsv.sendProduct();
        exportCsv=new ExportCsv(filePath,product);
    }


    @Test
    void writeToCsvTest() {
        boolean resultado = exportCsv.writeToCsv();
        assertEquals(resultado,true,"writeToCsv deve criar um ficheiro csv");
    }
@Test
    void writeToCsvFalseTest() {
        boolean resultado = exportCsv.writeToCsv();
        assertFalse(!resultado, "writeToCsv deve criar um ficheiro csv");
    }



}