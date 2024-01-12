package circularityIndexCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

public class MaterialTest {
    private Material m1;

    @BeforeEach
    void setUp() {
        m1 = new Material("m1");
    }

    @Test
    void getValidFxTest() {
        double lifespan = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);
        double usefulness = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);
        double averageLifespan = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);
        double AverageUsefulness = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);
        m1.setLifespan(lifespan);
        m1.setUsefulness(usefulness);
        m1.setAverageLifespan(averageLifespan);
        m1.setAverageUsefulness(AverageUsefulness);

        double fxValue = m1.getFx();

        // Case 1: getFx() should return a value greater than zero
        assertTrue(fxValue > 0, "getfX() should return a value greater than zero");
    }

    @Test
    void getDenominatorZeroFxTest() {
        m1.setLifespan(0); // Configura Lifespan como zero
        m1.setUsefulness(0); // Configura Usefulness como zero
        m1.setAverageLifespan(1);
        m1.setAverageUsefulness(1);

        // Assert
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> m1.getFx(), "getFx() should not return a value equal to zero");
        assertEquals("The product of the usefulness and lifespan cannot be zero", exception.getMessage());
    }

    @Test
    void getValidLinearFlowIndexTest() {
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
    void getNegativeLinearFlowIndexTest() {
        double virginMaterial = 1;
        double recoveredMaterial = 4;
        double wasteProduction = -1;
        double wasteOnRecycling = 4;

        m1.setVirginMaterial(virginMaterial);
        m1.setRecoveredMaterial(recoveredMaterial);
        m1.setWasteProduction(wasteProduction);
        m1.setWasteOnRecycling(wasteOnRecycling);

        double linearFlowIndexValue = m1.getLinearFlowIndex();

        // Verifica se o resultado não é menor que zero
        assertTrue(linearFlowIndexValue < 0, "getLinearFlowIndex() should not return a value less than zero");
    }

    @Test
    void getValidCircularityIndexTest() {
        double lifespan = 1;
        double usefulness = 1;
        double averageLifespan = 1;
        double AverageUsefulness = 1;

        double virginMaterial = 100;
        double recoveredMaterial = 50;
        double wasteProduction = 75;
        double wasteOnRecycling = 20;

        m1.setLifespan(lifespan);
        m1.setUsefulness(usefulness);
        m1.setAverageLifespan(averageLifespan);
        m1.setAverageUsefulness(AverageUsefulness);
        m1.setVirginMaterial(virginMaterial);
        m1.setRecoveredMaterial(recoveredMaterial);
        m1.setWasteProduction(wasteProduction);
        m1.setWasteOnRecycling(wasteOnRecycling);

        m1.getFx();
        m1.getLinearFlowIndex();

        double circularityIndexValue = m1.circularityIndex();

        assertTrue(circularityIndexValue > 0,
                "getCircularityIndexP() should return a value greater than zero");

    }

    @Test
    void getNegativeOrZeroCircularityIndexTest() {

        m1.setLifespan(1);
        m1.setUsefulness(1);
        m1.setAverageLifespan(10000);
        m1.setAverageUsefulness(10000);
        m1.setVirginMaterial(2);
        m1.setRecycledMaterial(2);
        m1.setRecoveredMaterial(1);
        m1.setWasteProduction(2);
        m1.setWasteOnRecycling(2);

        m1.getLinearFlowIndex();
        m1.getFx();

        assertTrue(m1.circularityIndex() <= 0,
                "getCircularityIndex() should not return a value less or equal than zero");
    }

    @Test
    void getValidUsefulnessTest() {
        double usefulness = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);
        double averageUsefulness = ThreadLocalRandom.current().nextDouble(0.1, Double.MAX_VALUE);

        m1.setUsefulness(usefulness);
        m1.setAverageUsefulness(averageUsefulness);

        double usefulnessValue = m1.getUsefulness();

        assertTrue(usefulnessValue > 0,
                "getUsefulness() should return a value greater than zero");
    }

    @Test
    void getNegativeOrEqualZeroUsefulnessTest() {
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

        m1.setLifespan(lifeSpan);
        m1.setAverageLifespan(averageLifeSpan);

        double lifeSpanValue = m1.getLifespan();

        assertTrue(lifeSpanValue > 0,
                "getLifeSpan() should return a value greater than zero");
    }

    @Test
    void getLessOrEqualZeroLifeSpan() {
        double lifeSpan = -10;
        double averageLifeSpan = -20;

        m1.setLifespan(lifeSpan);
        m1.setAverageLifespan(averageLifeSpan);

        double lifeSpanValue = m1.getLifespan();

        assertTrue(lifeSpanValue <= 0,
                "getLifeSpan() should not return a value less or equal than zero");
    }

    @Test
    void getValidInputRecycled() {
        double recycledMaterial = 5;
        double recoveredMaterial = 10;

        m1.setRecoveredMaterial(recoveredMaterial);
        m1.setRecycledMaterial(recycledMaterial);

        double inputRecycledValue = m1.getInputRecycled();

        assertTrue(inputRecycledValue < 0 | inputRecycledValue > 0,
                "getInputRecycled() should return a value greater than zero");
    }

    @Test
    void getValidMass() {
        double virginMaterial = 10;
        double getInputRecycled = 5;

        m1.setVirginMaterial(virginMaterial);
        m1.getInputRecycled();

        double massValue = m1.getMass();

        assertTrue(massValue > 0,
                "getMass() should return a value greater than zero");
    }

    @Test
    void getLessOrEqualZeroMass() {
        double virginMaterial = -10;
        double getInputRecycled = 0;

        m1.setVirginMaterial(virginMaterial);
        m1.getInputRecycled();

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
        m1.getWasteTotal();

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