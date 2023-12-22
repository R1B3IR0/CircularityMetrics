package productsystem;

public class UnitaryProcess extends Process {
    private Flow[] output;
    private Flow[] input;
    private int count;
    public UnitaryProcess(String name) {
        super(name);
    }

    public Flow addOutput(Flow output){
        return null;
    }
    public Flow removeOutput(Flow output){
        return null;
    }
    public Flow addInput(Flow input){
        return null;
    }
    public Flow removeInput(Flow input){
        return null;
    }
    public Flow[] getOutput(){
        return null;
    }
    public Flow[] getInput(){
        return null;
    }
    public int getCount(){
        return 0;
    }
    public void expandCapacity(){
    }
    public int findOutFlow(String name){
        return 0;
    }
    public int findInFlow(String name){
        return 0;
    }

}
