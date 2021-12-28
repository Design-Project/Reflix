package com.reflix.server.movie.entity;

import com.reflix.server.account.entity.Account;
import com.reflix.server.configure.entity.BaseTimeEntity;
import com.reflix.server.configure.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String imageUrl;

    private String movieTitle;

    private String content;

    private Integer rating;

    private Integer likeCount;

    @BatchSize(size = 200)
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

}
