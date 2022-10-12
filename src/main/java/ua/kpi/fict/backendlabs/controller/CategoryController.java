package ua.kpi.fict.backendlabs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kpi.fict.backendlabs.entity.Category;
import ua.kpi.fict.backendlabs.entity.Customer;
import ua.kpi.fict.backendlabs.repository.CategoryRepo;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("createCategory")
    public ResponseEntity createCategory(@RequestBody Category category) {
        if (categoryRepo.findCategoryByCategoryName(category.getCategoryName()) != null){
            return ResponseEntity.badRequest().body("Category name already taken");
        }
        categoryRepo.save(category);
        return ResponseEntity.ok("Category Created");
    }

    @GetMapping("viewCategories")
    public ResponseEntity getAllCategories(){
        return ResponseEntity.ok(categoryRepo.findAll());
    }
}
