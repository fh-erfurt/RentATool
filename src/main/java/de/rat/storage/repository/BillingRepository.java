package de.rat.storage.repository;

import de.rat.model.billing.Bill;
import de.rat.model.billing.Billing;
import de.rat.model.common.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BillingRepository extends CrudRepository<Billing,Integer> {


    Billing findById(int id);

}
