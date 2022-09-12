package com.Sprint3.sprint3.repository;

import com.Sprint3.sprint3.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long > {

    //Filter Transactions by Enterprise
    @Query(value="select * from transaction where enterprise_id in (select id from enterprise where id = ?1)", nativeQuery = true)
    public abstract ArrayList<Transaction> findByEnterprise(Long id);



}
