package productsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AggregatedProcess extends Process{
    private List<UnitaryProcess> container;
    private int count;
    public AggregatedProcess(String name) {
        super(name);
        this.container=new ArrayList<>();
        this.count=0;
    }

    public int findUnitaryProcess(int id){
        int position=0;
        for(UnitaryProcess un:this.container){
            if(un.getId()==id){
                return position;
            }
            position++;
        }
        return -1;
    }

    public UnitaryProcess addUnitaryProcess(UnitaryProcess un){
        if(un == null){
            throw new NullPointerException("Unitary Process cannot be null");
        }
        this.container.add(un);
        count++;
        return un;
    }

    public UnitaryProcess removeUnitaryProcess(int id){
        int pos=findUnitaryProcess(id);
        if(pos==-1){
            throw new NoSuchElementException(id + " doesn't exist");
        }
        UnitaryProcess un = this.container.get(pos);
        this.container.remove(pos);
        count--;
        return un;
    }

    public List<UnitaryProcess> getContainer() {
        return container;
    }

    public int getCount() {
        return count;
    }
}

