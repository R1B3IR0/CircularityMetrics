package productsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UnitaryProcess extends Process {
    private List<Flow> output;
    private List<Flow> input;
    private int countIn;
    private int countOut;
    public UnitaryProcess(String name) {
        super(name);
        this.input= new ArrayList<>();
        this.output= new ArrayList<>();
        this.countIn=0;
        this.countOut=0;
    }

    public Flow addFlowOutput(Flow output){
        if(output==null){
            throw new NullPointerException("Flow cannot be null");
        }
        this.output.add(output);
        this.countOut++;
        return output;
    }
    public Flow removeFlowOutput(String flowName){
        if(flowName==null){
            throw new NullPointerException("Flow Name cannot be null");

        }
        int pos=findOutFlow(flowName);
        if(pos==-1){
            throw new NoSuchElementException(flowName+"doesn't exist");
        }
        Flow flow = this.output.get(pos);
        this.output.remove(pos);
        this.countOut--;
        return flow;

    }
    public Flow addFlowInput(Flow input){
        if(input==null){
            throw new NullPointerException("Flow cannot be null");
        }
        this.input.add(input);
        this.countIn++;
        return input;
    }
    public Flow removeFlowInput(String flowName){
        if(flowName==null){
            throw new NullPointerException("Flow Name cannot be null");

        }
        int pos=findInFlow(flowName);
        if(pos==-1){
            throw new NoSuchElementException(flowName+"doesn't exist");
        }
        Flow flow = this.input.get(pos);
        this.input.remove(pos);
        this.countIn--;
        return flow;
    }
    public List<Flow> getOutput(){
        return output;
    }
    public List<Flow> getInput(){
        return input;
    }
    public int getCountIn(){
        return countIn;
    }
    public int getCountOut(){
        return countOut;
    }
    public int findOutFlow(String flowName){
        int position=0;
        for(Flow f: this.input){
            if (f.getFlowName().equals(flowName)) {
                return position;

            }
            position++;
        }
        return 0;
    }
    public int findInFlow(String flowName){
        int position=0;
        for(Flow f:this.input){
            if(f.getFlowName().equals(flowName)){
                return position;
            }
            position++;
        }
        return -1;
    }

}
