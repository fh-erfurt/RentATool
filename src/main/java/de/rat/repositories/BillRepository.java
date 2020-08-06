package de.rat.repositories;

import de.rat.model.billing.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BillRepository extends CrudRepository<Bill,Integer> {

    @Query("FROM Bill b where b.customer.id =:customer_id ")
    List<Bill> findByCustomerId(@Param("customer_id") Integer customer_id);
}