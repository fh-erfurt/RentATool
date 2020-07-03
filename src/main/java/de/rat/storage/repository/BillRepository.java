package de.rat.storage.repository;

import de.rat.model.billing.Bill;
import de.rat.model.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface BillRepository extends CrudRepository<Bill,Integer>
{

    Bill findByBillNumber(int id);

    List<Bill> findByRentDate(LocalDate date);
    List<Bill> findByFullRentPrice(double rentPrice);

    //Query for searching Bill after customers lastname
    @Query("FROM Bill b where b.customer.lastname=:customerLastName ")
    List<Bill> findByCustomer(@Param("customerLastName") String customerLastName);

    //Query for searching bill after prices between a range
    @Query("FROM Bill b WHERE b.fullRentPrice between :lowRentPrice and :highRentPrice ")
    List<Bill> findByRentPrice(@Param("lowRentPrice")double lowRentPrice, @Param("highRentPrice")double highRentPrice);



}