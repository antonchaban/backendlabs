package ua.kpi.fict.backendlabs.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.fict.backendlabs.entity.AccountEntity;


public interface AccountRepo extends CrudRepository<AccountEntity, Long> {
}
