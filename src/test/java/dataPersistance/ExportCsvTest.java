package dataPersistance;

import circularityIndexCalculator.Material;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExportCsvTest {
    private ExportCsv exportCsv;
    private Product product;
    private List<Material> lista;
    @BeforeEach
    void setUp() {
        exportCsv=new ExportCsv();
        lista = new ArrayList<>();
    }

    @Test
    void writeToCsvTest() {
        boolean resultado = exportCsv.writeToCsv("teste");
        assertEquals(resultado,true,"writeToCsv deve criar um ficheiro csv");
    }
    @Test
    void writeToCsvNullTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> exportCsv.writeToCsv(null),
                "Esperava-se que writeToCsv lançasse NullPointerException"
        );
        assertEquals("filename cannot be null", exception.getMessage());
    }
}