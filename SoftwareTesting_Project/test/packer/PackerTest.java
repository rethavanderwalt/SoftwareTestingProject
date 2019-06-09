/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;


import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author 91030418
 */
public class PackerTest {
    // Test data
        Address customerAddress0 = new Address("77 Tia Ave", "Newton", "High", "T869", new Coordinates(1004, 98));
        Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
        
        Depot depot = new Depot("Main Depot", depotAddress);
        
        Manifest manifest = new Manifest();
        Product testproduct0 = new Product("Hammer", 3, false, false);
        Product testproduct1 = new Product("Weedkiller", 2, true, false);
        Product testproduct2 = new Product("Ladder", 15, false, false);
        Product testproduct3 = new Product("Saw", 5, false, false);
        Product testproduct4 = new Product("Nails", 1, false, false);
        Product testproduct5 = new Product("LightBulb", 1, false, true);
        Product testproduct6 = new Product("Lawnmower", 20, true, false);
        
        Customer customer0 = new Customer("Andy Bravo", customerAddress0);
        
        Box box0 = new Box(customer0, depot);
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Packer class...");
    }

    /**
     * Test of packProducts method, of class Packer.
     */
    @Test
    public void testPackProducts() {
        
        System.out.println("packProducts");
        Packer testPacker = new Packer();
        manifest.addProduct(testproduct0, 2);
        
        List<Box> packedBoxes = new ArrayList<>();
        packedBoxes.add(box0);
        box0.addProduct(testproduct0, 2);
        
        List<Box> result = testPacker.packProducts(customer0, depot, manifest);
        
        assertEquals(packedBoxes.toString(), result.toString());
        
        //To see what the expected and actual results were
        System.out.println("Expected: ");
        System.out.println(packedBoxes.toString());
        System.out.println("\nActual:");
        System.out.println(result.toString());
    } 
}