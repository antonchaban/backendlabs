package ua.kpi.fict.backendlabs.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.fict.backendlabs.entity.CustomerEntity;

public interface CustomerRepo extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity findCustomerByUsername(String cusName);
}
