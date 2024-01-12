package productsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UnitaryProcess extends Process {
    private List<Flow> output;
    private List<Flow> input;
    public UnitaryProcess(String name) {
        super(name);
        this.input= new ArrayList<>();
        this.output= new ArrayList<>();
    }

    public Flow addFlowOutput(Flow output){
        if(output==null){
            throw new NullPointerException("Flow cannot be null");
        }
        this.output.add(output);
        return output;
    }
    public Flow removeFlowOutput(String flowName){
        if(flowName==null){
            throw new NullPointerException("Flow Name cannot be null");

        }
        int pos=findOutFlow(flowName);
        if(pos==-1){
            throw new NoSuchElementException(flowName);
        }
        Flow flow = this.output.get(pos);
        this.output.remove(pos);
        return flow;

    }
    public Flow addFlowInput(Flow input){
        if(input==null){
            throw new NullPointerException("Flow cannot be null");
        }
        this.input.add(input);
        return input;
    }
    public Flow removeFlowInput(String flowName){
        if(flowName==null){
            throw new NullPointerException("Flow Name cannot be null");
        }
        int pos=findInFlow(flowName);
        if(pos==-1){
            throw new NoSuchElementException(flowName);
        }
        Flow flow = this.input.get(pos);
        this.input.remove(pos);

        return flow;
    }
    public List<Flow> getOutput(){
        return output;
    }
    public List<Flow> getInput(){
        return input;
    }
    public int findOutFlow(String flowName){
        int position=0;
        if(flowName==null){
            throw new NullPointerException(flowName);
        }
        for(Flow f: this.output){
            if (f.getFlowName().equals(flowName)) {
                return position;

            }
            position++;
        }
        return -1;
    }
    public int findInFlow(String flowName){
        int position=0;
        if(flowName==null){
            throw new NullPointerException(flowName);
        }
        for(Flow f:this.input){
            if(f.getFlowName().equals(flowName)){
                return position;
            }
            position++;
        }
        return -1;
    }

}
