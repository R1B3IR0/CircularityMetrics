package circularityIndexCalculator;

public class Material {
    private String nameMaterial;
    private double virginMaterial;
    private double recoveredMaterial;
    private double wasteOnMaterial;
    private double wasteTotal;
    private double wasteRadioactive;
    private double recycledMaterial;
    private double energyMain;
    private double energySecondary;
    private double wasteProduction;
    private double lifespan;
    private double usefulness;
    private double averageUsefulness;
    private double averageLifespan;

    public Material(String nameMaterial, double virginMaterial, double recoveredMaterial, double wasteOnMaterial, double wasteTotal, double wasteRadioactive, double recycledMaterial, double energyMain, double energySecondary, double wasteProduction, double lifespan, double usefulness, double averageUsefulness, double averageLifespan) {
        this.nameMaterial = nameMaterial;
        this.virginMaterial = virginMaterial;
        this.recoveredMaterial = recoveredMaterial;
        this.wasteOnMaterial = wasteOnMaterial;
        this.wasteTotal = wasteTotal;
        this.wasteRadioactive = wasteRadioactive;
        this.recycledMaterial = recycledMaterial;
        this.energyMain = energyMain;
        this.energySecondary = energySecondary;
        this.wasteProduction = wasteProduction;
        this.lifespan = lifespan;
        this.usefulness = usefulness;
        this.averageUsefulness = averageUsefulness;
        this.averageLifespan = averageLifespan;
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

    public double getWasteOnMaterial() {
        return wasteOnMaterial;
    }

    public void setWasteOnMaterial(double wasteOnMaterial) {
        this.wasteOnMaterial = wasteOnMaterial;
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

    public double getEnergyMain() {
        return energyMain;
    }

    public void setEnergyMain(double energyMain) {
        this.energyMain = energyMain;
    }

    public double getEnergySecondary() {
        return energySecondary;
    }

    public void setEnergySecondary(double energySecondary) {
        this.energySecondary = energySecondary;
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
        return 0.9/((usefulness/averageUsefulness)*(lifespan/averageLifespan));
    }

    public double getLinearFlowIndex() {
        return (2*virginMaterial-recoveredMaterial)/(2*getMass()+((wasteProduction-wasteOnMaterial)/2));
    }

    public double CircularityIndexP() {
        return 1-(getLinearFlowIndex()*getFx());
    }
s
}
