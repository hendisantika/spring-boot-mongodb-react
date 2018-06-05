package com.hendisantika.springbootmongodbreact.repository;

import com.hendisantika.springbootmongodbreact.model.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mongodb-react
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/06/18
 * Time: 05.35
 * To change this template use File | Settings | File Templates.
 */
public interface ContactRepository extends CrudRepository<Contact, String> {
    @Override
    void delete(Contact deleted);
}