package ua.kpi.fict.backendlabs.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.fict.backendlabs.entity.CategoryEntity;

public interface CategoryRepo extends CrudRepository<CategoryEntity, Long> {
    CategoryEntity findCategoryByCategoryName(String categoryName);
}
