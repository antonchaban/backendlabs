package ua.kpi.fict.backendlabs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kpi.fict.backendlabs.entity.CategoryEntity;
import ua.kpi.fict.backendlabs.entity.CustomerEntity;
import ua.kpi.fict.backendlabs.entity.RecordEntity;
import ua.kpi.fict.backendlabs.repository.CategoryRepo;
import ua.kpi.fict.backendlabs.repository.CustomerRepo;
import ua.kpi.fict.backendlabs.repository.RecordRepo;

import javax.naming.NameAlreadyBoundException;
import java.time.Instant;

@Service
public class RecordService {
    @Autowired
    private RecordRepo recordRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public RecordEntity createRecord(RecordEntity record, Long customerID, Long categoryID) {
        CustomerEntity customerEntity = customerRepo.findById(customerID).get();
        record.setCustomerEntity(customerEntity);
        CategoryEntity categoryEntity = categoryRepo.findById(categoryID).get();
        record.setCategoryEntity(categoryEntity);
        record.setRecordTime(Instant.now());
        return recordRepo.save(record);
    }

    public Iterable<RecordEntity> getAllRecords()
    {
        return recordRepo.findAll();
    }

    public Iterable<RecordEntity> getCustomersRecords(Long customerID){
        return recordRepo.findRecordByCustomerEntityID(customerID);
    }

    public Iterable<RecordEntity> getCustomersRecordsByCategory(Long customerID, Long categoryID){
        CustomerEntity customerEntity = customerRepo.findById(customerID).get();
        CategoryEntity categoryEntity = categoryRepo.findById(categoryID).get();
        return recordRepo.findRecordByCustomerEntityAndCategoryEntity(customerEntity, categoryEntity);
    }

}
