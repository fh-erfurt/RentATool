package de.rat.repositories;

import de.rat.model.logistics.Tool;
import org.springframework.data.repository.CrudRepository;

public interface ToolRepository extends CrudRepository<Tool,Integer> {
    Tool findById(int id);
    Tool findByDescription(String description);
}

