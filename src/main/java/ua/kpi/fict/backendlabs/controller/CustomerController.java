package ua.kpi.fict.backendlabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.fict.backendlabs.entity.CustomerEntity;
import ua.kpi.fict.backendlabs.repository.CustomerRepo;
import ua.kpi.fict.backendlabs.service.CustomerService;

import javax.naming.NameAlreadyBoundException;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("users")
    public ResponseEntity regCustomer(@RequestBody CustomerEntity customerEntity) {
        try {
            customerService.signUp(customerEntity);
            return ResponseEntity.ok("User Created");
        } catch (NameAlreadyBoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
