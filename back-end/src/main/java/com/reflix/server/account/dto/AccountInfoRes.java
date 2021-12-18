package com.reflix.server.account.dto;

import com.reflix.server.account.entity.Account;
import com.reflix.server.movie.dto.MoviesResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfoRes {

    private Long accountId;
    private String nickname;
    private Integer age;
    private String gender;
    private Long follow;
    private Long following;
    private Long postCount;
    private List<MoviesResponseDto.Item> movieList;

    public AccountInfoRes(Account account) {
        this.accountId = account.getAccountId();
        this.nickname = account.getNickname();
        this.age = account.getAge();
        this.gender = account.getGender();
        this.follow = account.getFollow();
        this.following = account.getFollowing();
        this.postCount = account.getPostCount();
         this. movieList = account.getMovies().stream().map(MoviesResponseDto.Item::new).collect(Collectors.toList());
    }
}
