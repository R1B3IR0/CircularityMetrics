package dataPersistance;

import productsystem.Flow;
import productsystem.Product;
import productsystem.UnitType;
import productsystem.UnitaryProcess;

public class Main {

    public static void main(String[] args) {
        Flow flow = new Flow("Teste", "Materials", 10, UnitType.kg, 10);
        Flow flow2 = new Flow("Material Virgem (V)", "Materials2", 20, UnitType.unit, 10);
        UnitaryProcess unitaryProcess = new UnitaryProcess("teste");
        unitaryProcess.addFlowInput(flow);
        unitaryProcess.addFlowOutput(flow2);
        Product product = new Product("teste", unitaryProcess);
        ExportCsv exportCsv = new ExportCsv("src/main/resources/CSV/result.csv", product);

        exportCsv.writeToCsv();

    }
}
