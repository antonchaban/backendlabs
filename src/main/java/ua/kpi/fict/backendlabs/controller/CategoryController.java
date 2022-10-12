package ua.kpi.fict.backendlabs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.fict.backendlabs.entity.Category;
import ua.kpi.fict.backendlabs.entity.Customer;
import ua.kpi.fict.backendlabs.repository.CategoryRepo;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("createCategory")
    public ResponseEntity regCustomer(@RequestBody Category category) {
        if (categoryRepo.findCategoryByCategoryName(category.getCategoryName()) != null){
            return ResponseEntity.badRequest().body("Category name already taken");
        }
        categoryRepo.save(category);
        return ResponseEntity.ok("Category Created");
    }
}
