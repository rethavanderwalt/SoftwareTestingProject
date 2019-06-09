/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import packer.Product;

/**
 *
 * @author 91030418
 */
public class BoxTest {
    Manifest manifest = new Manifest();

    // Test data
        Product testproduct0 = new Product("Hammer", 3, false, false);
        Product testproduct1 = new Product("Weedkiller", 2, true, false);
        Product testproduct2 = new Product("Ladder", 15, false, false);
        Product testproduct3 = new Product("Saw", 5, false, false);
        Product testproduct4 = new Product("Nails", 1, false, false);
        Product testproduct5 = new Product("LightBulb", 1, false, true);
        Product testproduct6 = new Product("Lawnmower", 20, true, false);
        
        Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
        Address customerAddress0 = new Address("77 Tia Ave", "Newton", "High", "T869", new Coordinates(1004, 98));
        Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
        
        Depot depot = new Depot("Main Depot", depotAddress);
        
        Customer customer0 = new Customer("Andy Bravo", customerAddress1);
        Customer customer1 = new Customer("James Smith", customerAddress1);
        
        Box box0 = new Box(customer0, depot);
        Box box1 = new Box(customer0, depot);
    
    public BoxTest() {
    }
    
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }

    /**
     * Test of addProduct method, of class Box.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        //adding some products to the box
        box0.addProduct(testproduct0, 6);
        box0.addProduct(testproduct1, 5);
        box0.addProduct(testproduct2, 4);
        box0.addProduct(testproduct3, 3);
        box0.addProduct(testproduct4, 2);
        box0.addProduct(testproduct5, 1);
        box0.addProduct(testproduct6, 1);
    }

    
    /**
     * Test of getWeight method, of class Box.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        assertEquals(3, testproduct0.getWeight());
        assertEquals(5, testproduct3.getWeight());
        assertEquals(2, testproduct1.getWeight());
    }
    

    /**
     * Test of canFit method, of class Box.
     */
    @Test
    public void testCanFit_Product_int() {
        System.out.println("canFit");
        assertEquals(true, box1.canFit(testproduct0, 1));
        
        //adding 2 of a large item
        assertEquals(false, box1.canFit(testproduct6, 2));
    }

    
    /**
     * Test of remainingCapacity method, of class Box.
     */
    @Test
    public void testRemainingCapacity() {
        System.out.println("remainingCapacity");
        assertEquals(20, box1.remainingCapacity(), 0.0);
        
        //after adding a product
        box1.addProduct(testproduct6, 1);
        assertEquals(0, box1.remainingCapacity(), 0.0);
    }

    
    /**
     * Test of isFragile method, of class Box.
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

    
    /**
     * Test of isHazardous method, of class Box.
     */
    @Test
    public void testIsHazardous() {
        System.out.println("isHazardous");
        assertEquals(false, testproduct0.isHazardous());
        assertEquals(false, testproduct0.isHazardous());
        assertEquals(false, testproduct4.isHazardous());
        assertEquals(false, testproduct5.isHazardous());
        assertEquals(true, testproduct1.isHazardous());
        assertEquals(true, testproduct6.isHazardous());
    }
    
    /**
     * Test of isHeavy method, of class Box.
     */
    @Test
    public void testIsHeavy() {
        System.out.println("isHeavy");
        assertEquals(false, box0.isHeavy());
    }  
}
