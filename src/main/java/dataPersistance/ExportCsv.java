package dataPersistance;

import circularityIndexCalculator.CreateMaterials;
import circularityIndexCalculator.Material;
import circularityIndexCalculator.ProductMCI;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import productsystem.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ExportCsv {
    private Product product;
    private List<Material> materials;
    private CreateMaterials createMaterials;
    private String fileName;

    public ExportCsv(String filename, Product product) {
        this.product = product;
        this.createMaterials = new CreateMaterials(this.product.getProcess());
        this.fileName = filename;
    }

    public boolean writeToCsv() {
        if(this.fileName == null)
            throw new IllegalArgumentException("filename cannot be null"
            );
        if(this.product == null)
            throw new IllegalArgumentException("product cannot be null"
            );
        this.materials = createMaterials.getMaterials();
        ProductMCI.productMciTotal(this.product);
        try (FileWriter fileWriter = new FileWriter(this.fileName);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)) {

            // Writing header
            csvPrinter.printRecord("Product",";", "Material",";", "Material virgem (V)",";","Materiais recuperados EoL (Rr)",";"
                    ,"Waste produzido na reciclagem (Wc)",";","Waste total produzido (W)",";","Waste radioactivo (Wr)",";","Materiais reciclados (R) (+ Burden Free) (-cr)",
                    ";","Energia necessária para produção das matérias/produtos principais",";","Energia necessária para produção das matérias/produtos secundário",
                    ";","Waste na produção de materiais (Wf) - ws",";","Input de Valor Reciclado (Ri) - fr",";","Massa (V+Ri)",";","Tempo de Vida Útil (anos)/Vida útil em média (anos)",";",
                    "Utilidade do Produto (U) - nº utilizações/Média (anos)",";","f(x)",";","LFI",";","MCIp",";","MCI Total");
            for(Material m : materials){
                csvPrinter.printRecord(product.getName(),";",m.getNameMaterial(),";", m.getVirginMaterial(),";",m.getRecoveredMaterial(),";",
                        m.getWasteOnRecycling(),";",m.getWasteTotal(),";",m.getWasteRadioactive(),";",m.getRecycledMaterial(),";",m.getEnergyNeededForMainMaterial(),";",
                        m.getEnergyNeededForSecondaryMaterial(),";",m.getWasteProduction(),";",m.getInputRecycled(),";",m.getMass(),";",m.getLifespan()/m.getAverageLifespan(),";",
                        m.getUsefulness()/m.getAverageUsefulness(),";",m.getFx(),";",m.getLinearFlowIndex(),";",m.circularityIndex(),";",product.getMci());

            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}