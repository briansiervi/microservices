package br.com.brian.services;

import br.com.brian.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Brian");
        person.setLastName("Mazini Siervi");
        person.setAdress("São Paulo - SP - Brasil");
        person.setGender("Male");

        return person;
    }
}
