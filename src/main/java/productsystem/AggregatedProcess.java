package productsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
//subclasse de Process
public class AggregatedProcess extends Process{
    private List<UnitaryProcess> container;//lista para armazenar Processos Unitários
    private int count;//contador de processos
    public AggregatedProcess(String name) {
        super(name);
        this.container=new ArrayList<>();
        this.count=0;
    }
//método para encontrar a posição de um processo pelo seu id
    public int findUnitaryProcess(int id){
        int position = 0;
        for (UnitaryProcess un : this.container) {
            if (un.getId() == id) {
                return position; // devolve a posição correta se encontrado
            }
            position++;
        }
        return -1; // caso nao encontre retorna -1
    }
//método para adicionar um Unitary Process
    public UnitaryProcess addUnitaryProcess(UnitaryProcess un){
        if(un == null){
            throw new NullPointerException("Unitary Process cannot be null");
        }
        this.container.add(un);
        count++;
        return un;
    }
//método para remover um processo
    public UnitaryProcess removeUnitaryProcess(int id){
        int pos=findUnitaryProcess(id);//encontra a posicao
        if(pos==-1){
            throw new NoSuchElementException(id + " doesn't exist");
        }
        UnitaryProcess un = this.container.get(pos);
        this.container.remove(pos);
        count--;
        return un;//devolve o processo removido
    }

    public List<UnitaryProcess> getContainer() {
        return container;
    }

    public int getCount() {
        return count;
    }
}

