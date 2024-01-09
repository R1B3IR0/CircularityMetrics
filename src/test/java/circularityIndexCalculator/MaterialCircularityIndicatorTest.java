package circularityIndexCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.Product;
import productsystem.ProductList;

import static org.junit.jupiter.api.Assertions.assertEquals;


/*
public class MaterialCircularityIndicatorTest {
    private MaterialCircularityIndicator mci;
    private MaterialList materials;
    private Product product;
    private ProductList products;

    @BeforeEach
    void setUp() {
        mci = new MaterialCircularityIndicator();
        materials = new MaterialList("materials");
        product = new Product("product", 1, 1, null);
        products = new ProductList("products");
    }
    @Test
    void productMciTotalNullTest() {
        // Case 1: productMciTotal() should return the total MCI of a product
        mci.productMciTotal(null);
        asserEquals(0, mci.productMciTotal(null), "productMciTotal() should return the total MCI of a product");
    }
    @Test
    void productListMciTotalNullTest() {
        // Case 1: productListMciTotal() should do the total MCI of each element on the product List
        mci.productListMciTotal(null);
        assertEquals(0, mci.productListMciTotal(null), "productListMciTotal() should do the total MCI of each product of the list");
    }

    @Test
    void mciTotalTest(){
        //Case 1: mciTotal() should return the total MCI of each element on the material List
        mci.mciTotal(materials);
        assertEquals(0, mci.mciTotal(materials), "mciTotal() should return the total MCI of each element on the material List");
    }
    @Test
    void mciTotalNullTest(){
        //Case 2: mciTotal() should return the total MCI of each element on the material List
        mci.mciTotal(null);
        assertEquals(0, mci.mciTotal(null), "mciTotal() should return the total MCI of each element on the material List");
    }
    @Test
    void mciTotalGreaterTest(){
        //Case 3: mciTotal() should return the total MCI of each element on the material List
        mci.mciTotal(materials);
        assertEquals(2, mci.mciTotal(materials), "mciTotal() should return the total MCI of each element on the material List");
    }
    @Test
    void mciTotalNegativeTest(){
        //Case 4: mciTotal() should return the total MCI of each element on the material List
        mci.mciTotal(materials);
        assertEquals(-1, mci.mciTotal(materials), "mciTotal() should return the total MCI of each element on the material List");
    }

}*/
