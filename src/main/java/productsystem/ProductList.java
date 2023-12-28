package productsystem;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private List<Product> list;
    private String name;
    private int count;

    public ProductList(String name) {
        this.name = name;
        this.count = 0;
        this.list = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return this.count;
    }

    public Product addProduct(Product product) {
        if (this.list.add(product) == true) {
            this.count++;
            return product;
        } else return null;
    }

    public Product removeProduct(String name) {
        int index = findProduct(name);
        if(index!=-1){
            this.count--;
            return this.list.remove(index);
        }
        else return null;
    }

    public int findProduct(String name) {
        for (Product product : this.list) {
            if (product.getName().equals(name))
                return this.list.indexOf(product);
        }
        return -1;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "list: " + list.toString()+
                "Name: " + name ;
    }
}

