package packer;

/**
 *
 * @author I.M.Bad
 */
public class Depot {
    private String name;
    private Address address;

    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
     /**
   * Gets the name of this depot.
   * @return this Depot's name.
   */
    public String getName() {
        return name.toString();
    }
    
     /**
   * Gets the coordinates of this depot.
   * @return this Depot's coordinates.
   */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    public String toString() {
        return this.getName();
    }
    
}
