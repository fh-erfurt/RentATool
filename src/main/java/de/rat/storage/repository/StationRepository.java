package de.rat.storage.repository;

import de.rat.model.logistics.Station;
import org.graalvm.compiler.lir.alloc.lsra.ssa.SSALinearScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StationRepository extends CrudRepository<Station,Integer>
{

    Station findById(int id);

}
