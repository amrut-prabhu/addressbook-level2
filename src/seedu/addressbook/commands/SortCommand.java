package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Lists all persons in the address book alphabetically to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Displays all persons in the address book "
            + "sorted in alphabetical order by name.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> sortedPersons = getSortedList(addressBook.getAllPersons().immutableListView());
        return new CommandResult(getMessageForSortedPersonListShownSummary(sortedPersons), sortedPersons);
    }

    /**
     * Returns a complete list of persons in the address book sorted alphabetically.
     * @param allPersons list of all persons in the address book
     * @return list of persons ordered alphabetically
     */
    private List<ReadOnlyPerson> getSortedList(List<ReadOnlyPerson> allPersons){
        return allPersons.stream()
               .sorted(((o1, o2) -> o1.getName().toString().compareToIgnoreCase(o2.getName().toString())))
               .collect(Collectors.toList());
    }
}
