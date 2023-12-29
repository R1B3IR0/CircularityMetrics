package productsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
        if (product == null)
            throw new IllegalArgumentException("Product cannot be null");
        this.count++;
        this.list.add(product);
        return product;
    }

    public Product removeProduct(String name) {
        int pos=findProduct(name);
        if(pos==-1){
            throw new NoSuchElementException("Product cannot be null");
        }
        Product product = this.list.get(pos);
        this.list.remove(pos);
        count--;
        return product;
    }

    public int findProduct(String name) {
        int position=0;
        if(name==null)
            throw new NoSuchElementException("Product cannot be null");
        for(Product p:this.list){
            if(p.getName().equals(name)){
                return position;
            }
            position++;
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

