package de.rat.storage.core;

import org.springframework.data.repository.CrudRepository;
import de.rat.model.logistics.Tool;
public interface ToolRepository extends CrudRepository<Tool,Integer> {
}
