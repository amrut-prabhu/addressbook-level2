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


    /**
     * Returns a formatted version of the entire welcome message
     *
     * @param version project version.
     * @param storageFilePath path for address book data storage file.
     * @param welcomeMessage welcome message text.
     * @param argsMessage launch command format text.
     * @return formatted version (eg. decorations) of entire welcome message
     */
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

    public String getFormattedGoodbyeMessage(String goodbyeMessage){
        return getFormattedMessage(goodbyeMessage, DIVIDER, DIVIDER);
    }

    public String getFormattedInitFailedMessage(String failMessage){
        return getFormattedMessage(failMessage, DIVIDER, DIVIDER);
    }

    public String getFormattedPrompt(String prompt){
        return LINE_PREFIX + prompt;
    }

    public String getFormattedResultFeedback(String resultFeedback){
        return getFormattedMessage(resultFeedback, DIVIDER);
    }

    /**
     * Returns formatted version of the messages.
     */
    public String getFormattedMessage(String... message){
        StringBuilder formattedMessage = new StringBuilder();
        for (String m : message) {
            formattedMessage.append(LINE_PREFIX).append(m.replace("\n", LS + LINE_PREFIX)).append(LS);
        }
        return formattedMessage.toString();
    }

}
