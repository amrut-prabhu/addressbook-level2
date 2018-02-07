package seedu.addressbook.data.person.address;

/**
 * Represents a Person's address postal code in the address book.
 */
public class PostalCode {

    public final String postalCode;

    /**
     * Default constructor
     */
    public PostalCode() {
        this("");
    }

    /**
     * Constructs a PostalCode with the given number
     */
    public PostalCode(String code) {
        postalCode = code;
    }

    /**
     * Returns Postal Code of the address
     *
     * @return the Postal Code of this address
     */
    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return getPostalCode();
    }
}