package com.Sprint3.sprint3.controller;

import com.Sprint3.sprint3.entities.Transaction;
import com.Sprint3.sprint3.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @GetMapping("/enterprises/{id}/movements")
    public ArrayList<Transaction> searchTransaction(@PathVariable long id){
        return transactionService.getByTransactionbyEntrepise(id);
    }

    @PostMapping("/enterprises/{id}/movements")
    private void createTransaction(@RequestBody Transaction transaction){
        transactionService.CreateAndUpdateTransaction(transaction);
    }

    @DeleteMapping("/enterprises/{id}/movements")
    private void deleteTransaction(@PathVariable("id") Long id){
        transactionService.deleteTransaction(id);
    }

    @PatchMapping("/movements/{id}")
    public void updateTransaction(@PathVariable long id, @RequestBody Map<Object, Object> dataToUpdate){
        transactionService.updateTransaction(id,dataToUpdate);
    }

}
