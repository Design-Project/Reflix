package com.reflix.server.movie.dto;

import com.reflix.server.account.entity.Account;
import com.reflix.server.movie.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyListRes {

    private Long replyId;

    private Long accountId;

    private String accountName;

    private Long postId;

    private String contents;

    private LocalDateTime createdAt;

    public ReplyListRes(Reply reply) {

        this.replyId = reply.getReplyId();

        Account account = reply.getAccount();
        this.accountId = account.getAccountId();
        this.accountName = account.getNickname();

        this.postId = reply.getPost().getPostId();

        this.contents = reply.getContents();

        this.createdAt = reply.getCreatedAt();
    }

}
