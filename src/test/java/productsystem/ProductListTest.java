package productsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ProductListTest {
    private ProductList pl1;
    private Product p1;

    @BeforeEach
    void setUp() {
        pl1 = new ProductList("pl1");
        p1 = new Product("p1", 1, 1, null);
    }

    @Test
    void addProductTest() {
        //Case 1: addProduct() should add a Product to the container
        pl1.addProduct(p1);
        assertEquals(1, pl1.getCount(), "addProduct() should add a Product to the container");
    }

    @Test
    void addNullProductTest() {
        //Case 2: Product cannot be null
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> pl1.addProduct(null),
                "Product cannot be null");
        assertEquals("Product cannot be null", exception.getMessage());
    }


    @Test
    void removeProcessTest() {
        //Case 1: Count should be 0
        pl1.addProduct(p1);
        pl1.removeProduct(p1.getName());
        assertEquals(0, pl1.getCount(), "removeProduct() should remove a Product from the container");
    }

    @Test
    void removeNotExistingProductTest() {
        // Case 2: Removing a product  that doesn't exist
        int expected = -1;
        int result = pl1.findProduct(p1.getName());
        assertEquals(expected, result, "removeProduct() should return -1(because the does not exist in the container)");
    }

    @Test
    void removeNullProductTest() {
        //Case 3: removeProduct() name cannot be null.
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> pl1.removeProduct(null),
                "Product cannot be null");
        assertEquals("Product cannot be null", exception.getMessage());
    }

    @Test
    void findProductTest() {
        //Case 1: findProduct() should return 0.
        pl1.addProduct(p1);
        assertEquals(0, pl1.findProduct(p1.getName()), "findProduct() should return 0");
    }

    @Test
    void NotFoundProductTest() {
        //Case 2: NotFoundProduct() should return -1.
        pl1.findProduct(p1.getName());
        assertEquals(-1, pl1.findProduct(p1.getName()), "findProduct() should return -1");
    }

    @Test
    void findNullProductTest() {
        //Case 3: findProduct() name cannot be null.
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> pl1.findProduct(null), "Product cannot be null");
        assertEquals("Product cannot be null", exception.getMessage());
    }

    @Test
    void testeCobertura() {
        pl1.addProduct(p1);
        assertEquals(1, pl1.getCount(), "addProduct() should add a Product to the container");
        pl1.removeProduct(p1.getName());
        assertEquals(0, pl1.getCount(), "removeProduct() should remove a Product from the container");
        pl1.findProduct(p1.getName());
        assertEquals(-1, pl1.findProduct(p1.getName()),"findProduct() should return -1");
    }
}