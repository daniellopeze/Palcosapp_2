package com.usa.palcosapp_1.repository.crudrepository;

import com.usa.palcosapp_1.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
