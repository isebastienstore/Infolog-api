package com.infolog.InfologServices.repository;

import com.infolog.InfologServices.model.Client;
import com.infolog.InfologServices.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}
