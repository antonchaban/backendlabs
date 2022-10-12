package ua.kpi.fict.backendlabs.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.fict.backendlabs.entity.Record;

public interface RecordRepo extends CrudRepository<Record, Long> {
}
