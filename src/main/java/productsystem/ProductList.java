package productsystem;

import java.util.List;

public class ProductList implements CircularityInfo {
    private List<Product> list;
    private String name;
    private int count;

    public ProductList(String name) {
    }

    public String getName() {
        return null;
    }
    public void setName(String name) {
    }
    public int getCount() {
        return 0;
    }
    public Product addProduct(Product product){
        return null;
    }
    public Product removeProduct(String name){
        return null;
    }
    public int findProduct(String name){
        return 0;
    }
    @Override
    public List<ProductList> sendList() {
        return null;
    }
}
