package ua.kpi.fict.backendlabs.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.fict.backendlabs.entity.Category;
import ua.kpi.fict.backendlabs.entity.Customer;
import ua.kpi.fict.backendlabs.entity.Record;

import java.util.List;

public interface RecordRepo extends CrudRepository<Record, Long> {
    List<Record> findRecordByCustomerID(Long cusID);
    List<Record> findRecordByCategoryID(Long catID);

    List<Record> findRecordByCustomerAndCategory(Customer customer, Category category);

}
