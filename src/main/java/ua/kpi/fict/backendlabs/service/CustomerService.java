package ua.kpi.fict.backendlabs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.kpi.fict.backendlabs.entity.CustomerEntity;
import ua.kpi.fict.backendlabs.repository.CustomerRepo;

import javax.naming.NameAlreadyBoundException;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public CustomerEntity signUp(CustomerEntity customer) throws NameAlreadyBoundException {
        if (customerRepo.findCustomerByUsername(customer.getUsername()) != null){
            throw new NameAlreadyBoundException("Username already taken");
        }
        return customerRepo.save(customer);
    }

    public Long delete(Long id) {
        customerRepo.deleteById(id);
        return id;
    }
}
