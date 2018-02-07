package seedu.addressbook.data.person.Address;

/**
 * Represents a Person's block address in the address book.
 */
public class Block {

    public final String blockNum;

    /**
     * Default constructor
     */
    public Block() {
        this("");
    }

    /**
     * Constructs a block with the given block number
     */
    public Block(String block) {
        blockNum = block;
    }

    /**
     * Returns block of the address
     *
     * @return the block address of this street
     */
    public String getBlock() {
        return blockNum;
    }
}