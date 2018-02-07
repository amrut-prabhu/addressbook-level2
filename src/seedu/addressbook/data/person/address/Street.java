package seedu.addressbook.data.person.address;

/**
 * Represents a Person's Street address in the address book.
 */
public class Street {

    public final String streetAddress;

    /**
     * Default constructor
     */
    public Street() {
        this("");
    }

    /**
     * Constructs a block with the given block number
     */
    public Street(String street) {
        streetAddress = street;
    }

    /**
     * Returns street of the address
     *
     * @return the street address of this street
     */
    public String getStreet() {
        return streetAddress;
    }

    @Override
    public String toString() {
        return getStreet();
    }
}