package circularityIndexCalculator;

public class Material {
    private String nameMaterial;
    private double virginMaterial;
    private double recoveredMaterial;
    private double wasteOnRecycling;
    private double wasteTotal;
    private double wasteRadioactive;
    private double recycledMaterial;
    private double energyNeededForMainMaterial;
    private double energyNeededForSecondaryMaterial;
    private double wasteProduction;
    private double lifespan;
    private double usefulness;
    private double averageUsefulness;
    private double averageLifespan;

    public Material(String nameMaterial) {
        this.nameMaterial = nameMaterial;
        this.virginMaterial = 0;
        this.recoveredMaterial = 0;
        this.wasteOnRecycling = 0;
        this.wasteTotal = 0;
        this.wasteRadioactive = 0;
        this.recycledMaterial = 0;
        this.energyNeededForMainMaterial = 0;
        this.energyNeededForSecondaryMaterial = 0;
        this.wasteProduction = 0;
        this.lifespan = 0;
        this.usefulness = 0;
        this.averageUsefulness = 0;
        this.averageLifespan = 0;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public double getVirginMaterial() {
        return virginMaterial;
    }

    public void setVirginMaterial(double virginMaterial) {
        this.virginMaterial = virginMaterial;
    }

    public double getRecoveredMaterial() {
        return recoveredMaterial;
    }

    public void setRecoveredMaterial(double recoveredMaterial) {
        this.recoveredMaterial = recoveredMaterial;
    }

    public double getWasteOnRecycling() {
        return wasteOnRecycling;
    }

    public void setWasteOnRecycling(double wasteOnRecycling) {
        this.wasteOnRecycling = wasteOnRecycling;
    }

    public double getWasteTotal() {
        return wasteTotal;
    }

    public void setWasteTotal() {
        this.wasteTotal = virginMaterial - recoveredMaterial;
    }

    public double getWasteRadioactive() {
        return wasteRadioactive;
    }

    public void setWasteRadioactive(double wasteRadioactive) {
        this.wasteRadioactive = wasteRadioactive;
    }

    public double getRecycledMaterial() {
        return recycledMaterial;
    }

    public void setRecycledMaterial(double recycledMaterial) {
        this.recycledMaterial = recycledMaterial;
    }

    public double getEnergyNeededForMainMaterial() {
        return energyNeededForMainMaterial;
    }

    public void setEnergyNeededForMainMaterial(double energyNeededForMainMaterial) {
        this.energyNeededForMainMaterial = energyNeededForMainMaterial;
    }

    public double getEnergyNeededForSecondaryMaterial() {
        return energyNeededForSecondaryMaterial;
    }

    public void setEnergyNeededForSecondaryMaterial(double energyNeededForSecondaryMaterial) {
        this.energyNeededForSecondaryMaterial = energyNeededForSecondaryMaterial;
    }

    public double getWasteProduction() {
        return wasteProduction;
    }

    public void setWasteProduction(double wasteProduction) {
        this.wasteProduction = wasteProduction;
    }

    public double getLifespan() {
        return lifespan;
    }

    public void setLifespan(double lifespan) {
        this.lifespan = lifespan;
    }

    public double getUsefulness() {
        return usefulness;
    }

    public void setUsefulness(double usefulness) {
        this.usefulness = usefulness;
    }

    public double getAverageUsefulness() {
        return averageUsefulness;
    }

    public void setAverageUsefulness(double averageUsefulness) {
        this.averageUsefulness = averageUsefulness;
    }

    public double getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(double averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public double getMass() {
        return virginMaterial + getInputRecycled();
    }

    public double getInputRecycled() {
        return recycledMaterial + recoveredMaterial;
    }

    public double getFx() {
        double a = 0, b = 0;
        a = usefulness / averageUsefulness;
        b = lifespan / averageLifespan;
        if (a * b <= 0)
            throw new ArithmeticException("The product of the usefulness and lifespan cannot be zero");
        return 0.9 / (a * b);
    }

    public double getLinearFlowIndex() {
        return (2 * virginMaterial - recoveredMaterial) / (2 * getMass() + ((wasteProduction - wasteOnRecycling) / 2));
    }

    public double circularityIndex() {
        return (1 - (getLinearFlowIndex() * getFx()));
    }
}
