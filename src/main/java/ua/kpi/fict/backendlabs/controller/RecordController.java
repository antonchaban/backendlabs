package ua.kpi.fict.backendlabs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kpi.fict.backendlabs.entity.CategoryEntity;
import ua.kpi.fict.backendlabs.entity.CustomerEntity;
import ua.kpi.fict.backendlabs.entity.RecordEntity;
import ua.kpi.fict.backendlabs.repository.CategoryRepo;
import ua.kpi.fict.backendlabs.repository.CustomerRepo;
import ua.kpi.fict.backendlabs.repository.RecordRepo;
import ua.kpi.fict.backendlabs.service.RecordService;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1")
public class RecordController {

    @Autowired
    private RecordService recordService;


    @PostMapping("records")
    public ResponseEntity createRecord(@RequestBody RecordEntity recordEntity, @RequestParam Long customerID,
                                       @RequestParam Long categoryID) {
        return ResponseEntity.ok(recordService.createRecord(recordEntity, customerID, categoryID));
    }

    @GetMapping("records")
    public ResponseEntity getAllRecords() {
        return ResponseEntity.ok(recordService.getAllRecords());
    }


    @GetMapping("/users/{customerID}/records")
    public ResponseEntity getCustomersRecords(@PathVariable Long customerID) {
        return ResponseEntity.ok(recordService.getCustomersRecords(customerID));
    }

    @GetMapping("/users/{customerID}/categories/{categoryID}/records")
    public ResponseEntity getCustomersRecordsByCategory(@PathVariable Long customerID, @PathVariable Long categoryID) {
        return ResponseEntity.ok(recordService.getCustomersRecordsByCategory(customerID, categoryID));
    }
}
