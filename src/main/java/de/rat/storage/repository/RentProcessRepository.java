package de.rat.storage.repository;

import de.rat.model.logistics.Station;
import de.rat.model.customer.RentProcess;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;


public interface RentProcessRepository extends CrudRepository<RentProcess,Integer>
{

//    RentProcess findById(int id);
//
//    List<RentProcess> findByReturnDate(LocalDate Date);
//    List<RentProcess> findByReturnStation(Station station);

}
