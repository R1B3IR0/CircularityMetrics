package productsystem;

public abstract class Process {
    private static int nextId = 0;
    private int id;
    private String name;

    public Process(String name) {
        this.name= name;
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return  nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

}
