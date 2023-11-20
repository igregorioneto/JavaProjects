package com.backend.cashflow.repository;

import com.backend.cashflow.model.Account;
import com.backend.cashflow.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT COUNT(a) > 0 FROM Account a WHERE a.email = :email")
    boolean existsEmail(@Param("email") String email);
}
