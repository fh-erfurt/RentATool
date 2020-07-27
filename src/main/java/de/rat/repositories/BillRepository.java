package de.rat.repositories;

import de.rat.model.billing.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface BillRepository extends CrudRepository<Bill,Integer>
{

    // TODO: delete????
    //Query for searching Bill after customers lastname
    @Query("FROM Bill b where b.customer.lastname=:customerLastName ")
    List<Bill> findByCustomer(@Param("customerLastName") String customerLastName);

    @Query("FROM Bill b where b.customer.id =:customer_id ")
    List<Bill> findByCustomerId(@Param("customer_id") Integer customer_id);

    //Query for searching bill after prices between a range
    @Query("FROM Bill b WHERE b.fullRentPrice between :lowRentPrice and :highRentPrice ")
    List<Bill> findByRentPriceSpan(@Param("lowRentPrice")double lowRentPrice, @Param("highRentPrice")double highRentPrice);
}