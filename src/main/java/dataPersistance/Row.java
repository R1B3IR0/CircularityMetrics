package dataPersistance;
import com.opencsv.bean.CsvBindByName;
public class Row {

    @CsvBindByName(column = "Produto")
    private String product;

    @CsvBindByName(column = "Processo")
    private String process;

    @CsvBindByName(column = "type")
    private String type;

    @CsvBindByName(column = "Flow")
    private String flow;

    @CsvBindByName(column = "Categoria")
    private String category;
    @CsvBindByName(column = "Qtd")
    private double quantity;

    @CsvBindByName(column = "Unidade")
    private String unity;

    @CsvBindByName(column = "Custo/Receita")
    private double cost;


    public Row() {
    }

    public String getProduct() {
        return product;
    }

    public String getProcess() {
        return process;
    }

    public String getType() {
        return type;
    }

    public String getFlow() {
        return flow;
    }

    public String getCategory() {
        return category;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnity() {
        return unity;
    }

    public double getCost() {
        return cost;
    }
}
