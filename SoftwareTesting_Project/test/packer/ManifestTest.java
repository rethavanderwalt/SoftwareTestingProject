
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import packer.Manifest;
import packer.Product;

/**
 *
 * @author 91030418
 */
public class ManifestTest {
    private Map<Product, Integer> quantities;
    private Set<Product> byWeight;
    
        // Test data
        Product testproduct0 = new Product("Hammer", 4, false, false);
        Product testproduct1 = new Product("Weedkiller", 3, true, false);
        Product testproduct2 = new Product("Ladder", 15, false, false);
        Product testproduct3 = new Product("Saw", 5, false, false);
        Product testproduct4 = new Product("Nails", 2, false, false);
        Product testproduct5 = new Product("LightBulb", 1, false, true);

        Manifest manifest = new Manifest();
        
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }
    
    @Before
    public void setUp(){
        byWeight = new TreeSet<>(new ProductWeightComparator());
        quantities = new HashMap<>();
        
        //adding some products to the manifest
        manifest.addProduct(testproduct0, 1);
        manifest.addProduct(testproduct1, 2);
        manifest.addProduct(testproduct3, 4);
        manifest.addProduct(testproduct4, 5);
        manifest.addProduct(testproduct5, 6);
    }

    
    /**
     * Test of addProduct method, of class Manifest.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        //adding some products to the manifest
        manifest.addProduct(testproduct0, 1);
        manifest.addProduct(testproduct1, 2);
        manifest.addProduct(testproduct2, 3);
        manifest.addProduct(testproduct3, 4);
        manifest.addProduct(testproduct4, 5);
        manifest.addProduct(testproduct5, 6);
    }
    
    /**
     * Test of removeProduct method, of class Manifest.
     */
    @Test
    public void testRemoveProduct() {
        System.out.println("removeProduct");
        manifest.removeProduct(testproduct0);
        
        //to see if it was removed
        assertEquals(false, manifest.containsProduct(testproduct0));
    }

    /**
     * Test of getTotalWeight method, of class Manifest.
     */
    @Test
    public void testGetTotalWeight() {
        System.out.println("getTotalWeight");
        assertEquals(4, testproduct0.getWeight());
        assertEquals(5, testproduct3.getWeight());
        assertEquals(3, testproduct1.getWeight());
    }

    /**
     * Test of getHeaviestUnder method, of class Manifest.
     */
    @Test
    public void testGetHeaviestUnder() {
        System.out.println("getHeaviestUnder");
        assertEquals(testproduct5, manifest.getHeaviestUnder(1));
        assertEquals(testproduct3, manifest.getHeaviestUnder(16));
    }

    
    /**
     * Test of isEmpty method, of class Manifest.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertEquals(true, byWeight.isEmpty());
    }

    
    /**
     * Test of containsProduct method, of class Manifest.
     */
    @Test
    public void testContainsProduct() {
        System.out.println("containsProduct");
        assertEquals(false, manifest.containsProduct(testproduct2));
        assertEquals(true, manifest.containsProduct(testproduct1));
        assertEquals(true, manifest.containsProduct(testproduct5));
    }

 
    /**
     * Test of hasFragileItems method, of class Manifest.
     */
    @Test
    public void testHasFragileItems() {
        System.out.println("hasFragileItems");
        assertEquals(false, testproduct0.isFragile());
        assertEquals(false, testproduct1.isFragile());
        assertEquals(true, testproduct5.isFragile());
        assertEquals(false, testproduct2.isFragile());
        assertEquals(false, testproduct3.isFragile());
    }
    
}
