package com.reflix.server.movie.dto;

import com.reflix.server.account.entity.Account;
import com.reflix.server.configure.entity.Status;
import com.reflix.server.movie.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRes {

    private Long postId;

    private String imageUrl;

    private String movieTitle;

    private String content;

    private Integer rating;

    private String accountNickName;

    private Integer likeCount;

    public PostRes(Post post) {
        this.postId = post.getPostId();
        this.imageUrl = post.getImageUrl();
        this.movieTitle = post.getMovieTitle();
        this.content = post.getContent();
        this.rating = post.getRating();
        this.accountNickName = post.getAccount().getNickname();
        this.likeCount = post.getLikeCount();
    }

}
