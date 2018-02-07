package seedu.addressbook.data.person.address;

/**
 * Represents a Person's address postal code in the address book.
 */
public class Unit {

    public final String unitNum;

    /**
     * Default constructor
     */
    public Unit() {
        this("");
    }

    /**
     * Constructs a Unit with the given number
     */
    public Unit(String unit) {
        unitNum = unit;
    }

    /**
     * Returns Unit of the address
     *
     * @return the person's unit in the address
     */
    public String getUnitNum() {
        return unitNum;
    }
}