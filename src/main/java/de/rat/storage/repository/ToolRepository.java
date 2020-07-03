package de.rat.storage.repository;

import de.rat.model.logistics.Category;
import de.rat.model.logistics.Tool;
import de.rat.model.logistics.ToolStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


public interface ToolRepository extends JpaRepository<Tool,Long>
{

    Tool findById(int id);
    Tool findByDescription(String description);

    List<Tool> findByCategory(Category category);
    List<Tool> findByToolStatus(ToolStatus status);
    List<Tool> findByRentPrice(double rentPrice);



    //ToDO Query
//    List<Tool> findByPrice(double lowRentPrice,double highRentPrice);


}

