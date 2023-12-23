package productsystem;

import java.util.List;

public class UnitaryProcess extends Process {
    private List<Flow> output;
    private List<Flow> input;
    private int count;
    public UnitaryProcess(String name) {
        super(name);
    }

    public Flow addOutput(Flow output){
        return null;
    }
    public Flow removeOutput(String name){
        return null;
    }
    public Flow addInput(Flow input){
        return null;
    }
    public Flow removeInput(String name){
        return null;
    }
    public List<Flow> getOutput(){
        return null;
    }
    public List<Flow> getInput(){
        return null;
    }
    public int getCount(){
        return 0;
    }
    public int findOutFlow(int id){
        return 0;
    }
    public int findInFlow(int id){
        return 0;
    }

}
