package com.infolog.InfologServices.repository;

import com.infolog.InfologServices.model.Account;
import com.infolog.InfologServices.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
}
