package seedu.addressbook.commands;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.util.TestUtil;

public class SortCommandTest {

    @Test
    public void sortCommand_validList(){
        SortCommand sortCommand = new SortCommand();

        Person person1 = TestUtil.generateTestPerson("Davis");
        Person person2 = TestUtil.generateTestPerson("Zafar");
        Person person3 = TestUtil.generateTestPerson("Adam");
        Person person4 = TestUtil.generateTestPerson("Riley");

        AddressBook addressBook = TestUtil.createAddressBook(person1, person2, person3, person4);

        List<Person> sortedPersons = Arrays.asList(person3, person1, person4, person2);


        sortCommand.setData(addressBook, Collections.emptyList());

        UniquePersonList persons = addressBook.getAllPersons();

        try{
            UniquePersonList sortedList = new UniquePersonList(sortedPersons);
            assertTrue(sortedList.equals(sortedPersons));
        }
        catch(Exception ex){
            System.out.println("Duplicate persons in list");
        }
    }
}
