package com.example.accountapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accountapp.model.Account;

public interface AccountRepository  extends JpaRepository<Account, Long>{


}
