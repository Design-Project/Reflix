package com.reflix.server.configure.account.entity;

import com.reflix.server.configure.account.dto.AccountAuthDto;
import com.reflix.server.configure.account.entity.enumtypes.OAuthType;
import com.reflix.server.configure.account.entity.enumtypes.RoleType;
import com.reflix.server.configure.entity.BaseTimeEntity;
import com.reflix.server.configure.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static com.reflix.server.configure.entity.Status.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String nickname;

    private String email;

    private LocalDate dateOfBirth;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private String phoneNumber;

    private String profileImage;

    private String address;

    @Enumerated(EnumType.STRING)
    private OAuthType oAuth;

    private Long kakaoId;

    private Integer smsAuthToken;

    private boolean isSmsCertified;

    public static Account createAccount(AccountAuthDto dto) {

        return Account.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .password(dto.getPassword())
                .phoneNumber(dto.getPhoneNumber())
                .status(VALID)
                .role(RoleType.ROLE_USER)
                .build();
    }

    public void createTokenToPhoneNumber(Integer smsAuthToken, String phoneNumber) {
        this.smsAuthToken = smsAuthToken;
        this.phoneNumber = phoneNumber;
    }

    public void certifySmsAuth() {
        this.isSmsCertified = true;
    }

    public void changeRole(RoleType roleType) {
        this.role = roleType;
    }
}
