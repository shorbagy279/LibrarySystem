package com.obaid.RestAPI.Repository;

import com.obaid.RestAPI.Entity.Transaction;
import com.obaid.RestAPI.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByUser(User user);
}
