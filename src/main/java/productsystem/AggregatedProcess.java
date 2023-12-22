package productsystem;

public class AggregatedProcess extends Process  {
    private UnitaryProcess[] container;
    private int count;

    public AggregatedProcess(String name) {
        super(name);
    }

    public UnitaryProcess addProcess(UnitaryProcess process){
        return null;
    }
    public UnitaryProcess removeProcess(UnitaryProcess process){
        return null;
    }
    public int getCount(){
        return 0;
    }
    public UnitaryProcess[] getContainer(){
        return null;
    }
    public void expandCapacity(){
    }
    public void findUnitaryProcess(String name){
    }

}
