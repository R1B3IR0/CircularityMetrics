package dataPersistance;

import circularityIndexCalculator.Material;
import productsystem.Product;

import java.util.List;

public class ExportCsv {
    private Product product;
    private List<Material> materialList;

    public ExportCsv() {
    }

    public boolean writeToCsv(String filename){
        return true;
    }
}
