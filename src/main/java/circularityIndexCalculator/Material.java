package circularityIndexCalculator;

public class Material {
    private String nameMaterial;
    private double virginMaterial;
    private double recoveredMaterial;
    private double wasteOnRecycling;
    private double wasteRadioctive;
    private double recycledMaterial;
    private double energyNeededForMainMaterial;
    private double energyNeededForSecondaryMaterial;
    private double wasteProduction;
    private double Lifespan;
    private double Usefulness;

    private double averageUsefulness;
    private double averageLifespan;

    public Material(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public double getWasteTotal(){
        return this.virginMaterial-this.recoveredMaterial;
    }
    public double getMass(){
        return this.virginMaterial+getInputRecycled();
    }
    public double getInputRecycled(){
        return this.recycledMaterial + this.recoveredMaterial;
    }
    public double getLifespan(){
        return this.Lifespan/this.averageLifespan;
    }
    public double getUsefulness(){
        return this.Usefulness/this.averageUsefulness;
    }

    public double getfX(){
        return 0.9/((getLifespan() * getUsefulness()));
    }
    public double getLinearFlowIndex(){
        double up = (2*this.virginMaterial) - this.recoveredMaterial;
        double down = (2 * getMass())+ ((this.wasteProduction - this.wasteOnRecycling)/2);
        return up/down;
    }

    public double getCircularityIndex(){
        return 1-(getLinearFlowIndex()*getfX());
    }










    //getters and setters
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

    public double getWasteRadioctive() {
        return wasteRadioctive;
    }

    public void setWasteRadioctive(double wasteRadioctive) {
        this.wasteRadioctive = wasteRadioctive;
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

    public void setLifespan(double lifespan) {
        Lifespan = lifespan;
    }

    public void setUsefulness(double usefulness) {
        Usefulness = usefulness;
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
}
