package ua.kpi.fict.backendlabs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.fict.backendlabs.entity.CategoryEntity;
import ua.kpi.fict.backendlabs.repository.CategoryRepo;

import javax.naming.NameAlreadyBoundException;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public CategoryEntity createCategory(CategoryEntity category) throws NameAlreadyBoundException {
        if (categoryRepo.findCategoryByCategoryName(category.getCategoryName()) != null){
            throw new NameAlreadyBoundException("Category already exists");
        }
        return categoryRepo.save(category);
    }

    public Iterable<CategoryEntity> getAllCategories()
    {
        return categoryRepo.findAll();
    }
}
