package com.reflix.server.account;

import com.reflix.server.account.dto.AccountAuthDto;
import com.reflix.server.account.dto.SignInReq;
import com.reflix.server.account.dto.SignInRes;
import com.reflix.server.account.entity.Account;
import com.reflix.server.configure.entity.Status;
import com.reflix.server.configure.response.exception.CustomException;
import com.reflix.server.configure.response.exception.CustomExceptionStatus;
import com.reflix.server.configure.security.authentication.CustomUserDetails;
import com.reflix.server.configure.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.reflix.server.configure.entity.Status.*;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    @Transactional
    public SignInRes signIn(SignInReq req) {
        Account account = accountRepository.findByEmailAndStatus(req.getEmail(), VALID)
                .orElseThrow(()-> new CustomException(CustomExceptionStatus.FAILED_TO_LOGIN));
        if(!passwordEncoder.matches(req.getPassword(),account.getPassword())){
            throw new CustomException(CustomExceptionStatus.FAILED_TO_LOGIN);
        }

        SignInRes res = SignInRes.builder()
                .accountId(account.getAccountId())
                .email(account.getEmail())
                .jwt(jwtTokenProvider.createToken(account.getEmail(), account.getRole()))
                .build();

        return res;
    }

    public AccountAuthDto getAuthAccount(CustomUserDetails customUserDetails) {
        Account account = customUserDetails.getAccount();
        AccountAuthDto accountInfoDto = new AccountAuthDto(account);
        accountInfoDto.setJwt(jwtTokenProvider.createToken(account.getEmail(), account.getRole()));
        return accountInfoDto;
    }

    public void getNicknameValidation(String nickname) {
        Optional<Account> accountOptional = accountRepository.findByNicknameAndStatus(nickname, VALID);
        if(accountOptional.isPresent()) throw new CustomException(CustomExceptionStatus.DUPLICATED_NICKNAME);
    }

    @Transactional
    public AccountAuthDto signUp(AccountAuthDto dto) {
        if (accountRepository.findByEmailAndStatus(dto.getEmail(), VALID).isPresent()) throw new CustomException(CustomExceptionStatus.DUPLICATED_EMAIL);
        if (dto.getNickname() != null){
            if (accountRepository.findByNicknameAndStatus(dto.getNickname(), VALID).isPresent()) throw new CustomException(CustomExceptionStatus.DUPLICATED_NICKNAME);
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Account account = Account.createAccount(dto);
        Account save = accountRepository.save(account);
        dto.setAccountId(save.getAccountId());
        dto.setJwt(jwtTokenProvider.createToken(account.getEmail(),account.getRole()));
        return dto;
    }

}
