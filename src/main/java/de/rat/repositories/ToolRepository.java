package de.rat.repositories;

import de.rat.model.logistics.Category;
import de.rat.model.logistics.ToolStatus;
import de.rat.model.logistics.Tool;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ToolRepository extends CrudRepository<Tool,Integer>
{
    Tool findById(int id);
    Tool findByDescription(String description);

    // TODO: Delete?
    List<Tool> findByCategory(Category category);
    List<Tool> findByToolStatus(ToolStatus status);
    List<Tool> findByRentPrice(double rentPrice);

    //Query for searching tool after prices between a range
    @Query("FROM Tool t WHERE t.rentPrice between :lowRentPrice and :highRentPrice ")
    List<Tool> findByRentPrice(@Param("lowRentPrice")double lowRentPrice, @Param("highRentPrice")double highRentPrice);
}

