package productsystem;

import java.util.List;

public class AggregatedProcess extends Process  {
    private List<UnitaryProcess> container;
    private int count;

    public AggregatedProcess(String name) {
        super(name);
    }

    public UnitaryProcess addProcess(UnitaryProcess process){
        return null;
    }
    public UnitaryProcess removeProcess(int id){
        return null;
    }
    public int getCount(){
        return 0;
    }
    public List<UnitaryProcess> getContainer(){
        return null;
    }
    public int findUnitaryProcess(int id) {
        return 0;
    }

}
