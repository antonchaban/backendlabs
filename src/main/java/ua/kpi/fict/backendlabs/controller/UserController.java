package ua.kpi.fict.backendlabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.fict.backendlabs.entity.Customer;
import ua.kpi.fict.backendlabs.repository.CustomerRepo;

import java.util.HashSet;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("signup")
    public ResponseEntity regCustomer(@RequestBody Customer customer) {
        if (customerRepo.findCustomerByUsername(customer.getUsername()) != null){
            return ResponseEntity.badRequest().body("Username already taken");
        }
        /*Customer newCustomer = */customerRepo.save(customer);
        return ResponseEntity.ok("User Created");
    }

}
