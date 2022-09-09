package com.Sprint3.sprint3.repository;

import com.Sprint3.sprint3.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long > {
}
