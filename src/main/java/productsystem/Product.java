package productsystem;

public class Product {
    private String name;
    Process process;

    private double mci;

    public Product(String name, Process process) {
        this.name = name;
        this.process = process;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public double getMci() {
        return mci;
    }

    public void setMci(double mci) {
        this.mci = mci;
    }
}
