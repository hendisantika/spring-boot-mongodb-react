package com.hendisantika.springbootmongodbreact.controller;

import com.hendisantika.springbootmongodbreact.model.Contact;
import com.hendisantika.springbootmongodbreact.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mongodb-react
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/06/18
 * Time: 05.36
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactRepository contactRepository;

    @GetMapping(value = "/contacts")
    public Iterable<Contact> contact() {
        return contactRepository.findAll();
    }

    @PostMapping(value = "/contacts")
    public Contact save(@RequestBody Contact contact) {
        contactRepository.save(contact);

        return contact;
    }

    @GetMapping(value = "/contacts/{id}")
    public Optional<Contact> show(@PathVariable String id) {
        return contactRepository.findById(id);
    }

    @PutMapping(value = "/contacts/{id}")
    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
        Optional<Contact> optcontact = contactRepository.findById(id);
        Contact c = optcontact.get();
        if (contact.getName() != null)
            c.setName(contact.getName());
        if (contact.getAddress() != null)
            c.setAddress(contact.getAddress());
        if (contact.getCity() != null)
            c.setCity(contact.getCity());
        if (contact.getPhone() != null)
            c.setPhone(contact.getPhone());
        if (contact.getEmail() != null)
            c.setEmail(contact.getEmail());
        contactRepository.save(c);
        return c;
    }

    @DeleteMapping(value = "/contacts/{id}")
    public String delete(@PathVariable String id) {
        Optional<Contact> optcontact = contactRepository.findById(id);
        Contact contact = optcontact.get();
        contactRepository.delete(contact);

        return "";
    }
}
