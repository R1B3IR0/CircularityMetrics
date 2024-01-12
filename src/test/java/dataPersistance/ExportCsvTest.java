package dataPersistance;

import circularityIndexCalculator.Material;
import org.junit.jupiter.api.BeforeEach;
import productsystem.Product;
import productsystem.UnitaryProcess;

import java.util.ArrayList;
import java.util.List;

class ExportCsvTest {
    private ExportCsv exportCsv;
    private Product product;
    private List<Material> lista;
    private String filePath;
    private UnitaryProcess unitaryProcess;
    @BeforeEach
    void setUp() {
        unitaryProcess=new UnitaryProcess("teste");
        filePath = "src/main/resources/CSV/result.csv";
        product=new Product("teste",unitaryProcess);
        exportCsv=new ExportCsv(filePath,product);
        lista = new ArrayList<>();
    }

    /*
    @Test
    void writeToCsvTest() {
        //MaterialList materials = new MaterialList(unitaryProcess);

        boolean resultado = exportCsv.writeToCsv();
        assertEquals(resultado,true,"writeToCsv deve criar um ficheiro csv");
    }
    */

    /*
    @Test

    void writeToCsvNullTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> exportCsv.writeToCsv(),
                "Esperava-se que writeToCsv lançasse NullPointerException"
        );
        assertEquals("filename cannot be null", exception.getMessage());
    }
    */
}