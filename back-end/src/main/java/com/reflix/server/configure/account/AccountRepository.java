package com.reflix.server.configure.account;

import com.reflix.server.configure.account.entity.Account;
import com.reflix.server.configure.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmailAndStatus(String email, Status status);
    Optional<Account> findByNicknameAndStatus(String nickname, Status status);
    Optional<Account> findByAccountIdAndStatus(Long accountId, Status status);
}
