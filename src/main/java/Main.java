import circularityIndexCalculator.CreateMaterials;
import circularityIndexCalculator.Material;
import circularityIndexCalculator.MaterialList;
import circularityIndexCalculator.ProductMCI;
import dataPersistance.ExportCsv;
import dataPersistance.ImportCsv;
import productsystem.AggregatedProcess;
import productsystem.Flow;
import productsystem.Product;
import productsystem.UnitaryProcess;

public class Main {
    public static void main(String[] args) {
        ImportCsv importCsv = new ImportCsv("src/main/resources/CSV/csv.csv");
        System.out.println(importCsv.getProcessNames());
        Product product = importCsv.sendProduct();
        ExportCsv exportCsv = new ExportCsv("src/main/resources/CSV/result.csv",product);
        exportCsv.writeToCsv();



    }
}
