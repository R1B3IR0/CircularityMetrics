package circularityIndexCalculator;

import productsystem.Process;
import productsystem.Product;
import productsystem.ProductList;

public class ProductMCI {
    public static double mciTotal(MaterialList materials) {
        if (materials == null)
            throw new IllegalArgumentException("Material List cannot be null");
        double numerator = 0, denominator = 0;
        for (Material material : materials.getMaterials()) {
            numerator += material.getVirginMaterial() * material.getCircularityIndexP();
            denominator += material.getCircularityIndexP();
        }
        if (denominator == 0)
            throw new ArithmeticException("The circularity index sum of all materials cannot be zero");
        return numerator / denominator;
    }

    public static void productMciTotal(Product product) {
        if (product == null)
            throw new IllegalArgumentException("Product cannot be null");
        Process process = product.getProcess();
        MaterialList materials = new MaterialList(process);
        materials.getMaterials();
        mciTotal(materials);
    }

    public static void productListMciTotal(ProductList products) {
        if (products == null)
            throw new IllegalArgumentException("Product List cannot be null");
        for (Product product : products.getProducts())
            productMciTotal(product);
    }
}
