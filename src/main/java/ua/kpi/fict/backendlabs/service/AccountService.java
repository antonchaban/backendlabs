package ua.kpi.fict.backendlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.fict.backendlabs.entity.AccountEntity;
import ua.kpi.fict.backendlabs.entity.CustomerEntity;
import ua.kpi.fict.backendlabs.repository.AccountRepo;
import ua.kpi.fict.backendlabs.repository.CustomerRepo;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private CustomerRepo customerRepo;

    public AccountEntity createAccount(AccountEntity account) {
        CustomerEntity customerEntity = customerRepo.findById(account.getCustomerID()).get();
//        customerEntity.setAccountEntity(account);
//        customerRepo.save(customerEntity);
        account.setCustomerEntity(customerEntity);
        return accountRepo.save(account);
    }
}
