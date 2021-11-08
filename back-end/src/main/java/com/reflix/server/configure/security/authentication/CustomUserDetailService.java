package com.reflix.server.configure.security.authentication;

import com.reflix.server.configure.account.AccountRepository;
import com.reflix.server.configure.account.entity.Account;
import com.reflix.server.configure.response.exception.CustomException;
import com.reflix.server.configure.response.exception.CustomExceptionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.reflix.server.configure.entity.Status.VALID;


@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<Account> optionalAccount = accountRepository.findByEmailAndStatus(email, VALID);
        if (!optionalAccount.isPresent()) throw new CustomException(CustomExceptionStatus.ACCOUNT_NOT_FOUND);
        return new CustomUserDetails(optionalAccount.get());
    }

}
