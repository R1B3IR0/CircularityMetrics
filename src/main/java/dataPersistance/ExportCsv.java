package dataPersistance;

import circularityIndexCalculator.CreateMaterials;
import circularityIndexCalculator.Material;
import circularityIndexCalculator.ProductMCI;
import com.opencsv.CSVWriter;
import productsystem.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        this.materials = createMaterials.getMaterials();
        ProductMCI.productMciTotal(this.product);

        try {
            FileWriter csvWriter = new FileWriter(this.fileName);

            ArrayList<String> header = new ArrayList();
            header.add("Material");
            header.add(";");
            ArrayList<String> line1 = new ArrayList();
            line1.add("\n");
            line1.add("Material virgem (V)");
            line1.add("\n");
            line1.add("Materiais recuperados EoL (Rr)");
            line1.add("\n");
            line1.add("Waste produzido na reciclagem (Wc)");
            line1.add("\n");
            line1.add("Waste total produzido (W)");
            line1.add("\n");
            line1.add("Waste radioativo (Wr)");
            line1.add("\n");
            line1.add("Materiais reciclados (R) (+ Burden Free) (-cr)");
            line1.add("\n");
            line1.add("Energia necessária para produção das matérias/produtos principais");
            line1.add("\n");
            line1.add("Energia necessária para produção das matérias/produtos secundário ");
            line1.add("\n");
            line1.add("Waste na produção de materiais (Wf) - ws");
            line1.add("\n");
            line1.add("Input de Valor Reciclado (Ri) - fr");
            line1.add("\n");
            line1.add("Massa (V+Ri)");
            line1.add("\n");
            line1.add("Tempo de Vida Útil (anos)/Vida útil em média (anos)");
            line1.add("\n");
            line1.add("Utilidade do Produto (U) - nº utilizações/Média (anos)");
            line1.add("\n");
            line1.add("Fx");
            line1.add("\n");
            line1.add("LFI");
            line1.add("\n");
            line1.add("MCIp");
            line1.add("\n");
            line1.add("MCI Total");
            line1.add("\n");
            line1.add("Produto");
            line1.add("\n");




            for (Material material : materials) {
                header.add(material.getNameMaterial());
                line1.add(String.valueOf(material.getVirginMaterial()));
                line1.add((String.valueOf(material.getRecoveredMaterial())));
                line1.add((String.valueOf(material.getWasteOnRecycling())));
                line1.add((String.valueOf(material.getWasteTotal())));
                line1.add((String.valueOf(material.getWasteRadioactive())));
                line1.add((String.valueOf(material.getRecycledMaterial())));
                line1.add((String.valueOf(material.getEnergyNeededForMainMaterial())));
                line1.add(String.valueOf(material.getEnergyNeededForSecondaryMaterial()));
                line1.add(String.valueOf(material.getWasteProduction()));
                line1.add(String.valueOf(material.getInputRecycled()));
                line1.add(String.valueOf(material.getMass()));
                line1.add(String.valueOf(material.getLifespan()));
                line1.add(String.valueOf(material.getUsefulness()));
                line1.add(String.valueOf(material.getFx()));
                line1.add(String.valueOf(material.getLinearFlowIndex()));
                //line1.add(String.valueOf(material.getMci()));
                //ine1.add(String.valueOf(ProductMCI.productMciTotal(this.product)));
                //line1.add(String.valueOf(this.product.getName()));
            }


            List<String[]> list = new ArrayList<>();
            list.add(header.toArray(new String[0]));
            list.add(line1.toArray(new String[0]));;

            try (CSVWriter writer = new CSVWriter(new FileWriter(this.fileName))) {
                writer.writeAll(list);

                // Writing data
                for (Material material : materials) {
                    List<String> line = new ArrayList<>();
                    line.add(material.getNameMaterial());
                    // Add other material data to the line as needed

                    writer.writeNext(line.toArray(new String[0]));
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}









/*
            // Writing data
            for (Material material : materials) {
                csvWriter.append(material.getNameMaterial()).append(";");
                csvWriter.append("\n");
                csvWriter.append("\n");
                csvWriter.append((String.valueOf(material.getVirginMaterial()))).append(";"); // new line
                csvWriter.append("\n");
                csvWriter.append((String.valueOf(material.getRecoveredMaterial())));
                csvWriter.append("\n");
                csvWriter.append((String.valueOf(material.getWasteOnRecycling())));
                csvWriter.append("\n");
                csvWriter.append((String.valueOf(material.getWasteOnRecycling())));
                csvWriter.append("\n");
                csvWriter.append((String.valueOf(material.getWasteRadioactive())));
                csvWriter.append("\n");
                csvWriter.append((String.valueOf(material.getRecycledMaterial())));
                csvWriter.append("\n");
                csvWriter.append((String.valueOf(material.getEnergyNeededForMainMaterial())));
                csvWriter.append("\n");
                csvWriter.append(String.valueOf(material.getEnergyNeededForSecondaryMaterial()));
                csvWriter.append("\n");
                csvWriter.append(String.valueOf(material.getWasteProduction()));
                csvWriter.append("\n");
                csvWriter.append(String.valueOf(material.getInputRecycled()));
                csvWriter.append("\n");
                csvWriter.append(String.valueOf(material.getMass()));
                csvWriter.append("\n");
                csvWriter.append(String.valueOf(material.getLifespan()));
                csvWriter.append("\n");
                csvWriter.append(String.valueOf(material.getUsefulness()));
                csvWriter.append("\n");
                csvWriter.append(String.valueOf(material.getFx()));
                csvWriter.append("\n");
                csvWriter.append(String.valueOf(material.getLinearFlowIndex()));
                csvWriter.append("\n");
                csvWriter.append("\n");

            }



            //csvWriter.append(String.valueOf(product.getMci()));
            //csvWriter.append("\n");
            //csvWriter.append(product.getName());


            csvWriter.flush();
            csvWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
*/