package com.Sprint3.sprint3.service;

import com.Sprint3.sprint3.entities.Transaction;
import com.Sprint3.sprint3.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public void CreateAndUpdateTransaction(Transaction transaction){
        //Guardar
        transactionRepository.save(transaction);
    }

    public List<Transaction> seeTransaction(){
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.addAll(transactionRepository.findAll());
        return transactions;
    }

    public Transaction seeTransactionId(long id){
        Transaction transactionFound = (Transaction) transactionRepository.findById(id).get();

        if (transactionFound != null){
            return transactionFound;
        } else {
            return null;
        }
    }

    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }


    public void updateTransaction(long id, Map<Object, Object> dataToUpdate){
        Transaction transactionFound = seeTransactionId(id);

        dataToUpdate.forEach((clave, valor) -> {
            Field campo = ReflectionUtils.findField(Transaction.class, (String) clave);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, transactionFound, valor);
        });

        transactionRepository.save(transactionFound);
    }

}
