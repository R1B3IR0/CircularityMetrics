package productsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

// Classe de teste para AggregatedProcess
class AggregatedProcessTest {

    private AggregatedProcess ag1;
    private UnitaryProcess up1;
    private UnitaryProcess up2;

    // Método executado antes de cada teste
    @BeforeEach
    void setUp() {
        ag1 = new AggregatedProcess("ag1");
        up1 = new UnitaryProcess("up1");
        up2 = new UnitaryProcess("up2");
    }

    // Teste para o método addUnitaryProcess
    @Test
    void addProcessTest() {
        // Caso 1: addUnitaryProcess() deve adicionar um UnitaryProcess ao container
        ag1.addUnitaryProcess(up1);
        assertEquals(1, ag1.getCount(), "addUnitaryProcess() deve adicionar um UnitaryProcess ao container");
    }

    // Teste para adicionar um UnitaryProcess nulo
    @Test
    public void addNullProcessTest() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> ag1.addUnitaryProcess(null),
                "Esperava-se que addUnitaryProcess lançasse NullPointerException"
        );
        assertEquals("Unitary Process cannot be null", exception.getMessage());
    }

    // Teste para o método removeUnitaryProcess
    @Test
    void removeProcessTest() {
        // Caso 1: Contagem deve ser 0
        ag1.addUnitaryProcess(up1);
        ag1.removeUnitaryProcess(up1.getId());
        assertEquals(0, ag1.getCount(), "removeUnitaryProcess() deve remover um UnitaryProcess do container");
    }

    // Teste para remover um UnitaryProcess que não existe
    @Test
    void removeNotExistingProcessTest() {
        // Caso 2: removeUnitaryProcess() deve retornar -1 (porque o ID não existe no container)
        int expected = -1;
        int result = ag1.findUnitaryProcess(expected);
        assertEquals(expected, result, "removeUnitaryProcess() deve retornar -1 (porque o ID não existe no container)");
    }

    // Caso 3: removeUnitaryProcess() o ID não pode ser nulo.

    // Teste para o método findUnitaryProcess
    @Test
    void findUnitaryProcessTest() {
        // Caso 1: findUnitaryProcess() deve retornar 0
        ag1.addUnitaryProcess(up1);
        assertEquals(0, ag1.findUnitaryProcess(up1.getId()), "findUnitaryProcess() deve retornar 0");
    }

    // Teste para encontrar um UnitaryProcess que não existe
    @Test
    void NotFoundUnitaryProcessTest() {
        // Caso 2: NotFoundUnitaryProcess() deve retornar -1
        ag1.findUnitaryProcess(up1.getId());
        assertEquals(-1, ag1.findUnitaryProcess(up1.getId()), "NotFoundUnitaryProcess() deve retornar -1");
    }





    // Teste para o método addUnitaryProcess
    @Test
    public void testAddUnitaryProcess() {
        assertEquals(0, ag1.getCount());
        ag1.addUnitaryProcess(up1);
        assertEquals(1, ag1.getCount());
        assertEquals(up1, ag1.getContainer().get(0));
    }

    // Teste para o método removeUnitaryProcess
    @Test
    public void testRemoveUnitaryProcess() {
        ag1.addUnitaryProcess(up1);
        ag1.addUnitaryProcess(up2);

        assertEquals(2, ag1.getCount());

        UnitaryProcess removedProcess = ag1.removeUnitaryProcess(up1.getId());

        assertEquals(1, ag1.getCount());
        assertEquals(up1, removedProcess);
    }

    // Teste para remover um UnitaryProcess que não existe
    @Test
    public void testRemoveNonexistentUnitaryProcess() {
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> ag1.removeUnitaryProcess(123),
                "Esperava-se que removeUnitaryProcess lançasse NoSuchElementException");
        assertEquals("123 doesn't exist", exception.getMessage());
    }

    // Teste para o método getContainer
    @Test
    public void testGetContainer() {
        assertEquals(0, ag1.getContainer().size());

        ag1.addUnitaryProcess(up1);

        assertEquals(1, ag1.getContainer().size());
        assertTrue(ag1.getContainer().contains(up1));
    }

    // Teste para o método findUnitaryProcess
    @Test
    public void testFindUnitaryProcess() {
        ag1.addUnitaryProcess(up1);
        ag1.addUnitaryProcess(up2);

        assertEquals(0, ag1.findUnitaryProcess(up1.getId()));
        assertEquals(1, ag1.findUnitaryProcess(up2.getId()));
    }

    // Teste para encontrar um UnitaryProcess que não existe
    @Test
    public void testFindNonexistentUnitaryProcess() {
        assertEquals(-1, ag1.findUnitaryProcess(123)); // Assumindo que 123 não é um ID válido
    }
}
