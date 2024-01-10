package dataPersistance;
import com.opencsv.bean.CsvBindByName;
public class Row {

    @CsvBindByName(column = "Produto")
    private String product;

    @CsvBindByName(column = "Processo")
    private String processo;

    @CsvBindByName(column = "type")
    private String type;

    @CsvBindByName(column = "Flow")
    private String flow;

    @CsvBindByName(column = "Categoria")
    private String categoria;
    @CsvBindByName(column = "Qtd")
    private double quantity;

    @CsvBindByName(column = "Unidade")
    private String unity;

    @CsvBindByName(column = "Custo/Receita")
    private double cost;


    public Row() {
    }

    public String getProduct() {
        return null;
    }

    public String getProcesso() {
        return null;
    }

    public String getType() {
        return null;
    }

    public String getFlow() {
        return null;
    }

    public String getCategoria() {
        return null;
    }

    public double getQuantity() {
        return 0;
    }

    public String getUnity() {
        return null;
    }

    public double getCost() {
        return 0;
    }
}
