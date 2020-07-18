package de.rat.repositories;


import de.rat.model.billing.Billing;
import org.springframework.data.repository.CrudRepository;

public interface BillingRepository extends CrudRepository<Billing,Integer> {


    Billing findById(int id);

}
