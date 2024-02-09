package ru.job4j.search;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Pasha", "Leshkevich", "881153", "SPB")
        );
        ArrayList<Person> persons = phones.find("53");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
        assertThat(persons.get(1).getSurname()).isEqualTo("Leshkevich");
    }

    @Test
    public void whenNotFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Java");
        assertThat(persons.size()).isEqualTo(0);
    }
}