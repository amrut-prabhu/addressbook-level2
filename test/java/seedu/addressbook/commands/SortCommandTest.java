package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.util.TestUtil;

public class SortCommandTest {

    private Person[] persons;

    private AddressBook addressBook;

    /**
     * Initialises persons array with 4 distinct persons
     */
    private void initPersons(){
        persons = new Person[4];
        persons[0] = TestUtil.generateTestPerson("Davis");
        persons[1] = TestUtil.generateTestPerson("Zafar");
        persons[2] = TestUtil.generateTestPerson("Adam");
        persons[3] = TestUtil.generateTestPerson("Riley");
    }

    @Test
    public void sortCommand_validList(){
        SortCommand sortCommand = new SortCommand();
        initPersons();

        addressBook = TestUtil.createAddressBook(persons);
        List<Person> sortedPersons = Arrays.asList(persons[2], persons[0], persons[3], persons[1]);
        sortCommand.setData(addressBook, Collections.emptyList());

        List<ReadOnlyPerson> actualPersons = getList(sortCommand);
        List<ReadOnlyPerson> expectedPersons = null;

        try{
            expectedPersons = new UniquePersonList(sortedPersons).immutableListView();
        }
        catch(Exception ex){
            System.out.println("Duplicate persons in list");
        }

        assertEquals(expectedPersons, actualPersons);
    }

    /**
     * Returns the sorted list of persons in the address book
     * @param command instance of SortCommand
     * @return list of persons sorted alphabetically
     */
    private List<ReadOnlyPerson> getList(SortCommand command){
        return command.getSortedList(addressBook.getAllPersons().immutableListView());
    }
}
