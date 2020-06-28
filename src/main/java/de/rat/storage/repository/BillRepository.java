package de.rat.storage.repository;

import de.rat.model.billing.Bill;
import de.rat.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;


public interface BillRepository extends CrudRepository<Bill,Integer>
{

    Bill findByBillNumber(int id);

    List<Bill> findByRentDate(LocalDate date);
    List<Bill> findByFullRentPrice(double rentPrice);

    //ToDo Query
    List<Bill> findByCustomer(String customerLastName);

    //ToDo Query
    List<Bill> findByRentPrice(double lowRentPrice,double highRentPrice);



}