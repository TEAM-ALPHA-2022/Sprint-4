package com.Sprint3.sprint3.controller;

import com.Sprint3.sprint3.entities.Transaction;
import com.Sprint3.sprint3.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/transaction")
    private List<Transaction> seeTransactions(){
        return transactionService.seeTransaction();
    }

    @PostMapping("/transaction")
    private void createTransaction(@RequestBody Transaction transaction){
        transactionService.CreateAndUpdateTransaction(transaction);
    }

    @GetMapping("/transaction/{id}")
    public Transaction searchTransaction(@PathVariable long id){
        return transactionService.seeTransactionId(id);
    }

    @DeleteMapping("/transaction/{id}")
    private void deleteTransaction(@PathVariable("id") Long id){
        transactionService.deleteTransaction(id);
    }

    @PatchMapping("/transaction/{id}")
    public void updateTransaction(@PathVariable long id, @RequestBody Map<Object, Object> dataToUpdate){
        transactionService.updateTransaction(id,dataToUpdate);
    }

}
