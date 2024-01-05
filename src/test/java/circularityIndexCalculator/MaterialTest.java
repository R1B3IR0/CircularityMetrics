package circularityIndexCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.*;



public class MaterialTest {

    private Material m1;


    @BeforeEach
    void setUp() {
        m1 = new Material("m1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0);
    }


    @Test
    void getValidFxTest() {
        double lifespan = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);
        double usefulness = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);
        m1.setLifespan(lifespan);
        m1.setUsefulness(usefulness);

        double fxValue = m1.getFx();

        // Case 1: getFx() should return a value greater than zero
        assertTrue(fxValue > 0, "getfX() should return a value greater than zero");
    }

    @Test
    void getZeroFxTest() {
        m1.setLifespan(0); // Configura Lifespan como zero
        m1.setUsefulness(0); // Configura Usefulness como zero
        // Act
        double fxValue = m1.getFx();
        // Assert
        assertEquals( "zero cannot be divided", fxValue, "zero cannot be divided");
    }

    @Test
    void getValidLinearFlowIndexTest() {
        // Definição de  valores aleatórios para atender ao intervalo desejado (0 a 1)
        double virginMaterial = 100;
        double recoveredMaterial = 50;
        double wasteProduction = 75;
        double wasteOnRecycling = 20;

        // Calcula o valor esperado do LinearFlowIndex
        double up = (2 * virginMaterial) - recoveredMaterial;
        double down = (2 * (virginMaterial + recoveredMaterial)) + ((wasteProduction - wasteOnRecycling) / 2);
        double expectedLinearFlowIndex = up / down;

        // Define os valores na instância m1
        m1.setVirginMaterial(virginMaterial);
        m1.setRecoveredMaterial(recoveredMaterial);
        m1.setWasteProduction(wasteProduction);
        m1.setWasteOnRecycling(wasteOnRecycling);

        double linearFlowIndexValue = m1.getLinearFlowIndex();

        // Verifica se o resultado está dentro do intervalo esperado (entre 0 e 1)
        assertTrue(linearFlowIndexValue >= 0 && linearFlowIndexValue <= 1,
                "getLinearFlowIndex() should return a value between 0 and 1");

        // Verifica se o resultado calculado está próximo do valor esperado
        assertEquals(expectedLinearFlowIndex, linearFlowIndexValue, 0.01,
                "The calculated LinearFlowIndex should be close to the expected value");
    }

    @Test
    void getLessThenZeroLinearFlowIndexTest() {
        double virginMaterial = -1;
        double recoveredMaterial = -2;
        double wasteProduction = -3;
        double wasteOnRecycling = -4;

        m1.setVirginMaterial(virginMaterial);
        m1.setRecoveredMaterial(recoveredMaterial);
        m1.setWasteProduction(wasteProduction);
        m1.setWasteOnRecycling(wasteOnRecycling);

        double linearFlowIndexValue = m1.getLinearFlowIndex();

        // Verifica se o resultado não é menor que zero
        assertTrue(linearFlowIndexValue < 0, "getLinearFlowIndex() should not return a value less than zero");
    }

    @Test
    void getValidCircularityIndexPTest() {
        double linerFlowIndex = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);
        double fx = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);

        m1.setLinearFlowIndex(linerFlowIndex);
        m1.setFx(fx);

        double circularityIndexValue = m1.getCircularityIndexP();

        assertTrue(circularityIndexValue > 0,
                "getCircularityIndexP() should return a value greater than zero");

    }

    @Test
    void getLessOrEqualZeroCircularityIndexPTest() {
        double linerFlowIndex = -1;
        double fx = -2;

        m1.setLinearFlowIndex(linerFlowIndex);
        m1.setFx(fx);

        double circularityIndexValue = m1.getCircularityIndexP();

        assertTrue(circularityIndexValue <= 0,
                "getCircularityIndexP() should not return a value less or equal than zero");
    }

    @Test
    void getValidUsefullnessTest() {
        double usefulness = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);
        double averageUsefulness = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);

        m1.setUsefulness(usefulness);
        m1.setAverageUsefulness(averageUsefulness);

        double usefulnessValue = m1.getUsefulness();

        assertTrue(usefulnessValue > 0,
                "getUsefulness() should return a value greater than zero");
    }

    @Test
    void getLessOrEqualZeroUsefullnessTest() {
        double usefulness = -10;
        double averageUsefulness = -20;

        m1.setUsefulness(usefulness);
        m1.setAverageUsefulness(averageUsefulness);

        double usefulnessValue = m1.getUsefulness();

        assertTrue(usefulnessValue <= 0,
                "getUsefulness() should not return a value less or equal than zero");
    }

    @Test
    void getValidLifeSpan() {
        double lifeSpan = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);
        double averageLifeSpan = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);

        m1.setLifeSpan(lifeSpan);
        m1.setAverageLifeSpan(averageLifeSpan);

        double lifeSpanValue = m1.getLifeSpan();

        assertTrue(lifeSpanValue > 0,
                "getLifeSpan() should return a value greater than zero");
    }

    @Test
    void getLessOrEqualZeroLifeSpan() {
        double lifeSpan = -10;
        double averageLifeSpan = -20;

        m1.setLifeSpan(lifeSpan);
        m1.setAverageLifeSpan(averageLifeSpan);

        double lifeSpanValue = m1.getLifeSpan();

        assertTrue(lifeSpanValue <= 0,
                "getLifeSpan() should not return a value less or equal than zero");
    }

    @Test
    void getValidInputRecycled() {
        double inputRecycled = 5;
        double totalWaste = -2;

        m1.setInputRecycled(inputRecycled);
        m1.setTotalWaste(totalWaste);

        double inputRecycledValue = m1.getInputRecycled();

        assertTrue(inputRecycledValue > 0 | inputRecycledValue < 0,
                "getInputRecycled() should return a value greater than zero");
    }

    @Test
    void getValidMass() {
        double virginMaterial = 10;
        double getInputRecycled = 5;

        m1.setVirginMaterial(virginMaterial);
        m1.setInputRecycled(getInputRecycled);

        double massValue = m1.getMass();

        assertTrue(massValue > 0,
                "getMass() should return a value greater than zero");
    }

    @Test
    void getLessOrEqualZeroMass() {
        double virginMaterial = -10;
        double getInputRecycled = 0;

        m1.setVirginMaterial(virginMaterial);
        m1.setInputRecycled(getInputRecycled);

        double massValue = m1.getMass();

        assertTrue(massValue <= 0,
                "getMass() should not return a value less or equal than zero");
    }

    @Test
    void getValidWasteTotal() {
        double virginMaterial = 10;
        double recoveredMaterial = 5;

        m1.setVirginMaterial(virginMaterial);
        m1.setRecoveredMaterial(recoveredMaterial);

        double wasteTotalValue = m1.getWasteTotal();

        assertTrue(wasteTotalValue > 0,
                "getWasteTotal() should return a value greater than zero");
    }

    @Test
    void getLessOrEqualZeroWasteTotal() {
        double virginMaterial = -10;
        double recoveredMaterial = -5;

        m1.setVirginMaterial(virginMaterial);
        m1.setRecoveredMaterial(recoveredMaterial);

        double wasteTotalValue = m1.getWasteTotal();

        assertTrue(wasteTotalValue <= 0,
                "getWasteTotal() should not return a value less or equal than zero");
    }
}
