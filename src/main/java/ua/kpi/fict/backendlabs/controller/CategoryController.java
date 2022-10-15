package ua.kpi.fict.backendlabs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kpi.fict.backendlabs.entity.CategoryEntity;
import ua.kpi.fict.backendlabs.entity.CustomerEntity;
import ua.kpi.fict.backendlabs.repository.CategoryRepo;
import ua.kpi.fict.backendlabs.service.CategoryService;

import javax.naming.NameAlreadyBoundException;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("categories")
    public ResponseEntity createCategory(@RequestBody CategoryEntity categoryEntity) {
        try {
            categoryService.createCategory(categoryEntity);
            return ResponseEntity.ok("Category Created");
        } catch (NameAlreadyBoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("categories")
    public ResponseEntity getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
