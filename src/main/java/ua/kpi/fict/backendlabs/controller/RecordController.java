package ua.kpi.fict.backendlabs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.fict.backendlabs.entity.Category;
import ua.kpi.fict.backendlabs.entity.Customer;
import ua.kpi.fict.backendlabs.entity.Record;
import ua.kpi.fict.backendlabs.repository.RecordRepo;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    @Autowired
    private RecordRepo recordRepo;

    @PostMapping("createRecord")
    public ResponseEntity createRecord(@RequestBody Record record){
        Record newRecord = recordRepo.save(record);
        return ResponseEntity.ok(newRecord);
    }
}
