package com.reflix.server.movie.entity;

import com.reflix.server.account.entity.Account;
import com.reflix.server.configure.entity.BaseTimeEntity;
import com.reflix.server.configure.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.reflix.server.configure.entity.Status.*;
import static javax.persistence.FetchType.LAZY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId")
    private Post post;

    private String contents;

    public Reply(Account account, Post post, String contents) {
        this.status = VALID;
        this.account = account;
        this.post = post;
        this.contents = contents;
    }

}
