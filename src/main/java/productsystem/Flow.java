package productsystem;

public class Flow {
    private String flowName;
    private FlowCategory category;
    private double quantity;
    private UnitType unit;
    private double cost;

    public Flow(String flowName, FlowCategory category, double quantity, UnitType unit, double cost) {
        this.flowName = flowName;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
        this.cost = cost;
    }

    public Flow() {

    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName= flowName;
    }

    public FlowCategory getCategory() {
        return category;
    }

    public void setCategory(FlowCategory category) {
        this.category= category;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity= quantity;
    }

    public UnitType getUnit() {
        return unit;
    }

    public void setUnit(UnitType unit) {
        this.unit=unit;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost= cost;
    }
}
