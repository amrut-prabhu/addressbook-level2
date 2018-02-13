package seedu.addressbook.ui;

import java.util.ArrayList;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;

/**
 * Format text (eg. decorations) for display
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    public String getFormattedWelcomeMessage(String version, String storageFilePath, String welcomeMessage, String argsMessage) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return getFormattedMessage(
                   DIVIDER,
                   DIVIDER,
                   welcomeMessage,
                   version,
                   argsMessage,
                   storageFileInfo,
                   DIVIDER);
    }

    private String getFormattedMessage(String... message){

    }

}
