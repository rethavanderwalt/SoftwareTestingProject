package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I.M.Bad
 */
public class Customer {
    
    private String name;
    private List<Address> addresses;

    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    
    /**
   * Adds a new address for the customer.
   */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
    /**
   * Gets the name of this Customer.
   * @return this Customer's name.
   */
    public String getName() {
        return name;
    }

    /**
   * Gets the customer's closest address to the company.
   * @return is the closest address.
   */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;
        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            if (distance < bestDistance) {
                bestAddress = a;
                bestDistance = distance;
            }
        }
        return bestAddress;
    }

    public String toString() {
        return this.getName();
    }
}
