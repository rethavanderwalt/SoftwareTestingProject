package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot; 

    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    /**
   * Add a new product.
   */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }

    /**
   * Add a new product with defined amount.
   * @param quantity This is the quantity of the new product to add.  
   */
    public void addProduct(Product product, int quantity) {
        if (canFit(product, quantity)); {
            contents.addProduct(product, quantity);
        }
    }
   
    /**
   * Gets the first and last name of this Student.
   * @return = the new label
   */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        if (this.isHeavy() == true) {
            label.append("HEAVY\n");
        }
        return label.toString();
    }
    
    public String toString() {
        return getLabel();
    }
    
    /**
   * Gets the total weight of the manifest
   * @return = the total weight
   */
    public double getWeight() {
        return contents.getTotalWeight();
    }
    
    /**
   * Returns bool on if the product can fit
   */
    public boolean canFit(Product p) {
        return p.getWeight() < 20;
    }
    
    /**
   * Returns bool on if the product can fit based on the quantity
   * @param quantity is the amount of the product
   */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < 20;
    }
    
    /**
   * Returns the amount of space remaining
   * @return = space left
   */
    public double remainingCapacity() {
        return 20 - this.getWeight();
    }
    
    /**
   * Returns bool on if any product in manifest is fragile
   */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    public boolean isHazardous() {
        return false;
    }
    
    /**
   * Returns true if weight is more than 15k, otherwise returns false
   */
    public boolean isHeavy() {
        if (this.getWeight() >=15){
            return true;
        }
        return false;
    }
}
