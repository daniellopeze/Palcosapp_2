package com.usa.palcosapp_1.repository.crudrepository;

import com.usa.palcosapp_1.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
