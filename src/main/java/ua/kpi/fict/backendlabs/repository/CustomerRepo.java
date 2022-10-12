package ua.kpi.fict.backendlabs.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.fict.backendlabs.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
    Customer findCustomerByUsername(String cusName);
}
