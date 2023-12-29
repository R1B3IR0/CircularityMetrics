package productsystem;

public class Product {
    private String name;
    private int lifespan;
    private int productUsefulness;
    Process process;

    public Product(String name, int lifespan, int productUsefulness, Process process) {
        this.name = name;
        this.lifespan = lifespan;
        this.productUsefulness = productUsefulness;
        this.process = process;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public int getProductUsefulness() {
        return productUsefulness;
    }

    public void setProductUsefulness(int productUsefulness) {
        this.productUsefulness = productUsefulness;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
}
