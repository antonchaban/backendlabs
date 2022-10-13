package ua.kpi.fict.backendlabs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kpi.fict.backendlabs.entity.Category;
import ua.kpi.fict.backendlabs.entity.Customer;
import ua.kpi.fict.backendlabs.entity.Record;
import ua.kpi.fict.backendlabs.repository.CategoryRepo;
import ua.kpi.fict.backendlabs.repository.CustomerRepo;
import ua.kpi.fict.backendlabs.repository.RecordRepo;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    @Autowired
    private RecordRepo recordRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    @PostMapping("createRecord")
    public ResponseEntity createRecord(@RequestBody Record record, @RequestParam Long customerID,
                                       @RequestParam Long categoryID) {
        Customer customer = customerRepo.findById(customerID).get();
        record.setCustomer(customer);
        Category category = categoryRepo.findById(categoryID).get();
        record.setCategory(category);
        record.setRecordTime(Instant.now());
        recordRepo.save(record);
        return ResponseEntity.ok(record);
    }

    @GetMapping("allRecords")
    public ResponseEntity getAllRecords(){
        return ResponseEntity.ok(recordRepo.findAll());
    }



    @GetMapping("customersRecords/{customerID}")
    public ResponseEntity getCustomersRecords(@PathVariable Long customerID){
        return ResponseEntity.ok(recordRepo.findRecordByCustomerID(customerID));
    }

    @GetMapping("customersRecordsByCategory/{customerID}")
    public ResponseEntity getCustomersRecordsByCategory(@PathVariable Long customerID, @RequestParam Long categoryID){
        Customer customer = customerRepo.findById(customerID).get();
        Category category = categoryRepo.findById(categoryID).get();

        return ResponseEntity.ok(recordRepo.findRecordByCustomerAndCategory(customer, category));
    }
}
