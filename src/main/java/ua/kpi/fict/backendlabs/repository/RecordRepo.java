package ua.kpi.fict.backendlabs.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.fict.backendlabs.entity.CategoryEntity;
import ua.kpi.fict.backendlabs.entity.CustomerEntity;
import ua.kpi.fict.backendlabs.entity.RecordEntity;

import java.util.List;

public interface RecordRepo extends CrudRepository<RecordEntity, Long> {
    List<RecordEntity> findRecordByCustomerEntityID(Long cusID);
    List<RecordEntity> findRecordByCategoryEntityID(Long catID);


    List<RecordEntity> findRecordByCustomerEntityAndCategoryEntity(CustomerEntity customerEntity, CategoryEntity categoryEntity);

}
