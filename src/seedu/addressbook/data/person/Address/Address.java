package seedu.addressbook.data.person.address;

import javafx.geometry.Pos;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format: ";
    public static final String ADDRESS_CONSTRAINTS = "a/BLOCK, STREET, UNIT, POSTAL CODE";
    public static final String ADDRESS_VALIDATION_REGEX = "(.*), (.*), (.*), (.*)";
    public static final String ADDRESS_SPLIT_REGEX = ", ";

    private static final int ADDRESS_BLOCK_INDEX = 0;
    private static final int ADDRESS_STREET_INDEX = 1;
    private static final int ADDRESS_UNIT_INDEX = 2;
    private static final int ADDRESS_POSTAL_CODE_INDEX = 3;

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS + ADDRESS_CONSTRAINTS);
        }

        setAddressComponents(trimmedAddress);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }


    private void setAddressComponents(String address) {
        String[] components = address.split(ADDRESS_SPLIT_REGEX);

        this.block = extractBlock(components);
        this.street = extractStreet(components);
        this.unit = extractUnit(components);
        this.postalCode = extractPostalCode(components);
    }

    /**
     * Extracts the block number from the address
     *
     * @param components list of the components of the address
     * @return block extracted from the address components
     */
    private Block extractBlock(String[] components) {
        return new Block(components[ADDRESS_BLOCK_INDEX]);
    }

    /**
     * Extracts the street from the address
     *
     * @param components list of the components of the address
     * @return street extracted from the address components
     */
    private Street extractStreet(String[] components) {
        return new Street(components[ADDRESS_STREET_INDEX]);
    }

    /**
     * Extracts the unit from the address
     *
     * @param components list of the components of the address
     * @return unit extracted from the address components
     */
    private Unit extractUnit(String[] components) {
        return new Unit(components[ADDRESS_UNIT_INDEX]);
    }

    /**
     * Extracts the postal code from the address
     *
     * @param components list of the components of the address
     * @return postal code extracted from the address components
     */
    private PostalCode extractPostalCode(String[] components) {
        return new PostalCode(components[ADDRESS_POSTAL_CODE_INDEX]);
    }

    @Override
    public String toString() {
        return block + ADDRESS_SPLIT_REGEX + street + ADDRESS_SPLIT_REGEX + unit + ADDRESS_SPLIT_REGEX + postalCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.equals(((Address) other))); // state check
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
